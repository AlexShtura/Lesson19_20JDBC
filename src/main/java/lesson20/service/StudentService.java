package lesson20.service;

import lesson20.entities.Student;

import java.util.List;

public interface StudentService extends BaseService<Student> {
    List<Student> findByCriteria(String field, String order);
}
