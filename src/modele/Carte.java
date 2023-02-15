package modele;

public class Carte {

    private String nomCarte;

    public Carte(String n) {
        nomCarte = n;
    }

    public Carte() {
        nomCarte = "?"; // Carte Anonyme = non connue
    }

    public String getNomCarte() {
        return nomCarte;
    }

    public void SetNomCarte(String n) { // Quand carte connue, je met son nom
        nomCarte = n;
    }
}
