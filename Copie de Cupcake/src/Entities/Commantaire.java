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
public class Commantaire {
    
    private int id ;
    private String sujet ;
    private String description   ;
    private int id_pub ;
    private int id_util ;

    public Commantaire( String sujet, String description, int id_pub, int id_util) {        
        this.sujet = sujet;
        this.description = description;
        this.id_pub = id_pub;
        this.id_util = id_util;
    }

    public Commantaire(int id, String sujet, String description, int id_pub, int id_util) {
        this.id = id;
        this.sujet = sujet;
        this.description = description;
        this.id_pub = id_pub;
        this.id_util = id_util;
    }

    public Commantaire(String sujet, String description) {
        this.sujet = sujet;
        this.description = description;
    }

    public Commantaire() {
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

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public int getId_util() {
        return id_util;
    }

    public void setId_util(int id_util) {
        this.id_util = id_util;
    }

    @Override
    public String toString() {
        return "Commantaire{" + "id=" + id + ", sujet=" + sujet + ", description=" + description + ", id_pub=" + id_pub + ", id_util=" + id_util + '}';
    }
    
    
    
}
