package modele;

import java.util.ArrayList;

public class Solution extends ArrayList<Carte> {

    public Solution(Suspect s, Objet o, Lieux l) {
        this.add(s);
        this.add(o);
        this.add(l);
    }

    public String getSolution() {
        String s = "---Solution---\nTueur : " + getSuspectSolution() + "\nObjet : " + getObjetSolution() + "\nLieux : "
                + getLieuxSolution();
        return s;
    }

    public String getSuspectSolution() {
        return this.get(0).getNomCarte();
    }

    public String getObjetSolution() {
        return this.get(1).getNomCarte();
    }

    public String getLieuxSolution() {
        return this.get(2).getNomCarte();
    }

    public void setSuspectSolution(String sus) {
        this.get(0).SetNomCarte(sus);
    }

    public void setObjetSolution(String obj) {
        this.get(1).SetNomCarte(obj);
    }

    public void setLieuxSolution(String li) {
        this.get(2).SetNomCarte(li);
    }

}
