package test.AeroportTestUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aeroport.Aeroport;
import aeroport.Ville;
import aeroport.Vol;

import java.time.Duration;
import java.util.Date;

public class VolTest {
     private Vol vol;
    private Aeroport depart;
    private Aeroport arrivee;
    private Date dateDepart;
    private Date dateArrivee;

    @BeforeEach
    public void setUp() {
        vol = new Vol();
        depart = new Aeroport("CDG", new Ville("Paris"));
        arrivee = new Aeroport("JFK", new Ville("New York"));
        dateDepart = new Date();
        dateArrivee = new Date(dateDepart.getTime() + Duration.ofHours(8).toMillis());
        vol.setDateDepart(dateDepart);
        vol.setDateArrivee(dateArrivee);
        vol.setDepart(depart);
        vol.setArrivee(arrivee);
    }

    @Test
    public void testObtenirDuree() {
        Duration duree = vol.obtenirDuree();
        assertEquals(Duration.ofHours(8), duree, "La durée du vol doit être de 8 heures.");
    }

    @Test
    public void testGestionReservations() {
        vol.ouvrir();
        assertTrue(vol.estOuvertAuxReservations(), "Les réservations pour le vol doivent être ouvertes.");
        vol.fermer();
        assertFalse(vol.estOuvertAuxReservations(), "Les réservations pour le vol doivent être fermées.");
    }
}
