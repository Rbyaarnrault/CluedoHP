package modele;

public class Hypothese {

    private String jDem;
    private String jRep;
    private String su;
    private String o;
    private String li;

    public Hypothese(String jDem, String jRep, String su, String o, String li) {
        this.jDem = jDem;
        this.jRep = jRep;
        this.su = su;
        this.o = o;
        this.li = li;
    }

    public String getJoueurDemandeHypothese() {
        return jDem;
    }

    public String getJoueurReponseHypothese() {
        return jRep;
    }

    public String getSuspectHypothese() {
        return su;
    }

    public String getObjetHypothese() {
        return o;
    }

    public String getLieuxHypothese() {
        return li;
    }
}
