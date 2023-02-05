package modele;

import java.util.*;

public class JeuCartes {

    private ArrayList<Carte> cartes;
    private ArrayList<Suspect> cartesSuspects;
    private ArrayList<Objet> cartesObjets;
    private ArrayList<Lieux> cartesLieux;

    public JeuCartes() {

        cartesSuspects = new ArrayList<Suspect>();
        String[] listeS = { "Fenrir Greyback", "Lucius Malefoy", "Peter Pettigrow",
                "Drago Malefoy", "Rafleur", "Bellatrix Lestrange" };

        for (int i = 0; i < listeS.length; i++) {
            Suspect s = new Suspect(listeS[i]);
            cartesSuspects.add(s);
        }
        cartesObjets = new ArrayList<Objet>();
        String[] listeO = { "Balai piégé", "Collier maudit", "Philtre d'amour",
                "Hydromel empoisonné", "Incendio", "Stupéfix" };

        cartesLieux = new ArrayList<Lieux>();
        for (int j = 0; j < listeO.length; j++) {
            Objet o = new Objet(listeO[j]);
            cartesObjets.add(o);
        }

        String[] listeL = { "Manoir Malfoy", "Tête de sanglier", "Cabane hurlante",
                "Poudlard", "Forêt interdite", "Gringotts",
                "Chez Weasley, Farces...", "Ministère de la Magie", "12 Square Grimmaurd" };

        for (int k = 0; k < listeL.length; k++) {
            Lieux l = new Lieux(listeL[k]);
            cartesLieux.add(l);
        }

        cartes = new ArrayList<Carte>();

        cartes.addAll(cartesSuspects);
        cartes.addAll(cartesObjets);
        cartes.addAll(cartesLieux);

        System.out.println("\n ****************** \n ---Cartes---");
        for (Carte car : cartes) {
            System.out.println(car.getNomCartes());
        }

        System.out.println("\n ****************** \n ---Cartes Suspects---");
        for (Suspect sus : cartesSuspects) {
            System.out.println(sus.getNomCartes());
        }

        System.out.println("\n ****************** \n ---Cartes Objets---");
        for (Objet obj : cartesObjets) {
            System.out.println(obj.getNomCartes());
        }

        System.out.println("\n ****************** \n ---Cartes Lieux---");
        for (Lieux li : cartesLieux) {
            System.out.println(li.getNomCartes());
        }
    }
}
