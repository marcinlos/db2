package pl.edu.agh.iisg.bd213lg.hellodb.dao.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

public class DAOImpl<T, Id extends Serializable> implements DAO<T, Id> {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Class<T> dataClass;
    
    public DAOImpl(Class<T> dataClass) {
        this.dataClass = dataClass;
    }
    
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public T find(Id id) {
        Object o = getSession().get(dataClass, id);
        return dataClass.cast(o);
    }

    @Override
    public Collection<T> findAll() {
        return findByCriteria();
    }
    
    @Override
    public Collection<T> findByExample(T example, String... excludes) {
        Session session = getSession();
        return findByExample(session, example, excludes);
    }
    
    private Collection<T> findByExample(Session session, T example,
            String... excludes) {
        Criteria criteria = session.createCriteria(dataClass);
        Example ex = Example.create(example);
        for (String s : excludes) {
            ex.excludeProperty(s);
        }
        criteria.add(ex);
        @SuppressWarnings("unchecked")
        List<T> result = (List<T>) criteria.list();
        return result;
    }

    @Override
    public Collection<T> findByCriteria(Criterion... criterion) {
        Session session = getSession();
        return findByCriteria(session, criterion);
    }
    
    private Collection<T> findByCriteria(Session session,
            Criterion... criterion) {
        Criteria criteria = session.createCriteria(dataClass);
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        @SuppressWarnings("unchecked")
        List<T> result = (List<T>) criteria.list();
        return result;
    }
    
    @Override
    public boolean save(T entity) {
        getSession().save(entity);
        return false;
    }

    @Override
    public boolean delete(T entity) {
        getSession().delete(entity);
        return true;
    }
    
}
