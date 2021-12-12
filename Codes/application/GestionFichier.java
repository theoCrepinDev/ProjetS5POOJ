package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GestionFichier {

    public static void LectureQuestions() throws FileNotFoundException{
        FileInputStream file = new FileInputStream("Donnees.txt");
        Scanner scannerLecture = new Scanner(file);

        int i = 0 ;

        while(scannerLecture.hasNextLine()){
            String line = scannerLecture.nextLine();
            String[] lineSep = line.split(",");

            switch (lineSep[0]) {
                case "Vf ":
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
                    System.out.println("vf");
                    break;
                case "Qcm ":
                    String texteQ = lineSep[2];
                    String choix1 = lineSep[3];
                    String choix2 = lineSep[4];
                    String choix3 = lineSep[5];
                    int answerQ = Integer.parseInt(lineSep[6].replaceAll("\\s+",""));
                    String themeQ = lineSep[7].replaceAll("\\s+","");
                    int niveauQ = Integer.parseInt(lineSep[8].replaceAll("\\s+",""));
                    new Qcm(texteQ,choix1, choix2, choix3, answerQ, themeQ, niveauQ);
                    System.out.println("qcm");
                    break;
                case "Rc ":
                    String texteR = lineSep[2];
                    String answerR = lineSep[3];
                    String themeR = lineSep[4].replaceAll("\\s+","");
                    int niveauR = Integer.parseInt(lineSep[5].replaceAll("\\s+",""));
                    System.out.println(themeR);
                    new Rc(texteR, answerR, themeR, niveauR);
                    System.out.println("rc");
                    break;
            }
        }
    }
    
}
