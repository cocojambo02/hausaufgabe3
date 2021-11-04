package repository;

import java.util.List;

public interface ICrudRepository<T,I> {

    T create(T obj);

    List<T> getAll();

    T update( I ID, T obj);

    void delete(T obj);
}