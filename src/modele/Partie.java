package modele;

import java.util.ArrayList;

public class Partie {

    private int nbJoueurs;
    private int tmpIntModJ;
    private ModeJeu modeJeu;
    private ArrayList<Lieux> cartesLieux;
    private ArrayList<Objet> cartesObjet;
    private ArrayList<Suspect> cartesSuspect;
    private ArrayList<Personnage> cartesPersonnage;
    private Solution solut;

    public Partie(int nbJoueurs, int tmpIntModeJ) {
        this.nbJoueurs = nbJoueurs;
        this.tmpIntModJ = tmpIntModeJ;
        modeJeu = new ModeJeu(tmpIntModeJ);
    }

}
