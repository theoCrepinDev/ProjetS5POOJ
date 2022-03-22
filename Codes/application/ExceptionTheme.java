/*
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
Classe pour la gestion des exception liée à la recherche du theme demandé dans la listes des Thèmes
Par exemple lorsque l'ont rentre une nouvelle question, si l'ont mets un thème qui 
n'est pas dans la liste, le programme va nous demander de rentrer un nouveau thème
*/
package application;

public class ExceptionTheme extends Exception {

    private String message;

    public ExceptionTheme(String nomTheme){
        this.message = "Le thème "+ nomTheme + " n'est pas présent dans la liste des thème...";
    }

    public String getMessage(){
        return message;
    }
    
}
