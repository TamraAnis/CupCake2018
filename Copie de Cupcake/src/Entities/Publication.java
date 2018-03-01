/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author med
 */
public class Publication {
    
    private int id ;
    private String sujet ;
    private String description ;
    private int id_util ;
    private int id_prod ;

    public Publication( String sujet, String description, int id_util, int id_prod) {
        this.sujet = sujet;
        this.description = description;
        this.id_util = id_util;
        this.id_prod = id_prod;
    }

    public Publication(int id, String sujet, String description, int id_util, int id_prod) {
        this.id = id;
        this.sujet = sujet;
        this.description = description;
        this.id_util = id_util;
        this.id_prod = id_prod;
    }
    
    public Publication (){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_util() {
        return id_util;
    }

    public void setId_util(int id_util) {
        this.id_util = id_util;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", sujet=" + sujet + ", description=" + description + ", id_util=" + id_util + ", id_prod=" + id_prod + '}';
    }
    
    
     
}
