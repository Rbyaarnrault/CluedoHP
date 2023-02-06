package vue;

import javax.swing.*;

import modele.Joueur;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EcranPartie extends JPanel implements ActionListener, ItemListener {

    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private JComboBox carte1;
    private JComboBox carte2;
    private JComboBox carte3;
    private JComboBox carte4;
    private JComboBox carte5;
    private JComboBox carte6;

    public EcranPartie(ArrayList<Joueur> liJ, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) {
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        cleanEcran();
        afficherBoutonRetour();
    }

    public void cleanEcran() { // Fonction de refresh du JPanel(Ecran)
        this.removeAll();
        this.updateUI();
    }

    public void afficherBoutonRetour() { // (évite de répéter le code)
        Icon imageRetourHome = new ImageIcon("Ressources/imageHome.png");
        boutonRetourAccueil = new JButton(imageRetourHome);
        boutonRetourAccueil.setBounds(20, 20, 50, 50);
        boutonRetourAccueil.addActionListener(this);
        this.add(boutonRetourAccueil);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
