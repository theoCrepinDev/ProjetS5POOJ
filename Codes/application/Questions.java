package application;

import java.util.ArrayList;
import java.util.List;
//implémentation loin d'être faites et visualisée
public class Questions{

    //curieux je ne sais pas si il faut qu'elle extends theme ou pas 
    private static List<Question> questions = new ArrayList<Question>();

    //Que dois faire le constructeur ?

    public void ajoutQuestion(Question question){
        questions.add(question);
    }
    
    public void supprimerQeustion(int index){
        questions.remove(index);
    }

    public static List<Question> getQuestions(){
        return questions;
    }

    public static Question getQuestion(int i){
        return questions.get(i);
    }

    //les méthodes de séléction d'une quesion
    // a définir dans la phase de jeux

    @Override
    public String toString(){
        String string ="";
        for (Theme theme : Themes.themes){
            string = string + " \n Il y a le théme : " + theme.getNom() ;
            string = string + " avec les question : \n";
            for (Question question : questions){
                Theme themQuestionActuelle = question.getTheme();
                if (theme.getNom() == themQuestionActuelle.getNom()){
                    string = string + question.toString() + "\n";
                }
            }
        }
        return string;
    }

    public static void resetIndicateursQuestion(){
        for (Question question : questions) {
            question.setPosee(false);
        }
    }
}