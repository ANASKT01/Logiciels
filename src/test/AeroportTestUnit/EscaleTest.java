package test.AeroportTestUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aeroport.Aeroport;
import aeroport.Escale;
import aeroport.Ville;

import java.time.LocalDateTime;
import java.time.Duration;

public class EscaleTest {
    private Escale escale;
    private Aeroport aeroport;
    private LocalDateTime depart;
    private LocalDateTime arrivee;

    @BeforeEach
    public void setUp() {
        aeroport = new Aeroport("Heathrow", new Ville("Londres"));
        depart = LocalDateTime.now();
        arrivee = depart.plusHours(2);
        escale = new Escale(aeroport, depart, arrivee);
    }

    @Test
    public void testGetDuree() {
        Duration duree = escale.getDuree();
        assertEquals(Duration.ofHours(2), duree, "La durée de l'escale doit être de 2 heures.");
    }
}
