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
        if(scanner.hasNextLine()){
            super.setTheme(scanner.nextLine());
        }
        System.out.println("Quel est l'enonce de la question ?");
        if(scanner.hasNextLine()){
            this.text = scanner.nextLine();
        }
        System.out.println("Quel est le niveau de la question ?");
        if(scanner.hasNextInt()){
            this.niveau = scanner.nextInt();
        }
        System.out.println("Quelle est la réponse de la question ? (true / false ?)");
        if(scanner.hasNextBoolean()){
            this.answer = scanner.nextBoolean();
        }
        System.out.println("Question enregistrée.");
    }

    @Override
    public String toString(){
        String string = "";
        string = ("Cette question VF est la numero " + this.numero + "  portant sur le theme de " + this.theme.getNom() + " de niveau " + this.niveau + ". \n L'enonce est : " + this.text + "\n" + "réponse attenude: 1 pour vrai et 2 pour faux \n");
        return string;
    }

    //on prend que pour les VF l'utilisateur entrera 1 pour vrai et 2 pour faux
    public boolean verificationReponse(String reponseDonnee) throws ExceptionReponse{
        if (reponseDonnee.replaceAll("\\s+","").equals("1")){
            return true == this.answer;
        }
        if(reponseDonnee.replaceAll("\\s+","").equals("2")){
            return this.answer == false;
        }
        throw new ExceptionReponse();
    }

}
