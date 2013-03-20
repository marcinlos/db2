package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.iisg.bd213lg.hellodb.domain.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	private HibernateTemplate hibernate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernate = new HibernateTemplate(sessionFactory);
	}

	@Transactional(readOnly = false)
	@Override
	public void saveUser(User user) {
		hibernate.saveOrUpdate(user);
	}

	@Transactional(readOnly = false)
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser(User user) {
		return (List<User>) hibernate.find("from " + User.class.getName());
	}

	@Override
	public User selectUserById(String userId) {
		return hibernate.get(User.class, userId);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteUser(User user) {
		hibernate.delete(user);
	}

}
