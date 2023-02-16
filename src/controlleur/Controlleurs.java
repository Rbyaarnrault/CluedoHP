package controlleur;

import javax.swing.SwingUtilities;

import modele.Model;
import vue.*;

public class Controlleurs {

    private Model modele;
    private FenetreAppli fen;
    private EcranAccueil panelAccueil;
    private EcranCreationPartie panelCreaPartie;
    private EcranPartie panelPartie;
    private EcranParametres panelParam;

    public static void main(String[] args) {
        new Controlleurs();
    }

    public Controlleurs() {
        modele = new Model();
        fen = new FenetreAppli(this);
        fen.setVisible(true);
        panelAccueil = new EcranAccueil(this);
        panelCreaPartie = new EcranCreationPartie(this);
        panelPartie = new EcranPartie(this);
        panelParam = new EcranParametres(this);
        choixEcranAffiche(1);
    }

    public void choixEcranAffiche(int choix) {
        SwingUtilities.updateComponentTreeUI(fen);
        switch (choix) {
            case 1: // Ecran Accueil
                fen.setContentPane(panelAccueil);
                fen.setTitle("Solver Cluedo HP  -  Accueil");
                break;

            case 2: // Ecran NouvellePartie
                fen.setContentPane(panelCreaPartie);
                fen.setTitle("Solver Cluedo HP  -  Création d'une partie");
                break;

            case 3: // Ecran Partie
                fen.setContentPane(panelPartie);
                fen.setTitle("Solver Cluedo HP  -  Partie en cours");
                break;

            case 4: // Ecran Parametres
                fen.setContentPane(panelParam);
                fen.setTitle("Solver Cluedo HP  -  Paramètres");
                break;
        }
    }
}