package jm.task.core.jdbc;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";

    private static final String USERNAME = "root1";
    private static final String PASSWORD = "12345_Aa";

//    private static Connection connection;

    public static void main(String[] args) {
        // реализуйте алгоритм здесь


        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if (!connection.isClosed()){
                System.out.println("Соединение с БД Установлено!");
            }

            connection.close();
            if (connection.isClosed()){
                System.out.println("Соединение с БД закрыто!");
            }
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
            System.err.println("Неудалось загрузить класс драйвера!");
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
