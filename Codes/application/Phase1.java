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

    //fonction pour savoir si il y a plusieurs joueurs avec le score le plus faible
    @Override
    public boolean uniquePerdant(){
        boolean resultat = true;
        int scorePerdantTemp = 0;
        long tempsReponseTemp = 0;
        for(Joueur joueur : joueursSelectionnes){
            if(joueur.getEtat() == "SELECTIONNE" && joueur.getScore() == scorePerdantTemp && joueur.getElapsedTime() == tempsReponseTemp){
                resultat = false;
            }
            if(joueur.getEtat() == "SELECTIONNE" && joueur.getScore() < scorePerdantTemp && joueur.getElapsedTime() > tempsReponseTemp){
                resultat = true;
                scorePerdantTemp = joueur.getScore();
                tempsReponseTemp = joueur.getElapsedTime();
            }
        }
        return resultat;
    }

    //fonction qui renvoit une liste des joueurs aynt le plus faible score
    @Override
    public List<Joueur> getPerdants(){
        List<Joueur> perdants = new ArrayList<>();
            int nbrPointsTemps = joueursSelectionnes.get(0).getScore();
            //on recherche le joueur de joueursSelectionne avec le moins de poinrs et on le supprime
            for(Joueur joueur : joueursSelectionnes){
                if(joueur.getScore() < nbrPointsTemps && joueur.getEtat() == "SELECTIONNE"){
                    nbrPointsTemps = joueur.getScore();
                }
            }
            for(Joueur joueur: joueursSelectionnes){
                if(joueur.getScore() == nbrPointsTemps){
                    perdants.add(joueur);
                }
            }
        return perdants;
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
        joueursSelectionnes.get(indiceJoueurConcerne).startTimer();
        String reponseDonnee = "";
        reponseDonnee = scanner.nextLine();
        boolean bonneReponse;
        try {
            bonneReponse = questionAPoser.verificationReponse(reponseDonnee);
            if(bonneReponse){
                System.out.println("\u001B[32m" + "Félicitation c'est une bonne réposne, votre score a été mis à jour" + "\u001B[0m");
                joueursSelectionnes.get(indiceJoueurConcerne).ajoutScore(3);
            }
            else{
                System.out.println("\u001B[31m" + "Mauvaise Réponse, pas de poitns accordé ..." + "\u001B[0m");
            }
            joueursSelectionnes.get(indiceJoueurConcerne).stopTimer();
        } catch (ExceptionReponse e) {
            while(true){
                System.out.println("Mauvais format de réponse donnée, \n entrer 1,2 ou 3 pour une quqestion QCM \n entre 1 pour true et 2 pour false pour un vrai/false \n entrer une réponse courte pour une réponse courte");
                String newReponse = scanner.nextLine();
                try {
                    boolean newBonneReponse = questionAPoser.verificationReponse(newReponse);
                    if(newBonneReponse){
                        System.out.println("\u001B[32m" + "Félicitation c'est une bonne réposne, votre score a été mis à jour" + "\u001B[0m");
                        joueursSelectionnes.get(indiceJoueurConcerne).ajoutScore(2);
                    }
                    else{
                        System.out.println("\u001B[31m" + "Mauvaise Réponse, pas de poitns accordé ..." + "\u001B[0m");
                    }
                    joueursSelectionnes.get(indiceJoueurConcerne).stopTimer();
                    break;
                } catch (Exception f) {
                    //TODO: handle exception
                }
            }
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
