package jm.task.core.jdbc.util;

public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "250695Roman";

    public Connection getConnection() {
        Connection connection = null;
        try {
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("connection OK);
    } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connection ERROR);
        }
        return connection;
}
