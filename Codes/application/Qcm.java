package application;

import java.util.Scanner;

public class Qcm extends Question {
    private String text;
    private String[] answers = new String[3];
    private int repJuste;

    private static Scanner scanner = new Scanner(System.in);

    //faut-il ajouter un tableau des questions deja crées ?

    public Qcm(){
        super(1);
        this.text = "";
        this.answers[0] = "";
        this.answers[1] = "";
        this.answers[2] = "";
        this.repJuste = 0;
    }

    //inutile je pense car on a la méthode de saisie
    //Nous la gardons en attendant de voir l'implémentation des phases de jeux.
    public Qcm(String text, String prop1, String prop2, String prop3, int bonneProp, String theme, int niveau){
        super(theme, niveau, 1);
        this.text = text;
        this.answers[0] = prop1;
        this.answers[1] = prop2;
        this.answers[2] = prop3;
        this.repJuste = bonneProp;
    }

    public void saisie(){
        System.out.println("Ajout d'une question de types QCM Quel est le theme de la question ?");
        super.setTheme(scanner.next());
        System.out.println("Quel est l'enonce de la question ?");
        this.text = scanner.next();
        System.out.println("Quelle est le choix n°1 de la question ? ");
        this.answers[0] = scanner.next();
        System.out.println("Quelle est le choix n°2 de la question ? ");
        this.answers[1] = scanner.next();
        System.out.println("Quelle est le choix n°3 de la question ? ");
        this.answers[2] = scanner.next();
        System.out.println("Quel est le niveau de la question");
        this.niveau = scanner.nextInt();
        System.out.println("Quelle est la bonne réponse de la question ? (numéro)");
        this.repJuste = scanner.nextInt();        
        System.out.println("Question enregistrée.");
    }
    public String saisieDev(){
        System.out.println("Ajout d'une question de types QCM Quel est le theme de la question ?");
        super.setTheme(scanner.next());
        System.out.println("Quel est l'enonce de la question ?");
        this.text = scanner.next();
        System.out.println("Quelle est le choix n°1 de la question ? ");
        this.answers[0] = scanner.next();
        System.out.println("Quelle est le choix n°2 de la question ? ");
        this.answers[1] = scanner.next();
        System.out.println("Quelle est le choix n°3 de la question ? ");
        this.answers[2] = scanner.next();
        System.out.println("Quel est le niveau de la question");
        this.niveau = scanner.nextInt();
        System.out.println("Quelle est la bonne réponse de la question ? (numéro)");
        this.repJuste = scanner.nextInt();        
        System.out.println("Question enregistrée.");
        return "Qcm, " + "q" + this.numero + "," +this.text + "," + this.answers[0] + ","+ this.answers[1] + ","+ this.answers[2] + "," + this.repJuste + "," +  this.theme.getNom() + "," + this.niveau;
    }

    @Override
    public String toString(){
        String string = "";
        string = ("Cette question QCM est la numero " + (this.numero) + " portant sur le theme de " + this.theme.getNom() + " de niveau " + this.niveau + ". \n L'enonce est : " + this.text + "\n" + "entrer le numéro de la bonne réponse \n");
        int indice = 0;
        for (String rep : answers ){
            string = string + "Choix n°" + (indice + 1);
            string = string + ":" + rep;
            string += "\n";
            indice++;
                }
        return string;
    }

    public boolean verificationReponse(String reponseDonnee) throws ExceptionReponse{
        if(reponseDonnee.equals("1") || reponseDonnee.equals("2") || reponseDonnee.equals("3")){
            return (Integer.parseInt(reponseDonnee.replaceAll("\\s+","")) == this.repJuste);
        }
        throw new ExceptionReponse();
        
    }

}