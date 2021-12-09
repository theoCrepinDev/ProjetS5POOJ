package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Themes{
    protected static List<Theme> themes = new ArrayList<>();

    public Themes(){
        List<Theme> themes = new ArrayList<>();
    }

    public Themes(String nom){
        List<Theme> themes = new ArrayList<>();
    }



    //méthodes de classes
    public static List<Theme> getThemes(){return themes;}

    //fonction renvoit -1 si le thème n'existe pas ou n'est pas dispo?
    public static int getIndiceOfTheme(String nom){
        int nonTrouve = -1;
        int positionActuel = 0;
        for(Theme theme:themes){
            if(theme.getNom().equals(nom)){
                return positionActuel;
            }
            positionActuel++;
        }
        return nonTrouve;
    }

    //Cette fonction renvoit aléatoirement 6 themes de la grande liste de thèmes
    //elle met les indicateurs de ces thèmes à true pour indiquer qu'ils ont étaient sélectionnés
    public static List<Theme> get6ThemesAl(){
        //déclaration de rand pour obtenir des entiers aléatoires
        List<Theme> themesChoisis = new ArrayList<>();
        Random rand = new Random();
        int nbrThemes = themes.size();
        for(int i =0; i < 6; i++){
        int indiceAleatoir = rand.nextInt(nbrThemes - 1);
        Theme themeTemp = Themes.themes.get(indiceAleatoir);
        boolean indicaThemeTemp = themeTemp.getIndicateur();
            while(indicaThemeTemp){
                //on séléection un indice aléatoir et on stock la valeur de l'indicateur du thème associé 
                indiceAleatoir = rand.nextInt(nbrThemes -1);
                themeTemp = Themes.themes.get(indiceAleatoir);
                indicaThemeTemp = themeTemp.getIndicateur();
            }
            themesChoisis.add(themeTemp);
            themeTemp.setIndicateur(true);
            //si le theme peut etre sélectionné on passe la valeur de son indicateur à true
            themes.get(indiceAleatoir).setIndicateur(true);
        }
        //on renvoit le tableau des 6 themes choisit
        return themesChoisis; 
    }

    public static void nouveauTheme(String nom){
        Theme theme = new Theme(nom);
        Themes.themes.add(theme);
    }

    public static void add(Theme theme){
        Themes.themes.add(theme);
    }

    //méthode pour renvoyer le thème à l'indice i
    public static Theme getTheme(int i){
        return themes.get(i);
    }

    //méthode renvoyant le nombre de themes
    public static int getNbrThemes(){
        return themes.size();
    }

    @Override
    public String toString(){
        String string = "";
        for (Theme theme : themes){
            if (!theme.getIndicateur()){
                string = string + (" le theme " + theme.getNom() + " n'a pas encore etait choisit \n");
            }
            else{
                string = string + ("le theme " + theme.getNom() + " a deja etait choisit \n");
            }
        }
        return string;
    }
}
