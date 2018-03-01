package GUI;



import Entities.Login;
import connexion.data;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.gestpromo;
import service.serviceLogin;


/**
 * FXML Controller class
 *
 * @author Metalleuxx
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField userid;
    @FXML
    private JFXButton logid;
    @FXML
    private JFXPasswordField passid;
    
    Connection cnx= data.getInstance().getConnection();
    public Statement ste;
//    ResultSet rs;
    Stage stage= new Stage();
    Parent root;
    Scene scene;
    @FXML
    private JFXButton signupid;
    @FXML
    private Label msg;
    @FXML
    private JFXCheckBox remember;
    
    private final String path="C:\\Users\\admin\\Documents\\NetBeansProjects\\Pi\\ini\\LoginData.ini";
    @FXML
    private JFXButton exit;
    @FXML
    private Hyperlink mail;
    @FXML
    private TextField type;

    public void setType(String type) {
        this.type.setText(type);
    }
    

    public LoginController() {
        try {
            ste = cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(serviceLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           

       //readinifile();
    }   
    public void recup() throws SQLException
    {
         

        
    }
    
    @FXML
    public void performLogin(ActionEvent event) throws SQLException, IOException{
          
          serviceLogin sl= new serviceLogin();
         Login L = new Login(userid.getText(), passid.getText());
         sl.LoginAction(L);
        
//        String req= "Select * from login where username=? and pass=?";
//        PreparedStatement prs= cnx.prepareStatement(req);
//        prs.setString(1, userid.getText());
//        prs.setString(2, passid.getText());
////        boolean stat = prs.execute();
//        rs = prs.executeQuery();
        if(!sl.LoginAction(L).next()){
            System.out.println("login failed");
            msg.setText("Username or Password incorrect");
        }
       else{
//            if(!remember.isSelected()){
//            System.out.println("success");
//            Node node =(Node)event.getSource();
//            stage = (Stage)node.getScene().getWindow();
//            stage.close();
//            FXMLLoader loader  =new FXMLLoader(getClass().getResource("PanierProduit.fxml"));
//            Parent root = (Parent) loader.load();
//            PanierProduitController pp=loader.getController() ; 
//            pp.setuser(userid.getText());
//            
//            Stage stag=new Stage();
//            stag.initStyle(StageStyle.TRANSPARENT);
//            stag.setScene(new Scene(root));
//            stag.show();
//            scene = new Scene(FXMLLoader.load(getClass().getResource("PanierProduit.fxml")));
//            stage.setScene(scene);
//            stage.show();
//            
//            
////            stage = (Stage) passid.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("produit.fxml"));
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//            }
//            else{
            
                //createiniFile();
                System.out.println("success");
//            Node node =(Node)event.getSource();
//            stage = (Stage)node.getScene().getWindow();
//            stage.close();
            FXMLLoader loader  =new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();
           // DashboardController pp=loader.getController() ;
            PromotionController pp=loader.getController() ;
           
            pp.setUser(userid.getText());
            
//            Stage stag=new Stage();
//            stag.initStyle(StageStyle.TRANSPARENT);
//            stag.setScene(new Scene(root));
//            stag.show();
  logid.getScene().setRoot(root);
            }}
            
    
    
    @FXML
    public void performSignUP(ActionEvent event) throws IOException{
        Node node =(Node)event.getSource();
            stage = (Stage)node.getScene().getWindow();
            stage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Signup_1.fxml")));
            stage.setScene(scene);
            stage.show();
//              FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup_1.fxml"));
//              Parent root = loader.load();
//              signupid.getScene().setRoot(root);
    }
//    @FXML
//    public void aaa(ActionEvent event) throws IOException{
//    
//            FXMLLoader loader  =new FXMLLoader(getClass().getResource("PanierProduit.fxml"));
//            Parent root = (Parent) loader.load();
//            PanierProduitController pp=loader.getController() ; 
//            pp.setuser(userid.getText());
//            Stage stag=new Stage();
//            stag.setScene(new Scene(root));
//            stag.show();
//    } 
//    public void createiniFile(){
//        try {
//        File file = new File(path);
//        if(!file.exists()){ 
//            file.createNewFile();
//        }
//        Wini wini = new Wini(new File(path));
//        wini.put("Login data", "Username",userid.getText());
//        wini.put("Login data", "Password",passid.getText());
//        wini.store();
//        
//            } catch (IOException ex) {
//                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//    }
//    public void readinifile(){
//        try {
//        File file = new File(path);
//        if(file.exists()){  
//            Wini wini = new Wini(new File(path));
//            String username = wini.get("Login data","Username");
//            String password = wini.get("Login data","Password");
//            if ((username!=null && !username.equals(""))&&(password!=null && !password.equals("")) ){
//                userid.setText(username);
//                passid.setText(password);
//                remember.setSelected(true);
//            }
//        }
//        
//        
//            } catch (IOException ex) {
//                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//    }
@FXML
    private void exit(ActionEvent event) {
        Node node =(Node)event.getSource();
            stage = (Stage)node.getScene().getWindow();
            stage.close();
    }

    @FXML
    private void sendmail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgotPass.fxml"));
//        ForgotPassController fp=loader.getController() ; 
//            fp.setuser(userid.getText());
            Parent root= loader.load();
            Scene sc = new Scene(root);
            Stage stage=  new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(sc);
            stage.show();
    }
    
}
