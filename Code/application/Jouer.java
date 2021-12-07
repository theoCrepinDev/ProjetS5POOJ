package application;

import java.util.Scanner;

public class Jouer {
    private Phase jeu;
    private static Scanner scanner = new Scanner(System.in);

    public Jouer(){
        jeu = new Phase1();
    }

    public void jouerPhase1(){
        jeu.selectionJoueurs();
        System.out.println("Bienvenu chèr joueurs, la Phase 1 va pourvoir commencer....");
        System.out.println("Voici les joueurs sélectionnés pour cette phase :");
        System.out.println(jeu.getJoueursJeu());

        for(int i = 0; i < 4; i++){
            jeu.selectionTheme();
            jeu.selectionQuestion(jeu.getThemesSelectionnes().get(0));
            jeu.poserQuestions(i);
        }

        System.out.println("Félicitation, la phase 1 est finie, vici les résultat :");
        System.out.println(jeu.getJoueursJeu());

        System.out.println("Souaitez vous passer à la pahse 2 ? \n 1 oui 2 arrêter le jeu ici ..");
        int choix = scanner.nextInt();
        if(choix == 1){
            this.jouerPhase2();
        }
    }

    public void jouerPhase2(){
        jeu = new Phase2(jeu);
        System.out.println("Bienvenu, si vous en êtes là c'est que vous avez gagné la phase 1 ... \n La phase 2 va pouvoir commencer !");
        jeu.selectionJoueurs();
        System.out.println("Voici les joueurs sélectionnés pour la phase 2");
        System.out.println(jeu.getJoueursJeu());
        jeu.selectionTheme();
        for(int i = 0; i < 6; i ++){
            System.out.println("Voici les thèmes disponnibles :");
            for(int k = 0; k < jeu.getThemesSelectionnes().size(); k++){
                System.out.println("Choix n°" + k + " : " + jeu.getThemesSelectionnes().get(k) );
            }
            System.out.println("Joueur : " + jeu.getJoueursJeu().get(i % 3).getNom() + " Entrer l'entier du thème voulut");
            int themeChoisit = scanner.nextInt();
            jeu.selectionQuestion(jeu.getThemesSelectionnes().get(themeChoisit));
            jeu.poserQuestions(i % 3);
            jeu.getThemesSelectionnes().remove(themeChoisit);
        }

        System.out.println("Félicitation, la phase 2 est finie, vici les résultat :");
        System.out.println(jeu.getJoueursJeu());

        System.out.println("Souaitez vous passer à la pahse 3 ? \n 1 oui 2 arrêter le jeu ici ..");
        int choix = scanner.nextInt();
        if(choix == 1){
            this.jouerPhase3();
        }
    }

    public void jouerPhase3(){
        jeu = new Phase3(jeu);
        jeu.selectionJoueurs();
        System.out.println("Bienvenue dans la dernière phase de ce jeu, un gagnant sera désigné à la fin de cette série de questions");
        System.out.println("Voici les joueurs en jeu pour cette phase : ");
        System.out.println(jeu.getJoueursJeu());

        jeu.selectionTheme();
        for(int i = 0; i < 4; i++){
            System.out.println("Voici les thèmes disponnibles :");
            for(int k = 0; k < jeu.getThemesSelectionnes().size(); k++){
                System.out.println("Choix n°" + k + " : " + jeu.getThemesSelectionnes().get(k) );
            }
            System.out.println("Joueur : " + jeu.getJoueursJeu().get(i % 2) + " Entrer l'entier du thème voulut");
            int themeChoisit = scanner.nextInt();
            jeu.selectionQuestion(jeu.getThemesSelectionnes().get(themeChoisit));
            jeu.poserQuestions(i%2);
        }

        System.out.println("La dernière phase est finie et nous avons un gagnat ! :");
        jeu.trouverGagnant();
    }
}
