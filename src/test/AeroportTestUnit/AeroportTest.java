package test.AeroportTestUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aeroport.Aeroport;
import aeroport.Ville;

public class AeroportTest {
    private Aeroport aeroport;
    private Ville ville;

    @BeforeEach
    public void setUp() {
        ville = new Ville("Paris");
        aeroport = new Aeroport("Charles de Gaulle", ville);
    }

    @Test
    public void testNomAeroport() {
        assertEquals("Charles de Gaulle", aeroport.getNom(), "Le nom de l'aéroport doit être 'Charles de Gaulle'.");
    }

    @Test
    public void testSetNom() {
        aeroport.setNom("Orly");
        assertEquals("Orly", aeroport.getNom(), "Le nom de l'aéroport après changement doit être 'Orly'.");
    }

    @Test
    public void testVilleAeroport() {
        assertSame(ville, aeroport.getVille(), "L'objet Ville associé doit être le même que celui défini dans setUp.");
    }

    @Test
    public void testSetVille() {
        Ville nouvelleVille = new Ville("Nice");
        aeroport.setVille(nouvelleVille);
        assertSame(nouvelleVille, aeroport.getVille(), "L'objet Ville après changement doit être le même que celui nouvellement défini.");
    }

    @Test
    public void testToString() {
        String expectedString = "Aeroport{nom='Charles de Gaulle', ville='" + ville.toString() + "'}";
        assertEquals(expectedString, aeroport.toString(), "La méthode toString doit retourner la chaîne formatée correctement.");
    }
}
