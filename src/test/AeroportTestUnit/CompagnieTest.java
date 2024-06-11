package test.AeroportTestUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aeroport.Compagnie;
import aeroport.Vol;

import java.util.Arrays;

public class CompagnieTest {
    private Compagnie compagnie;
    private Vol vol1;
    private Vol vol2;

    @BeforeEach
    public void setUp() {
        compagnie = new Compagnie();
        compagnie.setName("Air France");
        vol1 = new Vol();
        vol1.setNumero("VOL123");
        vol2 = new Vol();
        vol2.setNumero("VOL456");
    }

    @Test
    public void testAddVol() {
        compagnie.addVol(vol1);
        assertTrue(compagnie.getVols().contains(vol1), "Le vol doit être ajouté à la compagnie.");
        assertEquals(compagnie, vol1.getCompagnie(), "La relation bidirectionnelle doit être établie.");
    }

    @Test
    public void testRemoveVol() {
        compagnie.addVol(vol1);
        compagnie.removeVol(vol1);
        assertFalse(compagnie.getVols().contains(vol1), "Le vol doit être retiré de la compagnie.");
        assertNull(vol1.getCompagnie(), "La relation bidirectionnelle doit être rompue.");
    }

    @Test
    public void testSetVols() {
        compagnie.setVols(Arrays.asList(vol1, vol2));
        assertTrue(compagnie.getVols().containsAll(Arrays.asList(vol1, vol2)), "Tous les vols doivent être ajoutés à la compagnie.");
        assertEquals(compagnie, vol1.getCompagnie(), "La relation bidirectionnelle doit être établie pour vol1.");
        assertEquals(compagnie, vol2.getCompagnie(), "La relation bidirectionnelle doit être établie pour vol2.");
    }

}
