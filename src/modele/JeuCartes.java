package modele;

import java.util.*;

public class JeuCartes {

    private ArrayList<Suspect> cartesSuspect;
    private ArrayList<Objet> cartesObjets;
    private ArrayList<Lieux> cartesLieux;
    private ArrayList cartesMystere;

    public JeuCartes() {

        List<String> listeS = Arrays.asList("Balai piégé", "Collier maudit", "Philtre d'amour",
                "Hydromel empoisonné", "Incendio", "Stupéfix");
        for (int i = 0; i < listeS.size(); i++) {
            cartesSuspect.add(new Suspect(listeS.get(i)));
        }

        List<String> listeO = Arrays.asList("Balai piégé", "Collier maudit", "Philtre d'amour",
                "Hydromel empoisonné", "Incendio", "Stupéfix");
        for (int j = 0; j < listeO.size(); j++) {
            cartesObjets.add(new Objet(listeO.get(j)));
        }

        List<String> listeL = Arrays.asList("Manoir Malfoy", "Tête de sanglier", "Cabane hurlante",
                "Poudlard", "Forêt interdite", "Gringotts",
                "Chez Weasley, Farces...", "Ministère de la Magie", "12 Square Grimmaurd");
        for (int k = 0; k < listeL.size(); k++) {
            cartesLieux.add(new Lieux(listeL.get(k)));
        }

        for (Suspect s : cartesSuspect) {
            cartesMystere.add(s);
        }
        for (Objet o : cartesObjets) {
            cartesMystere.add(o);
        }
        for (Lieux l : cartesLieux) {
            cartesMystere.add(l);
        }
    }
}
