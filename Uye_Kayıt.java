package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

public class Uye_Kayıt {
	public void Uye_Ekle(String ad, String soyad, String username, LocalDate dogum_tarihi, String cinsiyet, String tlfno, String email, String sifre  ) {
		if (!ValidationUtil.isValidEmail(email)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText(null);
            alert.setContentText("Geçersiz e-posta adresi!");
            alert.showAndWait();
        } else {
        
			try (Connection connection = veritabanı.getConnection()) {
	            String query = "INSERT INTO kullanici (ad, soyad, username, dogum_tarihi, cinsiyet, tlfno, email, sifre) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, ad);
	            preparedStatement.setString(2, soyad);
	            preparedStatement.setString(3, username);
	            preparedStatement.setObject(4, java.sql.Timestamp.valueOf(dogum_tarihi.atStartOfDay()));
	            preparedStatement.setString(5, cinsiyet);
	            preparedStatement.setString(6, tlfno);
	            preparedStatement.setString(7, email);
	            preparedStatement.setString(8, sifre);
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
        }
    }
	
	public class ValidationUtil {
	    public static boolean isValidEmail(String email) {
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	        Pattern pattern = Pattern.compile(emailRegex);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
	}
	
	
}


	    
	 
