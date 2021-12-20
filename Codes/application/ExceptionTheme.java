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
