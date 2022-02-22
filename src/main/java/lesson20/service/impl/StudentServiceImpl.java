package lesson20.service.impl;

import lesson20.entities.Student;
import lesson20.repository.BaseRepository;
import lesson20.repository.StudentRepository;
import lesson20.repository.impl.StudentRepositoryImpl;
import lesson20.service.BaseService;
import lesson20.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    @Override
    public boolean update(Student entity) {
        return repository.update(entity);
    }

    @Override
    public boolean save(Student entity) {
        return repository.save(entity);
    }

    @Override
    public List<Student> findByCriteria(String field, String order) {
        return repository.findAllOrderByCriteria(field, order);
    }
}
