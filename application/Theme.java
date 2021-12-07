package application;

public class Theme{
    private String nom;
    private boolean indicateur;
    
    public Theme(){
        this.nom = "";
        //indicateur à faux si le thème n'a pas encore était choisit
        this.indicateur = false;
    }

    public Theme(String nom){
        this.nom = nom;
        this.indicateur = false;
    }
    

    //méthode permettant de renvoyer le String du nom du thème
    public String getNom(){
        return this.nom;
    }

    public boolean getIndicateur(){return this.indicateur;}

    public void setIndicateur(boolean bool){this.indicateur = bool;}

    public void setNom(String nom){this.nom = nom;}

    @Override
    public String toString(){
        return "Le thème se nome " +this.nom + "\n";
    }
}
