package permana.surya.dharma.repository;

import permana.surya.dharma.entity.Todolist;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository {
    private DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Todolist save(Todolist todolist) {
        String sql = "INSERT INTO todolist(todo) VALUES (?)";

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, todolist.getTodo());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return todolist;
    }

    @Override
    public Todolist findById(Integer id) {
//        for (Todolist todolist : todolistData) {
//            if (todolist.getId().equals(id)) {
//                return todolist;
//            }
//        }
        throw new InputMismatchException("Todolist dengan nomor " + id + " tidak ditemukan!");
    }

    private boolean isExist(Integer id) {
        String sql = "SELECT id FROM todolist WHERE id = ?";
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

    }

    @Override
    public boolean delete(Integer id) {
        if(isExist(id)) {
            String sql = "DELETE FROM todolist WHERE id = ?";
            try(Connection connection = dataSource.getConnection()) {
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Todolist> findAll() {
        String sql = "SELECT id, todo FROM todolist";
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {

            List<Todolist> todolists = new ArrayList<>();
            while (resultSet.next()) {
                Todolist todolist = new Todolist();
                todolist.setId(resultSet.getInt("id"));
                todolist.setTodo(resultSet.getString("todo"));

                todolists.add(todolist);
            }
            return todolists;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}