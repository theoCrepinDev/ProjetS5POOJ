import java.util.ArrayList;

public class Themes{
    private String nom;
    private boolean indicateur;
    protected ArrayList<Themes> themes = new ArrayList<Themes>();
    
    public Themes(){
        this.nom = "";
        this.indicateur = false;
        themes.add(this);
    }

    public Themes(String nom){
        this.nom = nom;
        this.indicateur = false;
        themes.add(this);
    }

    public int getIndiceOfTheme(String nom){
        int position = -1;
        int indiceActuel = 0;
            for (Themes theme : themes){
                if (theme.nom == nom){
                    return indiceActuel;
                }
                else{
                    indiceActuel++;
                }
            }
        return position;
    }

    //méthode renvoyant les 5 indices des 5 themes données en argument mais est-elle nécessaire
    //ou alors la compréhensions du text du sujet est-elle à revoir ?
    public int[] getIndicesOf5Themes(String nom1, String nom2, String nom3, String nom4,String nom5){
        int[] indices = new int[5];
        String[] noms = {nom1, nom2, nom3, nom4, nom5};
        for (int i = 0; i < 5; i++){
            indices[i] = getIndiceOfTheme(noms[i]);
        }
        return indices;
    }

    //méthode permettant de renvoyer le String du nom du thème
    public String getNom(){
        return this.nom;
    }

    @Override
    public String toString(){
        String string = "";
        for (Themes theme : themes){
            if (!theme.indicateur){
                string = string + ("le theme " + this.nom + " n'a pas encore etait choisit \n");
            }
            else{
                string = string + ("le theme " + this.nom + " a deja etait choisit \n");
            }
        }
        return string;
    }
}
