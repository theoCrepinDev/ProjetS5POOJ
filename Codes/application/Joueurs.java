package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueurs{
    private static List<Joueur> joueurs = new ArrayList<Joueur>();

    public Joueurs(){
        // ce n'est pas logique il faut re réfléchir à ce que doit faire le constructeur de cette class
        joueurs = new ArrayList<Joueur>();
    }

    //Modifier car modifi l'état du joueur
    //fonction qui renvoit un joueur aléatoir qui est en attente
    public static Joueur selectionAlJoueur(){
        //déclaration de rand pour obtenir des entiers aléatoirs
        int nbrJoueurs = joueurs.size();
        Random rand = new Random();
        String etatJoueurTemp;
        Joueur joueurTemp;
        int indiceAleatoir = 0;
        indiceAleatoir = rand.nextInt(nbrJoueurs);
        joueurTemp = joueurs.get(indiceAleatoir);
        etatJoueurTemp = joueurTemp.getEtat();
        while(etatJoueurTemp != "ATTENTE"){
            //on sélectionne un indice aléatoire et on stock la valeur de l'indicateur
            indiceAleatoir = rand.nextInt(nbrJoueurs);
            joueurTemp = joueurs.get(indiceAleatoir);
            etatJoueurTemp = joueurTemp.getEtat();
        }
        joueurTemp.changementEtat("SELECTIONNE");
        return joueurTemp;
    }

    public static void generation20Joueurs(){
        String[] alphabet = {"A", "B", "C", "D", "E","F", "G", "H", "I","J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"};
        for (String lettre : alphabet){
            Joueur joueur = new Joueur(lettre);
            joueurs.add(joueur);
        }
    }

    @Override
    public String toString(){
        String string = "";
        for (Joueur joueur : joueurs){
            string = string + joueur.toString() + "\n";
        }
        return string;
    }

    public static List<Joueur> getJoueur(){return Joueurs.joueurs;}

    public static int getNbrJoueursDisponnibles(){
        int joueursDisponnibles = 0;
        for(Joueur joueur : joueurs){
            if(joueur.getEtat() == "ATTENTE"){
                joueursDisponnibles++;
            }
        }
        return joueursDisponnibles;
    }

    public static List<Joueur> selectionGagnants(){
        List<Joueur> gagnants = new ArrayList<>();
        for (Joueur joueur : joueurs){
            if(joueur.getEtat() == "GAGNANT"){
                joueur.changementEtat("SELECTIONNE");
                gagnants.add(joueur);
            }
        }
        return gagnants;
    }
}