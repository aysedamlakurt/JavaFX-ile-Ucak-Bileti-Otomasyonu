package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Uye_Giris {
	public boolean login(String username, String sifre) {
        String query = "SELECT username, sifre FROM kullanici WHERE username = ? AND sifre = ?";
        try (Connection connection = veritabanı.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, sifre);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	public Uyeler getUserInfo(String username) {
        String query = "SELECT * FROM kullanici WHERE username = ?";
        try (Connection connection = veritabanı.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Uyeler(
                        resultSet.getString("ad"),
                        resultSet.getString("soyad"),
                        resultSet.getString("username"),
                        resultSet.getDate("dogum_tarihi").toLocalDate(),
                        resultSet.getString("cinsiyet"),
                        resultSet.getString("tlfno"),
                        resultSet.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
