package application;

import java.util.Scanner;

public class AjoutQuestion {
    private int idQuestion = 100;
    private String type; 
    private String question;
    private String reponse;
    private String theme;
    private int difficulté;


    public AjoutQuestion(String type, String question, String reponse, String theme, int difficulté){
        this.type = type;
        this.question = question; 
        this.reponse = reponse; 
        this.theme = theme; 
        this.difficulté = difficulté; 
    }

    public void infoQuestion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("quel type de question voulez vous ajouter? ");
        type = scanner.nextLine();

        if (type )
        
        System.out.println("quel question voulez vous poser? ");
        question = scanner.nextLine();
        
        System.out.println("quel est la reponse? ");
        reponse = scanner.nextLine();
        
        System.out.println("quel est le theme? ");
        theme = scanner.nextLine();
        
        System.out.println("quel est la difficulté? ");
        difficulté = scanner.nextLine();
    }
}
