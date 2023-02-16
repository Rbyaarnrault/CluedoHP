package vue;

import javax.swing.*;

import controlleur.Controlleurs;

public class FenetreAppli extends JFrame {

    private Controlleurs contr;

    public FenetreAppli(Controlleurs contr) { // Création et définition Fenêtre application

        this.contr = contr;
        this.setTitle("Solver Cluedo Harry Potter");
        this.setSize(600, 600); // Correspondance à 800/500 pour l'affichage des panels // valeurs
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
