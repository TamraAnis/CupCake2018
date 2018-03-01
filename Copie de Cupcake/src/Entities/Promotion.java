/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author MSI
 */
public class Promotion {

    private int id_promo;
    private int refpr;
    private int pourcentage;
    private int duree;
    private int nbr;

    public Promotion(  int refpr, int pourcentage, int duree, int nbr) {
        
        this.refpr = refpr;
        this.pourcentage = pourcentage;
        this.duree = duree;
        this.nbr = nbr;
    }

    public Promotion() {
    }
    public Promotion(int id,  int refpr, int pourcentage, int duree, int nbr) {
        
        this.refpr = refpr;
        this.pourcentage = pourcentage;
        this.duree = duree;
        this.nbr = nbr;
        this.id_promo = id;

    }

   

    public int getId_promo() {
        return id_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public int getRefpr() {
        return refpr;
    }

    public void setRefpr(int refpr) {
        this.refpr = refpr;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id_promo=" + id_promo + ", refpr=" + refpr + ", pourcentage=" + pourcentage + ", duree=" + duree + ", nbr=" + nbr + '}';
    }
    
    
}
