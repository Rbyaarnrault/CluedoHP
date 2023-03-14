package vue;

import modele.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

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
    private DefaultTableCellRenderer Renderer;

    public EcranPartie(Controlleurs contr) {
        this.contr = contr;
        nbJoueurs = contr.getModel().getListeJoueurs().size();
        // Création d'un JPanel pour l'écran d'Abonnes
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        pol = new Font("Serif", Font.BOLD, 12);
        nbCartesJoueurs = 18 / nbJoueurs; // part entière

        // ---JTable---
        /*
         * sPane = new JScrollPane();
         * sPane.setBounds(50, 50, 500, 400);
         * this.add(sPane);
         */

        table = new JTable(22, nbJoueurs + 1);
        table.setRowHeight(20);
        table.getColumnModel().getColumn(0).setPreferredWidth(130);
        table.setBounds(80, 50, 490, 440);
        table.setFont(pol);
        this.add(table);

        JTable tableCat = new JTable(3, 1);
        tableCat.setBounds(20, 70, 55, 420);
        tableCat.setRowHeight(0, 120);
        tableCat.setRowHeight(1, 120);
        tableCat.setRowHeight(2, 180);
        tableCat.setValueAt("Suspect", 0, 0);
        tableCat.setValueAt("Objet", 1, 0);
        tableCat.setValueAt("Lieux", 2, 0);
        tableCat.setFont(new Font("Serif", Font.BOLD, 14));
        this.add(tableCat);

        /*
         * for (int i = 1; i < 22; i++) {
         * for (int j = 0; j < nbJoueurs + 1; j++) {
         * 
         * if (i < 6) {
         * table.getCellRenderer(i, j).getTableCellRendererComponent(table,
         * table.getValueAt(i, j),
         * getFocusTraversalKeysEnabled(), isFocusOwner(), i,
         * j).setBackground(Color.CYAN);
         * } else if ((i >= 6) && (i < 12)) {
         * table.getCellRenderer(i, j).getTableCellRendererComponent(table,
         * table.getValueAt(i, j),
         * getFocusTraversalKeysEnabled(), isFocusOwner(), i,
         * j).setBackground(Color.GREEN);
         * } else {
         * table.getCellRenderer(i, j).getTableCellRendererComponent(table,
         * table.getValueAt(i, j),
         * getFocusTraversalKeysEnabled(), isFocusOwner(), i,
         * j).setBackground(Color.YELLOW);
         * }
         * }
         * }
         */

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

        Renderer = new DefaultTableCellRenderer();
        cocherCartesPerso();
        centerRendererTable(Renderer);

        int[] tabLigneRight = { 7, 8, 9, 10, 11, 12 }; // Pour centrer les cellules des lignes 7,8... à droite
        DefaultTableCellRenderer rightRend = new ConditionalRightTableCellRenderer(tabLigneRight);
        table.getColumnModel().getColumn(0).setCellRenderer(rightRend);

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

    public void cocherCartesPerso() {
        ArrayList<Carte> car = contr.getModel().getListeJoueurs().get(0).getCartesJoueur();

        for (int j = 1; j < 21 + 1; j++) {
            for (int i = 0; i < car.size(); i++) {

                if (car.get(i).getNomCarte().equals(table.getValueAt(j, 0))) {
                    table.setValueAt("O", j, nbJoueurs);
                    for (int y = 1; y < nbJoueurs; y++) {
                        table.setValueAt("X", j, y);
                    }
                    break;
                } else {
                    table.setValueAt("X", j, nbJoueurs);
                }
            }
        }
    }

    public void ajouterInfosHypothese(Hypothese h, String rep) {
        // Liste Joueur
        ArrayList<Joueur> lJ = contr.getModel().getListeJoueurs();
        String joueur;
        int x = 0;
        while (x < lJ.size()) {
            if (h.getJoueurReponseHypothese().equals(lJ.get(x).getNomJoueur())) {
                joueur = h.getJoueurReponseHypothese();
                break;
            }
            x++;
        }

        // Liste Cartes
        ArrayList<Carte> lC = contr.getModel().getListeCartes();

        int y = 0; // Suspect
        while (y < lC.size()) {
            if (h.getSuspectHypothese().equals(lC.get(y).getNomCarte())) {
                break;
            }
            y++;
        }

        int z = 0; // Objet
        while (z < lC.size()) {
            if (h.getObjetHypothese().equals(lC.get(z).getNomCarte())) {
                break;
            }
            z++;
        }

        int k = 0; // Lieux
        while (k < lC.size()) {
            if (h.getLieuxHypothese().equals(lC.get(k).getNomCarte())) {
                break;
            }
            k++;
        }

        int j = 0; // Réponse
        while (j < lC.size()) {
            if (rep.equals(lC.get(j).getNomCarte())) {
                break;
            }
            j++;
        }

        if (rep.equals("aucune")) {

            table.setValueAt("X", y + 1, x);
            table.setValueAt("X", z + 1, x);
            table.setValueAt("X", k + 1, x);

        } else {
            table.setValueAt("O", j + 1, x);

            for (int tmp = 1; tmp < lJ.size(); tmp++) {
                if (tmp != x) { // Si diff de la carte trouvée
                    table.setValueAt("X", j + 1, tmp);
                }
            }
        }
    }

    private void centerRendererTable(DefaultTableCellRenderer DefTabCell) {
        DefTabCell.setHorizontalAlignment(JLabel.CENTER); // centre les données de ton tableau

        for (int i = 1; i < table.getColumnCount(); i++) { // centre chaque cellule de ton tableau
            table.getColumnModel().getColumn(i).setCellRenderer(DefTabCell);
        }
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
