package com.example.pruebarelaciones.Service;

import java.util.List;

public interface BaseService<T, I> {
    T getById(I id);

    List<T> getAll();

    T update(I id, T data);

    void deleteById(I id);

}
