package test.ReservatonTestUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import reservation.Client;

public class ClientTest {
     @Test
    void testClientNom() {
        Client client = new Client("John Doe", "johndoe@example.com");
        assertEquals("John Doe", client.getNom());
    }

    @Test
    void testSetNom() {
        Client client = new Client("John Doe", "johndoe@example.com");
        client.setNom("Jane Doe");
        assertEquals("Jane Doe", client.getNom());
    }
}
