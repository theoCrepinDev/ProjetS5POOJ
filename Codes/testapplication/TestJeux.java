package testapplication;

import java.io.File;
import java.io.FileNotFoundException;

import application.GestionFichier;
import application.Jouer;
import application.Joueurs;

public class TestJeux {
    public static void lanceJeu(){
        CreationDonnees.creer10Themes();
        try {
            GestionFichier.LectureQuestions();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

            Joueurs joueursTest = new Joueurs();
            joueursTest.generation20Joueurs();

            Jouer jeu1 = new Jouer();
            jeu1.jouerPhase1();
            
            
            System.out.println(joueursTest.getJoueur());

        }
}
