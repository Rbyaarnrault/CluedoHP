package vue;

import modele.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class EcranCreationPartie extends JPanel implements ActionListener, ItemListener {

    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private static int nbJoueurs, nbCartesJoueurs; // prévoir getter ?
    private JComboBox jcbNbJoueurs, jcbModeJeu, jcbType1, jcbType2, jcbType3, jcbType4, jcbType5, jcbType6,
            C1, C2, C3, C4, C5, C6;
    private JLabel labelJ1;
    private JTextField barreJ2, barreJ3, barreJ4, barreJ5;
    private JButton boutonSuivant;
    private JButton boutonLancerPartie;
    private Font pol;
    private Joueur J1, J2, J3, J4, J5;
    private ArrayList<Joueur> listeJoueurs;
    private ArrayList<Carte> cartes;
    private ArrayList<Suspect> cartesSuspects;
    private ArrayList<Objet> cartesObjets;
    private ArrayList<Lieux> cartesLieux;

    public EcranCreationPartie() {
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
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
                cleanEcran();
                afficherBoutonRetour();
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

        JLabel texteChoixCartesPerso = new JLabel("--- Choix des mes cartes ---");
        JLabel texteChoixCartesRest = new JLabel("--- Choix des cartes restantes ---");
        boutonLancerPartie = new JButton("Lancer la partie");
        texteChoixCartesPerso.setFont(pol);
        texteChoixCartesRest.setFont(pol);
        texteChoixCartesPerso.setBounds(190, 80, 250, 30);
        texteChoixCartesRest.setBounds(170, 300, 300, 30);
        boutonLancerPartie.setBounds(210, 500, 200, 40);
        this.add(texteChoixCartesPerso);
        this.add(texteChoixCartesRest);
        this.add(boutonLancerPartie);

        int nbCartesJoueurs = 18 / nbJoueurs; // part entière
        System.out.println(nbCartesJoueurs + " cartes chacun");

        String[] liType = { "--Type--", "Suspect", "Objet", "Lieux" };

        jcbType1 = new JComboBox(liType);
        jcbType2 = new JComboBox(liType);
        jcbType3 = new JComboBox(liType);
        jcbType4 = new JComboBox(liType);
        jcbType5 = new JComboBox(liType);
        jcbType6 = new JComboBox(liType);

        if (nbCartesJoueurs == 6) { // 0 cartes restantes
            jcbType1.setBounds(120, 130, 80, 20);
            jcbType2.setBounds(260, 130, 80, 20);
            jcbType3.setBounds(400, 130, 80, 20);
            jcbType4.setBounds(120, 220, 80, 20);
            jcbType5.setBounds(260, 220, 80, 20);
            jcbType6.setBounds(400, 220, 80, 20);
            JLabel labAucune = new JLabel("Aucunes");
            labAucune.setBounds(270, 350, 100, 30);
            labAucune.setFont(pol);
            this.add(labAucune);

        } else if (nbCartesJoueurs == 4) { // 2 cartes restantes
            jcbType1.setBounds(210, 130, 80, 20);
            jcbType2.setBounds(350, 130, 80, 20);
            jcbType3.setBounds(210, 220, 80, 20);
            jcbType4.setBounds(350, 220, 80, 20);
            jcbType5.setBounds(210, 350, 80, 20);
            jcbType6.setBounds(350, 350, 80, 20);

        } else if (nbCartesJoueurs == 3) { // 3 cartes restantes
            jcbType1.setBounds(120, 170, 80, 20);
            jcbType2.setBounds(260, 170, 80, 20);
            jcbType3.setBounds(400, 170, 80, 20);
            jcbType4.setBounds(120, 370, 80, 20);
            jcbType5.setBounds(260, 370, 80, 20);
            jcbType6.setBounds(400, 370, 80, 20);

        }
        jcbType1.addItemListener(this);
        jcbType2.addItemListener(this);
        jcbType3.addItemListener(this);
        jcbType4.addItemListener(this);
        jcbType5.addItemListener(this);
        jcbType6.addItemListener(this);
        this.add(jcbType1);
        this.add(jcbType2);
        this.add(jcbType3);
        this.add(jcbType4);
        this.add(jcbType5);
        this.add(jcbType6);
    }

    // ----------------------------------------

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object a = e.getSource();
        if (a == jcbNbJoueurs) { // si on change le nb de joueurs

            nbJoueurs = Integer.valueOf((String) jcbNbJoueurs.getSelectedItem());
            System.out.println(nbJoueurs + " joueurs \n -----");

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
        } else if ((a == jcbType1) || (a == jcbType2) || (a == jcbType3) ||
                (a == jcbType4) || (a == jcbType5) || (a == jcbType6)) {

            String[] listeSuspects = { "Fenrir Greyback", "Lucius Malefoy", "Peter Pettigrow",
                    "Drago Malefoy", "Rafleur", "Bellatrix Lestrange" };
            String[] listeObjets = { "Balai piégé", "Collier maudit", "Philtre d'amour",
                    "Hydromel empoisonné", "Incendio", "Stupéfix" };
            String[] listeLieux = { "Manoir Malfoy", "Tête de sanglier", "Cabane hurlante",
                    "Poudlard", "Forêt interdite", "Gringotts",
                    "Chez Weasley, Farces...", "Ministère de la Magie", "12 Square Grimmaurd" };

            if (e.getSource() == jcbType1) {
                if (jcbType1.getSelectedItem() == "Suspect") {
                    C1 = new JComboBox(listeSuspects);
                } else if (jcbType1.getSelectedItem() == "Objet") {
                    C1 = new JComboBox(listeObjets);
                } else if (jcbType1.getSelectedItem() == "Lieux") {
                    C1 = new JComboBox(listeLieux);
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C1.setBounds(95, 155, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C1.setBounds(185, 155, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C1.setBounds(95, 200, 130, 30);
                }
                this.add(C1);

            } else if (e.getSource() == jcbType2) {
                if (jcbType2.getSelectedItem() == "Suspect") {
                    C2 = new JComboBox(listeSuspects);
                } else if (jcbType2.getSelectedItem() == "Objet") {
                    C2 = new JComboBox(listeObjets);
                } else if (jcbType2.getSelectedItem() == "Lieux") {
                    C2 = new JComboBox(listeLieux);
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C2.setBounds(235, 155, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C2.setBounds(325, 155, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C2.setBounds(235, 200, 130, 30);
                }
                this.add(C2);

            } else if (e.getSource() == jcbType3) {
                if (jcbType3.getSelectedItem() == "Suspect") {
                    C3 = new JComboBox(listeSuspects);
                } else if (jcbType3.getSelectedItem() == "Objet") {
                    C3 = new JComboBox(listeObjets);
                } else if (jcbType3.getSelectedItem() == "Lieux") {
                    C3 = new JComboBox(listeLieux);
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C3.setBounds(385, 155, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C3.setBounds(185, 245, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C3.setBounds(385, 200, 130, 30);
                }
                this.add(C3);

            } else if (e.getSource() == jcbType4) {
                if (jcbType4.getSelectedItem() == "Suspect") {
                    C4 = new JComboBox(listeSuspects);
                } else if (jcbType4.getSelectedItem() == "Objet") {
                    C4 = new JComboBox(listeObjets);
                } else if (jcbType4.getSelectedItem() == "Lieux") {
                    C4 = new JComboBox(listeLieux);
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C4.setBounds(95, 245, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C4.setBounds(325, 245, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C4.setBounds(95, 395, 130, 30);
                }
                this.add(C4);

            } else if (e.getSource() == jcbType5) {
                if (jcbType5.getSelectedItem() == "Suspect") {
                    C5 = new JComboBox(listeSuspects);
                } else if (jcbType5.getSelectedItem() == "Objet") {
                    C5 = new JComboBox(listeObjets);
                } else if (jcbType5.getSelectedItem() == "Lieux") {
                    C5 = new JComboBox(listeLieux);
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C5.setBounds(235, 245, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C5.setBounds(185, 395, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C5.setBounds(235, 395, 130, 30);
                }
                this.add(C5);

            } else if (e.getSource() == jcbType6) {
                if (jcbType6.getSelectedItem() == "Suspect") {
                    C6 = new JComboBox(listeSuspects);
                } else if (jcbType6.getSelectedItem() == "Objet") {
                    C6 = new JComboBox(listeObjets);
                } else if (jcbType6.getSelectedItem() == "Lieux") {
                    C6 = new JComboBox(listeLieux);
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C6.setBounds(385, 245, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C6.setBounds(325, 395, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C6.setBounds(385, 395, 130, 30);
                }
                this.add(C6);

            }
        } else {
            JOptionPane.showMessageDialog(this, "ERROR: Problème !");
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
                listeJoueurs = new ArrayList<Joueur>();
                J1 = new Joueur("Moi");
                J2 = new Joueur(barreJ2.getText());
                J3 = new Joueur(barreJ3.getText());
                listeJoueurs.add(J1);
                listeJoueurs.add(J2);
                listeJoueurs.add(J3);
                if (nbJoueurs == 3) {
                    choixSousMenuCreationPartie(2);
                    ;
                } else if (nbJoueurs == 4) {
                    if (!barreJ4.getText().equals("")) {
                        J4 = new Joueur(barreJ4.getText());
                        listeJoueurs.add(J4);
                        choixSousMenuCreationPartie(2);
                    } else {
                        JOptionPane.showMessageDialog(this, "Vous devez entrer le nom de tous les joueurs !");
                    }
                } else if (nbJoueurs == 5) {
                    if ((!barreJ4.getText().equals("")) &&
                            (!barreJ5.getText().equals(""))) {
                        J4 = new Joueur(barreJ4.getText());
                        J5 = new Joueur(barreJ5.getText());
                        listeJoueurs.add(J4);
                        listeJoueurs.add(J5);
                        choixSousMenuCreationPartie(2);
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
