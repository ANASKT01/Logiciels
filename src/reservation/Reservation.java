package reservation;

import aeroport.Vol;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reservation {

    private static final Map<String, Reservation> reservationsByNumero = new HashMap<>();

    private String numero;
    private Date date;
    private Client client;
    private List<Passager> passagers;
    private boolean isConfirmed;

    
    public Reservation() {
        passagers = new ArrayList<>();
        isConfirmed = false;
    }

    public Reservation(String numero, Date date, Client client) {
        if (reservationsByNumero.containsKey(numero)) {
            throw new IllegalArgumentException("Numero de reservation deja utilise.");
        }
        this.numero = numero;
        this.date = date;
        this.client = client;
        this.passagers = new ArrayList<>();
        this.isConfirmed = false;
        reservationsByNumero.put(numero, this);
    }

    public static Reservation getReservationByNumero(String numero) {
        return reservationsByNumero.get(numero);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (!this.numero.equals(numero) && reservationsByNumero.containsKey(numero)) {
            throw new IllegalArgumentException("Numero de reservation deja utilise.");
        }
        reservationsByNumero.remove(this.numero);
        this.numero = numero;
        reservationsByNumero.put(numero, this);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        
        if (this.client != null) {
            this.client.setReservation(null);
        }
        
        this.client = client;
        
        if (this.client != null) {
            this.client.setReservation(this);
        }
    }
    

    public List<Passager> getPassagers() {
        return passagers;
    }

    public void setPassagers(List<Passager> passagers) {
        this.passagers = passagers;
    }

    public void addPassager(Passager passager) {
        this.passagers.add(passager);
        passager.setReservation(this); 
    }
    
    public void removePassager(Passager passager) {
        if (this.passagers.remove(passager)) {
            passager.setReservation(null); 
        }
    }
    

    public void confirmer() {
        isConfirmed = true;
    }

    public void annuler() {
        isConfirmed = false;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public static void clearReservations() {
        reservationsByNumero.clear();
    }
    
    
}
