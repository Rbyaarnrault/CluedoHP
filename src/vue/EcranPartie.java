package vue;

import modele.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import controlleur.Controlleurs;

public class EcranPartie extends JPanel implements ActionListener {

    private Controlleurs contr;
    private int nbJoueurs, nbCartesJoueurs;
    private Font pol;
    private JTable table;
    private JButton boutonFaireProposotion;

    public EcranPartie(Controlleurs contr) {
        this.contr = contr;
        nbJoueurs = contr.getModel().getListeJoueurs().size();
        // Création d'un JPanel pour l'écran d'Abonnes
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        pol = new Font("Serif", Font.BOLD, 22);
        nbCartesJoueurs = 18 / nbJoueurs; // part entière
        table = new JTable(21, 7);
        table.setBounds(50, 100, 500, 350);
        this.add(table);

        boutonFaireProposotion = new JButton("Faire une hypothèse");
        boutonFaireProposotion.setBounds(200, 500, 200, 30);
        boutonFaireProposotion.addActionListener(this);
        this.add(boutonFaireProposotion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonFaireProposotion) {
            contr.choixEcranAffiche(5);
        }
    }
}