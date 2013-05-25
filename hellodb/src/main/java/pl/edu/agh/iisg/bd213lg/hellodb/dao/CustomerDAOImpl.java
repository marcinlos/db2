package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.iisg.bd213lg.hellodb.domain.Customer;

public class CustomerDAOImpl implements
        CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public Customer find(String id) {
        Object c = getSession().get(Customer.class, id);
        return (Customer) c;
    }

    @Override
    public Collection<Customer> findAll() {
    	Criteria criteria = getSession().createCriteria(Customer.class);
    	List<Customer> result = (List<Customer>) criteria.list();
        return result;
    }
    
    @Override
    public boolean save(Customer entity) {
        getSession().save(entity);
        return true;
    }

    @Override
    public boolean delete(Customer entity) {
        getSession().delete(entity);
        return true;
    }
    
    @Override
    public boolean update(Customer entity) {
    	getSession().update(entity);
    	return true;
    }
    
}
