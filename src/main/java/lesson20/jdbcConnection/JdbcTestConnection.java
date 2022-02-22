package lesson20.jdbcConnection;

import lesson20.entities.Student;
import lesson20.repository.BaseRepository;
import lesson20.repository.StudentRepository;
import lesson20.repository.impl.StudentRepositoryImpl;
import lesson20.service.BaseService;
import lesson20.service.StudentService;
import lesson20.service.impl.StudentServiceImpl;

import java.sql.Statement;

public class JdbcTestConnection {
    public static void main(String[] args) {

        /*String createTable = "create table students (id int primary key auto_increment, name varchar(20), age int)";
        String insert = "insert students(name, age) values('Anton', 27),('Kirill', 32)";
        String update = "update students set age = 20 where id = 2";
        String delete = "delete from students where name = 'Kirill'";
        JdbcConnection myConnection = new JdbcConnection();

        try (Connection connection = myConnection.getConnection();
             Statement statement = connection.createStatement()) {
            //statement.executeUpdate(createTable);
            int rows = statement.executeUpdate(insert);
            System.out.println(rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        JdbcConnection connection = new JdbcConnection();
        StudentRepository repository = new StudentRepositoryImpl(connection);
        StudentService service = new StudentServiceImpl(repository);
        //Student student = new Student("Anton", 54);
        //boolean isSave = service.save(student);
        /*Student student = service.findById(1);
        student.setAge(66);
        boolean flag = service.update(student);
        System.out.println(flag);*/
        //boolean isSave = service.deleteById(4);
        service.findByCriteria("name", "ASC").forEach(System.out::println);

    }
}
