/*
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
Implémente les méthodes abstraite et toutes les fonctionnélité propre au Réponse courtes
*/
package application;

import java.util.Scanner;

public class Rc extends Question{
    private String text;
    private String answer;

    private static Scanner scanner = new Scanner(System.in);

        //faut-il ajouter un tableau des questions deja crées ?

    public Rc(){
        super(3);
        text = "";
        answer = "";
    }
    
    public Rc(String text, String answer, String theme, int niveau){
        super(theme, niveau, 3);
        this.text = text;
        this.answer = answer;
    }

    //permet la saisie d'une question
    public void saisie(){
        System.out.println("ha Quel est le theme de la question ?");
        super.setTheme(scanner.nextLine());
        System.out.println("Quel est l'enonce de la question ?");
        this.text = scanner.nextLine();        
        System.out.println("Quelle est la réponse de la question ? ");
        this.answer = scanner.nextLine();        
        System.out.println("Quel est le niveau de la question ?");
        this.niveau = scanner.nextInt();        
        
        System.out.println("Question enregistrée.");
    }
    //permet la saisie d'une question et renvoit ce qui doit être inscrit dans le fichier donnees.txt
    public String saisieDev(){
        System.out.println("Ajout d'une question de types Réponse courte Quel est le theme de la question ?");       
        String theme = scanner.next();        
        super.setTheme(theme);
        System.out.println("Quel est l'enonce de la question ?");
        this.text = scanner.next();         
        System.out.println("Quelle est la réponse de la question ?");   
        this.answer = scanner.next();       
        System.out.println("Quel est le niveau de la question ?");
        this.niveau = scanner.nextInt();
        System.out.println("Question enregistrée.");
        return "RC, " + this.numero + "," +this.text + "," + this.answer + "," + this.theme.getNom() + "," + this.niveau;
    }

    @Override
    public String toString(){
        String string = "";
        string = ("Cette question VF est la numero " + this.numero + " portant sur le theme de " + this.theme.getNom() + " de niveau " + this.niveau + ". \n L'enonce est : " + this.text + "\n" + "entrer votre réponse courte: \n");
        return string;
    }

    public boolean verificationReponse(String reponseDonnee){
        return this.answer.toLowerCase().replaceAll("\\s+","").equals(reponseDonnee.toLowerCase().replaceAll("\\s+",""));
    }

}