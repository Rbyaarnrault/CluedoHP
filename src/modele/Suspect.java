package modele;

public class Suspect extends Carte {

    public Suspect(String s) {
        super(s);
    }

    public Suspect() {
        super();
    }

    public void SetNomCarte(String n) { // Quand carte connue, je met son nom
        super.SetNomCarte(n);
    }
}
