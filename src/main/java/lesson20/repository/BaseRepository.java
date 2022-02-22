package lesson20.repository;

import java.util.List;

public interface BaseRepository<T> {

    T findById(int id);
    List<T> findAll();
    boolean deleteById(int id);
    boolean update(T entity);
    boolean save(T entity);
}
