import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Joueurs extends Joueur{
    private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();

    public Joueurs(){
        // ce n'est pas logique il faut re réfléchir à ce que doit faire le constructeur de cette class
        super();
        joueurs.add(this);
    }

    public Joueur selectionAlJoueur(){
        int nbrJoueurs = joueurs.size();
        Random rand = new Random();
        int indicejoueurChoisit = rand.nextInt(nbrJoueurs - 1);
        return joueurs.get(indicejoueurChoisit);
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