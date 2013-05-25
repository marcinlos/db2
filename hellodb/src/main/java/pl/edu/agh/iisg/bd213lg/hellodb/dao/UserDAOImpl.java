package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.iisg.bd213lg.hellodb.domain.Customer;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.User;

public class UserDAOImpl implements UserDAO  {

	@Autowired
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Collection<User> findAll() {
		Criteria criteria = getSession().createCriteria(User.class);
    	List<User> result = (List<User>) criteria.list();
        return result;
	}
	

}
