package modele;

import java.util.ArrayList;

public class Model {

    private ArrayList<Joueur> listeJoueurs;
    private ArrayList<Carte> jeuCartes;
    private ArrayList<Carte> mesCartes;
    private ArrayList<Carte> cartesSuspects;
    private ArrayList<Carte> cartesObjets;
    private ArrayList<Carte> cartesLieux;

    private ArrayList<Carte> solution;

    public Model() {
        String[] listeCartes = { "Fenrir Greyback", "Lucius Malefoy", "Peter Pettigrow",
                "Drago Malefoy", "Rafleur", "Bellatrix Lestrange", "Balai piégé", "Collier maudit", "Philtre d'amour",
                "Hydromel empoisonné", "Incendio", "Stupéfix", "Manoir Malfoy", "Tête de sanglier", "Cabane hurlante",
                "Poudlard", "Forêt interdite", "Gringotts",
                "Chez Weasley, Farces...", "Ministère de la Magie", "12 Square Grimmaurd" };

        listeJoueurs = new ArrayList<Joueur>();
        jeuCartes = new ArrayList<Carte>();
        mesCartes = new ArrayList<Carte>();
        solution = new ArrayList<Carte>();

        System.out.println("\n-----------------------\n ---jeu de cartes complet---");

        for (int i = 0; i < 21; i++) { // jeu de cartes complet
            jeuCartes.add(new Carte(listeCartes[i]));
            System.out.println(jeuCartes.get(i));
        }

        System.out.println("---cartes Suspects---");
        for (int i = 0; i < 6; i++) { // cartes Suspects
            cartesSuspects.add(jeuCartes.get(i));
            System.out.println(jeuCartes.get(i));
        }

        System.out.println("---cartes Objets---");
        for (int i = 6; i < 12; i++) { // cartes Objets
            cartesObjets.add(jeuCartes.get(i));
            System.out.println(jeuCartes.get(i));
        }

        System.out.println("---cartes Lieux---");
        for (int i = 12; i < 21; i++) { // cartes Lieux
            cartesLieux.add(jeuCartes.get(i));
            System.out.println(jeuCartes.get(i));
        }

    }
}
