package aeroport;

import java.time.Duration;
import java.time.LocalDateTime;

public class Escale {
    private Aeroport aeroport;
    private LocalDateTime depart;
    private LocalDateTime arrivee;

    public Escale(Aeroport aeroport, LocalDateTime depart, LocalDateTime arrivee) {
        this.aeroport = aeroport;
        this.depart = depart;
        this.arrivee = arrivee;
    }

    
    public Aeroport getAeroport() {
        return aeroport;
    }

    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
    }

    public LocalDateTime getDepart() {
        return depart;
    }

    public void setDepart(LocalDateTime depart) {
        this.depart = depart;
    }

    public LocalDateTime getArrivee() {
        return arrivee;
    }

    public void setArrivee(LocalDateTime arrivee) {
        this.arrivee = arrivee;
    }

    
    public Duration getDuree() {
        return Duration.between(depart, arrivee);
    }
}
