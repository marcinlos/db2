package pl.edu.agh.iisg.bd213lg.mvc.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Customer;

@Repository("CustomerDAO")
@Scope("singleton")
public class CustomerDAOImpl extends DAOImpl<Customer, String> implements
        CustomerDAO {

    public CustomerDAOImpl() {
        super(Customer.class); 
    }

}
