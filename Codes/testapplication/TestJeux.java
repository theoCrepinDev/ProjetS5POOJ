package testapplication;

import java.io.FileNotFoundException;
import java.util.Scanner;

import application.GestionFichier;
import application.Jouer;
import application.Joueurs;
import application.Menu;
public class TestJeux {
    private static Scanner scanner = new Scanner(System.in);

    public static void lanceJeu(){      
        Jouer jeu1 = new Jouer();
        jeu1.jouerPhase1();
    }

    public static void lanceGrandJeu(){
        Jouer jeu = new Jouer();
        jeu.grandJeu();
    }

    public static void main(String[] args) throws FileNotFoundException{
        int choixGeneration = 0;
        System.out.println("Souhaitez vous générer 20 joueurs et choissir si il sont controlés\npar Ia ou par l'utilisateur ?\n1: oui\n2:non");
        choixGeneration = scanner.nextInt();
        while (choixGeneration <= 0 || choixGeneration > 2) {
            System.out.println("Ce choix n'est pas disponnible");
            System.out.println("Souhaitez vous générer 20 joueurs et choissir si il sont controlés\npar Ia ou par l'utilisateur ?\1: oui\n2:non");
            choixGeneration = scanner.nextInt();
        }
        if(choixGeneration == 1){
            Joueurs.generation20Joueurs();
        }

        try {
            GestionFichier.lectureThemes();
            GestionFichier.lectureQuestions();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            System.out.println("Problème de génération des questions et des Thèmes\nVérifiez que vous avez ouvert le dossier PROJETS5POOJ dans l'éditeur\net que le fichier Donnes.txt et Themes.txt est bien a la racine de ce dossier");
        }
        while(true){
            Menu.menu();
        }
    }
}
