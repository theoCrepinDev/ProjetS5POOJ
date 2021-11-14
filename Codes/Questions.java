import java.util.ArrayList;
import java.util.List;
//implémentation loin d'être faites et visualisée
public class Questions extends Themes {

    //curieux je ne sais pas si il faut qu'elle extends theme ou pas 
    private List<Question> questions = new ArrayList<Question>();

    //Que dois faire le constructeur ?

    public void ajoutQuestion(Question question){
        questions.add(question);
    }
    
    public void supprimerQeustion(int index){
        questions.remove(index);
    }

    //les méthodes de séléction d'une quesion
    // a définir dans la phase de jeux

    @Override
    public String toString(){
        String string ="";
        for (Themes theme : super.themes){
            string = string + "Il y a le théme :" + theme ;
            string = string + "avec les question : \n";
            for (Question question : questions){
                String themQuestionActuelle = question.getTheme();
                if (theme.getNom() == themQuestionActuelle){
                    string = string + question.toString() + "\n";
                }
            }
        }
        return string;
    }
}