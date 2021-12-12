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
        System.out.println("Quelle type de question voulez vous implementer : \n 1:Qcm \n2: Vf\n3: Reponse courte");
        int indType = scanner.nextInt();
        if ( indType == 1){

        }
        if ( indType == 2){
            ajoutQuestion(Vf.saisieTest());;
        }
        if ( indType == 3){

        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        askForQuestion();
    }
    
    
}
