package dao;

import model.License;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<License> getAll(){
        try{
            List<License> licenses = new ArrayList<>();
            connection = dataSource.getConnection(user, password);
            String selectQuery = "SELECT * FROM cinema_hub.licenses";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                int id = set.getInt("id");
                Date date = set.getDate("receiving_date");
                License license = new License(date);
                license.setId(id);
                licenses.add(license);
            }
            return licenses;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void delete(int id){
        try{
            connection = dataSource.getConnection(user, password);
            String deleteQuery = "DELETE FROM cinema_hub.licenses WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
