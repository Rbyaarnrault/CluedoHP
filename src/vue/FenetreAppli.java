package vue;

import java.util.*;
import javax.swing.*;

public class FenetreAppli {
    private static JFrame fen;

    public FenetreAppli() { // Création et définition Fenêtre application

        // Création d'une JFrame
        fen = new JFrame("Goathèque -   CONNEXION");
        fen.addWindowListener(null);
        fen.setSize(814, 537); // Correspondance à 800/500 pour l'affichage des panels // valeurs
        fen.setLayout(null);
        fen.setResizable(false);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setLocationRelativeTo(null);
        fen.setVisible(true);
    }
}
