package vue;

import modele.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class EcranCreationPartie extends JPanel implements ActionListener, ItemListener {

    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private int nbJoueurs; // prévoir getter ?
    private JComboBox jcbNbJoueurs, jcbModeJeu;
    private JTextField barreJ1, barreJ2, barreJ3, barreJ4, barreJ5;

    public EcranCreationPartie() {
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        cleanEcran();
        afficherBoutonRetour();
        choixSousMenuCreationPartie(1);
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

    public void choixSousMenuCreationPartie(int num) {
        switch (num) {
            case 1: // Accueil
                setEcranCrea_Accueil();
                break;

            case 2: // nom Joueurs
                setEcranCrea_NomJoueurs();
                break;
            case 3: // choix de ses cartes
                setEcranCrea_ChoixMesCartes();
                break;
        }
    }

    // -----------------CASE1------------------
    public void setEcranCrea_Accueil() {

        String l[] = { "---x---", "3", "4", "5" };
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

        this.add(texteNbJoueurs);
        this.add(texteModeJeu);
        this.add(jcbNbJoueurs);
        this.add(jcbModeJeu);
    }

    // -----------------CASE2------------------
    public void setEcranCrea_NomJoueurs() {

    }

    // -----------------CASE3------------------
    public void setEcranCrea_ChoixMesCartes() {

    }
    // ----------------------------------------

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jcbNbJoueurs) { // si on change le nb de joueurs
            if (jcbNbJoueurs.getSelectedItem() == "---x---") {
                JOptionPane.showMessageDialog(this, "Vous devez choisir un nombre de Joueurs !");
            } else {
                try {
                    nbJoueurs = Integer.valueOf((String) jcbNbJoueurs.getSelectedItem());
                    System.out.println(nbJoueurs + " joueurs \n -----");

                    cleanEcran();
                    afficherBoutonRetour();
                    setEcranCrea_Accueil();

                    if (nbJoueurs == 3) {
                        JLabel lab1 = new JLabel("Joueur1");
                        JLabel lab2 = new JLabel("Joueur2");
                        JLabel lab3 = new JLabel("Joueur3");
                        lab1.setBounds(120, 180, 60, 30);
                        lab2.setBounds(120, 230, 60, 30);
                        lab3.setBounds(120, 280, 60, 30);
                        barreJ1 = new JTextField();
                        barreJ2 = new JTextField();
                        barreJ3 = new JTextField();
                        barreJ1.setBounds(180, 180, 300, 30);
                        barreJ2.setBounds(180, 230, 300, 30);
                        barreJ3.setBounds(180, 280, 300, 30);
                        this.add(lab1);
                        this.add(lab2);
                        this.add(lab3);
                        this.add(barreJ1);
                        this.add(barreJ2);
                        this.add(barreJ3);

                    } else if (nbJoueurs == 4) {
                        JLabel lab1 = new JLabel("Joueur1");
                        JLabel lab2 = new JLabel("Joueur2");
                        JLabel lab3 = new JLabel("Joueur3");
                        JLabel lab4 = new JLabel("Joueur4");

                        lab1.setBounds(120, 180, 60, 30);
                        lab2.setBounds(120, 230, 60, 30);
                        lab3.setBounds(120, 280, 60, 30);
                        lab4.setBounds(120, 330, 60, 30);

                        barreJ1 = new JTextField();
                        barreJ2 = new JTextField();
                        barreJ3 = new JTextField();
                        barreJ4 = new JTextField();

                        barreJ1.setBounds(180, 180, 300, 30);
                        barreJ2.setBounds(180, 230, 300, 30);
                        barreJ3.setBounds(180, 280, 300, 30);
                        barreJ4.setBounds(180, 330, 300, 30);

                        this.add(lab1);
                        this.add(lab2);
                        this.add(lab3);
                        this.add(lab4);
                        this.add(barreJ1);
                        this.add(barreJ2);
                        this.add(barreJ3);
                        this.add(barreJ4);

                    } else if (nbJoueurs == 5) {
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

                        barreJ1 = new JTextField();
                        barreJ2 = new JTextField();
                        barreJ3 = new JTextField();
                        barreJ4 = new JTextField();
                        barreJ5 = new JTextField();

                        barreJ1.setBounds(180, 180, 300, 30);
                        barreJ2.setBounds(180, 230, 300, 30);
                        barreJ3.setBounds(180, 280, 300, 30);
                        barreJ4.setBounds(180, 330, 300, 30);
                        barreJ5.setBounds(180, 380, 300, 30);
                        this.add(lab1);
                        this.add(lab2);
                        this.add(lab3);
                        this.add(lab4);
                        this.add(lab5);
                        this.add(barreJ1);
                        this.add(barreJ2);
                        this.add(barreJ3);
                        this.add(barreJ4);
                        this.add(barreJ5);
                    }

                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonRetourAccueil) {
            FenetreAppli.choixEcranAffiche(1);
        }
    }
}
