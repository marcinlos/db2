package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.edu.agh.iisg.bd213lg.hellodb.domain.Shipper;

public class ShipperDAOImpl implements ShipperDAO  {

	@Autowired
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Collection<Shipper> findAll() {
		Criteria criteria = getSession().createCriteria(Shipper.class);
    	List<Shipper> result = (List<Shipper>) criteria.list();
        return result;
	}
	

}
