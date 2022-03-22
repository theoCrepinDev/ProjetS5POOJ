/*
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
Classe pour la gestion des exceptions liées au réponses données aux questions
*/

package application;

public class ExceptionReponse extends Exception {
    private String message;

    public ExceptionReponse(){
        this.message = "mauvais format de réponse";
    }

    public String getMessage(){
        return this.message;
    }
    
}
