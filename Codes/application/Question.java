package application;

//class abstract car la définition des méthode de saisie et 
//_à)/d'affihcage dépend du type de la question
public abstract class Question extends Questions {
    protected int numero;
    private static int numeroActuel = 1;
    protected Theme theme;
    protected int niveau;
    //indicateur pour =è
    private boolean posee;

    public Question(){
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.theme = Themes.getTheme(0);
        this.niveau = 0;
        super.ajoutQuestion(this);
        this.posee = false;
    }
    public Question(String theme, int niveau){
        this.numero = numeroActuel;
        numeroActuel += 10;
        int temp = Themes.getIndiceOfTheme(theme);
        this.theme = Themes.getTheme(temp);
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
        int temp = Themes.getIndiceOfTheme(nomTheme);
        this.theme = Themes.getTheme(temp);
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

    @Override
    public abstract String toString();

    public abstract void saisie();

    public abstract boolean verificationReponse(String reponseDonnee);
}