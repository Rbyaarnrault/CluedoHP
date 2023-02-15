package vue;

import java.util.*;
import javax.swing.*;

public class FenetreAppli {
    private static JFrame fen;
    private static EcranAccueil panelAccueil;
    private static EcranParametres panelParam;

    public FenetreAppli() { // Création et définition Fenêtre application

        // Création d'une JFrame
        fen = new JFrame("Solver Cluedo Harry Potter");
        fen.addWindowListener(null);
        fen.setSize(600, 600); // Correspondance à 800/500 pour l'affichage des panels // valeurs
        fen.setLayout(null);
        fen.setResizable(false);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setLocationRelativeTo(null);

        choixEcranAffiche(1);

        fen.setVisible(true);
    }

    public static void choixEcranAffiche(int choix) {
        switch (choix) {
            case 1: // Ecran Accueil
                panelAccueil = new EcranAccueil();
                fen.setContentPane(panelAccueil);
                fen.setTitle("Solver Cluedo HP  -  Accueil");
                break;

            case 4: // Ecran Parametres
                panelParam = new EcranParametres();
                fen.setContentPane(panelParam);
                fen.setTitle("Solver Cluedo HP  -  Paramètres");
                break;
        }
    }
}
