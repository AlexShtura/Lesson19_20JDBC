package lesson20.repository;

import lesson20.entities.Student;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student>{
    List<Student> findAllOrderByCriteria(String field, String order);
}
