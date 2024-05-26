package application;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BiletAlma {
	 public static ObservableList<Yemekler> getAllYemekler() {
	        ObservableList<Yemekler> yemeklerListesi = FXCollections.observableArrayList();
	        String sql = "SELECT * FROM yemekler";

	        try (Connection connection = veritabanı.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                String yemekturu = rs.getString("yemekturu");
	                String yemek = rs.getString("yemek");
	                String fiyat = rs.getString("fiyat");

	                yemeklerListesi.add(new Yemekler(yemekturu, yemek, fiyat));
	               
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return yemeklerListesi;
	    }
	 
	 public static String hesapla(int agirlik) {
		 	if(agirlik <= 0) {
		 		return "0";
		 	}
		 	else if (agirlik <= 5) {
		        return "300";
		    } else if (agirlik <= 10) {
		        return "600";
		    } else if (agirlik <= 15) {
		        return "900";
		    } else if (agirlik <= 25) {
		        return "1500";
		    } else if (agirlik <= 35) {
		        return "2100";
		    } else {
		        return "Geçersiz değer"; 
		    }
		}
	 
	 public void BiletEkle(String musteri_username, String departure, String destination, String seferTarihi, String kalkisSaati, String inisSaati, String paket, String koltuk, String yemek, String bagaj, String hizmet,  String fiyat ) {
			
			try (Connection connection = veritabanı.getConnection()) {
	            String query = "INSERT INTO biletler (musteri_username, departure, destination, seferTarihi, kalkisSaati, inisSaati, paket, koltuk, yemek, bagaj, hizmet, fiyat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, musteri_username);
	            preparedStatement.setString(2, departure);
	            preparedStatement.setString(3, destination);
	            preparedStatement.setString(4, seferTarihi);
	            preparedStatement.setString(5, kalkisSaati);
	            preparedStatement.setString(6, inisSaati);
	            preparedStatement.setString(7,paket);
	            preparedStatement.setString(8, koltuk);
	            preparedStatement.setString(9, yemek);
	            preparedStatement.setString(10, bagaj);
	            preparedStatement.setString(11, hizmet);
	            preparedStatement.setString(12, fiyat);
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	
	
	
	
}
