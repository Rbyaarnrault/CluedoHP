package vue;

import modele.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.*;

import controlleur.Controlleurs;

public class EcranPartie extends JPanel implements ActionListener {

    private Controlleurs contr;
    private int nbJoueurs, nbCartesJoueurs;
    private Font pol;
    private JTable table;
    private JButton boutonFaireProposotion, boutonHistorique;
    private JScrollPane sPane;

    public EcranPartie(Controlleurs contr) {
        this.contr = contr;
        nbJoueurs = contr.getModel().getListeJoueurs().size();
        // Création d'un JPanel pour l'écran d'Abonnes
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        pol = new Font("Serif", Font.BOLD, 22);
        nbCartesJoueurs = 18 / nbJoueurs; // part entière

        // ---JTable---
        /*
         * sPane = new JScrollPane();
         * sPane.setBounds(50, 50, 500, 400);
         * this.add(sPane);
         */

        table = new JTable(22, nbJoueurs + 1);
        // table.setRowHeight(40);
        table.setBounds(50, 50, 500, 400);
        this.add(table);

        for (int i = 0; i < nbJoueurs; i++) {

            String j = contr.getModel().getListeJoueurs().get(i).getNomJoueur();

            if (!j.equals("Moi")) {
                table.setValueAt(j, 0, i);
            } else {
                table.setValueAt(contr.getModel().getListeJoueurs().get(0).getNomJoueur(), 0, nbJoueurs);
            }
        }

        for (int i = 0; i < 21; i++) {

            String c = contr.getModel().getListeCartes().get(i).getNomCarte();

            table.setValueAt(c, i + 1, 0);
        }

        // ------------
        boutonFaireProposotion = new JButton("Faire une hypothèse");
        boutonFaireProposotion.setBounds(250, 500, 200, 30);
        boutonFaireProposotion.addActionListener(this);
        this.add(boutonFaireProposotion);

        boutonHistorique = new JButton("Historique hypothèses");

        boutonHistorique.setBounds(30, 500, 200, 30);
        boutonHistorique.addActionListener(this);
        this.add(boutonHistorique);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonFaireProposotion) {
            contr.choixEcranAffiche(5);
        } else if (e.getSource() == boutonHistorique) {
            contr.choixEcranAffiche(6);
        }
    }
}