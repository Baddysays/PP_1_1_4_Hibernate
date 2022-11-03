package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {

    }


    @Override
    public void createUsersTable() throws SQLException {

//        try (Connection connection = Util.getConnection();
//             Statement statement = connection.createStatement()) {
//            String sql = "CREATE TABLE IF NOT EXISTS USER " +
//                    "(ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
//                    "name varchar(40) NOT NULL, " +
//                    "lastname varchar(40) NOT NULL, age TINYINT)";
//
//
//            statement.execute(sql);
//        }
    }

    public void dropUsersTable() {
//        try (Connection connection = Util.getConnection();
//                Statement statement = connection.createStatement()) {
//            statement.execute("DROP TABLE IF EXISTS user;");
//        } catch (SQLException e) {
//            System.err.println("не удалена табл.");
//        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        String sql = "insert into user(name, lastName, age) values (?, ?, ?);";
//        try (Connection connection = Util.getConnection();
//                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.err.println("пользователь не сохранен.");
//            e.printStackTrace();
    }

    public void removeUserById(long id) {
//        String sql = "delete from user where  id = ?;";

//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
    }

    public List<User> getAllUsers() {
//        String sql = "SELECT * FROM user;";
//        try (Connection connection = Util.getConnection();
//                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<User> list = new ArrayList<>();
//            while (resultSet.next()) {
//                list.add(new User(resultSet.getString("name"),
//                        resultSet.getString("lastName"),
//                        resultSet.getByte("age")));
//            }
//           return list;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }


    public void cleanUsersTable() {
//    String sql = "delete from user;";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) { }
//    }
    }
}

