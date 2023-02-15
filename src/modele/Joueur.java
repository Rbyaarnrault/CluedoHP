package modele;

import java.util.ArrayList;

public class Joueur {
    private String nomJoueur;
    private int nbCartesJoueur;
    private ArrayList<Carte> cartesJoueur;

    public Joueur(String j, int nb) {
        nomJoueur = j;
        cartesJoueur = new ArrayList<Carte>();
        for (int i = 1; i <= nb; i++) {
            ajouterCartesJoueurs();
        }
    }

    public void ajouterCartesJoueurs() {
        cartesJoueur.add(new Carte());
    }

    public void trouverCarteJoueur(String nomC, String type) { // affecte à un joueur une de ses cartes trouvée.
        int x = 1;
        while ((cartesJoueur.get(x).getNomCarte() != "?") && (x < nbCartesJoueur)) {
            x++;
        }
        cartesJoueur.remove(cartesJoueur.get(x));

        if (type.equals("Suspect")) {
            cartesJoueur.add(new Suspect(nomC));
        } else if (type.equals("Objet")) {
            cartesJoueur.add(new Objet(nomC));
        } else if (type.equals("Lieux")) {
            cartesJoueur.add(new Lieux(nomC));
        }
    }
}
