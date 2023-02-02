package modele;

public class ModeJeu {

    private int numModeJeu;
    private String nomModeJeu;

    public ModeJeu(int numModeJeu) {
        this.numModeJeu = numModeJeu;
        choixModeJeu();
    }

    public void choixModeJeu() {
        switch (numModeJeu) {
            case 1: // Mode Classique : Demande des cartes au joueur à sa gauche(changement de
                    // joueur jusqu'à réponse positive)
                nomModeJeu = "Classique";
                // TODO
                break;

            case 2: // Mode Expert : Demande des cartes au joueurs de son choix (1 seule Demande,
                    // positive ou négative)
                nomModeJeu = "Expert";
                // TODO
                break;

            default: // Mode Classique : Demande des cartes au joueur à sa gauche(changement de
                     // joueur jusqu'à réponse positive)
                nomModeJeu = "Classique";
                break;
        }
    }

    public String getNomModeJeu() {
        return nomModeJeu;
    }
}
