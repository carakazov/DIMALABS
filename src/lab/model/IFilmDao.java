package lab.model;

import java.sql.SQLException;
import java.util.List;

public interface IFilmDao {
    void create(Film film);
    Film get(int id);
    List<Film> getAll();
    void update(Film film) throws SQLException;
    void delete(int id);
}
