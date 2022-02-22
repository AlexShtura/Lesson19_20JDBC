package lesson20.repository.impl;

import lesson20.entities.Student;
import lesson20.jdbcConnection.JdbcConnection;
import lesson20.repository.BaseRepository;
import lesson20.repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private static final String INSERT = "INSERT INTO students (name, age) values (?, ?)";
    private static final String DELETE = "DELETE FROM students where id=?";
    //private static final String SELECT_BY_ID = "SELECT * FROM students where id=?";
    private static final String SELECT_ALL = "SELECT * FROM students";
    private static final String SELECT_BY_ID = "SELECT id,name,age FROM students where id=?";
    private static final String SELECT_ALL_ORDER_BY = "SELECT * FROM students ORDER BY ? ?";
    private static final String UPDATE = "UPDATE students SET name=?, age=? where id=?";

    private JdbcConnection connection;

    public StudentRepositoryImpl(JdbcConnection connection) {
        this.connection = connection;
    }

    @Override
    public Student findById(int id) {
        Student student = new Student();
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                /*student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));*/
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student>students = new ArrayList<>();
        try (Connection conn = connection.getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                /*student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));*/
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean deleteById(int id) {
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Student entity) {
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getAge());
            statement.setInt(3, entity.getId());
            return statement.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean save(Student entity) {
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(INSERT)) {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getAge());
            statement.setInt(3, entity.getId());
            return statement.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> findAllOrderByCriteria(String field, String order) {
        List<Student> students = new ArrayList<>();
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_ORDER_BY)) {
            statement.setString(1, field);
            statement.setString(2, order);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }
}
