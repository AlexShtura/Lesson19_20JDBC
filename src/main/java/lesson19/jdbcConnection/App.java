package lesson19.jdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {

        String createTable = "create table students (id int primary key auto_increment, name varchar(20), age int)";
        String insert = "insert students(name, age) values('Anton', 27),('Kirill', 32)";
        String update = "update students set age = 20 where id = 2";
        String delete = "delete from students where name = 'Kirill'";
        MyConnection myConnection = new MyConnection();

        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()) {
            //statement.executeUpdate(createTable);
            int rows = statement.executeUpdate(insert);
            System.out.println(rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
