public class Persona implements Comparable<Persona> {

    //stato interno
    private String nome;
    private String cognome;
    private int eta;

    //metodi costruttori
    public Persona() {}

    public Persona(int eta, String nome, String cognome) {
        setEta(eta);
        setNome(nome);
        setCognome(cognome);
    }

    //metodi getter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }


    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    //altri metodi
    //ridefinisco il metodo toString di object
    public String toString() {
        return nome + " " + cognome + " " + eta;
    }

    public boolean equals(Persona p) {
        if (cognome.equals(p.getCognome()) &&
                nome.equals(p.getNome()) &&
                eta == p.getEta())
            return true;
        else
            return false;
    }

    public int compareTo(Persona p) {
        if (getEta() == p.getEta())	return 0;
        else
            if (getEta()>p.getEta()) return 1;
        else return -1;
    }
}
