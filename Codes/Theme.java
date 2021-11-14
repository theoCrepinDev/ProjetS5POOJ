import java.util.ArrayList;

public class Theme{
    private String nom;
    private boolean indicateur;
    protected ArrayList<Theme> themes = new ArrayList<Theme>();
    
    public Theme(){
        this.nom = "";
        this.indicateur = false;
        themes.add(this);
    }

    public Theme(String nom){
        this.nom = nom;
        this.indicateur = false;
        themes.add(this);
    }

    public int getIndiceOfTheme(String nom){
        int position = -1;
        int indiceActuel = 0;
            for (Theme theme : themes){
                if (theme.nom == nom){
                    return indiceActuel;
                }
                else{
                    indiceActuel++;
                }
            }
        return position;
    }

    public int[] getIndicesOf5Themes(String nom1, String nom2, String nom3, String nom4,String nom5){
        int[] indices = new int[5];
        String[] noms = {nom1, nom2, nom3, nom4, nom5};
        for (int i = 0; i < 5; i++){
            indices[i] = getIndiceOfTheme(noms[i]);
        }
        return indices;
    }

    @Override
    public String toString(){
        String string = "";
        for (Theme theme : themes){
            if (theme.indicateur == false){
                string = string + ("le theme " + this.nom + " n'a pas encore etait choisit \n");
            }
            else{
                string = string + ("le theme " + this.nom + " a deja etait choisit \n");
            }
        }
        return string;
    }
}
