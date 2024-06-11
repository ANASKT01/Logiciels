package test.AeroportTestUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import aeroport.Ville;

public class VilleTest {
     @Test
    public void testNomVille() {
        Ville ville = new Ville("Paris");
        assertEquals("Paris", ville.getNom(), "Le nom de la ville devrait être Paris.");
    }

    @Test
    public void testSetNom() {
        Ville ville = new Ville("Lyon");
        ville.setNom("Marseille");
        assertEquals("Marseille", ville.getNom(), "Le nom de la ville devrait être mis à jour à Marseille.");
    }

    @Test
    public void testToString() {
        Ville ville = new Ville("Nice");
        String expectedString = "Ville{nom='Nice'}";
        assertEquals(expectedString, ville.toString(), "La méthode toString de Ville ne renvoie pas le format attendu.");
    }
}
