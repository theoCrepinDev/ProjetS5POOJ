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
    private static Scanner scanner =new Scanner(System.in);
    //boolean pour savoir si la réponse est donnée par une IA ou par l'utilisateur
    private boolean iaControl;

    public Joueur(){
        this.nom = "";
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.score = 0;
        this.etat = "ATTENTE";
        timer = new Timer();
        iaControl = false;
    }

    public Joueur(String nom){
        this.nom = nom;
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.score = 0;
        this.etat = "ATTENTE";
        timer = new Timer();
        int choixControl = 0;
        while(choixControl != 1 && choixControl != 2){
            System.out.println("Voulez vous que ce joueur " + this.nom + " soit controlé par L'IA ou par un utilisateur ?\n1 pour IA\n2 pour utilisateur");
            choixControl = scanner.nextInt();
        }
        if(choixControl == 1){
            iaControl = true;
        }else{
            iaControl = false;
        }
    }

    public void saisie(){
        
        System.out.println("Quel est le nom du joueur ?");
        this.nom = scanner.nextLine();
        int choixControl = 0;
        while(choixControl != 1 && choixControl != 2){
            System.out.println("Voulez vous que ce joueur " + this.nom + " soit controlé par L'IA ou par un utilisateur ?\n1 pour IA\n2 pour utilisateur");
            choixControl = scanner.nextInt();
        }
        if(choixControl == 1){
            iaControl = true;
        }else{
            iaControl = false;
        }
        
    }

    @Override
    public String toString(){
        String s = "Le joueur : " + this.nom + " sous le numero : " + this.numero + " est actuellement : " + this.etat + " avec un score de : " + this.score + " avec un temp de réponse de :" + this.timer.getElapsedTime() + "\n";
        if (iaControl){
            s += " controlé par une IA\n";
        }else{
            s += " controlé par un utilisateur\n";
        }
        return s;
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

    public boolean isIa(){ return this.iaControl; }

    //méthode de test pour mettre la valeur du timer à x secondes
    public void setTimmer(long x){
        this.timer.setTimmer(x);
    }
}
