package application;

import java.util.Scanner;

public class Vf extends Question{
    private String text;
    private boolean answer;

    private static Scanner scanner = new Scanner(System.in);
    
    public Vf(){
        super();
        text = "";
        answer = false;
    }

    //inutile je pense car on a la méthode de saisie
    //Nous la gardons en attendant de voir l'implémentation des phases de jeux.
    public Vf(String text, boolean answer, String theme, int niveau ){
        super(theme, niveau);
        this.text = text;
        this.answer = answer;
    }

    public void saisie(){
        System.out.println("Ajout d'une question de types Vrai faux Quel est le theme de la question ?");       
        super.setTheme(scanner.nextLine());        
        System.out.println("Quel est l'enonce de la question ?");        
        this.text = scanner.nextLine();        
        System.out.println("Quel est le niveau de la question ?");        
        this.niveau = scanner.nextInt();        
        System.out.println("Quelle est la réponse de la question ? (true / false ?)");
        this.answer = scanner.nextBoolean();        
        System.out.println("Question enregistrée.");
    }

    @Override
    public String toString(){
        String string = "";
        string = ("Cette question VF est la numero " + this.numero + "  portant sur le theme de " + this.theme.getNom() + " de niveau " + this.niveau + ". \n L'enonce est : " + this.text + "\n" + "réponse attenude: 1 pour vrai et 2 pour faux \n");
        return string;
    }

    public static String saisieTest(){
        System.out.println("Ajout d'une question de types Vrai faux Quel est le theme de la question ?");       
        String theme = scanner.nextLine();        
        System.out.println("Quel est l'enonce de la question ?");        
        String enonce = scanner.nextLine();        
        System.out.println("Quel est le niveau de la question ?");        
        int niveau = scanner.nextInt();        
        System.out.println("Quelle est la réponse de la question ? (true / false ?)");
        boolean answer = scanner.nextBoolean();        
        System.out.println("Question enregistrée.");
        return "Vf, q" + 100 + "," +enonce + "," + answer + "," + theme + "," + niveau +";";
    }

    //on prend que pour les VF l'utilisateur entrera 1 pour vrai et 2 pour faux
    public boolean verificationReponse(String reponseDonnee){
        if (reponseDonnee.equals("1")){
            return true == this.answer;
        }
        else{
            return this.answer == false;
        }
    }


}
