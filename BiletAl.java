package application;


import java.net.URL;
import javafx.scene.layout.GridPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BiletAl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label adlbl;

    @FXML
    private Label avantajlbl;

    @FXML
    private RadioButton avantajradio;

    

    @FXML
    private Label bagajfiyatlbl;
    
    @FXML
    private Label bagajlbl;

    @FXML
    private Slider bagajslider;

    @FXML
    private Label comfortlbl;

    @FXML
    private RadioButton comfortradio;

    @FXML
    private Label departlbl;

    @FXML
    private Label departtimelbl;

    @FXML
    private Label destlbl;

    @FXML
    private Label eglencefiyatlbl;

    @FXML
    private RadioButton eglenceradio;

    @FXML
    private Label ekolbl;

    @FXML
    private RadioButton ekoradio;
    
    @FXML
    private Label ekhizmetlbl;

    @FXML
    private Label fiyatlbl;

    @FXML
    private Label flexfiyatlbl;

    @FXML
    private RadioButton flexradio;

   
    
    @FXML
    private Label koltuklbl;
    
    @FXML
    private Button biletkabulbuton;

    @FXML
    private Label sigortafiyatlbl;

    @FXML
    private RadioButton sigortaradio;

    @FXML
    private Button sorgulabuton;

    @FXML
    private Label soyadlbl;

    @FXML
    private Label tarihlbl;

    @FXML
    private Label tlfnolbl;

   

    @FXML
    private Label ucussecfiyatlbl;

    @FXML
    private TextField ucussecin;

    @FXML
    private TextField ucusseckalk;

    @FXML
    private TableView<Ucuslar> ucustableview;

    @FXML
    private Label desttimelbl;
    
    @FXML
    private Label yemeklbl;
    
    @FXML
    private Button yemekistemebuton;
    
   
    @FXML
    private TableColumn<Ucuslar, String> col3_inis;

    @FXML
    private TableColumn<Ucuslar, String> col3_inissaat;

    @FXML
    private TableColumn<Ucuslar, String> col3_kalkis;

    @FXML
    private TableColumn<Ucuslar, String> col3_kalkissaat;

    @FXML
    private TableColumn<Ucuslar, LocalDate> col3_tarih;
    
    @FXML
    private TableColumn<Ucuslar, String> col3_ucusno;
    
    @FXML
    private TableColumn<Yemekler, String> col4_yemek;

    @FXML
    private TableColumn<Yemekler, String> col4_yemekfiyat;

    @FXML
    private TableColumn<Yemekler, String> col4_yemektur;
    
    @FXML
    private GridPane koltukGrid1;

    @FXML
    private GridPane koltukGrid2;
    
    @FXML
    private Label usernamelbl;


   

    private ToggleGroup koltukGroup;

    
    
    private ObservableList<Ucuslar> data;
    
    private ToggleGroup toggleGroup;
    
    @FXML
    private TableView<Yemekler> yemektableview;
    
    @FXML
    private Button secimlerbittibuton;
   
    
    @FXML
    void biletkabulbuton_clck(ActionEvent event) {
    
    	   
       
       String username = usernamelbl.getText();
    	String departure  = departlbl.getText();
        String destination = destlbl.getText();
        String seferTarihi = tarihlbl.getText();
        String kalkisSaati  = departtimelbl.getText();
        String inisSaati = desttimelbl.getText();
        RadioButton selectedRadioButton = null;
		try {
			selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        String paket = selectedRadioButton.getText();
        String koltuk = koltuklbl.getText();
        String yemek  = yemeklbl.getText();
        String bagaj = bagajlbl.getText();
        String hizmet = ekhizmetlbl.getText();
        String fiyat = fiyatlbl.getText();

        
       
       
       
        
        if ( !departure.isEmpty() || !destination.isEmpty() ) {
        	BiletAlma biletekle = new BiletAlma();
        	biletekle.BiletEkle(username, departure, destination, seferTarihi, kalkisSaati, inisSaati, paket, koltuk, yemek, bagaj, hizmet, fiyat);
     
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        	alert.setTitle("Başarılı");
        	alert.setHeaderText(null);
        	alert.setContentText("Bilet Eklendi.");
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
    void secimlerbittibuton_clck(ActionEvent event) {
    	 
    	  bagajslider.valueProperty().addListener((obs, oldValue, newValue) -> {
              int secilenAgirlik = (int) Math.round(newValue.doubleValue());
              String bagajFiyati = BiletAlma.hesapla(secilenAgirlik);
              bagajfiyatlbl.setText (bagajFiyati);
              if(ekoradio.isSelected()) {
              	bagajlbl.setText(String.valueOf(newValue.intValue() +15) + "KG"); }
              if(avantajradio.isSelected() || comfortradio.isSelected()) {
                  bagajlbl.setText(String.valueOf(newValue.intValue() +20) + "KG"); }
          });
         
         
    	 Ucuslar selectedUcus = ucustableview.getSelectionModel().getSelectedItem();
     	ucussecfiyatlbl.setText(selectedUcus.getFiyat());
     	departlbl.setText(selectedUcus.getDeparture());
     	destlbl.setText(selectedUcus.getDestination());
     	LocalDate seferTarihi = selectedUcus.getSeferTarihi();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String formattedDate = seferTarihi.format(formatter);
         tarihlbl.setText(formattedDate);
     	
     	departtimelbl.setText(selectedUcus.getKalkisSaati());
     	desttimelbl.setText(selectedUcus.getInisSaati());
    	 
    	int secilenPaket = 0;
			try {
				if (ekoradio.isSelected()) {
					secilenPaket = Integer.parseInt(ekolbl.getText());
				} else if (avantajradio.isSelected()) {
					secilenPaket = Integer.parseInt(avantajlbl.getText());
		
				} else if (comfortradio.isSelected()) {
					secilenPaket = Integer.parseInt(comfortlbl.getText());
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
  	int toplamFiyat = hesaplaToplamFiyat( yemektableview, bagajfiyatlbl, secilenPaket);
  	fiyatlbl.setText(toplamFiyat + "TL");
  	
  	 RadioButton selectedKoltuk = (RadioButton) koltukGroup.getSelectedToggle();
       if (selectedKoltuk != null) {
		 koltuklbl.setText(selectedKoltuk.getText());
		}
      
    
    }


    @FXML
    void sorgulabuton_clck(ActionEvent event) {
    	
    	sorgulabuton.setOnAction(e -> sorgula());
        loadAllUcuslar();

    }


    
    
    @FXML
    void yemekistemebuton_clck(ActionEvent event) {
    		yemeklbl.setText("Yemek Seçilmedi.");
    }
    @FXML
    boolean yemektableview_clck(MouseEvent event) {
    	return true;

    }
    
    @FXML
    void ucustableview_clck(MouseEvent event) {
    	
    	 setUcusInfo(null);
    	 Ucuslar selectedUcus = ucustableview.getSelectionModel().getSelectedItem();
    	 ucussecfiyatlbl.setText(String.valueOf(Integer.parseInt(selectedUcus.getFiyat())));
         ekolbl.setText(selectedUcus.getFiyat());
         avantajlbl.setText(String.valueOf(Integer.parseInt(selectedUcus.getFiyat()) + 470));
         comfortlbl.setText(String.valueOf(Integer.parseInt(selectedUcus.getFiyat()) + 550));
    }
    
  
   
    
    public void setUcusInfo(Ucuslar ucusNumarası) {
    	 
    	
    }
    
    public void setUserInfo(Uyeler user) {
    	usernamelbl.setText(user.getUsername());     
    	adlbl.setText(user.getAd());
        soyadlbl.setText(user.getSoyad());
        tlfnolbl.setText(user.getTlfno());
    }
    
    private void refreshTable() {
        ObservableList<Ucuslar> ucuslarListesi = Yonetici_Class.getAllUcuslar();
        col3_ucusno.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("ucusNumarasi"));
        col3_kalkis.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("departure"));
        col3_inis.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("destination"));
        col3_tarih.setCellValueFactory(new PropertyValueFactory<Ucuslar, LocalDate>("seferTarihi"));
        col3_kalkissaat.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("kalkisSaati"));
        col3_inissaat.setCellValueFactory(new PropertyValueFactory<Ucuslar, String>("inisSaati"));
        ucustableview.setItems(ucuslarListesi);
        ObservableList<Yemekler> yemeklerListesi = BiletAlma.getAllYemekler();
        col4_yemektur.setCellValueFactory(new PropertyValueFactory<Yemekler, String>("yemekturu"));
        col4_yemek.setCellValueFactory(new PropertyValueFactory<Yemekler, String>("yemek"));
        col4_yemekfiyat.setCellValueFactory(new PropertyValueFactory<Yemekler, String>("fiyat"));
        yemektableview.setItems(yemeklerListesi);
    }
  
    @FXML
    void initialize() {
    	refreshTable();
    	
        toggleGroup = new ToggleGroup();

        
        ekoradio.setToggleGroup(toggleGroup);
        comfortradio.setToggleGroup(toggleGroup);
        avantajradio.setToggleGroup(toggleGroup);
        koltukGroup = new ToggleGroup();
        
        koltukGroup = new ToggleGroup();
        
      
       
        createSeats(koltukGrid1, new String[]{"A", "B", "C"});
        
        createSeats(koltukGrid2, new String[]{"D", "E", "F"});
        
        bagajslider.valueProperty().addListener((obs, oldValue, newValue) -> {
            int secilenAgirlik = (int) Math.round(newValue.doubleValue());
            String bagajFiyati = BiletAlma.hesapla(secilenAgirlik);
            bagajfiyatlbl.setText (bagajFiyati);
            if(ekoradio.isSelected()) {
            	bagajlbl.setText(String.valueOf(newValue.intValue() +15) + "KG"); }
            if(avantajradio.isSelected() || comfortradio.isSelected()) {
                bagajlbl.setText(String.valueOf(newValue.intValue() +20) + "KG"); }
        });
       
        
       
    }
    
    private void sorgula() {
        String departure = ucusseckalk.getText();
        String destination = ucussecin.getText();

        Yonetici_Class databaseService = new Yonetici_Class();
        data = FXCollections.observableArrayList(databaseService.getUcuslar(departure, destination));
        ucustableview.setItems(data);
    }

    private void loadAllUcuslar() {
        data = Yonetici_Class.getAllUcuslar();
        ucustableview.setItems(data);
    }
    
    private void createSeats(GridPane gridPane, String[] columns) {
        int rows = 10; 
       

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns.length; j++) {
                RadioButton koltuk = new RadioButton();
                koltuk.setText((i + 1) + columns[j]);
                koltuk.setToggleGroup(koltukGroup);
                gridPane.add(koltuk, j, i);
            }
           }
        }
    
   
   
    
    public int hesaplaToplamFiyat(TableView<Yemekler> yemektableview, Label bagajFiyatLabel, int secilenPaket) {
        int toplamFiyat = 0;
        Yemekler secilenYemek = yemektableview.getSelectionModel().getSelectedItem(); 
        toplamFiyat += secilenPaket;
        if(secilenYemek == null) {
        	yemeklbl.setText("Yemek Seçilmedi.");
        } else {
        	
             yemeklbl.setText(secilenYemek.getYemek());
             	if(ekoradio.isSelected()) {
             		toplamFiyat += hesaplaYemekFiyati(secilenYemek);
        }
        }
        int bagajFiyati = Integer.parseInt(bagajfiyatlbl.getText());
        toplamFiyat += bagajFiyati;
       
       
        
        if (eglenceradio.isSelected() && !comfortradio.isSelected()) {
		    toplamFiyat += 20;
		} if (flexradio.isSelected()  && !comfortradio.isSelected()) {
			 toplamFiyat += 120;
		}  if (sigortaradio.isSelected()) {
			 toplamFiyat += 15;
		}
  
        return toplamFiyat;
    }
    private int hesaplaYemekFiyati(Yemekler secilenYemek) {
    	secilenYemek = yemektableview.getSelectionModel().getSelectedItem();
        
        return Integer.parseInt(secilenYemek.getFiyat());
    }
    
    @FXML
    private void handleRadioButtonAction() {
       
        String secilenHizmet = "";
        if (sigortaradio.isSelected()) {
            secilenHizmet += sigortaradio.getText() + ", ";
        }
        if (eglenceradio.isSelected()) {
            secilenHizmet += eglenceradio.getText() + ", ";
        }
        if (flexradio.isSelected()) {
            secilenHizmet += flexradio.getText() + ", ";
        }
        
        if (!secilenHizmet.isEmpty()) {
            secilenHizmet = secilenHizmet.substring(0, secilenHizmet.length() - 2); 
            ekhizmetlbl.setText(secilenHizmet);
        } else {
            ekhizmetlbl.setText(" Ek hizmet seçilmedi.");
        }
    }
    
}
