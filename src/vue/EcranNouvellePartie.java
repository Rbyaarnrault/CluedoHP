package vue;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EcranNouvellePartie extends JPanel implements ActionListener, ItemListener {

    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private JComboBox jcbNbJoueurs;
    private JComboBox jcbModeJeu;

    public EcranNouvellePartie() {
        this.setBackground(Color.white);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        cleanEcran();
        afficherBoutonRetour();
        choixReglagesPartie();
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonRetourAccueil) {
            FenetreAppli.choixEcranAffiche(1);
        }
    }

    public void choixReglagesPartie() {
        String liste[] = { "Classique (Questions au joueur de gauche)", "Expert (Question au joueur de son choix)" };
        jcbModeJeu = new JComboBox(liste);
        jcbModeJeu.setBounds(280, 100, 280, 30);
        JLabel texteModeJeu = new JLabel("Choisissez un mode de Jeu: ");
        texteModeJeu.setBounds(80, 100, 180, 30);

        String liste2[] = { "1", "2", "3" };
        jcbNbJoueurs = new JComboBox(liste2);
        jcbNbJoueurs.setBounds(420, 50, 80, 30);
        JLabel texteNbJoueurs = new JLabel("Quel est le nombre de joueurs de cette partie ?");
        texteNbJoueurs.setBounds(120, 50, 300, 30);

        jcbNbJoueurs.addItemListener(this);
        this.add(jcbModeJeu);
        this.add(texteModeJeu);
        this.add(jcbNbJoueurs);
        this.add(texteNbJoueurs);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jcbNbJoueurs) {

        }
    }
}
