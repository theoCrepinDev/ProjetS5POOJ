public class Question {
    private int numero;
    private int numeroActuel = 1;

    public Question(){
        this.numero = numeroActuel;
        numeroActuel += 1;
    }
}
