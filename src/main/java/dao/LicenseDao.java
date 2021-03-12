package dao;

import model.License;

import java.sql.*;

public class LicenseDao extends Dao{
    private Connection connection;
    public void create(License license){
        try{
            connection = dataSource.getConnection(user, password);
            String addQuery = "INSERT INTO cinema_hub.licenses(receiving_date) VALUES(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setDate(1, license.getReceivingDate());
            preparedStatement.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public License read(int id){
        try{
            connection = dataSource.getConnection(user, password);
            String selectQuery = "SELECT * FROM cinema_hub.licenses WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet set = preparedStatement.executeQuery();
            set.next();
            int licenseId = set.getInt("id");
            Date receivindDate = set.getDate("receiving_date");
            License license = new License(receivindDate);
            license.setId(id);
            return license;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
