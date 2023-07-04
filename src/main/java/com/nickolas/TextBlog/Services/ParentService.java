package com.nickolas.TextBlog.Services;

import java.util.List;

public interface ParentService<T> {

    void create(T t);
    List<T> getAll();
    void delete(int id);
    void update(int id, T t);
    T getById(int id);
}
