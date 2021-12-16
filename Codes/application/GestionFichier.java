package application;

import java.io.*;
import java.util.Scanner; 


public class GestionFichier {

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

    public static void askForQuestion() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle type de question voulez vous implementer : \n1:Qcm \n2: Vf\n3: Reponse courte");
        int indType = scanner.nextInt();
        if ( indType == 1){
            ajoutQuestion((new Qcm()).saisieTest());
        }
        if ( indType == 2){
            ajoutQuestion((new Vf()).saisieTest());
        }
        if ( indType == 3){
            ajoutQuestion((new Rc()).saisieTest());
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        Themes.nouveauTheme("Géographie");
        Themes.nouveauTheme("Histoire");
        Themes.nouveauTheme("Français");
        Themes.nouveauTheme("Anglais");
        Themes.nouveauTheme("Mathématiques");
        Themes.nouveauTheme("Films");
        Themes.nouveauTheme("Musique");
        Themes.nouveauTheme("Sport");
        Themes.nouveauTheme("Physique");
        Themes.nouveauTheme("Informatique");
        askForQuestion();
    }
    
    
}
