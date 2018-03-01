/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static com.mysql.jdbc.Messages.getString;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import connexion.data;
import Entities.Promotion;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class gestpromo {

    public Connection con = data.getInstance().getConnection();
    public Statement ste;

    public gestpromo() {
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(gestpromo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Ajouterpromo(Promotion E) throws SQLException {
     

        String req = "INSERT INTO `promotion`(`RefPr`, `Pourcentage`, `DureePromo`, `NbrePromo`) VALUES (?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(req);
        
        
        pre.setInt(1,E.getRefpr());
        pre.setInt(2, E.getPourcentage());
        pre.setInt(3, E.getDuree());
        pre.setInt(4,E.getNbr());
      
         pre.executeUpdate();
        System.out.println(" Ajoutée");

    }

    public void supprimerpromo(int Idp) throws SQLException {
        Scanner sc = new Scanner(System.in);
       
           String req = "DELETE from  promotion  WHERE IdPromo =?";
          PreparedStatement pre = con.prepareStatement(req);
            pre.setInt(1, Idp);
            pre.executeUpdate();
    }

    public void ModifierEvent(int id,int a,int b,int c,int d  ) throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        
        
      
     String req = "UPDATE `promotion` SET `RefPr`=?,Pourcentage=?,`DureePromo`=?,`NbrePromo`=?  WHERE IdPromo=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1,a);
        pre.setInt(2,b);
        pre.setInt(3, c);
        pre.setInt(4, d);
         pre.setInt(5, id);
        
       
        pre.executeUpdate();
      
        System.out.println("promotion Modifie avec Succees");
    }

    public void Afficher(List<Promotion> list,int i) {

        try {
            String req = "SELECT * FROM promotion AS n join produit AS a WHERE n.RefPr = a.RefPr AND a.idF="+i ;
            ResultSet res;
            res = ste.executeQuery(req);
            while (res.next()) {
                Promotion p = new Promotion(res.getInt("idPromo"), res.getInt("RefPr"), res.getInt("Pourcentage"), res.getInt("DureePromo"),res.getInt("NbrePromo"));
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(gestpromo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
