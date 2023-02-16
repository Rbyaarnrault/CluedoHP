package modele;

public class Objet extends Carte {

    public Objet(String o) {
        super(o);
    }

    public Objet() {
        super();
    }

    public void SetNomCarte(String n) { // Quand carte connue, je met son nom
        super.SetNomCarte(n);
    }
}
