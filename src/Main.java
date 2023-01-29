import modele.*;
import vue.*;
import controlleur.*;

public class LancementAppli {

    public LancementAppli() {
        // controlleur. //...utilisation ou on par défault du controlleur
        new FenetreAppli();
    }

    public static void main(String[] args) throws Exception {
        new LancementAppli();
    }
}
