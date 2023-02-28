package vue;

import modele.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import controlleur.Controlleurs;

public class EcranHypothese extends JPanel implements ActionListener, ItemListener {

    private Controlleurs contr;
    private Icon imageRetourHome;
    private JButton boutonRetourAccueil;
    private int nbJoueurs;
    private JComboBox jcbDemandeur, jcbRepondeur, jcbSuspect, jcbObjet, jcbLieux, jcbReponse;
    private JLabel texteProposition, texteDemandeA, texteDeuxPoints1, texteSuspect, texteObjet, texteLieux,
            texteReponseDe, texteJoueurRep, texteAucune;

    private JButton boutonValider;
    private Font pol;
    private JCheckBox boxAucune, boxCarte;

    public EcranHypothese(Controlleurs contr) {
        this.contr = contr;
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);
        pol = new Font("Serif", Font.BOLD, 20);
        setEcranHypothese();
        afficherBoutonRetour();
    }

    public void afficherBoutonRetour() { // (évite de répéter le code)
        Icon imageRetourHome = new ImageIcon("Ressources/imageHome.png");
        boutonRetourAccueil = new JButton(imageRetourHome);
        boutonRetourAccueil.setBounds(20, 20, 50, 50);
        boutonRetourAccueil.addActionListener(this);
        // this.add(boutonRetourAccueil);
    }

    // -----------------CASE1------------------
    public void setEcranHypothese() {

        JLabel texteProposition = new JLabel("Hypothèse");
        JLabel texteDemandeA = new JLabel(" demande à ");
        JLabel texteDeuxPoints1 = new JLabel(":");
        JLabel texteSuspect = new JLabel("Suspect");
        JLabel texteObjet = new JLabel("Objet");
        JLabel texteLieux = new JLabel("Lieux");
        JLabel texteReponseDe = new JLabel("Réponse de ");
        JLabel texteJoueurRep = new JLabel("");
        JLabel texteDeuxPoints2 = new JLabel(":");
        JLabel texteAucune = new JLabel("Aucune");

        texteProposition.setBounds(250, 50, 100, 40);
        texteProposition.setFont(pol);
        texteDemandeA.setBounds(250, 120, 100, 30);
        texteDeuxPoints1.setBounds(500, 120, 20, 30);
        texteSuspect.setBounds(150, 180, 50, 30);
        texteObjet.setBounds(270, 180, 50, 30);
        texteLieux.setBounds(410, 180, 50, 30);
        texteReponseDe.setBounds(230, 300, 100, 30);
        texteJoueurRep.setBounds(350, 300, 100, 30);
        texteDeuxPoints2.setBounds(440, 300, 20, 30);
        texteAucune.setBounds(250, 350, 80, 30);

        Model m = contr.getModel();

        // -------------------
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

        jcbSuspect = new JComboBox(oS);
        jcbObjet = new JComboBox(oO);
        jcbLieux = new JComboBox(oL);

        jcbSuspect.setBounds(35, 220, 170, 30);
        jcbObjet.setBounds(215, 220, 170, 30);
        jcbLieux.setBounds(395, 220, 170, 30);
        // -------------------

        ArrayList<Joueur> lJ = m.getListeJoueurs();

        String[] oJ = { "", "", "", "", "" };
        String[] oJ2 = { "", "", "", "" };

        for (int x = 0; x < lJ.size(); x++) {
            oJ[x] = lJ.get(x).getNomJoueur();
            if (lJ.get(x).getNomJoueur() != "Moi") {
                oJ2[x] = lJ.get(x).getNomJoueur();
            }
        }

        jcbDemandeur = new JComboBox(oJ);
        jcbRepondeur = new JComboBox(oJ2);

        jcbDemandeur.setBounds(110, 120, 120, 30);
        jcbRepondeur.setBounds(340, 120, 120, 30);
        // -------------------

        ArrayList<Carte> lC = m.getListeCartes();

        String[] oC = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };

        for (int x = 0; x < lC.size(); x++) {
            oC[x] = lC.get(x).getNomCarte();
        }

        jcbReponse = new JComboBox(oC);

        jcbReponse.setBounds(250, 410, 170, 30);
        // --------------------

        boxAucune = new JCheckBox();
        boxCarte = new JCheckBox();

        boxAucune.setBounds(200, 350, 30, 30);
        boxCarte.setBounds(200, 410, 30, 30);

        // --------------------

        boutonValider = new JButton("Valider l'hypothèse");
        boutonValider.setBounds(220, 500, 160, 30);
        boutonValider.addActionListener(this);

        jcbDemandeur.addItemListener(this);
        jcbRepondeur.addItemListener(this);
        jcbSuspect.addItemListener(this);
        jcbObjet.addItemListener(this);
        jcbLieux.addItemListener(this);
        jcbReponse.addItemListener(this);

        // Permet d'aligner le texte au centre du JComboBox
        DefaultListCellRenderer centr = new DefaultListCellRenderer();
        centr.setHorizontalAlignment(JLabel.CENTER);
        jcbDemandeur.setRenderer(centr);
        jcbRepondeur.setRenderer(centr);
        jcbSuspect.setRenderer(centr);
        jcbObjet.setRenderer(centr);
        jcbLieux.setRenderer(centr);
        jcbReponse.setRenderer(centr);

        this.add(texteProposition);
        this.add(texteDemandeA);
        this.add(texteDeuxPoints1);
        this.add(texteSuspect);
        this.add(texteObjet);
        this.add(texteLieux);
        this.add(texteReponseDe);
        this.add(texteJoueurRep);
        this.add(texteDeuxPoints2);
        this.add(texteAucune);
        this.add(jcbDemandeur);
        this.add(jcbRepondeur);
        this.add(jcbSuspect);
        this.add(jcbObjet);
        this.add(jcbLieux);
        this.add(jcbReponse);
        this.add(boxAucune);
        this.add(boxCarte);
        this.add(boutonValider);
    }

    // ----------------------------------------

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonValider) {
            contr.choixEcranAffiche(24);
        }
    }
}
