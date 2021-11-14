import java.util.Scanner;

public class Vf extends Types{
    private String text;
    private boolean answer;
    
        //faut-il ajouter un tableau des questions deja crées ?

    public Vf(){
        super();
        this.text = "";
        this.answer = false;
    }

    public Vf(String text, boolean answer){
        super();
        this.text = text;
        this.answer = answer;
    }

    public void saisie(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le theme de la question ?");
        this.theme = scanner.nextLine();
        System.out.println("Quel est le niveau de la question ?");
        this.niveau = scanner.nextInt();
        System.out.println("Quel est l'enonce de la question ?");
        this.text = scanner.nextLine();
        System.out.println("Quelle est la réponse de la question ? (true / false ?)");
        this.answer = scanner.nextBoolean();
        System.out.println("Question enregistrée.");
        scanner.close();
    }

    @Override
    public String toString(){
        String string = "";
        string = ("Cette question VF est la numero " + this.numero + "portant sur le theme de " + this.theme + " de niveau " + this.niveau + ". \n L'enonce est : " + this.answer + "\n");
        return string;
    }

}
