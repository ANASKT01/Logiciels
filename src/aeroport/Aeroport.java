package aeroport;

public class Aeroport {

    private String nom;

    private Ville ville;

    public Aeroport() {
    }

    public Aeroport(String nom, Ville ville) {
        this.nom = nom;
        this.ville = ville;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public String toString() {
        return "Aeroport{" +
                "nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
    
}
