package com.birelandef.dao;

import com.birelandef.entities.Sportsmen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sophie on 14/05/17.
 */
@Service("storageService")
@EnableTransactionManagement
public class ServiceImpl implements SService {
    @Autowired
    private DAO dao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Sportsmen sportsmen) {
        dao.save(sportsmen);

    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Sportsmen> getAll() {
        return dao.getAll();
    }
}
