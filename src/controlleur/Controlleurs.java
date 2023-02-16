package controlleur;

import modele.Model;
import vue.FenetreAppli;

public class Controlleurs {

    Model modele;
    FenetreAppli fen;

    public static void main(String[] args) {
        new Controlleurs();
    }

    public Controlleurs() {
        modele = new Model();
        fen = new FenetreAppli();
        fen.setVisible(true);
    }

}