package vue;

import modele.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class EcranCreationPartie extends JPanel implements ActionListener, ItemListener {

    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private static int nbJoueurs; // prévoir getter ?
    private JComboBox jcbNbJoueurs, jcbModeJeu, jcbType1, jcbType2, jcbType3, jcbType4, jcbType5, jcbType6,
            C1, C2, C3, C4, C5, C6;
    private JLabel labelJ1;
    private JTextField barreJ2, barreJ3, barreJ4, barreJ5;
    private JButton boutonSuivant;
    private JButton boutonLancerPartie;
    private Font pol;
    private Joueur J1, J2, J3, J4, J5;

    public EcranCreationPartie() {
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        cleanEcran();
        afficherBoutonRetour();
        choixSousMenuCreationPartie(1);
        pol = new Font("Serif", Font.BOLD, 20);
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

            case 2: // choix de ses cartes
                setEcranCrea_ChoixCartes();
                break;
        }
    }

    // -----------------CASE1------------------
    public void setEcranCrea_Accueil() {

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

    // -----------------CASE2------------------
    public void setEcranCrea_ChoixCartes() {
        cleanEcran();
        afficherBoutonRetour();

        JLabel texteChoixCartesPerso = new JLabel("--- Choix des mes cartes ---");
        JLabel texteChoixCartesRest = new JLabel("--- Choix des cartes restantes ---");
        boutonLancerPartie = new JButton("Lancer la partie");
        texteChoixCartesPerso.setFont(pol);
        texteChoixCartesRest.setFont(pol);
        texteChoixCartesPerso.setBounds(190, 80, 250, 30);
        texteChoixCartesRest.setBounds(170, 280, 300, 30);
        boutonLancerPartie.setBounds(210, 500, 200, 40);
        this.add(texteChoixCartesPerso);
        this.add(texteChoixCartesRest);
        this.add(boutonLancerPartie);

        int nbCartesJoueurs = 18 / nbJoueurs;
        System.out.println(nbCartesJoueurs + " cartes chacun");

        String[] liType = { "Suspect", "Objet", "Lieux" };

        if (nbCartesJoueurs == 6) { // 0 cartes restantes
            jcbType1 = new JComboBox(liType);
            jcbType2 = new JComboBox(liType);
            jcbType3 = new JComboBox(liType);
            jcbType4 = new JComboBox(liType);
            jcbType5 = new JComboBox(liType);
            jcbType6 = new JComboBox(liType);
            C1 = new JComboBox<>();
            C2 = new JComboBox<>();
            C3 = new JComboBox<>();
            C4 = new JComboBox<>();
            C5 = new JComboBox<>();
            C6 = new JComboBox<>();
            JLabel labAucune = new JLabel("Aucunes");
            jcbType1.setBounds(120, 130, 80, 20);
            jcbType2.setBounds(260, 130, 80, 20);
            jcbType3.setBounds(400, 130, 80, 20);
            jcbType4.setBounds(120, 220, 80, 20);
            jcbType5.setBounds(260, 220, 80, 20);
            jcbType6.setBounds(400, 220, 80, 20);
            labAucune.setBounds(270, 330, 100, 30);
            labAucune.setFont(pol);
            this.add(jcbType1);
            this.add(jcbType2);
            this.add(jcbType3);
            this.add(jcbType4);
            this.add(jcbType5);
            this.add(jcbType6);
            this.add(C1);
            this.add(C2);
            this.add(C3);
            this.add(C4);
            this.add(C5);
            this.add(C6);
            this.add(labAucune);

        } else if (nbCartesJoueurs == 4) { // 2 cartes restantes
            jcbType1 = new JComboBox(liType);
            jcbType2 = new JComboBox(liType);
            jcbType3 = new JComboBox(liType);
            jcbType4 = new JComboBox(liType);
            jcbType5 = new JComboBox(liType);
            jcbType6 = new JComboBox(liType);
            C1 = new JComboBox<>();
            C2 = new JComboBox<>();
            C3 = new JComboBox<>();
            C4 = new JComboBox<>();
            C5 = new JComboBox<>();
            C6 = new JComboBox<>();
            jcbType1.setBounds(220, 130, 80, 20);
            jcbType2.setBounds(340, 130, 80, 20);
            jcbType3.setBounds(220, 220, 80, 20);
            jcbType4.setBounds(340, 220, 80, 20);
            jcbType5.setBounds(220, 330, 80, 20);
            jcbType6.setBounds(340, 330, 80, 20);
            this.add(jcbType1);
            this.add(jcbType2);
            this.add(jcbType3);
            this.add(jcbType4);
            this.add(jcbType5);
            this.add(jcbType6);
            this.add(C1);
            this.add(C2);
            this.add(C3);
            this.add(C4);
            this.add(C5);
            this.add(C6);

        } else if (nbCartesJoueurs == 3) { // 3 cartes restantes
            jcbType1 = new JComboBox(liType);
            jcbType2 = new JComboBox(liType);
            jcbType3 = new JComboBox(liType);
            jcbType4 = new JComboBox(liType);
            jcbType5 = new JComboBox(liType);
            jcbType6 = new JComboBox(liType);
            C1 = new JComboBox<>();
            C2 = new JComboBox<>();
            C3 = new JComboBox<>();
            C4 = new JComboBox<>();
            C5 = new JComboBox<>();
            C6 = new JComboBox<>();
            jcbType1.setBounds(120, 130, 80, 20);
            jcbType2.setBounds(260, 130, 80, 20);
            jcbType3.setBounds(400, 130, 80, 20);
            jcbType4.setBounds(120, 330, 80, 20);
            jcbType5.setBounds(260, 330, 80, 20);
            jcbType6.setBounds(400, 330, 80, 20);
            this.add(jcbType1);
            this.add(jcbType2);
            this.add(jcbType3);
            this.add(jcbType4);
            this.add(jcbType5);
            this.add(jcbType6);
            this.add(C1);
            this.add(C2);
            this.add(C3);
            this.add(C4);
            this.add(C5);
            this.add(C6);
        }
        JeuCartes jeucartes = new JeuCartes();

    }
    // ----------------------------------------

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jcbNbJoueurs) { // si on change le nb de joueurs
            if (jcbNbJoueurs.getSelectedItem() == "--- x ---") {
                JOptionPane.showMessageDialog(this, "Vous devez choisir un nombre de Joueurs !");
            } else {
                try {
                    nbJoueurs = Integer.valueOf((String) jcbNbJoueurs.getSelectedItem());
                    System.out.println(nbJoueurs + " joueurs \n -----");

                    cleanEcran();
                    afficherBoutonRetour();
                    setEcranCrea_Accueil();

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

                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        }
    }

    public static int getNbJoueurs() {
        return nbJoueurs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonRetourAccueil) {
            FenetreAppli.choixEcranAffiche(1);

        } else if (e.getSource() == boutonSuivant) {
            if (!barreJ2.getText().equals("") &&
                    (!barreJ3.getText().equals(""))) {
                J1 = new Joueur("Moi");
                J2 = new Joueur(barreJ2.getText());
                J3 = new Joueur(barreJ3.getText());
                if (nbJoueurs == 3) {
                    setEcranCrea_ChoixCartes();
                } else if (nbJoueurs == 4) {
                    if (!barreJ4.getText().equals("")) {
                        J4 = new Joueur(barreJ4.getText());
                        setEcranCrea_ChoixCartes();
                    } else {
                        JOptionPane.showMessageDialog(this, "Vous devez entrer le nom de tous les joueurs !");
                    }
                } else if (nbJoueurs == 5) {
                    if ((!barreJ4.getText().equals("")) &&
                            (!barreJ5.getText().equals(""))) {
                        J4 = new Joueur(barreJ4.getText());
                        J5 = new Joueur(barreJ5.getText());
                        setEcranCrea_ChoixCartes();
                    } else {
                        JOptionPane.showMessageDialog(this, "Vous devez entrer le nom de tous les joueurs !");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vous devez entrer le nom de tous les joueurs !");
            }
        }
    }
}
