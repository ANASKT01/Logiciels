package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Vol {

    private String numero;
    private Aeroport depart;
    private Aeroport arrivee;
    private Compagnie compagnie;
    private Date dateDepart;
    private Date dateArrivee;
    private boolean estOuvertAuxReservations;

    private List<Escale> escales = new ArrayList<>();

    public Vol() {
        this.escales = new ArrayList<>();
    }

    public Vol(String numero, Aeroport depart, Aeroport arrivee, Compagnie compagnie, Date dateDepart, Date dateArrivee) {
        this.numero = numero;
        this.depart = depart;
        this.arrivee = arrivee;
        this.compagnie = compagnie;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.estOuvertAuxReservations = false;
        this.compagnie.addVol(this);
    }
    
    public Duration obtenirDuree() {
        if(this.dateDepart != null && this.dateArrivee != null) {
            return Duration.of(dateArrivee.getTime() - dateDepart.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        if(compagnie!=null) {
            compagnie.addVolWithoutBidirectional(this);
        }
        if(this.compagnie!=null){
            this.compagnie.removeVolWithoutBidirectional(this);
        }
        this.compagnie = compagnie;
    }

    protected void setCompagnieWithoutBidirectional(Compagnie compagnie) {
        this.compagnie = compagnie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aeroport getDepart() {
        return depart;
    }

    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }

    public Aeroport getArrivee() {
        return arrivee;
    }

    public void setArrivee(Aeroport arrivee) {
        this.arrivee = arrivee;
    }

    public List<Escale> getEscales() {
        return escales;
    }

    public void setEscales(List<Escale> escales) {
        this.escales = escales;
    }

    public void addEscale(Escale escale) {
        escales.add(escale);
        escales.sort((e1, e2) -> e1.getDepart().compareTo(e2.getDepart()));
    }

    public void removeEscale(Escale escale) {
        escales.remove(escale);
    }

   
    public void ouvrir() {
        this.estOuvertAuxReservations = true;
    }

    
    public void fermer() {
        this.estOuvertAuxReservations = false;
    }

    
    public boolean estOuvertAuxReservations() {
        return estOuvertAuxReservations;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return ((Vol) obj).getNumero().equals(this.numero);
        } catch (Exception e){
            return false;
        }
    }
}