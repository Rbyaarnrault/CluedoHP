package vue;

import modele.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import controlleur.Controlleurs;

public class EcranChoixJoueurs extends JPanel implements ActionListener, ItemListener {

    private Controlleurs contr;
    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private int nbJoueurs;
    private JComboBox jcbNbJoueurs, jcbModeJeu;
    private JLabel labelJ1;
    private JTextField barreJ2, barreJ3, barreJ4, barreJ5;
    private JButton boutonSuivant;
    private Font pol;

    public EcranChoixJoueurs(Controlleurs contr) {
        this.contr = contr;
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        ChoisirJoueurs();
        pol = new Font("Serif", Font.BOLD, 20);
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

    // -----------------CASE1------------------
    public void ChoisirJoueurs() {

        cleanEcran();
        afficherBoutonRetour();

        String l[] = { "--- x ---", "3", "4", "5" };
        String l2[] = { "Classique (Questions au joueur de gauche)", "Expert (Question au joueur de son choix)" };

        JLabel texteNbJoueurs = new JLabel("Quel est le nombre de joueurs de cette partie ?");
        JLabel texteModeJeu = new JLabel("Choisissez un mode de Jeu: ");
        texteNbJoueurs.setBounds(120, 50, 300, 30);
        texteModeJeu.setBounds(80, 100, 180, 30);

        jcbNbJoueurs = new JComboBox(l);
        jcbModeJeu = new JComboBox(l2);
        jcbNbJoueurs.addItemListener(this);
        jcbModeJeu.addItemListener(this);
        jcbNbJoueurs.setBounds(420, 50, 80, 30);
        jcbModeJeu.setBounds(280, 100, 280, 30);

        // Permet d'aligner le texte au centre du JComboBox
        DefaultListCellRenderer centr = new DefaultListCellRenderer();
        centr.setHorizontalAlignment(JLabel.CENTER);
        jcbNbJoueurs.setRenderer(centr);
        jcbModeJeu.setRenderer(centr);

        this.add(texteNbJoueurs);
        this.add(texteModeJeu);
        this.add(jcbNbJoueurs);
        this.add(jcbModeJeu);
    }

    // ----------------------------------------

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object a = e.getSource();
        if (a == jcbNbJoueurs) { // si on change le nb de joueurs

            nbJoueurs = Integer.valueOf((String) jcbNbJoueurs.getSelectedItem());
            System.out.println(getNbJoueurs() + " joueurs \n -----");

            ChoisirJoueurs();

            JLabel lab1 = new JLabel("Joueur1");
            JLabel lab2 = new JLabel("Joueur2");
            JLabel lab3 = new JLabel("Joueur3");
            lab1.setBounds(120, 180, 60, 30);
            lab2.setBounds(120, 230, 60, 30);
            lab3.setBounds(120, 280, 60, 30);
            labelJ1 = new JLabel("Moi");
            labelJ1.setFont(pol);
            barreJ2 = new JTextField();
            barreJ3 = new JTextField();
            labelJ1.setBounds(180, 180, 300, 30);
            barreJ2.setBounds(180, 230, 300, 30);
            barreJ3.setBounds(180, 280, 300, 30);
            labelJ1.setHorizontalAlignment(SwingConstants.CENTER);
            barreJ2.setHorizontalAlignment(SwingConstants.CENTER);
            barreJ3.setHorizontalAlignment(SwingConstants.CENTER);
            boutonSuivant = new JButton("Suivant");
            boutonSuivant.setBounds(440, 500, 120, 50);
            boutonSuivant.addActionListener(this);
            this.add(lab1);
            this.add(lab2);
            this.add(lab3);
            this.add(labelJ1);
            this.add(barreJ2);
            this.add(barreJ3);
            this.add(boutonSuivant);

            if (nbJoueurs == 4) {
                JLabel lab4 = new JLabel("Joueur4");
                lab4.setBounds(120, 330, 60, 30);
                barreJ4 = new JTextField();
                barreJ4.setBounds(180, 330, 300, 30);
                barreJ4.setHorizontalAlignment(SwingConstants.CENTER);
                this.add(lab4);
                this.add(barreJ4);

            } else if (nbJoueurs == 5) {
                JLabel lab4 = new JLabel("Joueur4");
                JLabel lab5 = new JLabel("Joueur5");
                lab4.setBounds(120, 330, 60, 30);
                lab5.setBounds(120, 380, 60, 30);
                barreJ4 = new JTextField();
                barreJ5 = new JTextField();
                barreJ4.setBounds(180, 330, 300, 30);
                barreJ5.setBounds(180, 380, 300, 30);
                barreJ4.setHorizontalAlignment(SwingConstants.CENTER);
                barreJ5.setHorizontalAlignment(SwingConstants.CENTER);
                this.add(lab4);
                this.add(lab5);
                this.add(barreJ4);
                this.add(barreJ5);
            }
        }
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonRetourAccueil) {
            contr.choixEcranAffiche(1);

        } else if (e.getSource() == boutonSuivant) {
            if (nbJoueurs == 3) {
                if ((!barreJ2.getText().equals(null)) && (!barreJ3.getText().equals(null))) {
                    contr.getModel().getListeJoueurs().add(new Joueur(labelJ1.getText(), 6));
                    contr.getModel().getListeJoueurs().add(new Joueur(barreJ2.getText(), 6));
                    contr.getModel().getListeJoueurs().add(new Joueur(barreJ3.getText(), 6));
                } else {
                    JOptionPane.showMessageDialog(this, "Vous devez entrer le nom de tous les joueurs !");
                }
            } else if (nbJoueurs == 4) {
                if ((!barreJ2.getText().equals(null)) && (!barreJ3.getText().equals(null))
                        && (!barreJ4.getText().equals(null))) {
                    contr.getModel().getListeJoueurs().add(new Joueur(labelJ1.getText(), 4));
                    contr.getModel().getListeJoueurs().add(new Joueur(barreJ2.getText(), 4));
                    contr.getModel().getListeJoueurs().add(new Joueur(barreJ3.getText(), 4));
                    contr.getModel().getListeJoueurs().add(new Joueur(barreJ4.getText(), 4));
                } else {
                    JOptionPane.showMessageDialog(this, "Vous devez entrer le nom de tous les joueurs !");
                }
            } else if (nbJoueurs == 5) {
                if ((!barreJ2.getText().equals(null)) && (!barreJ3.getText().equals(null))
                        && (!barreJ4.getText().equals(null)) && (!barreJ5.getText().equals(null))) {
                    contr.getModel().getListeJoueurs().add(new Joueur(labelJ1.getText(), 3));
                    contr.getModel().getListeJoueurs().add(new Joueur(barreJ2.getText(), 3));
                    contr.getModel().getListeJoueurs().add(new Joueur(barreJ3.getText(), 3));
                    contr.getModel().getListeJoueurs().add(new Joueur(barreJ4.getText(), 3));
                    contr.getModel().getListeJoueurs().add(new Joueur(barreJ5.getText(), 3));
                } else {
                    JOptionPane.showMessageDialog(this, "Vous devez entrer le nom de tous les joueurs !");
                }
            }
            contr.choixEcranAffiche(3);
        }
    }
}