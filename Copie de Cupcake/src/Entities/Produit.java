/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



public class Produit {
    
    private int RefPr;
    private String NomPr;
    private String DescPr;
    private String TypePr;
    private String imagePr;
    private int PrixPr;

    public Produit() {
    }

    public Produit(int RefPr, String NomPr, String TypePr) {
        this.RefPr = RefPr;
        this.NomPr = NomPr;
        this.TypePr = TypePr;
    }
   

    public Produit(int RefPr, String NomPr, int PrixPr, String DescPr, String TypePr) {
        this.RefPr = RefPr;
        this.NomPr = NomPr;
        this.PrixPr = PrixPr;
        this.DescPr = DescPr;
        this.TypePr = TypePr;
    }

    public Produit(String NomPr, int PrixPr, String DescPr, String TypePr, String imagePr) {
        this.NomPr = NomPr;
        this.PrixPr = PrixPr;
        this.DescPr = DescPr;
        this.TypePr = TypePr;
        this.imagePr = imagePr;
    }

    public int getRefPr() {
        return RefPr;
    }

    public void setRefPr(int RefPr) {
        this.RefPr = RefPr;
    }

    public String getNomPr() {
        return NomPr;
    }

    public void setNomPr(String NomPr) {
        this.NomPr = NomPr;
    }

    public int getPrixPr() {
        return PrixPr;
    }

    public void setPrixPr(int PrixPr) {
        this.PrixPr = PrixPr;
    }

    public String getDescPr() {
        return DescPr;
    }

    public void setDescPr(String DescPr) {
        this.DescPr = DescPr;
    }

    public String getTypePr() {
        return TypePr;
    }

    public void setTypePr(String Type) {
        this.TypePr = Type;
    }

    public String getImagePr() {
        return imagePr;
    }

    public void setImagePr(String imagePr) {
        this.imagePr = imagePr;
    }

    
    @Override
    public String toString() {
        return "Produit{" + "RefPr=" + RefPr + ", NomPr=" + NomPr + ", PrixPr=" + PrixPr + ", DescPr=" + DescPr + ", Type=" + TypePr + '}';
    }
    
}
