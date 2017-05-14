package com.birelandef.dao;

import com.birelandef.entities.Sportsmen;

import java.util.List;

/**
 * Created by sophie on 14/05/17.
 */
interface DAO<T> {
    public void save(T sportsmen);
    public List<T> getAll();
}
