package application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import testapplication.TestJeux;

public class Menu {

    public static void menu() throws FileNotFoundException{
        
        int menu = 0; 
        while (menu <= 0 || menu > 4 ){
            Scanner scanner = new Scanner(System.in);
            System.out.println("que voulez vous faire: \n \n choisissez ce que vous voulez: \n 1: jeu \n 2: settings \n 3: developper \n 4: exit");
            menu = scanner.nextInt();
            //faire exception pour farouk ?  
            if(menu <= 0 || menu > 4 ){
                System.out.println("le chifre saisie n'est pas dans le menu");
            }
        }
        if (menu == 1){
            TestJeux.lanceJeu();
            
        }
        if (menu == 2){
            // afficher question par theme / afficher theme / afficher question d'un nv par theme / afficher joueur et etat / 
        }
        if (menu == 3){
            //developper { ajout questions / ajouter theme / supprimer question }
            GestionFichier.askForQuestion();

        }
        if (menu == 4){
             System.exit(0);
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
        menu();
    }
    
}
