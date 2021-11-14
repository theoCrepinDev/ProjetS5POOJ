import java.util.Scanner;

import javax.lang.model.util.AbstractTypeVisitor6;

//class abstract car la définition des méthode de saisie et 
//d'affihcage dépend du type de la question
public abstract class Question extends Questions {
    protected int numero;
    private int numeroActuel = 1;
    protected String theme;
    int niveau;

    public Question(){
        this.numero = numeroActuel;
        numeroActuel += 10;
        this.theme = "";
        this.niveau = 0;
        super.ajoutQuestion(this);
    }

    //les méthodes de séléction d'une quesion
    // a définir dans la phase de jeux

    //renvoit le theme de la question en String
    public String getTheme(){
        return this.theme;
    }

    @Override
    public abstract String toString();

    public abstract void saisie();

}