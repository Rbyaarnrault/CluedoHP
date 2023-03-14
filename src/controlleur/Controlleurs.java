package controlleur;

import javax.swing.SwingUtilities;

import modele.*;
import vue.*;

public class Controlleurs {

    private Model modele;
    private FenetreAppli fen;
    private EcranAccueil panelAccueil;
    private EcranChoixJoueurs panelChoixJoueurs;
    private EcranChoixCartes panelChoixCartes;
    private EcranPartie panelPartie;
    private EcranHypothese panelHypothese;
    private EcranHistorique panelHistorique;
    private EcranParametres panelParam;

    public static void main(String[] args) {
        new Controlleurs();
    }

    public Controlleurs() {
        modele = new Model();
        fen = new FenetreAppli(this);
        fen.setVisible(true);
        choixEcranAffiche(1);
    }

    public void choixEcranAffiche(int choix) {
        SwingUtilities.updateComponentTreeUI(fen);
        switch (choix) {
            case 1: // Ecran Accueil
                panelAccueil = new EcranAccueil(this);
                fen.setContentPane(panelAccueil);
                fen.setTitle("Solver Cluedo HP  -  Accueil");
                break;

            case 2: // Ecran Choix Joueurs
                panelChoixJoueurs = new EcranChoixJoueurs(this);
                fen.setContentPane(panelChoixJoueurs);
                fen.setTitle("Solver Cluedo HP  -  Création d'une partie");
                break;

            case 3: // Ecran Choix Cartes
                panelChoixCartes = new EcranChoixCartes(this);
                fen.setContentPane(panelChoixCartes);
                fen.setTitle("Solver Cluedo HP  -  Création d'une partie");
                break;

            case 14: // Ecran Partie
                panelPartie = new EcranPartie(this);
                fen.setContentPane(panelPartie);
                fen.setTitle("Solver Cluedo HP  -  Partie en cours");
                break;

            case 24: // Ecran Partie
                Hypothese h = panelHypothese.getHypothese();
                String r = panelHypothese.getReponse();
                panelPartie.ajouterInfosHypothese(h, r);
                fen.setContentPane(panelPartie);
                fen.setTitle("Solver Cluedo HP  -  Partie en cours");
                break;

            case 5: // Ecran Hypothèse
                panelHypothese = new EcranHypothese(this);
                fen.setContentPane(panelHypothese);
                fen.setTitle("Solver Cluedo HP  -  Faire une hypothèse");
                break;

            case 6: // Ecran Historique
                panelHistorique = new EcranHistorique(this);
                fen.setContentPane(panelHistorique);
                fen.setTitle("Solver Cluedo HP  -  Historique des hypothèses ");
                break;

            case 7: // Ecran Parametres
                panelParam = new EcranParametres(this);
                fen.setContentPane(panelParam);
                fen.setTitle("Solver Cluedo HP  -  Paramètres");
                break;
        }
    }

    public Model getModel() {
        return modele;
    }
}