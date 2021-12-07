package testapplication;

import application.Jouer;
import application.Joueurs;

public class TestJeux {
        public static void main(String[] args){
            CreationDonnees.creer10Themes();
            CreationDonnees.creationQuestions();

            Joueurs joueursTest = new Joueurs();
            joueursTest.generation20Joueurs();

            Jouer jeu1 = new Jouer();
            jeu1.jouerPhase1();
            
            
            System.out.println(joueursTest.getJoueur());

        }
}
