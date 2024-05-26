package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;



public class Yonetici_Class {
	 
	public void Ucus_Ekle(String ucusNumarası, String departure, String destination, LocalDate seferTarihi, String kalkisSaati, String inisSaati, String fiyat ) {
		
			try (Connection connection = veritabanı.getConnection()) {
	            String query = "INSERT INTO ucuslar (ucusNumarası, departure, destination, seferTarihi, kalkisSaati, inisSaati, fiyat) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, ucusNumarası);
	            preparedStatement.setString(2, departure);
	            preparedStatement.setString(3, destination);
	            preparedStatement.setDate(4, Date.valueOf(seferTarihi));
	            preparedStatement.setString(5, kalkisSaati);
	            preparedStatement.setString(6, inisSaati);
	            preparedStatement.setString(7, fiyat);
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	public static void Ucus_Sil(String ucusNumarası) {
        String sql = "DELETE FROM ucuslar WHERE ucusNumarası = ?";

        try (Connection conn = veritabanı.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ucusNumarası);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NUMBERS = 1000;

    public static String generateFlightNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 2; i++) {
            char randomChar = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
            sb.append(randomChar);
        }
        int randomNumber = random.nextInt(NUMBERS);
        sb.append(String.format("%03d", randomNumber));

        return sb.toString();
    
    }
    
    
   
    public static ObservableList<Ucuslar> getAllUcuslar() {
        ObservableList<Ucuslar> ucuslarListesi = FXCollections.observableArrayList();
        String sql = "SELECT * FROM ucuslar";

        try (Connection connection = veritabanı.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String ucusNumarası = rs.getString("ucusNumarası");
                String departure = rs.getString("departure");
                String destination = rs.getString("destination");
                LocalDate seferTarihi = rs.getDate("seferTarihi").toLocalDate();
                String kalkisSaati = Utils.formatTimeToString(rs, "kalkisSaati");
                String inisSaati = Utils.formatTimeToString(rs, "inisSaati");
                String fiyat = rs.getString("fiyat");

                ucuslarListesi.add(new Ucuslar(ucusNumarası, departure, destination, seferTarihi, kalkisSaati, inisSaati, fiyat));
               
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ucuslarListesi;
    }
    
    public class Utils {
        public static String formatTimeToString(ResultSet rs, String columnName) throws SQLException {
            Time time = rs.getTime(columnName);
            LocalTime localTime = time.toLocalTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            return localTime.format(formatter);
        }
    }
public void YemekEkle(String yemekturu, String yemek, String fiyat ) {
		
		try (Connection connection = veritabanı.getConnection()) {
            String query = "INSERT INTO yemekler (yemekturu, yemek, fiyat) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, yemekturu);
            preparedStatement.setString(2, yemek);
            preparedStatement.setString(3, fiyat);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
public Ucuslar getUcusInfo(String ucusNumarasi) {
    String query = "SELECT * FROM ucuslar WHERE ucusNumarası = ?";
    try (Connection connection = veritabanı.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, ucusNumarasi);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return new Ucuslar(
                    resultSet.getString("ucusNumarasi"),
                    resultSet.getString("departure"),
                    resultSet.getString("destination"),
                    resultSet.getDate("seferTarihi").toLocalDate(),
                    resultSet.getString("kalkisSaati"),
                    resultSet.getString("inisSaati"),
                    resultSet.getString("fiyat")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

public List<Ucuslar> getUcuslar(String departure, String destination) {
    List<Ucuslar> ucusListesi = new ArrayList<>();

    try(Connection connection = veritabanı.getConnection()) {
        
        String query = "SELECT * FROM ucuslar WHERE departure = ? AND destination = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, departure);
        stmt.setString(2, destination);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Ucuslar ucus = new Ucuslar(
                rs.getString("ucusNumarasi"),
                rs.getString("departure"),
                rs.getString("destination"),
                rs.getDate("seferTarihi").toLocalDate(),
                rs.getString("kalkisSaati"),
                rs.getString("inisSaati"),
                rs.getString("fiyat")
            );
            ucusListesi.add(ucus);
        }

        rs.close();
        stmt.close();
        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return ucusListesi;
}

public static ObservableList<Biletler> getAllBiletler() {
    ObservableList<Biletler> BiletlerListesi = FXCollections.observableArrayList();
    String sql = "SELECT * FROM biletler";

    try (Connection connection = veritabanı.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            String musteri_username = rs.getString("musteri_username");
            String departure = rs.getString("departure");
            String destination = rs.getString("destination");
            LocalDate seferTarihi = rs.getDate("seferTarihi").toLocalDate();
            String kalkisSaati = Utils.formatTimeToString(rs, "kalkisSaati");
            String inisSaati = Utils.formatTimeToString(rs, "inisSaati");
            String paket= rs.getString("paket");
            String koltuk = rs.getString("koltuk");
            String yemek = rs.getString("yemek");
            String bagaj = rs.getString("bagaj");
            String hizmet = rs.getString("hizmet");
            String fiyat = rs.getString("fiyat");

            BiletlerListesi.add(new Biletler(musteri_username, departure, destination, seferTarihi, kalkisSaati, inisSaati, paket, koltuk, yemek, bagaj, hizmet, fiyat));
           
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return BiletlerListesi;
}

public static void Bilet_Sil(String username) {
    String sql = "DELETE FROM biletler WHERE musteri_username = ?";

    try (Connection conn = veritabanı.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, username);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
}
    
    
    
    
    
    

