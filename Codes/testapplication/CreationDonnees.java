package testapplication;

import application.*;

public class CreationDonnees {

    public static void creer10Themes(){
        Themes.nouveauTheme("Géographie");
        Themes.nouveauTheme("Histoire");
        Themes.nouveauTheme("Français");
        Themes.nouveauTheme("Anglais");
        Themes.nouveauTheme("Mathématiques");
        Themes.nouveauTheme("Films");
        Themes.nouveauTheme("Musique");
        Themes.nouveauTheme("Sport");
        Themes.nouveauTheme("Physique");
        Themes.nouveauTheme("Informatique");
    }
    public static void creationQuestions(){
        Rc q1 = new Rc("En quelle année, Mao a-t-il lancé sa révolution culturelle ?","1966", "Histoire", 3);
        Qcm q2 = new Qcm("En France, en quelle année a débuté la IIIe République ?","1815", "1870", "1918", 2, "Histoire", 2 );
        Vf q3 = new Vf("La guerre d'Algérie a pris fin en 1962?", true, "Histoire", 1);
        Rc q4 = new Rc("En quelle année, la révolution des Œillets a-t-elle eu lieu au Portugal ?  ","1974", "Histoire", 2);
        Qcm q5 = new Qcm("En quelle année Salvador Allende a-t-il été renversé par Pinochet au Chili ?","1946", "1958", "1973", 3, "Histoire", 3 );
        Vf q6 = new Vf("Le mur de Berlin est tombé en 1992", false, "Histoire", 1);
        Rc q7 = new Rc("En quelle année, le commandant Massoud a-t-il été assassiné ?","2001", "Histoire", 2);
        Qcm q8 = new Qcm("En quelle année, Charles Martel a-t-il remporté la bataille de Poitiers ?","437", "732", "998", 2, "Histoire", 3 );
        Vf q9 = new Vf("En France la majorité à été abaissée à 18 ans en 1974.", true, "Histoire", 1);
    
        Rc q10 = new Rc("Dans quelle ville italienne se trouve la tour Pirelli ?", "Milan", "Géographie",1);
        Rc q11 = new Rc("Quel fleuve franchit le pont Vasco de Gama ?","Le Tage", "Géographie",2);
        Rc q12 = new Rc("Dans quelle ville européenne se trouve le pont Felipe II ?", "Barcelone", "Géographie",3);
        Qcm q13 = new Qcm("Quelle ville est surnommée la Fiancée de la Méditerranée ?","Alexandrie","Tunis", "Tel-Aviv",3, "Géographie",1);
        Qcm q14 = new Qcm("Dans quelle ville se trouve la Statue de la Liberté ?","Washington", "New York", "Chicago",2, "Géographie",2);
        Qcm q15 = new Qcm("Quel est le chef-lieu du département de l’Allier ?", "Moulins", "Montluçon", "Vichy", 1, "Géographie",3);
        Vf q16 = new Vf("Le Nil coule en Afrique", true, "Géographie",1);
        Vf q17 = new Vf("Le chateau d'If se trouve face à Rennes", false, "Géographie",2);
        Vf q18 = new Vf("Santiago est surnommée la Cité de grès rose.", false, "Géographie",3);
    
        Rc q19 = new Rc("À quel auteur doit-on le roman « Le Comte de Monte-Cristo » ?", "Alexandre Dumas", "Français",1);
        Rc q20 = new Rc("Quel auteur de polar a publié « Le Grand nulle part » ?","James Ellroy", "Français",2);
        Rc q21 = new Rc("À quel écrivain doit-on les « Illusions perdues » ?", "Honoré de Balzac", "Français",3);
        Qcm q22 = new Qcm("Quel auteur a livré ses « Mémoires d’outre-tombe » ?","Chateaubriand","Beaumarchais", "Flaubert",1, "Français",1);
        Qcm q23 = new Qcm("À quel auteur doit-on « La Chartreuse de Parme » ?","Hugo", "Stendhal", "Balzac",2, "Français",2);
        Qcm q24 = new Qcm("À quel auteur doit-on le roman « Moby Dick » ?", "William Faulkner", "Mark Twain", "Herman Melville", 3, "Français",3);
        Vf q25 = new Vf("Le roman <A rebours> est écrit J. -K Huysmans", true, "Français",1);
        Vf q26 = new Vf("Le roman <Le bruit et la fureur> est écrit par Rudyard Kipling.", false, "Français",2);
        Vf q27 = new Vf("Le roman <De sang-froid> est écrit par T.S. Eliot", false, "Français",3);
    
        Rc q28 = new Rc("Combien font 8 x 9", "72", "Mathématiques",1);
        Rc q29 = new Rc("Si 10 000 euros rapportent 280 euros d’intérêts. Combien rapportent 7 500 euros ?","210", "Mathématiques",2);
        Rc q30 = new Rc("Combien y a-t-il de décimètres (dm) dans 5 mètres", "50", "Mathématiques",3);
        Qcm q31 = new Qcm("Qu’est-ce qu’un triangle isocèle","Un triangle qui a un angle droit","Un triangle qui a trois côtés de même longueur", "Un triangle qui a deux côtés de même longueur",3, "Mathématiques",1);
        Qcm q32 = new Qcm("Si 20 km sont représentés par 5 cm sur une carte, quelle est l'échelle de cette carte ?","1/400000", "1/20000", "1/40",1, "Mathématiques",2);
        Qcm q33 = new Qcm("Quelle est la racine carrée de 36", "9", "12", "6", 3, "Mathématiques",3);
        Vf q34 = new Vf("Un losange avec un angle droit est un rectangle", false, "Mathématiques",1);
        Vf q35 = new Vf("Le cerlce est un polygone", false, "Mathématiques",2);
        Vf q36 = new Vf("La somme des angles d'un triangle est égale à 180°", true, "Mathématiques",3);
    
        Rc q37 = new Rc("le prétérite de abide", "abode", "Anglais",1);
        Rc q38 = new Rc("Quel est le participe passé de awake?","awoken", "Anglais",2);
        Rc q39 = new Rc("Quel est le prétérite de bet", "bet", "Anglais",3);
        Qcm q40 = new Qcm("Take a chair and sit ... me","beside","besides", "besided",1, "Anglais",1);
        Qcm q41 = new Qcm("He has a ... in the cupboard","skeleton", "body", "men",1, "Anglais",2);
        Qcm q42 = new Qcm("Canadians say that Vancouver is ... to live in than any other city", "easier", "easiest", "easy", 1, "Anglais",3);
        Vf q43 = new Vf("la phrase est juste ? : I have worked here since January", true, "Anglais",1);
        Vf q44 = new Vf("Shakespearse was born in Manchester", false, "Anglais",2);
        Vf q45 = new Vf("The great Fire destroyed London in 1666", true, "Anglais",3);
        
        Rc q90 = new Rc("Qu'elle est la durée d'un match de foot","90 minutes", "Sport", 1);
Qcm q89 = new Qcm("Qu'elle est la durée d'un match de rugby","90","80","45",2,"Sport", 2);
Vf q88 = new Vf("La durée d'une prolongation de football est de 10min? ",false, "Sport",3);
Rc q87 = new Rc("Qui a gagner la coupe du monde de foot de 2010","Espagne", "Sport", 3);
Qcm q86 = new Qcm("Qui est considéré comme le meilleur joueur de basket-ball de tous les temps ?","Micheal Jordan","Cobe Brian","Tony Parker",1,"Sport", 2);
Vf q85 = new Vf("Le temps d'un match de handball est de 60 minutes?",true, "Sport",1);
Rc q84 = new Rc("En qu'elle année l'escalade à été implémenté au JO ","2021", "Sport", 3);
Qcm q83 = new Qcm("le Yaniro est une technique utilisé en:","escalade","football","rugby",1,"Sport",1);
Vf q82 = new Vf("Il existe plusieurs catégorie par taille à l'escalade?",false, "Sport",2);


Rc q81 = new Rc("Qu'elle est le numéro atomique de l'hydrogène?","1", "Physique", 1);
Qcm q80 = new Qcm("Comment appelle-t-on le réseau internet hertzien sans fil ?","le wi-fi","la TNT","le FM",1,"Physique",1);
Vf q79 = new Vf("1 kilo est équivalent a 100 gramme",false, "Physique",1);
Rc q78 = new Rc("Qu'elle est le numéro atomique de l'argent?","43", "Physique", 3);
Qcm q77 = new Qcm("1 mètre cube d'eau est equivalent à: ","10 mètre","1000 litre","10 décimètrecube",2,"Physique",2);
Vf q76 = new Vf("Est ce que l'eau mouille?",true, "Physique",1);
Rc q75 = new Rc("Combien Newton à t'il inventé de théorèmes?","3", "Physique", 2);
Qcm q74 = new Qcm("Quel nom de physicien a-t-on donné à l’unité internationale de l'intensité du courant électrique ?","Ohm","Watt","Ampère",3,"Physique",3);
Vf q73 = new Vf("L'or est-il le métal le plus précieux? ",false, "Physique",2);

Rc q72 = new Rc("Qu'elle language informatique est aussi une danse?","JAVA","Informatique", 2);
Qcm q71 = new Qcm("Qui a inventé le JAVA","1990","1992","1985",2,"Informatique",3);
Vf q70 = new Vf("La programmation et le codage sont identiques?",false, "Informatique",2);
Rc q69 = new Rc("Qui à inventé un ordinateur fonctionnant à l'eau?","Vladimir Lukyanov", "Informatique",3);
Qcm q68 = new Qcm("Comment s'appelle les problèmes rencontrer en programation? ","des bugs"," des bogues","des tuilles",2,"Informatique",2);
Vf q67 = new Vf("Le premier programeur été une dame? ",true, "Informatique",2);
Rc q66 = new Rc("En quelle année a été fabriqué la machine de Turing","1936", "Informatique", 3);
Qcm q65 = new Qcm("Quel film à été le premier à avoir des scène entièrement faite par ordinateur?","Star Wars","Tron","Harry Potter",2,"Informatique",3);
Vf q64 = new Vf("Il est possible de renommer des dossier par n'importe quelle nom?",false, "Informatique",2);

Rc q63 = new Rc("Qu'elle est le CD le plus vendu","Thriller", "Musique", 2);
Rc q62 = new Rc("Quel titre Robin Thicke a-t-il interprété aux côtés de T.I et Pharell Williams ?","Blurred Lines", "Musique", 3);
Rc q61 = new Rc("De quel pays, les Beatles sont-ils originaires ?","Angleterre", "Musique", 2);
Qcm q60 = new Qcm(" Quel est le titre du second album studio de Stromae?","Formidable","Racine carree","Alors on danse",2,"Musique",2);
Qcm q59 = new Qcm("Quel groupe a interprété la chanson « C.R.E.A.M. » ?","Wu Tang clan","Black Eyed Peas","Public Enemy",1,"Musique",3);
Qcm q58 = new Qcm("Qui interprète le tube « Andalouse » ?","Keen' V","Julien Doré","Kendji Girac",3,"Musique",2);
Vf q57 = new Vf("Kanye West interprète le tube  Berzerk  ?",false, "Musique",2);
Vf q56 = new Vf("Le saxophoniste Charlie Parker été surnommé The bird?",true, "Musique",3);
Vf q55 = new Vf("Le groupe Fréro Delavega s’est fait connaître dans The Voice?",true, "Musique",2);

Rc q54 = new Rc("Quelle émission est animée par Jamy Gourmaud, Frédéric Courant, Sabine Quindou ?","C'est pas sorcier", "Films", 2);
Rc q53 = new Rc("Dans la 1ère saison de Prison Break, pour quel assassinat Lincoln Burrows est-il emprisonné à Fox River ?","Terrence Steadman", "Films", 3);
Rc q52 = new Rc("Combien y a t'il de Films de l'univers de star wars?","15", "Films", 3);
Qcm q51 = new Qcm("Qui a gagné la 1ère édition de Koh Lanta en 2001?","Gilles","Philippe","Christina",1,"Films",3);
Qcm q50 = new Qcm(" À quel numéro de la rue Evergreen Terrace les Simpson habitent-ils ?","69","115","742",3,"Films",2);
Qcm q49 = new Qcm("Dans la série Friends, combien de fois Ross s’est-il marié ?","0 fois","3 fois","5 fois",2,"Films",2);
Vf q48 = new Vf("Thalassa a été crée en 1980 ?",false, "Films",2);
Vf q47 = new Vf("C'est le sorcier qui choisi sa baguette? ",false, "Films",1);
Vf q46 = new Vf("Dans Harry Potter, Mimi Geignarde qui a 13 ans est incarnée par une actrice de 37 ans?",true, "Films",2);
    }
    
}
