package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import pl.edu.agh.iisg.bd213lg.hellodb.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Customer;

public class CustomerDAOImpl extends DAOImpl<Customer, String> implements
        CustomerDAO {

    public CustomerDAOImpl() {
        super(Customer.class); 
    }

}
