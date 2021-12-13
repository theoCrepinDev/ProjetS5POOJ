package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phase3 implements Phase {
    private List<Joueur> joueursSelectionnes;   
    private int derniereQuestionSelec;
    private Question questionAPoser;
    private List<Theme> themesSelectiones;

    private static Scanner scanner = new Scanner(System.in);

    public Phase3(Phase phase2){
        this.joueursSelectionnes = phase2.getJoueursJeu();
        this.derniereQuestionSelec = phase2.getDerniereQuestionSelectionnee();
    }

    @Override
    public void selectionJoueurs() {
        // TODO Auto-generated method stub
        int nbrPointsTemps = joueursSelectionnes.get(0).getScore();
        Joueur joueurPerdantTemp = joueursSelectionnes.get(0);
        //on recherche le joueur de joueursSelectionne avec le moins de poinrs et on le supprime
        for(Joueur joueur : joueursSelectionnes){
            if(joueur.getScore() <= nbrPointsTemps && joueur.getEtat() == "SELECTIONNE"){
                joueurPerdantTemp = joueur;
                nbrPointsTemps = joueur.getScore();
            }
        }
        joueurPerdantTemp.changementEtat("ELIMINE");
        joueursSelectionnes.remove(joueurPerdantTemp);
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
    public void poserQuestions(int indiceJoueurConcerne) {
        // TODO Auto-generated method stub
        System.out.println("Cette question est pour le joueur nomé: " + joueursSelectionnes.get(indiceJoueurConcerne).getNom() + " ");     
        System.out.println(questionAPoser);
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

    @Override
    public int getDerniereQuestionSelectionnee() {
        // TODO Auto-generated method stub
        return 0;
    }    
}
