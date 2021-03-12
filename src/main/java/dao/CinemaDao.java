package dao;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import model.Cinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinemaDao extends Dao{
    private Connection connection;
    public void create(Cinema cinema) {
        try{
            connection = dataSource.getConnection(user, password);
            String addQuery = "INSERT INTO cinema_hub.cinemas(address, rating, license_id) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setString(1, cinema.getAddress());
            preparedStatement.setInt(2, cinema.getRating());
            preparedStatement.setInt(3, cinema.getLicenseId());
            preparedStatement.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Cinema get(int id){
        try{
            connection = dataSource.getConnection(user, password);
            String readQuery = "SELECT * FROM cinema_hub.cinemas WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(readQuery);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            int cinemaId = result.getInt("id");
            String cinemaAddress = result.getString("address");
            int rating = result.getInt("rating");
            int cinemaLicenseId = result.getInt("license_id");
            Cinema cinema = new Cinema(cinemaAddress, rating, cinemaLicenseId);
            cinema.setId(cinemaId);
            return cinema;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Cinema> getAll(){
        try{
             List<Cinema> cinemas = new ArrayList<>();
             String selectQuery = "SELECT * FROM cinema_hub.cinemas";
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery();
             while(resultSet.next()){
                 int cinemaId = resultSet.getInt("id");
                 String cinemaAddress = resultSet.getString("address");
                 int rating = resultSet.getInt("rating");
                 int cinemaLicenseId = resultSet.getInt("license_id");
                 Cinema cinema = new Cinema(cinemaAddress, rating, cinemaLicenseId);
                 cinema.setId(cinemaId);
                 cinemas.add(cinema);
             }
             return cinemas;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void update(Cinema cinema){
        try{
            connection = dataSource.getConnection(user, password);
            String updateQuery = "UPDATE cinema_hub.cinemas SET address = ?, rating = ?, license_id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, cinema.getAddress());
            preparedStatement.setInt(2, cinema.getRating());
            preparedStatement.setInt(3, cinema.getLicenseId());
            preparedStatement.setInt(4, cinema.getId());
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id){
        try{
            connection = dataSource.getConnection(user, password);
            String deleteQuery = "DELETE FROM cinema_hub.cinemas WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
