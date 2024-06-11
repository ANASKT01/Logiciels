package test.ReservatonTestUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import reservation.Passager;

public class PassagerTest {
    @Test
    void testPassagerNom() {
        Passager passager = new Passager("Jane Doe");
        assertEquals("Jane Doe", passager.getNom());
    }

    @Test
    void testSetNom() {
        Passager passager = new Passager("Jane Doe");
        passager.setNom("John Doe");
        assertEquals("John Doe", passager.getNom());
    }
}
