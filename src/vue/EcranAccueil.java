package vue;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcranAccueil extends JPanel implements ActionListener {

    private JButton boutonNouvellePartie;
    private JButton boutonParametres;

    public EcranAccueil() {
        // Création d'un JPanel pour l'écran d'Abonnes
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(0, 0, 600, 600);

        JLabel titreAppli1 = new JLabel("Solver Cluedo");
        JLabel titreAppli2 = new JLabel("Harry Potter");
        titreAppli1.setBounds(150, 30, 400, 50);
        titreAppli2.setBounds(200, 80, 400, 50);
        Font pol = new Font("Serif", Font.BOLD, 40);
        titreAppli1.setFont(pol);
        titreAppli2.setFont(pol);
        this.add(titreAppli1);
        this.add(titreAppli2);

        boutonNouvellePartie = new JButton("Nouvelle Partie");
        boutonParametres = new JButton("Paramètres");
        boutonNouvellePartie.setBounds(200, 350, 200, 50);
        boutonParametres.setBounds(200, 430, 200, 50);

        boutonNouvellePartie.addActionListener(this);
        boutonParametres.addActionListener(this);
        this.add(boutonNouvellePartie);
        this.add(boutonParametres);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boutonNouvellePartie) {
            FenetreAppli.choixEcranAffiche(2);
        } else if (e.getSource() == boutonParametres) {
            FenetreAppli.choixEcranAffiche(3);
        }
    }
}
