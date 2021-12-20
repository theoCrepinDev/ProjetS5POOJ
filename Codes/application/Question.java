/*
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
Implémente la Struture commune des trois types de Question possible
*/
package application;

import java.util.Scanner;

//class abstract car la définition des méthode de saisie et 
//d'affihcage dépend du type de la question
public abstract class Question extends Questions {
    protected int numero;
    private static int numeroActuel = 1;
    protected Theme theme;
    protected int niveau;
    //indicateur pour =è
    private boolean posee;
    //type de question 1 QCM 2 VF 3 RC
    private int type;

    private static Scanner scanner = new Scanner(System.in);

    public Question(int type){
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.theme = Themes.getTheme(0);
        this.niveau = 0;
        super.ajoutQuestion(this);
        this.posee = false;
        this.type = type;
    }
    public Question(String theme, int niveau, int type){
        this.numero = numeroActuel;
        numeroActuel += 10;       
        this.type = type;
        int temp;
        try {
            temp = Themes.getIndiceOfTheme(theme);
            this.theme = Themes.getTheme(temp);
        } catch (ExceptionTheme e) {
            // TODO Auto-generated catch block
            System.out.println("erreur constru");
            
        }
        this.niveau = niveau;
        super.ajoutQuestion(this);
        this.posee = false;
    }
    
    //méthode get et set pour arg poséé
    public void setPosee(boolean posee){
        this.posee = posee;
    }

    public boolean getPosee(){
        return posee;
    }

    public void setTheme(String nomTheme){
        int temp;
        try {
            temp = Themes.getIndiceOfTheme(nomTheme);
            this.theme = Themes.getTheme(temp);
        } catch (ExceptionTheme e) {
            // TODO Auto-generated catch block
            while(true){
                System.out.println("Ce thème n'existe pas entrer un nouveau thème");
                String nvxTheme = scanner.nextLine();
                try {
                    temp = Themes.getIndiceOfTheme(nvxTheme);
                    this.theme = Themes.getTheme(temp);
                    break;
                } catch (Exception f) {
                    //TODO: handle exception
                }
            }
        }
    }
    //les méthodes de séléction d'une quesion
    // a définir dans la phase de jeux

    //renvoit le theme de la question en String
    public Theme getTheme(){
        return this.theme;
    }

    //renvoit le niveau de la question
    public int getNiveau(){
        return this.niveau;
    }

    //1 QCM 2 VF 3 RC
    public int getType(){
        return this.type;
    }

    @Override
    public abstract String toString();

    public abstract void saisie();

    public abstract String saisieDev();

    public abstract boolean verificationReponse(String reponseDonnee) throws ExceptionReponse;
}