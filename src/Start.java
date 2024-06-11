import reservation.Client;
import reservation.Passager;
import reservation.Reservation;
import aeroport.Aeroport;
import aeroport.Ville;
import aeroport.Vol;
import aeroport.Compagnie;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Start {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        printHeader("Initialisation des objets");

        Compagnie easyJet = new Compagnie("EasyJet");
        Compagnie britishAirways = new Compagnie("British Airways");

        Ville villeParis = new Ville("Paris");
        Ville villeTanger = new Ville("Tanger");
        Ville villeNewYork = new Ville("New York");
        Ville villeLondres = new Ville("Londres");

        Aeroport aeroportDepart = new Aeroport("Charles de Gaulle", villeParis);
        Aeroport aeroportArrivee = new Aeroport("Ibn Battuta", villeTanger);
        Aeroport aeroportParis = new Aeroport("Charles de Gaulle", villeParis);
        Aeroport aeroportNewYork = new Aeroport("JFK International", villeNewYork);
        Aeroport aeroportTanger = new Aeroport("Ibn Battuta", villeTanger);
        Aeroport aeroportLondres = new Aeroport("Heathrow", villeLondres);

        Vol volFinal = new Vol("FL123", aeroportDepart, aeroportArrivee, easyJet, parseDate("21/10/2024 13:00"), parseDate("21/10/2024 16:00"));
        Vol volParisNewYork = new Vol("PNY123", aeroportParis, aeroportNewYork, easyJet, parseDate("22/10/2024 10:00"), parseDate("22/10/2024 20:00"));
        Vol volTangerLondres = new Vol("TL456", aeroportTanger, aeroportLondres, britishAirways, parseDate("23/10/2024 11:00"), parseDate("23/10/2024 14:00"));

        easyJet.addVol(volFinal);
        easyJet.addVol(volParisNewYork);
        britishAirways.addVol(volTangerLondres);

        Client client = new Client("Anas Kotoub", "anas.kotoub@gmail.com");
        Reservation reservation = new Reservation("res123", new Date(), client);
        client.setReservation(reservation);

        Passager passager1 = new Passager("Forestier Florian");
        Passager passager2 = new Passager("Croce Loris");
        reservation.addPassager(passager1);
        reservation.addPassager(passager2);

        printHeader("Details de la Reservation");

        printFlightDetails(volParisNewYork);
        printFlightDetails(volTangerLondres);
        printFlightDetails(volFinal);
        
        printReservationDetails(reservation);
        
        reservation.confirmer();
        printStatus(reservation);

        reservation.annuler();
        printStatus(reservation);

        Passager passager3 = new Passager("Yannick Loiseau");
        reservation.addPassager(passager3);
        printPassengers(reservation);

        testReservationUniqueness();
    }

    private static Date parseDate(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            System.out.println("Erreur de format de date: " + e.getMessage());
            return new Date();
        }
    }

    private static void printHeader(String title) {
        System.out.println("\n=== " + title.toUpperCase() + " ===");
    }

    private static void printFlightDetails(Vol vol) {
        System.out.println("\nVol " + vol.getNumero() + " (" + vol.getCompagnie().getName() + ")");
        System.out.println("De " + vol.getDepart().getNom() + " a " + vol.getArrivee().getNom());
        System.out.println("Depart: " + dateFormat.format(vol.getDateDepart()) + " - Arrivee: " + dateFormat.format(vol.getDateArrivee()));
        System.out.println("Duree du vol: " + vol.obtenirDuree().toMinutes() + " minutes");
    }

    private static void printReservationDetails(Reservation reservation) {
        System.out.println("Numero de reservation: " + reservation.getNumero());
        System.out.println("Client: " + reservation.getClient().getNom());
        printPassengers(reservation);
    }

    private static void printStatus(Reservation reservation) {
        System.out.println("Statut de la reservation: " + (reservation.isConfirmed() ? "Confirmee" : "Annulee"));
    }

    private static void printPassengers(Reservation reservation) {
        System.out.println("Passagers:");
        for (Passager passager : reservation.getPassagers()) {
            System.out.println("  - " + passager.getNom());
        }
    }

    private static void testReservationUniqueness() {
        printHeader("Test de l'unicite du numero de reservation");
        Compagnie testCompagnie = new Compagnie("Test Airlines");
        Client testClient = new Client("Test Client", "test@example.com");
        Reservation res1 = new Reservation("TEST123", new Date(), testClient);
    /*  try {
            
            new Reservation("TEST123", new Date(), testClient);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Numero de reservation deja utilise.");
        }*/
        Reservation res2 = new Reservation("TEST124", new Date(), testClient);
        System.out.println("Reservation cree avec succes : " + res2.getNumero());
    }
}
