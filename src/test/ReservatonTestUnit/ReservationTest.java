package test.ReservatonTestUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import reservation.Client;
import reservation.Passager;
import reservation.Reservation;

import java.util.Date;

public class ReservationTest {
    private Reservation reservation;
    private Client client;
    private static final String RESERVATION_NUMBER = "RES123";

    @BeforeEach
    void setUp() {
        client = new Client("John Doe", "johndoe@example.com");
        reservation = new Reservation(RESERVATION_NUMBER, new Date(), client);
    }

    @AfterEach
    void tearDown() {
       
        Reservation.clearReservations();
    }

    @Test
    void testReservationNumero() {
        assertEquals(RESERVATION_NUMBER, reservation.getNumero());
    }

    @Test
    void testUniquenessOfReservationNumber() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Reservation(RESERVATION_NUMBER, new Date(), client);
        }, "Should throw an exception when trying to create a reservation with a duplicate number");
        assertTrue(thrown.getMessage().contains("Numero de reservation deja utilise"));
    }

    @Test
    void testAddPassager() {
        Passager passager = new Passager("Jane Doe");
        reservation.addPassager(passager);
        assertTrue(reservation.getPassagers().contains(passager));
        assertEquals(reservation, passager.getReservation());
    }

    @Test
    void testRemovePassager() {
        Passager passager = new Passager("Jane Doe");
        reservation.addPassager(passager);
        reservation.removePassager(passager);
        assertFalse(reservation.getPassagers().contains(passager));
        assertNull(passager.getReservation());
    }

    @Test
    void testConfirmReservation() {
        reservation.confirmer();
        assertTrue(reservation.isConfirmed());
    }

    @Test
    void testAnnulerReservation() {
        reservation.confirmer();
        reservation.annuler();
        assertFalse(reservation.isConfirmed());
    }
}
