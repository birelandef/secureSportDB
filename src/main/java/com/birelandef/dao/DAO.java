package com.birelandef.dao;

import java.util.List;

/**
 * Created by sophie on 14/05/17.
 */
public interface DAO<T> {
    public void save(T sportsmen);
    public List<T> getAll();
}
