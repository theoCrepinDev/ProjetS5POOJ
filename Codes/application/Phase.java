/*
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
    Interface qui permet de réaliser les action nécéssaires au jeu en fonction de la phase en cours

*/
package application;

import java.util.List;

public interface Phase {
    void selectionJoueurs();
    void selectionTheme();
    void selectionQuestion(Theme theme);
    void poserQuestions(int indiceJoueurConcerne) throws InterruptedException;
    List<Joueur> getJoueursJeu();
    List<Theme> getThemesSelectionnes();
    void trouverGagnant();
    int getDerniereQuestionSelectionnee();
    boolean uniquePerdant();
    List<Integer> getPerdants();
    int getDerniereThemeSelectionnee();
    void setDernierThemeSelectionne(int dernierThemeSelectionne);
    void trouverGrandGagnant();
}
