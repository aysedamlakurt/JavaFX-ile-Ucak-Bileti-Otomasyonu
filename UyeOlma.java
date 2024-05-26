package application;

import java.io.IOException; 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.time.LocalDate;

public class UyeOlma {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adtxt;

    @FXML
    private Label cinslbl;

    @FXML
    private DatePicker dgdtpick;

    @FXML
    private Label dglbl;

    @FXML
    private Label epostalbl;

    @FXML
    private TextField epostatxt;

    @FXML
    private RadioButton erkekradio;

    @FXML
    private Label isimlbl;

    @FXML
    private RadioButton kadınradio;

    @FXML
    private Label lbl1;

    @FXML
    private RadioButton noneradio;

    @FXML
    private Label passlbl;

    @FXML
    private PasswordField passtxt;

    @FXML
    private TextField soyadtxt;

    @FXML
    private Label soyisimlbl;

    @FXML
    private Label tlflbl;

    @FXML
    private TextField tlftxt;
    
    @FXML
    private TextField usernametxt;

    @FXML
    private Button uyemisinbtn;

    @FXML
    private Button uyeolbtn;

    @FXML
    void uyemisinbtn_clck(ActionEvent event) {
    	try {
       	  FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
             Parent root = loader.load();
             Stage stage = new Stage();
             Image person = new Image("icon.png");
             stage.getIcons().add(person);
             stage.setScene(new Scene(root));
             stage.setTitle("KURT AIRLINES");
             stage.showAndWait(); }
             catch (IOException e) {
           	  e.printStackTrace();
             }

    }

    @FXML
    void uyeolbtn_clck(ActionEvent event) {
    	String ad = adtxt.getText();
        String soyad = soyadtxt.getText();
        String username = usernametxt.getText();
        String tlfno = tlftxt.getText();
        String email = epostatxt.getText();
        String cinsiyet = "";
        if (erkekradio.isSelected()) {
            cinsiyet = "Erkek";
        } else if (kadınradio.isSelected()) {
            cinsiyet = "Kadın";
        } else if (noneradio.isSelected()) {
            cinsiyet = "Belirtmek İstemiyorum";
        }
        String sifre = passtxt.getText();
        LocalDate dogum_tarihi = dgdtpick.getValue();
        
        
        Uye_Kayıt uyekayıt = new Uye_Kayıt();
        if ( !username.isEmpty() || !sifre.isEmpty() ) {
        uyekayıt.Uye_Ekle(ad, soyad, username, dogum_tarihi, cinsiyet, tlfno, email, sifre);
        try {
         	  FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
               Parent root = loader.load();
               Stage stage = new Stage();
               Image person = new Image("icon.png");
               stage.getIcons().add(person);
               stage.setScene(new Scene(root));
               stage.setTitle("KURT AIRLINES");
               stage.showAndWait(); }
               catch (IOException e) {
             	  e.printStackTrace();
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
    void initialize() {
        assert adtxt != null : "fx:id=\"adtxt\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert cinslbl != null : "fx:id=\"cinslbl\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert dgdtpick != null : "fx:id=\"dgdtpick\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert dglbl != null : "fx:id=\"dglbl\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert epostalbl != null : "fx:id=\"epostalbl\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert epostatxt != null : "fx:id=\"epostatxt\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert erkekradio != null : "fx:id=\"erkekradio\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert isimlbl != null : "fx:id=\"isimlbl\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert kadınradio != null : "fx:id=\"kadınradio\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert noneradio != null : "fx:id=\"noneradio\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert passlbl != null : "fx:id=\"passlbl\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert passtxt != null : "fx:id=\"passtxt\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert soyadtxt != null : "fx:id=\"soyadtxt\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert soyisimlbl != null : "fx:id=\"soyisimlbl\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert tlflbl != null : "fx:id=\"tlflbl\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert tlftxt != null : "fx:id=\"tlftxt\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert usernametxt != null : "fx:id=\"usernametxt\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert uyemisinbtn != null : "fx:id=\"uyemisinbtn\" was not injected: check your FXML file 'UyeOlma.fxml'.";
        assert uyeolbtn != null : "fx:id=\"uyeolbtn\" was not injected: check your FXML file 'UyeOlma.fxml'.";

    }

}
