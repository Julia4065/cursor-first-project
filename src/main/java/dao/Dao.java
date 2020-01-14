package dao;

import java.util.List;

public interface Dao<T> {

    T get(int id);

    T get(String name);

    List<T> getAll();

    void save(T t);

    void delete(T t);
}