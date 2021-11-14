import java.util.Scanner;

public class Joueur{
    private int numero;
    private String nom;
    private int score;
    private String etat;
    private int numeroActuel = 100;
    
    public Joueur(){
        this.nom = "";
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.score = 0;
        this.etat = "ATTENTE";
    }

    public Joueur(String nom){
        this.nom = nom;
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.score = 0;
        this.etat = "ATTENTE";
    }

    public void saisie(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Quel est le nom du joueur ?");
        this.nom = scanner.nextLine();
        scanner.close();
        
    }

    @Override
    public String toString(){
        return "Le joueur : " + this.nom + "sous le numero : " + this.numero + "est actuellement : " + this.etat + " avec un score de : " + this.score;
    }

    public void ajoutScore(int ajout){ this.score += ajout; }

    public void changementEtat(String etat){ this.etat = etat ;}
}
