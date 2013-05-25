package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import java.util.Collection;

import org.hibernate.criterion.Criterion;

import pl.edu.agh.iisg.bd213lg.hellodb.domain.User;

public interface UserDAO {
    
    
    Collection<User> findAll();
    

}