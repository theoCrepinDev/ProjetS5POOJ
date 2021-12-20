package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Phase3 implements Phase {
    private List<Joueur> joueursSelectionnes;   
    private int derniereQuestionSelec;
    private Question questionAPoser;
    private List<Theme> themesSelectiones;
    private int dernierThemeSelectionne;

    private static Scanner scanner = new Scanner(System.in);

    public Phase3(Phase phase2){
        this.joueursSelectionnes = phase2.getJoueursJeu();
        this.derniereQuestionSelec = phase2.getDerniereQuestionSelectionnee();
        this.dernierThemeSelectionne = phase2.getDerniereThemeSelectionnee();
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

    @Override
    public void selectionTheme() {
        // TODO Auto-generated method stub
        this.themesSelectiones = new ArrayList<>();
        themesSelectiones.add(Themes.getTheme(1));
        themesSelectiones.add(Themes.getTheme(3));
        themesSelectiones.add(Themes.getTheme(5));        
    }

    @Override
    public void selectionQuestion( Theme theme) {
        // TODO Auto-generated method stub
        int nbrQuestion = Questions.getQuestions().size();
        Question resultat = Questions.getQuestion(this.derniereQuestionSelec);
        for(int i = 0; i <nbrQuestion; i++){
            if(!Questions.getQuestion(i).getPosee() && Questions.getQuestion(i).getNiveau() == 3 && Questions.getQuestion(i).getTheme().getNom().equals(theme.getNom())){
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
                        joueursSelectionnes.get(indiceJoueurConcerne).ajoutScore(5);
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
        if(joueursSelectionnes.get(0).getScore() > joueursSelectionnes.get(1).getScore()){
            System.out.println("Félicitation le joueur " + joueursSelectionnes.get(0).getNom() + " a gané !!!!");
            joueursSelectionnes.get(1).changementEtat("ELIMINE");
            joueursSelectionnes.get(0).changementEtat("GAGNANT");
        }
        else{
            System.out.println("Félicitation le joueur " + joueursSelectionnes.get(1).getNom() + " a gané !!!!");
            joueursSelectionnes.get(0).changementEtat("ELIMINE");
            joueursSelectionnes.get(1).changementEtat("GAGNANT");
        }        
    }

    public void trouverGrandGagnant() {
        // TODO Auto-generated method stub
        if(joueursSelectionnes.get(0).getScore() > joueursSelectionnes.get(1).getScore()){
            System.out.println("Félicitation le joueur " + joueursSelectionnes.get(0).getNom() + " a gagné le GRAND-JEU !!!!");
            joueursSelectionnes.get(1).changementEtat("ELIMINE");
            joueursSelectionnes.get(0).changementEtat("GRAND-GAGNANT");
        }
        else{
            System.out.println("Félicitation le joueur " + joueursSelectionnes.get(1).getNom() + " a gagné le grand-JEU!!!!");
            joueursSelectionnes.get(0).changementEtat("ELIMINE");
            joueursSelectionnes.get(1).changementEtat("GRAND-GAGNANT");
        }        
    }

    @Override
    public int getDerniereQuestionSelectionnee() {
        // TODO Auto-generated method stub
        return 0;
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
    
}
