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
    private int nbJoueurs, nbCartesJoueurs;
    private JButton boutonLancerPartie;
    private Font pol;
    private JPanel panC1, panC2, panC3, panC4, panC5, panC6;

    public EcranChoixCartes(Controlleurs contr) {
        this.contr = contr;
        nbJoueurs = contr.getModel().getListeJoueurs().size();
        // Création d'un JPanel pour l'écran d'Abonnes
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        pol = new Font("Serif", Font.BOLD, 22);
        nbCartesJoueurs = 18 / nbJoueurs; // part entière
        System.out.println(nbCartesJoueurs + " cartes chacun \n -----");
        AfficherComposantsNonEffaces();
    }

    public void cleanEcran(JPanel pan) { // Fonction de refresh du JPanel(Ecran)
        pan.removeAll();
        pan.updateUI();
    }

    public void afficherBoutonRetour() { // (évite de répéter le code)
        Icon imageRetourHome = new ImageIcon("Ressources/imageHome.png");
        boutonRetourAccueil = new JButton(imageRetourHome);
        boutonRetourAccueil.setBounds(20, 20, 50, 50);
        boutonRetourAccueil.addActionListener(this);
        this.add(boutonRetourAccueil);
    }

    public void AfficherComposantsNonEffaces() {

        JLabel texteChoixCartesPerso = new JLabel("--- Choix des mes cartes ---");
        JLabel texteChoixCartesRest = new JLabel("--- Choix des cartes restantes ---");
        boutonLancerPartie = new JButton("Lancer la partie");
        texteChoixCartesPerso.setFont(pol);
        texteChoixCartesRest.setFont(pol);
        texteChoixCartesPerso.setBounds(180, 80, 270, 30);
        texteChoixCartesRest.setBounds(150, 300, 300, 30);
        boutonLancerPartie.setBounds(210, 500, 200, 40);
        boutonLancerPartie.addActionListener(this);
        this.add(texteChoixCartesPerso);
        this.add(texteChoixCartesRest);
        this.add(boutonLancerPartie);
        afficherBoutonRetour();

        if (nbCartesJoueurs == 6) { // 0 cartes restantes
            JLabel labAucune = new JLabel("Aucunes");
            labAucune.setBounds(270, 350, 100, 30);
            labAucune.setFont(pol);
            this.add(labAucune);
        }

        String[] liType = { "--Type--", "Suspect", "Objet", "Lieux" };

        jcbType1 = new JComboBox(liType);
        jcbType2 = new JComboBox(liType);
        jcbType3 = new JComboBox(liType);
        jcbType4 = new JComboBox(liType);
        jcbType5 = new JComboBox(liType);
        jcbType6 = new JComboBox(liType);

        if (nbCartesJoueurs == 6) { // 0 cartes restantes
            jcbType1.setBounds(100, 130, 80, 20);
            jcbType2.setBounds(260, 130, 80, 20);
            jcbType3.setBounds(420, 130, 80, 20);
            jcbType4.setBounds(100, 220, 80, 20);
            jcbType5.setBounds(260, 220, 80, 20);
            jcbType6.setBounds(420, 220, 80, 20);

        } else if (nbCartesJoueurs == 4) { // 2 cartes restantes
            jcbType1.setBounds(170, 130, 80, 20);
            jcbType2.setBounds(350, 130, 80, 20);
            jcbType3.setBounds(170, 220, 80, 20);
            jcbType4.setBounds(350, 220, 80, 20);
            jcbType5.setBounds(170, 350, 80, 20);
            jcbType6.setBounds(350, 350, 80, 20);

        } else if (nbCartesJoueurs == 3) { // 3 cartes restantes
            jcbType1.setBounds(100, 170, 80, 20);
            jcbType2.setBounds(260, 170, 80, 20);
            jcbType3.setBounds(420, 170, 80, 20);
            jcbType4.setBounds(100, 370, 80, 20);
            jcbType5.setBounds(260, 370, 80, 20);
            jcbType6.setBounds(420, 370, 80, 20);
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

        panC1 = new JPanel();
        panC2 = new JPanel();
        panC3 = new JPanel();
        panC4 = new JPanel();
        panC5 = new JPanel();
        panC6 = new JPanel();
    }

    @Override
    public void itemStateChanged(ItemEvent item) {
        Object i = item.getSource();
        Model m = contr.getModel();
        ArrayList<Carte> lS = m.getListeCartesSuspect();
        ArrayList<Carte> lO = m.getListeCartesObjet();
        ArrayList<Carte> lL = m.getListeCartesLieux();

        String[] oS = { "", "", "", "", "", "" };
        String[] oO = { "", "", "", "", "", "" };
        String[] oL = { "", "", "", "", "", "", "", "", "" };

        for (int x = 0; x < lS.size(); x++) {
            oS[x] = lS.get(x).getNomCarte();
        }

        for (int y = 0; y < lO.size(); y++) {
            oO[y] = lO.get(y).getNomCarte();
        }

        for (int z = 0; z < lL.size(); z++) {
            oL[z] = lL.get(z).getNomCarte();
        }

        if (i == jcbType1) {
            cleanEcran(panC1);

            if (jcbType1.getSelectedItem() == "Suspect") {
                C1 = new JComboBox(oS); // contr.modele.cartesSuspect
            } else if (jcbType1.getSelectedItem() == "Objet") {
                C1 = new JComboBox(oO);
            } else if (jcbType1.getSelectedItem() == "Lieux") {
                C1 = new JComboBox(oL);
            }
            if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                panC1.setBounds(35, 160, 170, 35);
                C1.setBounds(95, 155, 130, 30);
            } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                panC1.setBounds(115, 160, 170, 35);
                C1.setBounds(185, 205, 130, 30);
            } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                panC1.setBounds(35, 200, 170, 35);
                C1.setBounds(95, 200, 130, 30);
            }
            panC1.add(C1);
            this.add(panC1);
            SwingUtilities.updateComponentTreeUI(panC1);

        } else if (i == jcbType2) {
            cleanEcran(panC2);

            if (jcbType2.getSelectedItem() == "Suspect") {
                C2 = new JComboBox(oS);
            } else if (jcbType2.getSelectedItem() == "Objet") {
                C2 = new JComboBox(oO);
            } else if (jcbType2.getSelectedItem() == "Lieux") {
                C2 = new JComboBox(oL);
            }
            if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                panC2.setBounds(215, 160, 170, 35);
                C2.setBounds(235, 155, 130, 30);
            } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                panC2.setBounds(315, 160, 170, 35);
                C2.setBounds(325, 155, 130, 30);
            } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                panC2.setBounds(215, 200, 170, 35);
                C2.setBounds(235, 200, 130, 30);
            }
            panC2.add(C2);
            this.add(panC2);
            SwingUtilities.updateComponentTreeUI(panC2);

        } else if (i == jcbType3) {
            cleanEcran(panC3);

            if (jcbType3.getSelectedItem() == "Suspect") {
                C3 = new JComboBox(oS);
            } else if (jcbType3.getSelectedItem() == "Objet") {
                C3 = new JComboBox(oO);
            } else if (jcbType3.getSelectedItem() == "Lieux") {
                C3 = new JComboBox(oL);
            }
            if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                panC3.setBounds(395, 160, 170, 35);
                C3.setBounds(385, 155, 130, 30);
            } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                panC3.setBounds(115, 250, 170, 35);
                C3.setBounds(185, 245, 130, 30);
            } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                panC3.setBounds(395, 200, 170, 35);
                C3.setBounds(385, 200, 130, 30);
            }
            panC3.add(C3);
            this.add(panC3);
            SwingUtilities.updateComponentTreeUI(panC3);

        } else if (i == jcbType4) {
            cleanEcran(panC4);

            if (jcbType4.getSelectedItem() == "Suspect") {
                C4 = new JComboBox(oS);
            } else if (jcbType4.getSelectedItem() == "Objet") {
                C4 = new JComboBox(oO);
            } else if (jcbType4.getSelectedItem() == "Lieux") {
                C4 = new JComboBox(oL);
            }
            if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                panC4.setBounds(35, 250, 170, 35);
                C4.setBounds(95, 245, 130, 30);
            } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                panC4.setBounds(315, 250, 170, 35);
                C4.setBounds(325, 245, 130, 30);
            } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                panC4.setBounds(35, 400, 170, 35);
                C4.setBounds(95, 395, 130, 30);
            }
            panC4.add(C4);
            this.add(panC4);
            SwingUtilities.updateComponentTreeUI(panC4);

        } else if (i == jcbType5) {
            cleanEcran(panC5);

            if (jcbType5.getSelectedItem() == "Suspect") {
                C5 = new JComboBox(oS);
            } else if (jcbType5.getSelectedItem() == "Objet") {
                C5 = new JComboBox(oO);
            } else if (jcbType5.getSelectedItem() == "Lieux") {
                C5 = new JComboBox(oL);
            }
            if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                panC5.setBounds(215, 250, 170, 35);
                C5.setBounds(235, 245, 130, 30);
            } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                panC5.setBounds(115, 380, 170, 35);
                C5.setBounds(185, 395, 130, 30);
            } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                panC5.setBounds(215, 400, 170, 35);
                C5.setBounds(235, 395, 130, 30);
            }
            panC5.add(C5);
            this.add(panC5);
            SwingUtilities.updateComponentTreeUI(panC5);

        } else if (i == jcbType6) {
            cleanEcran(panC6);

            if (jcbType6.getSelectedItem() == "Suspect") {
                C6 = new JComboBox(oS);
            } else if (jcbType6.getSelectedItem() == "Objet") {
                C6 = new JComboBox(oO);
            } else if (jcbType6.getSelectedItem() == "Lieux") {
                C6 = new JComboBox(oL);
            }
            if (nbJoueurs == 3) { // 6 cartes, 0 restantes
                panC6.setBounds(395, 250, 170, 35);
                C6.setBounds(385, 245, 130, 30);
            } else if (nbJoueurs == 4) { // 4 cartes, 2 restantes
                panC6.setBounds(315, 380, 170, 35);
                C6.setBounds(325, 395, 130, 30);
            } else if (nbJoueurs == 5) { // 3 cartes, 3 restantes
                panC6.setBounds(395, 400, 170, 35);
                C6.setBounds(385, 395, 130, 30);
            }
            panC6.add(C6);
            this.add(panC6);
            SwingUtilities.updateComponentTreeUI(panC6);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonRetourAccueil) {
            contr.choixEcranAffiche(1);
        } else if (e.getSource() == boutonLancerPartie) {
            ArrayList<Joueur> liJoueurs = contr.getModel().getListeJoueurs();

            liJoueurs.get(0).trouverCarteJoueur(String.valueOf(C1.getSelectedItem()),
                    String.valueOf(jcbType1.getSelectedItem()));
            liJoueurs.get(0).trouverCarteJoueur(String.valueOf(C2.getSelectedItem()),
                    String.valueOf(jcbType2.getSelectedItem()));
            liJoueurs.get(0).trouverCarteJoueur(String.valueOf(C3.getSelectedItem()),
                    String.valueOf(jcbType3.getSelectedItem()));
            if (nbJoueurs == 3) {
                liJoueurs.get(0).trouverCarteJoueur(String.valueOf(C4.getSelectedItem()),
                        String.valueOf(jcbType4.getSelectedItem()));
                liJoueurs.get(0).trouverCarteJoueur(String.valueOf(C5.getSelectedItem()),
                        String.valueOf(jcbType5.getSelectedItem()));
                liJoueurs.get(0).trouverCarteJoueur(String.valueOf(C6.getSelectedItem()),
                        String.valueOf(jcbType6.getSelectedItem()));
            } else if (nbJoueurs == 4) {
                liJoueurs.get(0).trouverCarteJoueur(String.valueOf(C4.getSelectedItem()),
                        String.valueOf(jcbType4.getSelectedItem()));
            }

            contr.choixEcranAffiche(14);
        }
    }
}
