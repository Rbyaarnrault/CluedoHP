package vue;

import modele.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import controlleur.Controlleurs;

public class EcranChoixCartes extends JPanel implements ActionListener, ItemListener {

    private Controlleurs contr;
    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private JComboBox jcbType1, jcbType2, jcbType3, jcbType4, jcbType5, jcbType6,
            C1, C2, C3, C4, C5, C6;
    private int nbJoueurs;
    private JButton boutonLancerPartie;
    private Font pol;

    public EcranChoixCartes(Controlleurs contr) {
        this.contr = contr;
        nbJoueurs = contr.getModel().getListeJoueurs().size();
        // Création d'un JPanel pour l'écran d'Abonnes
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        ChoisirCartes();
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

    // -----------------CASE2------------------
    public void ChoisirCartes() {

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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void itemStateChanged(ItemEvent item) {
        Object i = item.getSource();
        if ((i == jcbType1) || (i == jcbType2) || (i == jcbType3) ||
                (i == jcbType4) || (i == jcbType5) || (i == jcbType6)) {

            if (i == jcbType1) {
                if (jcbType1.getSelectedItem() == "Suspect") {
                    C1 = new JComboBox(); // contr.modele.cartesSuspect
                } else if (jcbType1.getSelectedItem() == "Objet") {
                    C1 = new JComboBox();
                } else if (jcbType1.getSelectedItem() == "Lieux") {
                    C1 = new JComboBox();
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C1.setBounds(95, 155, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C1.setBounds(185, 155, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C1.setBounds(95, 200, 130, 30);
                }
                this.add(C1);

            } else if (i == jcbType2) {
                if (jcbType2.getSelectedItem() == "Suspect") {
                    C2 = new JComboBox();
                } else if (jcbType2.getSelectedItem() == "Objet") {
                    C2 = new JComboBox();
                } else if (jcbType2.getSelectedItem() == "Lieux") {
                    C2 = new JComboBox();
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C2.setBounds(235, 155, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C2.setBounds(325, 155, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C2.setBounds(235, 200, 130, 30);
                }
                this.add(C2);

            } else if (i == jcbType3) {
                if (jcbType3.getSelectedItem() == "Suspect") {
                    C3 = new JComboBox();
                } else if (jcbType3.getSelectedItem() == "Objet") {
                    C3 = new JComboBox();
                } else if (jcbType3.getSelectedItem() == "Lieux") {
                    C3 = new JComboBox();
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C3.setBounds(385, 155, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C3.setBounds(185, 245, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C3.setBounds(385, 200, 130, 30);
                }
                this.add(C3);

            } else if (i == jcbType4) {
                if (jcbType4.getSelectedItem() == "Suspect") {
                    C4 = new JComboBox();
                } else if (jcbType4.getSelectedItem() == "Objet") {
                    C4 = new JComboBox();
                } else if (jcbType4.getSelectedItem() == "Lieux") {
                    C4 = new JComboBox();

                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C4.setBounds(95, 245, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C4.setBounds(325, 245, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C4.setBounds(95, 395, 130, 30);
                }
                this.add(C4);

            } else if (i == jcbType5) {
                if (jcbType5.getSelectedItem() == "Suspect") {
                    C5 = new JComboBox();
                } else if (jcbType5.getSelectedItem() == "Objet") {
                    C5 = new JComboBox();
                } else if (jcbType5.getSelectedItem() == "Lieux") {
                    C5 = new JComboBox();
                }
                if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                    C5.setBounds(235, 245, 130, 30);
                } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                    C5.setBounds(185, 395, 130, 30);
                } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                    C5.setBounds(235, 395, 130, 30);
                }
                this.add(C5);

            } else if (i == jcbType6) {
                if (jcbType6.getSelectedItem() == "Suspect") {
                    C6 = new JComboBox();
                } else if (jcbType6.getSelectedItem() == "Objet") {
                    C6 = new JComboBox();
                } else if (jcbType6.getSelectedItem() == "Lieux") {
                    C6 = new JComboBox();
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
        }
    }
}
