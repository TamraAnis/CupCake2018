/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Login;
import Entities.Promotion;
import com.jfoenix.controls.JFXButton;
import connexion.data;
import entities.Produit;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import service.gestpromo;

/**
 * FXML Controller class
 *
 * @author med
 */
public class PromotionController implements Initializable {

    @FXML
    private JFXButton acceuil;
    @FXML
    private JFXButton panier;
    @FXML
    private JFXButton produits;
    @FXML
    private Pane P_acceuil;    
    @FXML
    private Pane P_panier;    
    @FXML
    private Pane P_produit;
    @FXML
    private ComboBox<String> raa;
    private TextField pour;
    @FXML
    private TextField reff;
         public Connection con = data.getInstance().getConnection();
             public Statement ste;
    @FXML
    private TextField four;
    @FXML
    private TextField paa;
    @FXML
    private TextField daa;
    @FXML
    private TextField qaa;
       private ObservableList<Promotion> list;
    @FXML
    private JFXButton promo;
    @FXML
    private Pane P_promo;
    @FXML
    private Pane P_promo1;
    @FXML
    private JFXButton promo1;
    @FXML
    private Pane P_affpromo;
    @FXML
    private TableView<Promotion> table;
    @FXML
    private TableColumn<Promotion, ?> id;
    @FXML
    private TableColumn<Promotion, ?> ref;
    @FXML
    private TableColumn<Promotion, ?> pour1;
    @FXML
    private TableColumn<Promotion, ?> duree;
    @FXML
    private TableColumn<Promotion, ?> nbr;
    @FXML
    private TextField modref;
    @FXML
    private TextField modpour;
    @FXML
    private TextField modduree;
    @FXML
    private TextField modnbr;
    @FXML
    private JFXButton aff;
    @FXML
    private TextField modid;
    @FXML
    private AnchorPane body;
    @FXML
    private AnchorPane pan;
    @FXML
    private TextField user;
    @FXML
    private TextField type;
    @FXML
    private TextField idd;
    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;    
    }
    public String etat;

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    

    public void setUser(String user) {
        this.user.setText(user); 
    }
    
  //  private String pers=this.type.getText();

    public void setType(String type) {
        this.type.setText(type); 
    }

    public String getUser() {
        return user.getText();
    }
    

    public AnchorPane getBody() {
        return body;
    }

    public void setFour(String four) {
        this.four.setText(four);
    }

    public String getFour() {
        return four.getText();
    }

    public String getType() {
        return type.getText();
    }



public PromotionController() {
        try {
            ste = con.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(gestpromo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws MessagingException, SQLException
    {
       
         if (event.getSource() ==  promo)
        {
            try {
              String a=getUser();
                               
            String req1 = "SELECT * from utilisateurs where `Login` ='"+a+"'   ";
        ResultSet res1;
            res1 = ste.executeQuery(req1);
            while(res1.next()){
                Login p = new Login(res1.getString("Login"),res1.getString("Pass"),res1.getString("Type"));
               setType(p.getType());
                
              }
            
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
            if("fournisseur".equals(getType()))
            {
            b();
                System.out.println(user.getText());
            //SendMail();
            P_promo.toFront();
            P_acceuil.toBack();
            P_promo1.toBack();
            P_panier.toBack();
            P_produit.toBack();
            P_affpromo.toBack();}
            else if ("client".equals(getType()))
            {
                P_promo.toBack();
            P_acceuil.toBack();
            P_promo1.toBack();
            P_panier.toBack();
            P_produit.toBack();
            P_affpromo.toBack();
            }
          

        } 
        else  if (event.getSource() ==  promo1)
        {
             try {
              String a=getUser();
                               
            String req1 = "SELECT * from utilisateurs where `Login` ='"+a+"'   ";
        ResultSet res1;
            res1 = ste.executeQuery(req1);
            while(res1.next()){
               setEtat(res1.getString("etat"));
              }
            
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
            if("fournisseur".equals(getType()) && "valide".equals(getEtat()) ) 
            { 
                
                    P_promo1.toFront();
            P_acceuil.toBack();
            P_panier.toBack();
            P_promo.toBack();
            P_produit.toBack();
            P_affpromo.toBack();
                
            }
            else 
            {
                Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(" attendre la validation du administrateur ");
        alert.show();
            }
        } 
        else  if (event.getSource() ==  aff)
        {
             afficher();
            P_affpromo.toFront();
            
            P_panier.toBack();
            P_acceuil.toBack();
            P_promo1.toBack();
            P_promo.toBack();
            P_produit.toBack();
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
         P_promo1.toBack();
            
            P_promo.toBack();
            P_affpromo.toBack();
         }
       
        
        // TODO
     
    @FXML
    private void cherche(ActionEvent event) {
         list = FXCollections.observableArrayList();
                            try {
                                int m =parseInt(four.getText());
                                String a=raa.getValue();
            String req = "SELECT * from produit where `idF` ="+m;
                   
            ResultSet res;
            res = ste.executeQuery(req);
            while (res.next()) {
                Produit p = new Produit(res.getInt("RefPr"),res.getString("NomPr"),res.getString("idF"));
                String s="";
                
raa.getItems().add(s+p.getNomPr());        
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(gestpromo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


     @FXML
    private void yalla(ActionEvent event) {
                            try {
                                int m =parseInt(four.getText());
                                String a=raa.getValue();
                               
            String req1 = "SELECT * from produit where `idF` ="+m+" and  NomPr='"+a+"'";
         
                    
        ResultSet res1;
            res1 = ste.executeQuery(req1);
            while(res1.next()){
                            Produit p = new Produit(res1.getInt("RefPr"),res1.getString("NomPr"),res1.getString("idF"));
                            String x="";
                            setReff(x+p.getRefPr());
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(gestpromo.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
     @FXML
    private void ajouter(ActionEvent event) throws  SQLException{
        gestpromo sv = new gestpromo();
        Pattern pattern = Pattern.compile("[1-9]\\d*");
         Matcher matcher = pattern.matcher(paa.getText());
         Matcher matcher1 = pattern.matcher(daa.getText());
         Matcher matcher2 = pattern.matcher(qaa.getText());
        if(reff.getText().isEmpty() || reff.getText()==null || paa.getText().isEmpty() || paa.getText()==null ||daa.getText().isEmpty() || daa.getText()==null || qaa.getText().isEmpty() || qaa.getText()==null  )
        {  Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("il manque des information ");
        alert.show();
        }
        else if(!matcher.matches() || !matcher1.matches() || !matcher2.matches())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("les informations incorrect ");
        alert.show();
        }
        else {
        Promotion pr=new Promotion(parseInt(reff.getText()),parseInt(paa.getText()),parseInt(daa.getText()),parseInt(qaa.getText()));    
            sv.Ajouterpromo(pr);}
    }  
    public void setReff(String reff) {
        this.reff.setText(reff);
    }
    
     public void afficher() {
          
                    gestpromo sv = new gestpromo();
                    list = FXCollections.observableArrayList();

            sv.Afficher(list,parseInt(getFour()));  
        id.setCellValueFactory(new PropertyValueFactory<>("id_promo"));
        ref.setCellValueFactory(new PropertyValueFactory<>("refpr"));
        pour1.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
        duree.setCellValueFactory(new PropertyValueFactory<>("duree"));
        nbr.setCellValueFactory(new PropertyValueFactory<>("nbr"));
        
//        table.setItems(null);
        table.setItems(list);

    }
    @FXML
     private void tab_clicked(MouseEvent event) {
        
        Promotion p = table.getItems().get(table.getSelectionModel().getSelectedIndex());
       
        setRef1(p.getRefpr());
        setPour1(p.getPourcentage());
        setDuree1(p.getDuree());
        setNbr1(p.getNbr());
        setId1(p.getId_promo());

    }
     public void setRef1(int ref1) {
        String s="";
        s=s+ref1;
        this.modref.setText(s); 
    }

    public void setPour1(int pour1) {
        String s="";
        s=s+pour1;
        this.modpour.setText(s); 
    }

    public void setDuree1(int duree1) {
        String s="";
        s=s+duree1;
        this.modduree.setText(s); 
    }

    public void setNbr1(int nbr1) {
        String s="";
        s=s+nbr1;
        this.modnbr.setText(s); 
    }
      public void setId1(int id1) {
        String s="";
        s=s+id1;
        this.modid.setText(s); 
    }
    @FXML
    private void valider(ActionEvent event) throws SQLException, IOException {
         gestpromo sv = new gestpromo();
         Pattern pattern = Pattern.compile("[1-9]\\d*");
         Matcher matcher = pattern.matcher(modduree.getText());
         Matcher matcher1 = pattern.matcher(modnbr.getText());
         Matcher matcher2 = pattern.matcher(modref.getText());
        if(modduree.getText().isEmpty() || modduree.getText()==null || modnbr.getText().isEmpty() || modnbr.getText()==null ||modref.getText().isEmpty() || modref.getText()==null )
        {  Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("il manque des information ");
        alert.show();
        }
        else if(!matcher.matches() || !matcher1.matches() || !matcher2.matches())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("les informations incorrect ");
        alert.show();
        }
        else{
            sv.ModifierEvent(parseInt(modid.getText()),parseInt(modref.getText()),parseInt(modpour.getText()),parseInt(modduree.getText()),parseInt(modnbr.getText()));
             afficher();
        modid.setText("");
        modduree.setText("");
        modnbr.setText("");
        modpour.setText("");
        modref.setText("");}
             
    }
    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
         gestpromo sv = new gestpromo();
         int i=parseInt(modid.getText());
            sv.supprimerpromo(i);
            afficher();
            modid.setText("");
        modduree.setText("");
        modnbr.setText("");
        modpour.setText("");
        modref.setText("");
         Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("suppression valider ");
        alert.show();
    }
    public void b()
    {
        try {
              String a=getUser();
                               
            String req1 = "SELECT * from utilisateurs where `Login` ='"+a+"'   ";
        ResultSet res1;
            res1 = ste.executeQuery(req1);
            while(res1.next()){
                Login p = new Login(res1.getInt("Id"));
                String s="";
               setFour(s+p.getId());
               }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void SendMail() throws MessagingException, SQLException{
        String mesg;
        String h="mohamed.douss@esprit.tn";
        
           
            System.out.println("  2");

          mesg="le fournisseur "+user.getText()+"  veut ajouter ";
          
          
       String from ="manifessto7@gmail.com";
       String pass="19201920a";
       String [] to={h};
       String host="mail.javatpoint.com";
       String sub="pswd";
                 System.out.println("  zbui44441");

        Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
         
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,pass);  
           }    
          });    
          //compose message    
             System.out.println(getEmail()+"   mochkla");
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(h));    
           message.setSubject(sub);    
           message.setText(mesg);  
                        System.out.println("  mehich mochkla");

           //send message  
           Transport.send(message); 
           
           System.out.println("message sent successfully");  
       
       
       } 

}