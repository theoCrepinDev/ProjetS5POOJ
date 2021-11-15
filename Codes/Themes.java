import java.util.ArrayList;
import java.util.Random;

public class Themes{
    private String nom;
    private boolean indicateur;
    protected ArrayList<Themes> themes = new ArrayList<Themes>();
    
    public Themes(){
        this.nom = "";
        //indicateur à faux si le thème n'a pas encore était choisit
        this.indicateur = false;
        themes.add(this);
    }

    public Themes(String nom){
        this.nom = nom;
        this.indicateur = false;
        themes.add(this);
    }

    //fonction renvoit -1 si le thème n'existe pas ou n'est pas dispo?
    public int getIndiceOfTheme(String nom){
        int nonTrouve = -1;
        int positionActuel = 0;
        for(Themes theme : themes){
            if(theme.nom == nom){
                if(theme.indicateur == true){
                    return nonTrouve;
                }
                else{
                    return positionActuel;
                }
            }
        }
        return nonTrouve;
    }

    //Cette fonction renvoit aléatoirement 6 themes de la grande liste de thèmes
    //elle met les indicateurs de ces thèmes à true pour indiquer qu'ils ont étaient sélectionnés
    public Themes[] get6ThemesAl(){
        //déclaration de rand pour obtenir des entiers aléatoires
        Themes[] themesChoisis = new Themes[6];
        Random rand = new Random();
        int nbrThemes = themes.size();
        boolean indicaThemeTemp = false;
        Themes themeTemp;
        int indiceAleatoir = 0;
        for(int i =0; i < 6; i++){
            while(!indicaThemeTemp){
                //on séléection un indice aléatoir et on stock la valeur de l'indicateur du thème associé 
                indiceAleatoir = rand.nextInt(nbrThemes -1);
                themeTemp = themes.get(indiceAleatoir);
                indicaThemeTemp = themeTemp.indicateur;
                themesChoisis[i] = themeTemp;
            }
            //si le theme peut etre sélectionné on passe la valeur de son indicateur à true
            themes.get(indiceAleatoir).indicateur = true;
        }
        //on renvoit le tableau des 6 themes choisit
        return themesChoisis; 
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
