/* 
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
    classe qui créer le fonctionnement de la phase 1, 2 et 3 qui serons ensuite appellées
    dans le jeu pour faire dérouler les parties
*/

package application;

import java.util.List;
import java.util.Scanner;

public class Jouer {
    private Phase jeu;
    private static Scanner scanner = new Scanner(System.in);
    private static int dernierThemeSelectionne = -1;

    public Jouer(){
        jeu = new Phase1();
    }

    //déclaration des 2 méthode pour les 3 phases de jeu.

    public Jouer(List<Joueur> gagnants) {
        jeu = new Phase2(gagnants);
    }

    //réalise la phase 1 avec les méthide de l'interface phase et lance la phase 2
    public void jouerPhase1(){
        jeu.setDernierThemeSelectionne(dernierThemeSelectionne);
        jeu.selectionJoueurs();
        System.out.println("Bienvenu chère joueurs, la Phase 1 va pourvoir commencer....");
        System.out.println("Voici les joueurs sélectionnés pour cette phase :");
        System.out.println(jeu.getJoueursJeu());

        //pose une question a chasque joueur
        for(int i = 0; i < 4; i++){
            jeu.selectionTheme();
            jeu.selectionQuestion(jeu.getThemesSelectionnes().get(0));
            try {
                jeu.poserQuestions(i);
            } catch (InterruptedException e) {
                System.out.println("Il y a un problème avec l'exécution de l'IA pour le choix automatique des réponses.");
            }
        }
        
        //on vérifie qu'il n'y a pas d'égalité et si il y en a on repose des questions aux joueurs 
        //étant en égalité
        int nbrQuestionSupp = 0;
        while(!jeu.uniquePerdant() && nbrQuestionSupp < 3){
            System.out.println("il y a plusieurs perdant, égalité de score et de temps de réponse, nous allons les départager en trois question maximum..");
            System.out.println("Si après cela il y a toujours égalité ils serons départagés aléatoirement au début de la phase suivante");;
            List<Integer> perdants =jeu.getPerdants();
            for(int i : perdants){
                jeu.selectionTheme();
                jeu.selectionQuestion(jeu.getThemesSelectionnes().get(0));
                try {
                    jeu.poserQuestions(i);
                } catch (InterruptedException e) {
                    System.out.println("Il y a un problème avec l'exécution de l'IA pour le choix automatique des réponses.");
                }
            }
            nbrQuestionSupp++;
        }

        System.out.println("Félicitation, la phase 1 est finie, vici les résultat :");
        System.out.println(jeu.getJoueursJeu());

        dernierThemeSelectionne = jeu.getDerniereThemeSelectionnee();

        int choix = 0;
        while(choix != 1 && choix != 2){
            System.out.println("Souaitez vous passer à la pahse 2 ? \n 1 oui 2 arrêter le jeu ici ..");
            choix = scanner.nextInt();
            if(choix == 1){
                jeu = new Phase2(jeu);
                this.jouerPhase2();
            }
        }
        
    }

    //réalise la phase 2 avec les méthide de l'interface phase et lance la phase 3
    public void jouerPhase2(){
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
            try {
                System.out.println("Joueur : " + jeu.getJoueursJeu().get(i % 3).getNom() + " Entrer l'entier du thème voulut");
                int themeChoisit = scanner.nextInt();
                jeu.selectionQuestion(jeu.getThemesSelectionnes().get(themeChoisit));
                jeu.poserQuestions(i % 3);
                jeu.getThemesSelectionnes().remove(themeChoisit);
                
            } catch (Exception e) {
                while(true){
                        System.out.println("Entrer un entier entre O et " + (5 - i));
                        System.out.println("Joueur : " + jeu.getJoueursJeu().get(i % 3).getNom() + " Entrer l'entier du thème voulut");
                        String nvxThemeChoisit = scanner.nextLine();
                    try {
                        int theme = Integer.parseInt(nvxThemeChoisit);
                        jeu.selectionQuestion(jeu.getThemesSelectionnes().get(theme));
                        jeu.poserQuestions(i % 3);
                        jeu.getThemesSelectionnes().remove(theme);
                        break;
                    } catch (Exception f) {
                        
                    }
                    
                }

            }
            
        }
        //on vérifie qu'il n'y a pas d'égalité et si il y en a on repose des questions aux joueurs 
        //étant en égalité
        int nbrQuestionSupp = 0;
        while(!jeu.uniquePerdant() && nbrQuestionSupp < 3){
            System.out.println("il y a plusieurs perdant, égalité de score et de temps de réponse, nous allons les départager en trois question maximum..");
            System.out.println("Si après cela il y a toujours égalité ils serons départagés aléatoirement au début de la phase suivante");;
            List<Integer> perdants =jeu.getPerdants();
            for(int i : perdants){
                jeu.selectionQuestion(Themes.getTheme((dernierThemeSelectionne + 1) % Themes.getNbrThemes()));
                dernierThemeSelectionne++;
                try {
                    jeu.poserQuestions(i);
                } catch (InterruptedException e) {
                    System.out.println("Il y a un problème avec l'exécution de l'IA pour le choix automatique des réponses.");
                }
            }
            nbrQuestionSupp++;
        }

        System.out.println("Félicitation, la phase 2 est finie, vici les résultat :");
        System.out.println(jeu.getJoueursJeu());

        int choix = 0;
        while(choix != 1 && choix != 2){
            System.out.println("Souaitez vous passer à la pahse 3 ? \n 1 oui 2 arrêter le jeu ici ..");
            choix = scanner.nextInt();
        }
            if(choix == 1){
                this.jouerPhase3();
            }
    }

    //réalise la phase 3 avec les méthide de l'interface phase et affiche le gagnant
    public void jouerPhase3(){
        jeu = new Phase3(jeu);
        jeu.selectionJoueurs();
        System.out.println("Bienvenue dans la dernière phase de ce jeu, un gagnant sera désigné à la fin de cette série de questions");
        System.out.println("Voici les joueurs en jeu pour cette phase : ");
        System.out.println(jeu.getJoueursJeu());

        jeu.selectionTheme();
        for(int i = 0; i < 6; i++){
            System.out.println("Voici les thèmes disponnibles :");
            for(int k = 0; k < jeu.getThemesSelectionnes().size(); k++){
                System.out.println("Choix n°" + k + " : " + jeu.getThemesSelectionnes().get(k) );
            }
            try {
                System.out.println("Joueur : " + jeu.getJoueursJeu().get(i % 2).getNom() + " Entrer l'entier du thème voulut");
                int themeChoisit = scanner.nextInt();
                jeu.selectionQuestion(jeu.getThemesSelectionnes().get(themeChoisit));
                jeu.poserQuestions(i % 2);
                
            } catch (Exception e) {
                while(true){
                        System.out.println("Entrer un entier entre O et 2");
                        System.out.println("Joueur : " + jeu.getJoueursJeu().get(i % 2).getNom() + " Entrer l'entier du thème voulut");
                        String nvxThemeChoisit = scanner.nextLine();
                    try {
                        int theme = Integer.parseInt(nvxThemeChoisit);
                        jeu.selectionQuestion(jeu.getThemesSelectionnes().get(theme));
                        jeu.poserQuestions(i % 2);
                        break;
                    } catch (Exception f) {
                        
                    }
                    
                }

            }
        }
        //on vérifie qu'il n'y a pas d'égalité et si il y en a on repose des questions aux joueurs 
        //étant en égalité
        int nbrQuestionSupp = 0;
        while(!jeu.uniquePerdant() && nbrQuestionSupp < 3){
            System.out.println("il y a plusieurs perdant, égalité de score et de temps de réponse, nous allons les départager en trois question maximum..");
            System.out.println("Si après cela il y a toujours égalité ils serons départagés aléatoirement au début de la phase suivante");;
            List<Integer> perdants =jeu.getPerdants();
            for(int i : perdants){
                jeu.selectionTheme();
                jeu.selectionQuestion(jeu.getThemesSelectionnes().get(0));
                try {
                    jeu.poserQuestions(i);
                } catch (InterruptedException e) {
                    System.out.println("Il y a un problème avec l'exécution de l'IA pour le choix automatique des réponses.");
                }
            }
            nbrQuestionSupp++;
        }

        System.out.println("La dernière phase est finie et nous avons un gagnat ! :");
        jeu.trouverGagnant();
    }

    //déclaration de la méthode de grand jeu
    public void grandJeu(){
        if(Joueurs.getNbrJoueursDisponnibles() < 12){
            System.out.println("Il n'y a pas assez de joueurs disponnible pour faire un grand jeu\nIl faut au minimum 12 joueurs.");
        }else{
            for(int i = 0; i < 3; i++){
                Jouer jeu = new Jouer();
                jeu.jouerPhase1();
                System.out.println(Joueurs.getJoueur());
                Themes.resetIndicateursThemes();
                Questions.resetIndicateursQuestion();
                System.out.print("LE prochain jeu va commencer ... (entrer n'importe quelle lettre)");
                scanner.next();
            }
            List<Joueur> gagnants = Joueurs.selectionGagnants();
            Jouer jeuGagnant = new Jouer(gagnants);
            jeuGagnant.jouerPhase2();
            jeuGagnant.jeu.trouverGrandGagnant();
        }
    }
}
