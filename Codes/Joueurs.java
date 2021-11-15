import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Joueurs{
    private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();

    public Joueurs(){
        // ce n'est pas logique il faut re réfléchir à ce que doit faire le constructeur de cette class
    }

    //Modifier car modifi l'état du joueur
    //fonction qui renvoit un joueur aléatoir qui est en attente
    public Joueur selectionAlJoueur(){
        //déclaration de rand pour obtenir des entiers aléatoirs
        int nbrJoueurs = joueurs.size();
        Random rand = new Random();
        String etatJoueurTemp;
        Joueur joueurTemp;
        int indiceAleatoir = 0;
        indiceAleatoir = rand.nextInt(nbrJoueurs - 1);
        joueurTemp = joueurs.get(indiceAleatoir);
        etatJoueurTemp = joueurTemp.getEtat();
        while(etatJoueurTemp != "ATTENTE"){
            //on sélectionne un indice aléatoire et on stock la valeur de l'indicateur
            indiceAleatoir = rand.nextInt(nbrJoueurs - 1);
            joueurTemp = joueurs.get(indiceAleatoir);
            etatJoueurTemp = joueurTemp.getEtat();
        }
        return joueurTemp;
    }

    public void generation20Joueurs(){
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
}