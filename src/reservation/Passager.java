package reservation;

public class Passager {

    private String nom;
    private Reservation reservation;

    public Passager() {
    }

    public Passager(String nom) {
        this.nom = nom;
    }

   
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
}
