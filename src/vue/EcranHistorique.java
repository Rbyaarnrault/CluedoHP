package vue;

import modele.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.*;

import controlleur.Controlleurs;

public class EcranHistorique extends JPanel implements ActionListener {

    private Controlleurs contr;
    private int nbJoueurs, nbCartesJoueurs;
    private Font pol;
    private JButton boutonRetourNotes;
    private JScrollPane sPane;
    private JTable tableHistorique;

    public EcranHistorique(Controlleurs contr) {
        this.contr = contr;

        // Création d'un JPanel pour l'écran d'Abonnes
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        pol = new Font("Serif", Font.BOLD, 22);
        setEcranHistorique();
    }

    public void setEcranHistorique() {
        boutonRetourNotes = new JButton("Retour aux notes");
        boutonRetourNotes.setBounds(30, 500, 250, 30);
        boutonRetourNotes.addActionListener(this);
        this.add(boutonRetourNotes);

        ArrayList<Hypothese> liHypo = contr.getModel().getListeHypotheses();

        String colums[] = { "Le joueur ", "demande au joueur ", "le suspect ", "l'objet ", "et le lieu " };
        String data[][] = new String[liHypo.size()][5];

        DefaultTableModel modTab = new DefaultTableModel(data, colums);

        tableHistorique = new JTable(modTab);
        sPane = new JScrollPane(tableHistorique);
        sPane.setBounds(50, 50, 500, 440);

        DefaultTableCellRenderer rend = new DefaultTableCellRenderer();
        rend.setHorizontalAlignment(JLabel.CENTER); // centre les données de ton tableau

        for (int i = 0; i < tableHistorique.getColumnCount(); i++) { // centre chaque cellule de ton tableau
            tableHistorique.getColumnModel().getColumn(i).setCellRenderer(rend);
        }

        for (int i = 0; i < liHypo.size(); i++) {
            tableHistorique.setValueAt(liHypo.get(i).getJoueurDemandeHypothese() + "     --> ", i, 0);
            tableHistorique.setValueAt(liHypo.get(i).getJoueurReponseHypothese() + "  : ", i, 1);
            tableHistorique.setValueAt(liHypo.get(i).getSuspectHypothese(), i, 2);
            tableHistorique.setValueAt(liHypo.get(i).getObjetHypothese(), i, 3);
            tableHistorique.setValueAt(liHypo.get(i).getLieuxHypothese(), i, 4);
        }

        tableHistorique.setBounds(0, 0, 490, 440);
        sPane.add(tableHistorique);
        this.add(sPane);
        tableHistorique.setShowGrid(false);
        SwingUtilities.updateComponentTreeUI(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonRetourNotes) {
            contr.choixEcranAffiche(24);
        }
    }
}
