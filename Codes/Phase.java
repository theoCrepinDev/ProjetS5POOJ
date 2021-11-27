import java.util.ArrayList;

public interface Phase {
    ArrayList<Joueur> selectionJoueurs();
    ArrayList<Themes> selectionTheme();
    void poserQuestions();
}
