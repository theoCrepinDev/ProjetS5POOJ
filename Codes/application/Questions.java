/*
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
    Implémente le gestion de la liste de toutes les questions
    avec les fonction de sélections
*/
package application;

import java.util.ArrayList;
import java.util.List;
public class Questions{

    private static List<Question> questions = new ArrayList<Question>();


    public static void ajoutQuestion(Question question){
        questions.add(question);
    }
    
    public static void supprimerQeustionIndex(int index){
        questions.remove(index);
    }

    public static void supprimerQuestionNumero(int numero){
        int index = 0;
        for(int i = 0; i < questions.size(); i++){
            if(questions.get(i).numero == numero){
                index =  i;
            }
        }
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