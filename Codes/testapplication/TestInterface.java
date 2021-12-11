package testapplication;

import java.util.Scanner;

public class TestInterface {

    public static void main(String[] args){
        int menu = 0; 
        while (menu <= 0 || menu > 3 ){
            Scanner scanner = new Scanner(System.in);
            System.out.println("que voulez vous faire: \n \n choisissez ce que vous voulez: \n 1: jeu \n 2: settings \n 3: developper ");
            menu = scanner.nextInt();
            //faire exception pour farouk ?  
            if(menu <= 0 || menu > 3 ){
                System.out.println("le chifre saisie n'est pas dans le menu");
            }
        }
        if (menu == 1){
            TestJeux.lanceJeu();
            
        }
        if (menu == 2){
            //settings ??
        }
        if (menu == 3){
            //developper { ajout questions ( voir pour si question dans document)}
        }

    }
    
}
