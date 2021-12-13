package application;

import java.util.Scanner;

public class Joueur{
    private int numero;
    private String nom;
    private int score;
    //etat "SELECTIONNE";"GAGNANT";"SUPER-GAGNANT";"ELIMINE";"ATTENTE"
    private String etat;
    private static int numeroActuel = 100;
    //on rajoute un timer par joueur pour connaitre leur temps de réponse total
    private Timer timer;
    
    public Joueur(){
        this.nom = "";
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.score = 0;
        this.etat = "ATTENTE";
        timer = new Timer();
    }

    public Joueur(String nom){
        this.nom = nom;
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.score = 0;
        this.etat = "ATTENTE";
        timer = new Timer();
    }

    public void saisie(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Quel est le nom du joueur ?");
        this.nom = scanner.nextLine();
        scanner.close();
        
    }

    @Override
    public String toString(){
        return "Le joueur : " + this.nom + " sous le numero : " + this.numero + " est actuellement : " + this.etat + " avec un score de : " + this.score + " avec un temp de réponse de :" + this.timer.getElapsedTime() + "\n";
    }

    public void ajoutScore(int ajout){ this.score += ajout; }

    public void changementEtat(String etat){ this.etat = etat ;}

    public String getEtat(){return this.etat;}

    public int getScore(){return this.score;}

    public String getNom(){return this.nom;}

    //méthode gestion timer
    public void startTimer(){
        this.timer.startTimer();
    }

    public void stopTimer(){
        this.timer.stopTimer();
    }

    public long getElapsedTime(){
        return this.timer.getElapsedTime();
    }
}
