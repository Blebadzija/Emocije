package org.etsntesla.it;

import java.util.List;

public interface BaseRepository<T> {

    List<T> getAll();
    T getById(int id);
    void create(T item);
    void update(T item);
    void delete(T item);

}
