package testapplication;

import java.io.File;
import java.io.FileNotFoundException;

import application.GestionFichier;
import application.Jouer;
import application.Joueurs;
import application.Vf;

public class TestJeux {
    public static void lanceJeu(){
        try {
            GestionFichier.lectureThemes();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            GestionFichier.lectureQuestions();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            Joueurs.generation20Joueurs();

            Jouer jeu1 = new Jouer();
            jeu1.grandJeu();
            
            
            System.out.println(Joueurs.getJoueur());

        }

    public static void main(String[] args){
            lanceJeu();
    }
}
