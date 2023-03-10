package modele;

import java.util.ArrayList;

public class Joueur {
    private String nomJoueur;
    private int nbCartesJoueur;
    private ArrayList<Carte> cartesJoueur;

    public Joueur(String j, int nb) {
        nomJoueur = j;
        cartesJoueur = new ArrayList<Carte>();
        nbCartesJoueur = nb;
        for (int i = 1; i <= nb; i++) {
            ajouterCartesJoueurs();
        }
    }

    public void ajouterCartesJoueurs() {
        cartesJoueur.add(new Carte());
    }

    public void trouverCarteJoueur(String nomC, String type) { // affecte à un joueur une de ses cartes trouvée.
        for (int i = 0; i < cartesJoueur.size(); i++) {
            if (cartesJoueur.get(i).getNomCarte().equals("?")) {

                if (type.equals("Suspect")) {
                    cartesJoueur.set(i, new Suspect(nomC));
                } else if (type.equals("Objet")) {
                    cartesJoueur.set(i, new Objet(nomC));
                } else if (type.equals("Lieux")) {
                    cartesJoueur.set(i, new Lieux(nomC));
                }
                break;
            }
        }
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public ArrayList<Carte> getCartesJoueur() {
        return cartesJoueur;
    }
}
