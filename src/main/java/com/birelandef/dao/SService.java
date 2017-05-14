package com.birelandef.dao;

import com.birelandef.Sportsmen;

import java.util.List;

/**
 * Created by sophie on 14/05/17.
 */
public interface SService {
    public void save(Sportsmen content);
    public List<Sportsmen> getAll();
}
