package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ia {
    private static List<String> reponsesCourtes = new ArrayList<>();
    private static Random rand = new Random();

    public Ia(){

    }

    public static void ajoutRC(String reponseCourte){
        reponsesCourtes.add(reponseCourte);
    }

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
