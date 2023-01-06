package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {

        String createTable = "CREATE TABLE IF NOT EXISTS Users " +
                "(id BIGINT not null auto_increment PRIMARY KEY," +
                " name VARCHAR (50)," +
                " lastName VARCHAR(50)," +
                " age TINYINT)";

        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(createTable);
                System.out.println("Table created");

            } catch (SQLException e) {
                System.out.println("Error create Table");

            }
        }


    }

    public void dropUsersTable() throws SQLException {
        String dropTable = "DROP TABLE IF EXISTS Users";

        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(dropTable);
                System.out.println("Table deleted");

            } catch (SQLException e) {
                System.out.println("Error dropUsersTable");
            }
        }

    }

    public void saveUser(String name, String lastName, int age) throws SQLException {
        String saveUser = "INSERT INTO USERS (name, lastName, age) VALUES(?,?,?)";

        try (Connection connection = Util.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(saveUser)) {
                statement.setString(1,name);
                statement.setString(2,lastName);
                statement.setInt(3,age);
                statement.executeUpdate();
                System.out.println("User с именем-"+name+" добавлен в базу данных");

            } catch (SQLException e) {
                System.out.println("Error saving User");
            }
        }


    }

    public void removeUserById(long id) throws SQLException {

        String removeUserById = "DELETE FROM USERS WHERE id=?";

        try (Connection connection = Util.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(removeUserById)) {
                statement.setLong(1,id);
                statement.executeUpdate();
                System.out.println("User с id="+id+" удалён из базы данных");

            } catch (SQLException e) {
                System.out.println("Error deleting User");
            }
        }

    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
                while (resultSet.next()) {
                    users.add(new User(resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("lastName"), resultSet.getInt("age")));
                }



            } catch (SQLException e) {
                System.out.println("Error view Table");
            }
            System.out.println(users);
            return users;

        }
    }

    public void cleanUsersTable() throws SQLException {

        try (Connection connection = Util.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("DELETE FROM Users");
                System.out.println("Table cleared");

            } catch (SQLException e) {
                System.out.println("Error clean Table");
            }
        }



    }
}
