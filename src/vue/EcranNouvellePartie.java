package vue;

import modele.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class EcranNouvellePartie extends JPanel implements ActionListener, ItemListener {

    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private JComboBox jcbNbJoueurs;
    private JComboBox jcbModeJeu;
    private int nbJoueurs;
    private ArrayList<Joueur> joueurs;

    public EcranNouvellePartie() {
        this.setBackground(Color.lightGray);
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

        String liste2[] = { "-vide-", "3", "4", "5" };
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
            if (jcbNbJoueurs.getSelectedItem() != "-vide-") {

                nbJoueurs = Integer.valueOf((String) jcbNbJoueurs.getSelectedItem());
                System.out.println(nbJoueurs);

                JLabel lab1 = new JLabel("Joueur1");
                JLabel lab2 = new JLabel("Joueur2");
                JLabel lab3 = new JLabel("Joueur3");
                JLabel lab4 = new JLabel("Joueur4");
                JLabel lab5 = new JLabel("Joueur5");

                lab1.setBounds(120, 180, 60, 30);
                lab2.setBounds(120, 230, 60, 30);
                lab3.setBounds(120, 280, 60, 30);
                lab4.setBounds(120, 330, 60, 30);
                lab5.setBounds(120, 380, 60, 30);

                JTextField barrej1 = new JTextField();
                JTextField barrej2 = new JTextField();
                JTextField barrej3 = new JTextField();
                JTextField barrej4 = new JTextField();
                JTextField barrej5 = new JTextField();

                barrej1.setBounds(180, 180, 300, 30);
                barrej2.setBounds(180, 230, 300, 30);
                barrej3.setBounds(180, 280, 300, 30);
                barrej4.setBounds(180, 330, 300, 30);
                barrej5.setBounds(180, 380, 300, 30);

                this.add(lab1);
                this.add(lab2);
                this.add(lab3);
                this.add(barrej1);
                this.add(barrej2);
                this.add(barrej3);

                if (nbJoueurs >= 4) {
                    this.add(lab4);
                    this.add(barrej4);
                }
                if (nbJoueurs >= 5) {
                    this.add(lab5);
                    this.add(barrej5);
                }

                if (jcbNbJoueurs.getSelectedItem() == "3") {
                    this.remove(lab4);
                    this.remove(lab5);
                    this.remove(barrej4);
                    this.remove(barrej5);
                } else if (jcbNbJoueurs.getSelectedItem() == "4") {
                    this.remove(lab5);
                    this.remove(barrej5);
                }
                this.updateUI();
            }
        }
    }
}
