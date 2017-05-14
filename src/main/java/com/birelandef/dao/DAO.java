package com.birelandef.dao;

import com.birelandef.Sportsmen;

import java.util.List;

/**
 * Created by sophie on 14/05/17.
 */
interface DAO {
    public void save(Sportsmen sportsmen);
    public List<Sportsmen> getAll();
}
