package vue;

import java.util.*;
import javax.swing.*;

public class FenetreAppli {
    private static JFrame fen;

    public FenetreAppli() { // Création et définition Fenêtre application

        // Création d'une JFrame
        fen = new JFrame("Solver Cluedo Harry Potter");
        fen.addWindowListener(null);
        fen.setSize(800, 500); // Correspondance à 800/500 pour l'affichage des panels // valeurs
        fen.setLayout(null);
        fen.setResizable(false);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setLocationRelativeTo(null);
        fen.setVisible(true);
    }

    public void choixJPanel(int numE) {

        switch (numE) {
            case 1: // Ecran Accueil

                break;

            case 2: // Ecran Nouvelle partie

                break;
        }
    }
}
