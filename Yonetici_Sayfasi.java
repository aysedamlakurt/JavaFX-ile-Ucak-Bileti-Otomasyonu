package application;


import java.net.URL;

import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.application.Platform;

public class Yonetici_Sayfasi {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<Ucuslar, LocalDate> col1_date;

    @FXML
    private TableColumn<Ucuslar, String> col1_depart;

    @FXML
    private TableColumn<Ucuslar, String> col1_dest;

    @FXML
    private TableColumn<Ucuslar, String> col1_intime;

    @FXML
    private TableColumn<Ucuslar, String> col1_kalktime;

    @FXML
    private TableColumn<Ucuslar, String> col1_ucusno;

    @FXML
    private TableColumn<Biletler, String> col2_username;

    @FXML
    private TableColumn<Biletler, LocalDate> col2_tarih;

    @FXML
    private TableColumn<Biletler, String> col2_depart;

    @FXML
    private TableColumn<Biletler, String> col2_dest;

    @FXML
    private TableColumn<Biletler, String> col2_departtime;

    @FXML
    private TableColumn<Biletler, String> col2_desttime;

    @FXML
    private TableColumn<Biletler, String> col2_paket;

   
    @FXML
    private DatePicker datebox;

    @FXML
    private TextField departtimetxt;

    @FXML
    private TextField departtxt;

    @FXML
    private TextField desttimetxt;

    @FXML
    private TextField desttxt;

    @FXML
    private Button eklebuton;

    @FXML
    private Button eklecikisbuton;
    
    @FXML
    private TextField fiyattxt;

    @FXML
    private TextField inissaat_txt;

    @FXML
    private TextField inistxt;

    @FXML
    private TextField kalkissaat_txt;

    @FXML
    private TextField kalkistxt;

    @FXML
    private Button silbuton;

    @FXML
    private Button silcikisbuton;
    
    @FXML
    private DatePicker sildatebox;
    
    @FXML
    private Button sorgula_buton;

    @FXML
    private TextField sorintext;

    @FXML
    private TextField sorkalktxt;

    @FXML
    private TableView<Ucuslar> siltableview;
    
    @FXML
    private TableView<Biletler> tableview_musteri;

    @FXML
    private Button soncikisbuton;

    @FXML
    private TextField ucusnotxt;

    @FXML
    private Button userucusbuton;
    
    @FXML
    private TextField yemekadtxt;

    @FXML
    private Button yemekeklebuton;

    @FXML
    private TextField yemekfiyattxt;

    @FXML
    private TextField yemekturtxt;
    
    @FXML
    private Button yemekcikisbuton;
    
    private ObservableList<Ucuslar> data;

    @FXML
    private Button koltuksecmebuton;

   

    @FXML
    void eklebuton_clck(ActionEvent event) {
    	
    	
    	String ucusNumarası = Yonetici_Class.generateFlightNumber();
    	String departure  = departtxt.getText();
        String destination = desttxt.getText();
        LocalDate seferTarihi = datebox.getValue();
        String kalkisSaati  = departtimetxt.getText();
        String inisSaati = desttimetxt.getText();
        String fiyat = fiyattxt.getText();

        Yonetici_Class ucusekle = new Yonetici_Class();
        Ucuslar ucus = ucusekle.getUcusInfo(ucusNumarası);
        BiletAl biletAlController = new BiletAl();
        biletAlController.setUcusInfo(ucus);
        
        if ( !departure.isEmpty() || !destination.isEmpty() ) {
        		
        	ucusekle.Ucus_Ekle(ucusNumarası, departure, destination, seferTarihi, kalkisSaati, inisSaati, fiyat);
     
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	alert.setTitle("Başarılı");
        	alert.setHeaderText(null);
        	alert.setContentText("Uçuş Eklendi.");
        	alert.showAndWait();
 
        } else {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText(null);
            alert.setContentText("Lütfen geçerli bir değer giriniz.");
            alert.showAndWait();
        } 
     
        
    }

    @FXML
    void eklecikisbuton_clck(ActionEvent event) {
    	 Platform.exit();
    }

    @FXML
    void silbuton_clck(ActionEvent event) {
    	 String ucusNumarası = ucusnotxt.getText();
         if (!ucusNumarası.isEmpty()) {
             Yonetici_Class.Ucus_Sil(ucusNumarası);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Başarılı");
             alert.setHeaderText(null);
             alert.setContentText("Uçuş Silindi.");
             alert.showAndWait();
             refreshTable();
             clearForm();
         } else {
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Hata");
             alert.setHeaderText(null);
             alert.setContentText("Lütfen silmek istediğiniz uçuşu seçiniz.");
             alert.showAndWait();
         }

    }

    @FXML
    void silcikisbuton_clck(ActionEvent event) {
    	Platform.exit();
    }
    
    @FXML
    void sorgula_butonclck(ActionEvent event) {

    }
    @FXML
    void siltableview_mouseclck(MouseEvent event) { 
    	Ucuslar selectedUcus = siltableview.getSelectionModel().getSelectedItem();
    	if (selectedUcus != null) {
    		ucusnotxt.setText(selectedUcus.getUcusNumarasi());
    		kalkistxt.setText(selectedUcus.getDeparture());
    		inistxt.setText(selectedUcus.getDestination());
    		sildatebox.setValue(selectedUcus.getSeferTarihi());
    		kalkissaat_txt.setText(selectedUcus.getKalkisSaati());
    		inissaat_txt.setText(selectedUcus.getInisSaati());
    	}

    }

    @FXML
    void soncikisbuton_clck(ActionEvent event) {
    	Platform.exit();
    }
    @FXML
    void tableviewmusteri_mouseclck(MouseEvent event) {

    }

    @FXML
    void userucusbuton_clck(ActionEvent event) {
    	Biletler secilenbilet = tableview_musteri.getSelectionModel().getSelectedItem(); 
    	 String username = secilenbilet.getMusteriUsername();
 
        if (!username.isEmpty()) {
            Yonetici_Class.Bilet_Sil(username);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Başarılı");
            alert.setHeaderText(null);
            alert.setContentText("Bilet Silindi.");
            alert.showAndWait();
            refreshTable();
            clearForm();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText(null);
            alert.setContentText("Lütfen silmek istediğiniz bileti seçiniz.");
            alert.showAndWait();
        }

    }
    
    @FXML
    void yemekcikisbuton_clck(ActionEvent event) {
    	Platform.exit();
    }
    
    @FXML
    void yemekeklebuton_clck(ActionEvent event) {
    	String yemekturu = yemekturtxt.getText();
        String yemek = yemekadtxt.getText();
        String fiyat = yemekfiyattxt.getText();
        
        if ( !yemekturu.isEmpty() || !fiyat.isEmpty() ) {
	        Yonetici_Class yemekekle = new Yonetici_Class();
	        yemekekle.YemekEkle(yemekturu, yemek, fiyat);
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	alert.setTitle("Başarılı");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Yemek Eklendi.");
	    	alert.showAndWait();

        } else {
	    	Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle("Hata");
	        alert.setHeaderText(null);
	        alert.setContentText("Lütfen geçerli bir değer giriniz.");
	        alert.showAndWait();
         } 
       

    }
    
   
    private void refreshTable() {
        ObservableList<Ucuslar> ucuslarListesi = Yonetici_Class.getAllUcuslar();
        col1_ucusno.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("ucusNumarasi"));
        col1_depart.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("departure"));
        col1_dest.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("destination"));
        col1_date.setCellValueFactory(new PropertyValueFactory<Ucuslar, LocalDate>("seferTarihi"));
        col1_kalktime.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("kalkisSaati"));
        col1_intime.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("inisSaati"));
        siltableview.setItems(ucuslarListesi);
        ObservableList<Biletler> BiletlerListesi = Yonetici_Class.getAllBiletler();
        col2_username.setCellValueFactory(new PropertyValueFactory<Biletler, String>("musteriUsername"));
        col2_depart.setCellValueFactory(new PropertyValueFactory<Biletler, String>("departure"));
        col2_dest.setCellValueFactory(new PropertyValueFactory<Biletler, String>("destination"));
        col2_tarih.setCellValueFactory(new PropertyValueFactory<Biletler, LocalDate>("seferTarihi"));
        col2_departtime.setCellValueFactory(new PropertyValueFactory<Biletler, String>("kalkisSaati"));
        col2_desttime.setCellValueFactory(new PropertyValueFactory<Biletler, String>("inisSaati"));
        col2_paket.setCellValueFactory(new PropertyValueFactory<Biletler, String>("paket"));
        tableview_musteri.setItems(BiletlerListesi);
    }

    private void clearForm() {
        ucusnotxt.clear();
        departtxt.clear();
        desttxt.clear();
        datebox.setValue(null);
        departtimetxt.clear();
        desttimetxt.clear();
    }

    @FXML
    void initialize() {
        refreshTable();
        sorgula_buton.setOnAction(e -> sorgula());
        loadAllUcuslar();
    }
     
      
    
    private void sorgula() {
        String departure = sorkalktxt.getText();
        String destination = sorintext.getText();

        Yonetici_Class databaseService = new Yonetici_Class();
        data = FXCollections.observableArrayList(databaseService.getUcuslar(departure, destination));
        siltableview.setItems(data);
    }

    private void loadAllUcuslar() {
        data = Yonetici_Class.getAllUcuslar();
        siltableview.setItems(data);
    }
    
   

}

