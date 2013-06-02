package pl.edu.agh.iisg.bd213lg.mvc.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.criterion.Criterion;

public interface DAO<T, Id extends Serializable> {

    T find(Id id);
    
    Collection<T> findAll();
    
    Collection<T> findByExample(T example, String... excludes);
    
    Collection<T> findByCriteria(Criterion... criterion);
    
    void save(T entity);
    
    void delete (T entity);
    
}
