package service;

import Entities.Login;
import connexion.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class serviceLogin {
    Connection cnx= data.getInstance().getConnection();
    public Statement ste;
    public ResultSet rs;

    public serviceLogin() {
        try {
            ste = cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(serviceLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ResultSet LoginAction(Login l) throws SQLException{
        String req= "Select * from Utilisateurs where login=? and pass=?";
        PreparedStatement prs= cnx.prepareStatement(req);
        prs.setString(1, l.getUsername());
        prs.setString(2, l.getPass());
        rs = prs.executeQuery();
        return rs;
    }
    
    
    
    
    
}
