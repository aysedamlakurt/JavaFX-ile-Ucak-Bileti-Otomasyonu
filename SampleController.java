
package application;

import java.net.URL; 

import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.stage.Modality;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn1;

   
    
    @FXML
    private Hyperlink hyplnk3;

    @FXML
    private ImageView img1;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Pane pane1;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;
    
    @FXML
    void btn1_clck(ActionEvent event) {
    	
    String username = txt1.getText();
    String sifre = txt2.getText();
    String admin = "admin";
    Uye_Giris giris = new Uye_Giris();
    
    
    if ( !username.isEmpty() || !sifre.isEmpty()) {
    	if( giris.login( username, sifre)) {
    		if(username.equals(admin)) {
    			try {
					 FXMLLoader loader = new FXMLLoader(getClass().getResource("yonetici_sayfası.fxml"));
					 Parent root = loader.load();
					 Stage stage = new Stage();
					 Image yonetici = new Image("admin.png");
					 stage.getIcons().add(yonetici);
					 stage.setScene(new Scene(root));
					 stage.setTitle("Hoşgeldiniz Admin!");
					 stage.showAndWait(); 
				} catch (IOException e) {
					e.printStackTrace();
				} 
    				
    			} else {
    				try {
    					Uyeler user = giris.getUserInfo(username);
    					FXMLLoader loader = new FXMLLoader(getClass().getResource("BiletAl.fxml"));
    					Parent root = loader.load();
    					Stage modalstage = new Stage();
    					BiletAl biletAlController = loader.getController();
                        biletAlController.setUserInfo(user);
    					modalstage.initModality(Modality.APPLICATION_MODAL); 
    					Image person = new Image("icon.png");
    					modalstage.getIcons().add(person);
    					modalstage.setScene(new Scene(root));
    					modalstage.setTitle("Biletini Seç");
    					modalstage.showAndWait(); 
    				} catch (IOException e) {
    					e.printStackTrace();
    				} 
    				
    			}	
            } else {
        	   Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Hata");
               alert.setHeaderText(null);
               alert.setContentText("Kullanıcı ad veya şifre hatalı!");
               alert.showAndWait();
            }
    	} else {
    	Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hata");
        alert.setHeaderText(null);
        alert.setContentText("Lütfen geçerli bir değer giriniz.");
        alert.showAndWait();
    }
    	
    }
    
    
    @FXML
    void hyplnk1_clck(ActionEvent event) {
    	
   
    }
    
    
    @FXML
    void hyplnk3_clck(ActionEvent event) {
    	 try {
       	  FXMLLoader loader = new FXMLLoader(getClass().getResource("UyeOlma.fxml"));
             Parent root = loader.load();
             Stage modalstage = new Stage();
             modalstage.initModality(Modality.APPLICATION_MODAL); 
             Image person = new Image("person.png");
             modalstage.getIcons().add(person);
             modalstage.setScene(new Scene(root));
             modalstage.setTitle("Üye Ol");
             modalstage.showAndWait(); }
             catch (IOException e) {
           	  e.printStackTrace();
             }
    }
  
    
    




    @FXML
    void initialize() {
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert hyplnk3 != null : "fx:id=\"hyplnk3\" was not injected: check your FXML file 'Sample.fxml'.";
        assert img1 != null : "fx:id=\"img1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'Sample.fxml'.";
        assert pane1 != null : "fx:id=\"pane1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txt1 != null : "fx:id=\"txt1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txt2 != null : "fx:id=\"txt2\" was not injected: check your FXML file 'Sample.fxml'.";

    }

}
