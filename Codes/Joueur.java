public class Joueur {
    private int numero;
    private String nom;
    private int score;
    private String etat;
    private int numeroActuel = 100;
    

    public Joueur(String nom){
        this.nom = nom;
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.score = 0;
        this.etat = "ATTENTE";
    }

    public String tooString(){
        return "Le joueur : " + this.nom + "sous le numero : " + this.numero + "est actuellement : " + this.etat + " avec un score de : " + this.score;
    }

    public void ajoutScore(int ajout){ this.score += ajout; }

    public void changementEtat(String etat){ this.etat = etat ;}
}
