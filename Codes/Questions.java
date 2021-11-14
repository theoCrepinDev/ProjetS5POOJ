import java.util.ArrayList;
import java.util.List;
//implémentation loin d'être faites et visualisée
public class Questions extends Theme {

    //curieux je ne sais pas si il faut qu'elle extends theme ou pas 
    protected int numero;
    private int numeroActuel = 1;
    protected String theme;
    private List<Questions> questions = new ArrayList<Questions>();
    int niveau;

    public Questions(){
        this.numero = numeroActuel;
        numeroActuel += 1;
        questions.add(this);
        
    }

    
}
