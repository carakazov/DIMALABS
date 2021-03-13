package lab.model;

import com.mysql.cj.jdbc.MysqlDataSource;
import lab.model.Film;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmDao implements IFilmDao{
    private Connection connection;
    private final DataSource dataSource = new MysqlDataSource();
    private final String user = "root";
    private final String password = "yfgjktjy1813";

    public FilmDao(){}

    public void create(Film film) {
        try {
            connection = dataSource.getConnection(user, password);
            String addQuery = "INSERT INTO film_hub.films(title, director) VALUES(?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(addQuery);
            preparedStatement.setString(1, film.getTitle());
            preparedStatement.setString(2, film.getDirector());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Film get(int id) {
        try {
            connection = dataSource.getConnection(user, password);
            String readQuery = "SELECT * FROM film_hub.films WHERE id = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(readQuery);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            int filmId = result.getInt("id");
            String title = result.getString("title");
            String director = result.getString("director");
            Film film = new Film(title, director);
            film.setId(filmId);
            return film;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Film> getAll() {
        try {
            connection = dataSource.getConnection(user, password);
            List<Film> films = new ArrayList();
            String selectQuery = "SELECT * FROM film_hub.films";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int filmId = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String director = resultSet.getString("director");
                Film film = new Film(title, director);
                film.setId(filmId);
                films.add(film);
            }

            return films;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void update(Film film) throws SQLException{
        //try {
            connection = dataSource.getConnection(user, password);
            String updateQuery = "UPDATE film_hub.films SET title = ?, director = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, film.getTitle());
            preparedStatement.setString(2, film.getDirector());
            preparedStatement.setInt(3, film.getId());
            preparedStatement.execute();
        //} catch (SQLException e) {
          //  System.out.println(e.getMessage());
        //}

    }

    public void delete(int id) {
        try {
            connection = dataSource.getConnection(user, password);
            String deleteQuery = "DELETE FROM film_hub.films WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
