package modele;

public class Lieux extends Carte {

    public Lieux(String l) {
        super(l);
    }

    public Lieux() {
        super();
    }

    public void SetNomCarte(String n) { // Quand carte connue, je met son nom
        super.SetNomCarte(n);
    }
}
