package reservation;

public class Client {
    private String nom;
    private String contact; 
    private Reservation reservation;
    
    public Client() {
    }

    public Client(String nom, String contact) {
        this.nom = nom;
        this.contact = contact;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

}
