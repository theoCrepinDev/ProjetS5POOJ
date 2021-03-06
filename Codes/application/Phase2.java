/*
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
Méthodes nécéssaire au déroulement de la phase 1
Séléection des joueurs > sélection du thème  > pose la question > met a jour le score > gère les égalités
Ces méthode suive le déroulement indiqué dans le Sujet
*/
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Phase2 implements Phase {
    private List<Joueur> joueursSelectionnes;   
    private int derniereQuestionSelec;
    private Question questionAPoser;
    private List<Theme> themesSelectiones;
    private int dernierThemeSelectionne;
    
    private static Scanner scanner = new Scanner(System.in);

    public Phase2(Phase phase1){
        this.joueursSelectionnes = phase1.getJoueursJeu();
        this.derniereQuestionSelec = phase1.getDerniereQuestionSelectionnee();
        this.dernierThemeSelectionne = phase1.getDerniereThemeSelectionnee();
    }

    public Phase2(List<Joueur> gagnants) {
        this.joueursSelectionnes = gagnants;
        this.dernierThemeSelectionne = -1;
        this.derniereQuestionSelec = 0;
    }

    //fonction pour savoir si il y a plusieurs joueurs avec le score le plus faible
    @Override
    public boolean uniquePerdant(){
        int scorePerdantTemp = joueursSelectionnes.get(0).getScore();
        int nbrPerdant = 0;
        long tempsReponseTemp = joueursSelectionnes.get(0).getElapsedTime();
        for(Joueur joueur : joueursSelectionnes){
            if(joueur.getEtat() == "SELECTIONNE" && joueur.getScore() == scorePerdantTemp && joueur.getElapsedTime() == tempsReponseTemp){
                nbrPerdant ++;
            }
            if(joueur.getEtat() == "SELECTIONNE" && joueur.getScore() == scorePerdantTemp && joueur.getElapsedTime() > tempsReponseTemp){
                nbrPerdant = 1;
                scorePerdantTemp = joueur.getScore();
                tempsReponseTemp = joueur.getElapsedTime();
            }
            if(joueur.getEtat() == "SELECTIONNE" && joueur.getScore() < scorePerdantTemp){
                nbrPerdant = 1;
                scorePerdantTemp = joueur.getScore();
                tempsReponseTemp = joueur.getElapsedTime();
            }
        }
        return nbrPerdant == 1;
    }

    //fonction qui renvoit une liste des joueurs aynt le plus faible score
    @Override
    public List<Integer> getPerdants(){
        List<Integer> perdants = new ArrayList<>();
            int nbrPointsTemps = joueursSelectionnes.get(0).getScore();
            //on recherche le joueur de joueursSelectionne avec le moins de poinrs et on le supprime
            for(int i = 0; i < joueursSelectionnes.size(); i++){
                if(joueursSelectionnes.get(i).getScore() < nbrPointsTemps && joueursSelectionnes.get(i).getEtat() == "SELECTIONNE"){
                    nbrPointsTemps = joueursSelectionnes.get(i).getScore();
                }
            }
            for(int i = 0; i < joueursSelectionnes.size(); i++){
                if(joueursSelectionnes.get(i).getScore() == nbrPointsTemps){
                    perdants.add(i);
                }
            }
        return perdants;
    }

    @Override
    public void selectionJoueurs() {
        //ne supprime un joueur que si il y en a 4, sinon on est dans un grand jeu donc début avec 3 joueurs
        if (joueursSelectionnes.size() == 4) {
            if (uniquePerdant()) {
                int nbrPointsTemps = joueursSelectionnes.get(0).getScore();
                Joueur joueurPerdantTemp = joueursSelectionnes.get(0);
                long tempsReponseTemp = joueurPerdantTemp.getElapsedTime();
                //on recherche le joueur de joueursSelectionne avec le moins de poinrs et on le supprime
                for(Joueur joueur : joueursSelectionnes){
                    if(joueur.getScore() < nbrPointsTemps && joueur.getEtat() == "SELECTIONNE"){
                        joueurPerdantTemp = joueur;
                        nbrPointsTemps = joueur.getScore();
                        tempsReponseTemp = joueur.getElapsedTime();
                    }
                    else{
                        if(joueur.getScore() == nbrPointsTemps && joueur.getEtat() == "SELECTIONNE" && joueur.getElapsedTime() > tempsReponseTemp){
                            joueurPerdantTemp = joueur;
                            nbrPointsTemps = joueur.getScore();
                            tempsReponseTemp = joueur.getElapsedTime();
                        }
                    }
                }
                joueurPerdantTemp.changementEtat("ELIMINE");
                joueursSelectionnes.remove(joueurPerdantTemp);
            }
            else{
                //création d'un tableau contenant les dernier avec des timer egaux
                List<Integer> perdants = getPerdants();
                int nbrPerdants = perdants.size();
                Random rand = new Random();
                int indicePerdant = rand.nextInt(nbrPerdants);
                joueursSelectionnes.get(perdants.get(indicePerdant)).changementEtat("ELIMINE");
                joueursSelectionnes.remove(joueursSelectionnes.get(perdants.get(indicePerdant)));
    
                
            }
        }
                
    }

    @Override
    public void selectionTheme() {
        // TODO Auto-generated method stub
        this.themesSelectiones = new ArrayList<>();
        this.themesSelectiones = Themes.get6ThemesAl();        
    }

    @Override
    public void selectionQuestion( Theme theme) {
        // TODO Auto-generated method stub
        int nbrQuestion = Questions.getQuestions().size();
        Question resultat = Questions.getQuestion(this.derniereQuestionSelec);
        for(int i = 0; i <nbrQuestion; i++){
            if(!Questions.getQuestion(i).getPosee() && Questions.getQuestion(i).getNiveau() == 2 && Questions.getQuestion(i).getTheme().getNom().equals(theme.getNom())){
                resultat = Questions.getQuestion(i);
                this.derniereQuestionSelec = i;
                this.questionAPoser = resultat;
                resultat.setPosee(true);
                break;
            }
        }
    }

    @Override
    public void poserQuestions(int indiceJoueurConcerne) throws InterruptedException {
        // TODO Auto-generated method stub
        System.out.println("Cette question est pour le joueur nomé: " + joueursSelectionnes.get(indiceJoueurConcerne).getNom() + " ");     
        System.out.println(questionAPoser);
        joueursSelectionnes.get(indiceJoueurConcerne).startTimer();
        String reponseDonnee = "";
        if(joueursSelectionnes.get(indiceJoueurConcerne).isIa()){
            System.out.println("L'Ia choisit une réponse ...");
            switch (questionAPoser.getType()) {
                //QCM
                case 1:
                    reponseDonnee = Ia.getRepQCM();
                    break;
                //VF
                case 2:
                    reponseDonnee = Ia.getRepVf();
                    break;
                //RC
                case 3:
                    reponseDonnee = Ia.getRepRC();
                    break;
            }
        }else{
            reponseDonnee = scanner.nextLine();
        }
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
                        joueursSelectionnes.get(indiceJoueurConcerne).ajoutScore(3);
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
        return this.themesSelectiones;
    }
    
    @Override
    public void trouverGagnant() {
        // TODO Auto-generated method stub
        
    }    

    public int getDerniereQuestionSelectionnee(){
        return this.derniereQuestionSelec;
    }

    @Override
    public int getDerniereThemeSelectionnee() {
        // TODO Auto-generated method stub
        return this.dernierThemeSelectionne;
    }

    @Override
    public void setDernierThemeSelectionne(int theme){
        this.dernierThemeSelectionne = theme;
    }

    @Override
    public void trouverGrandGagnant() {
        // TODO Auto-generated method stub
        
    }
}
