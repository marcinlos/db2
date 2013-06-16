package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import java.util.Collection;

import pl.edu.agh.iisg.bd213lg.hellodb.domain.Customer;

public interface CustomerDAO {
    
	Customer find(String id);
    
    Collection<Customer> findAll();
    
    boolean save(Customer entity);
    
    boolean delete (Customer entity);
    
    public boolean update(Customer entity);

}
