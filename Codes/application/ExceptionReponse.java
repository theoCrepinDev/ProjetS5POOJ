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
