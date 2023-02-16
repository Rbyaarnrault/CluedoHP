package vue;

import java.util.*;
import javax.swing.*;

public class FenetreAppli extends JFrame {
    private static EcranAccueil panelAccueil;
    private static EcranParametres panelParam;

    public FenetreAppli() { // Création et définition Fenêtre application

        // Création d'une JFrame
        FenetreAppli fen = new FenetreAppli();
        fen.setTitle("Solver Cluedo Harry Potter");
        fen.setSize(600, 600); // Correspondance à 800/500 pour l'affichage des panels // valeurs
        fen.setLayout(null);
        fen.setResizable(false);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setLocationRelativeTo(null);

    }
}
