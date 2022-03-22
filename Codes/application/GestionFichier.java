/*
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
Classe pour la gestion du fichier de données,
permet de lire les questions présentes dans le fichier et le thème au lancement du programme
permet d'inscrire les nouveaux thèmes et les nouvelle questions rentrées 
par les utilisateur lors de l'exécution
*/

package application;

import java.io.*;
import java.util.Scanner; 


public class GestionFichier {
    private static Scanner scanner = new Scanner(System.in);

    //lecture des thèmes présents dans le fichier Themes.txt à l'execution du programme
    public static void lectureThemes() throws FileNotFoundException{
        FileInputStream file = new FileInputStream("Themes.txt");
        Scanner scannerThemes = new Scanner(file);

        while(scannerThemes.hasNextLine()){
            String line = scannerThemes.nextLine();

            Themes.nouveauTheme(line.replaceAll("\\s+", ""));
        }
    }

    //lecture des questions présentes dans le fichier Donnees.txt à l'execution du programme
    public static void lectureQuestions() throws FileNotFoundException{
        FileInputStream file = new FileInputStream("Donnees.txt");
        Scanner scannerLecture = new Scanner(file);
        while(scannerLecture.hasNextLine()){
            String line = scannerLecture.nextLine();
            String[] lineSep = line.split(",");

            switch (lineSep[0].replaceAll("\\s+", "")) {
                case "Vf":
                    boolean answerV;
                    if(lineSep[3].equals("true")){
                        answerV = true;
                    }
                    else{
                        answerV = false;
                    }
                    String themeV = lineSep[4].replaceAll("\\s+","");
                    int niveauV = Integer.parseInt(lineSep[5].replaceAll("\\s+",""));
                    new Vf(lineSep[2], answerV, themeV, niveauV);
                    break;
                case "Qcm":
                    String texteQ = lineSep[2];
                    String choix1 = lineSep[3];
                    String choix2 = lineSep[4];
                    String choix3 = lineSep[5];
                    int answerQ = Integer.parseInt(lineSep[6].replaceAll("\\s+",""));
                    String themeQ = lineSep[7].replaceAll("\\s+","");
                    int niveauQ = Integer.parseInt(lineSep[8].replaceAll("\\s+",""));
                    new Qcm(texteQ,choix1, choix2, choix3, answerQ, themeQ, niveauQ);
                    break;
                case "Rc":
                    String texteR = lineSep[2];
                    String answerR = lineSep[3];
                    //ajout de la reponse das la liste des réponses courtes pour l'IA
                    Ia.ajoutRC(answerR.replaceAll("\\s+",""));
                    String themeR = lineSep[4].replaceAll("\\s+","");
                    int niveauR = Integer.parseInt(lineSep[5].replaceAll("\\s+",""));
                    new Rc(texteR, answerR, themeR, niveauR);
                    break;
            }
        }
    }

    //inscrit une nouvelle question dans le fichier Donnees.txt
    public static void ajoutQuestion(String text) throws FileNotFoundException{
        //FileInputStream file = new FileInputStream("Donnees.txt");
        //Scanner scanner = new Scanner(file);
        try
        {
            //String filename="Donnees.txt";
            
            FileWriter fw = new FileWriter("Donnees.txt",true);
            fw.write("\n" + text);
            fw.close();
        }

        catch(IOException ioe)
        {
            System.err.println("IOException:" + ioe.getMessage());
        }
    }

    //inscrit un nouveau thème dans le fichier Themes.txt
    public static void AjoutTheme(String theme) throws FileNotFoundException{
        //FileInputStream file = new FileInputStream("Donnees.txt");
        //Scanner scanner = new Scanner(file);
        try
        {
            //String filename="Donnees.txt";
            
            FileWriter fw = new FileWriter("Themes.txt",true);
            fw.write("\n" + theme);
            fw.close();
        }

        catch(IOException ioe)
        {
            System.err.println("IOException:" + ioe.getMessage());
        }
    }

    //fonction qui permet a l'utilisateur de rentrer une nouvelle question
    public static void askForQuestion() throws FileNotFoundException{
        System.out.println("Quelle type de question voulez vous implementer : \n1:Qcm \n2: Vf\n3: Reponse courte");
        int indType = scanner.nextInt();
        if ( indType == 1){
            ajoutQuestion((new Qcm()).saisieDev());
        }
        if ( indType == 2){
            ajoutQuestion((new Vf()).saisieDev());
        }
        if ( indType == 3){
            ajoutQuestion((new Rc()).saisieDev());
        }
    }

    //fonction qui permet à l'utilisateur d'entrer un nouveau thème
    public static void askForTheme() throws FileNotFoundException{
        System.out.println("Quel est le nom du nouveau theme ?");
        String nvxTheme = scanner.next();
        AjoutTheme(nvxTheme);
        Themes.nouveauTheme(nvxTheme);
        
    }


}

