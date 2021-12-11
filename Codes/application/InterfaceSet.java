package application;


import java.util.Scanner;

public class InterfaceSet {
    private static int choixSet;

    /* Les entiers vont definir le choix de l'utilisateur; 
    1 = Jeu == renvoie au jeu; appelle de TestJeu 
    2 = settings == creer des options 
    3 = interface dévelppeur == rajout de question 
    */

    public InterfaceSet(){
        this.choixSet = choixSet;
    }

    public void setInterface(int choixSet){
        this.choixSet = choixSet;
    }

    public int getInterface(){
        return this.choixSet;
    }

    public  void selectSet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("que voulez vous faire: \n \n choisissez ce que vous voulez: \n 1: jeu \n 2: settings \n 3: developper ");
        int menu = scanner.nextInt();
        setInterface(menu);
    }

    public static void selectInterface(){

    }

    @Override
    public String toString(){
        return "vous avez choisis " + choixSet;
    }

    
}
