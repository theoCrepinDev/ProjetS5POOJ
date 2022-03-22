/*
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
    Définition du menu qui permet à l'utilisateur de naviguer
    dans les options du jeux et de gestion du jeu
*/
package application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import testapplication.TestJeux;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public static void menu() throws FileNotFoundException{
        
        int menu = 0; 
        while (menu <= 0 || menu > 4 ){
            System.out.println("que voulez vous faire: \n \n choisissez ce que vous voulez: \n 1: jeu \n 2: settings \n 3: developper \n 4: exit");
            menu = scanner.nextInt();
            //faire exception pour farouk ?  
            if(menu <= 0 || menu > 4 ){
                System.out.println("le chifre saisie n'est pas dans le menu");
            }
        }
        if (menu == 1){
            int sousMenu = 0;
            System.out.println("Ques voulez-vous faire :\n\n1: Lancer une jeu classique \n2:Faire un grand jeu (3 jeux classiques et 1 grand jeu)");
            sousMenu = scanner.nextInt();
            while(sousMenu <= 0 || sousMenu > 2){
                System.out.println("Le chiffre saisie n'est pas valide.");
                System.out.println("Ques voulez-vous faire :\n\n1: Lancer une jeu classique \n2:Faire un grand jeu (3 jeux classiques et 1 grand jeu)");
                sousMenu = scanner.nextInt();
            }
            switch (sousMenu) {
                case 1:
                    if(Joueurs.getNbrJoueursDisponnibles() < 4){
                        System.out.println("Impossible, pas assez de joueurs en attente");
                    }else{
                        TestJeux.lanceJeu();
                    }
                    break;
                case 2:
                if(Joueurs.getNbrJoueursDisponnibles() < 12){
                    System.out.println("Impossible, pas assez de joueurs en attente");
                }else{
                    TestJeux.lanceGrandJeu();
                }
                break;
            }
            
        }
        if (menu == 2){
            int sousMenu = 0;
            System.out.println("Ques voulez-vous faire :\n\n1: afficher les questions par Thèmes\n2:afficher les Thèmes\n3:afficher les joueurs et leur état\n4:générer 20 joueurs");
            sousMenu = scanner.nextInt();
            while(sousMenu <= 0 || sousMenu > 4){
                System.out.println("Le chiffre saisie n'est pas valide.");
                System.out.println("Ques voulez-vous faire :\n\n1: afficher les questions par Thèmes\n2:afficher les Thèmes\n3:afficher les joueurs et leur état");
                sousMenu = scanner.nextInt();
            }
            switch (sousMenu) {
                case 1:
                    System.out.println(Questions.getQuestions());
                    break;
                case 2:
                    System.out.println(Themes.getThemes());
                    break;
                case 3:
                    System.out.println(Joueurs.getJoueur());
                    break;
                case 4:
                    Joueurs.generation20Joueurs();
                    break;
            }
            
            // afficher question par theme / afficher theme / afficher question d'un nv par theme / afficher joueur et etat / 
        }
        if (menu == 3){
            int sousMenu = 0;
            System.out.println("Ques voulez-vous faire :\n\n1: Ajouter une question\n2:Ajouter un Thème\n3:Supprimer une question\n4:Ajouter un joueur");
            sousMenu = scanner.nextInt();
            while(sousMenu <= 0 || sousMenu > 4){
                System.out.println("Le chiffre saisie n'est pas valide.");
                System.out.println("Ques voulez-vous faire :\n\n1: Ajouter une question\n2:Ajouter un Thème\n3:Supprimer une question\n4:Ajouter un joueur");
                sousMenu = scanner.nextInt();
            }
            switch (sousMenu) {
                case 1:
                    GestionFichier.askForQuestion();
                    break;
                case 2:
                    GestionFichier.askForTheme();
                    break;
                case 3:
                    System.out.println("Vous supprimer une question à partir de son numéro,\nvous pouvez trouver le numéro d'une question dans le menu:\nSettings > afficher les question par thème");
                    String continuer = "0";
                    System.out.println("Entrer 1 pour s'arreter et n'importe quoi d'autre pour continuer");
                    continuer = scanner.next();
                    if(!continuer.equals("1")){
                        int numero;
                        System.out.println("Entrer le numéro de la question a supprimer :");
                        numero = scanner.nextInt();
                        Questions.supprimerQuestionNumero(numero);
                    }
                    break;
                case 4:
                    (new Joueur()).saisie();
            }
            //developper { ajout questions / ajouter theme / supprimer question }

        }
        if (menu == 4){
             System.exit(0);
        }

    }
    public static void main(String[] args) throws FileNotFoundException{
        menu();
    }
    
}
