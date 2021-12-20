/* 
Projet question réponse 2021 GUERIMAND, CREPIN, PHILIPPE, BURETTE
    Classe qui implément l'"IA" qui permet de donnée une réponse automatique
    avec un délai de réponse aléatoire compris entre 0 et 10 secondes lorsque 
    l'on définit un joueur comme controlé par une IA

    elle contient une liste de toute les réponse courtes présente dans le programme
     et en choisit une au hasard lorsqu'une réponse courte est attendue
*/

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ia {
    private static List<String> reponsesCourtes = new ArrayList<>();
    private static Random rand = new Random();

    public Ia(){

    }

    //ajout la réponse courte dans la liste lors de l'ajout d'une nouvelle réponse courte
    public static void ajoutRC(String reponseCourte){
        reponsesCourtes.add(reponseCourte);
    }

    //les trois méthodes suivantes renvoit une réponse d'un tye corect
    public static String getRepRC() throws InterruptedException{
        int nbrRC = reponsesCourtes.size();
        int indiceRepAl = rand.nextInt(nbrRC);
        int tempsPause = rand.nextInt(11);
        Thread.sleep(tempsPause * 1000);
        return reponsesCourtes.get(indiceRepAl);
    }

    public static String getRepQCM() throws InterruptedException{
        int choixAl = rand.nextInt(3) + 1;
        int tempsPause = rand.nextInt(11);
        Thread.sleep(tempsPause * 1000);
        return "" + choixAl;
    }

    public static String getRepVf() throws InterruptedException{
        int choixAl = rand.nextInt(2) + 1;
        int tempsPause = rand.nextInt(11);
        Thread.sleep(tempsPause * 1000);
        return "" + choixAl;
    }    
}
