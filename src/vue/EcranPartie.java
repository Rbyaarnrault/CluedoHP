package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcranPartie extends JPanel implements ActionListener, ItemListener {

    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private JComboBox carte1;
    private JComboBox carte2;
    private JComboBox carte3;
    private JComboBox carte4;
    private JComboBox carte5;
    private JComboBox carte6;

    public EcranPartie() {
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        cleanEcran();
        afficherBoutonRetour();
        choixCartesPersonelles();
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

    public int calculNombreCartesJoueur() {
        return 18 / EcranCreationPartie.getNbJoueurs();
    }

    public void choixCartesPersonelles() {
        String listeTypeCarte[] = { "Suspect", "Objet", "Lieu" };
        carte1 = new JComboBox(listeTypeCarte);
        carte2 = new JComboBox(listeTypeCarte);
        carte3 = new JComboBox(listeTypeCarte);
        carte1.setBounds(100, 100, 200, 40);
        carte2.setBounds(100, 150, 200, 40);
        carte3.setBounds(100, 200, 200, 40);
        this.add(carte1);
        this.add(carte2);
        this.add(carte3);
        if (calculNombreCartesJoueur() == 6) { // 3joueurs ,reste 0
            carte4 = new JComboBox(listeTypeCarte);
            carte5 = new JComboBox(listeTypeCarte);
            carte6 = new JComboBox(listeTypeCarte);
            carte4.setBounds(100, 250, 200, 40);
            carte5.setBounds(100, 300, 200, 40);
            carte6.setBounds(100, 350, 200, 40);
            this.add(carte4);
            this.add(carte5);
            this.add(carte6);
        } else if (calculNombreCartesJoueur() == 4) { // 4joueurs ,reste 2
            carte4 = new JComboBox(listeTypeCarte);
            carte4.setBounds(100, 250, 200, 40);
            this.add(carte4);
        }
        carte1.addItemListener(this);
        carte2.addItemListener(this);
        carte3.addItemListener(this);
        carte4.addItemListener(this);
        carte5.addItemListener(this);
        carte6.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonRetourAccueil) {
            FenetreAppli.choixEcranAffiche(1);
        }
    }
}
