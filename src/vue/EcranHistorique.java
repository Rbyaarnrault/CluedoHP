package vue;

import modele.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import controlleur.Controlleurs;

public class EcranHistorique extends JPanel implements ActionListener {

    private Controlleurs contr;
    private int nbJoueurs, nbCartesJoueurs;
    private Font pol;

    public EcranHistorique(Controlleurs contr) {
        this.contr = contr;

        // Création d'un JPanel pour l'écran d'Abonnes
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        pol = new Font("Serif", Font.BOLD, 22);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
