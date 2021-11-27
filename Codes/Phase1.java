import java.util.ArrayList;

public class Phase1 implements Phase {
    private static int dernierThemeSelectionne;
    private static ArrayList<Joueur> joueursSelectionnes;

    public Phase1(){
        dernierThemeSelectionne = 0;
    }

    public ArrayList<Joueur> selectionJoueurs(){
        joueursSelectionnes = new ArrayList<>();
        joueursSelectionnes.add(Joueurs.selectionAlJoueur());
        joueursSelectionnes.add(Joueurs.selectionAlJoueur());
        joueursSelectionnes.add(Joueurs.selectionAlJoueur());
        joueursSelectionnes.add(Joueurs.selectionAlJoueur());
        return joueursSelectionnes;
    }

    public ArrayList<Themes> selectionTheme(){
        ArrayList<Themes> themesSelectionnes = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            themesSelectionnes.add(Themes.getTheme((dernierThemeSelectionne + i) % 10 ));
        }
        return themesSelectionnes;
    }

    public void poserQuestions(){
 
    }
    
}
