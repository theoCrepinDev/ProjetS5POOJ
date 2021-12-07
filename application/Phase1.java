package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phase1 implements Phase {
    private List<Joueur> joueursSelectionnes;
    private int dernierThemeSelectionne;    
    private int derniereQuestionSelec;
    private Question questionAPoser;
    private Theme themeSelectionne;

    private static Scanner scanner = new Scanner(System.in);

    public Phase1(){
        this.joueursSelectionnes = new ArrayList<>();
        this.dernierThemeSelectionne = -1;
        this.derniereQuestionSelec = 0;
    }

    @Override
    public void selectionJoueurs() {
        // TODO Auto-generated method stub
        joueursSelectionnes.add(Joueurs.selectionAlJoueur());
        joueursSelectionnes.add(Joueurs.selectionAlJoueur());
        joueursSelectionnes.add(Joueurs.selectionAlJoueur());
        joueursSelectionnes.add(Joueurs.selectionAlJoueur());        
    }

    @Override
    public void selectionTheme() {
        // TODO Auto-generated method stub
        int nbrThemes = Themes.getNbrThemes();
        Theme themeTemp = Themes.themes.get((this.dernierThemeSelectionne + 1) % nbrThemes);
        this.themeSelectionne = themeTemp;
        dernierThemeSelectionne++;
    }

    @Override
    public void selectionQuestion(Theme theme) {
        // TODO Auto-generated method stub
        int nbrQuestion = Questions.getQuestions().size();
        Question resultat = Questions.getQuestion(this.derniereQuestionSelec);
        for(int i = 0; i <nbrQuestion; i++){
            if(!Questions.getQuestion(i).getPosee() && Questions.getQuestion(i).getNiveau() == 1 && Questions.getQuestion(i).getTheme().getNom().equals(theme.getNom())){
                resultat = Questions.getQuestion(i);
                this.derniereQuestionSelec = i;
                this.questionAPoser = resultat;
                resultat.setPosee(true);
                break;
            }
        }
    }

    @Override
    public void poserQuestions(int indiceJoueurConcerne) {
        // TODO Auto-generated method stub
        System.out.println("Cette question est pour le joueur nomé: " + joueursSelectionnes.get(indiceJoueurConcerne).getNom() + " ");     
        System.out.println(questionAPoser);
        String reponseDonnee = "";
        reponseDonnee = scanner.nextLine();
        boolean bonneReponse = questionAPoser.verificationReponse(reponseDonnee);
        if(bonneReponse){
            System.out.println("\u001B[32m" + "Félicitation c'est une bonne réposne, votre score a été mis à jour" + "\u001B[0m");
            joueursSelectionnes.get(indiceJoueurConcerne).ajoutScore(2);
        }
        else{
            System.out.println("\u001B[31m" + "Mauvaise Réponse, pas de poitns accordé ..." + "\u001B[0m");
        }
    }

    @Override
    public List<Joueur> getJoueursJeu() {
        // TODO Auto-generated method stub
        return this.joueursSelectionnes;
    }

    @Override
    public List<Theme> getThemesSelectionnes() {
        // TODO Auto-generated method stub
        List<Theme> resulat = new ArrayList<>();
        resulat.add(this.themeSelectionne);
        return resulat;
    }
    
    @Override
    public void trouverGagnant() {
        // TODO Auto-generated method stub
        
    }

    public int getDerniereQuestionSelectionnee(){return this.derniereQuestionSelec;}    
}
