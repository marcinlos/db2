package pl.edu.agh.iisg.bd213lg.hellodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.iisg.bd213lg.hellodb.dao.CustomerDAO;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Customer;

public class HelloDatabase {

    @Autowired
    private CustomerDAO customers;
    
    private String name;
    
    public void setCustomers(CustomerDAO customers) {
        this.customers = customers;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    @Transactional
    public void sayHello() {
    	System.out.println("Hello, " + name);
        for (Customer customer: customers.findAll()) {
            System.out.println(customer.getCompanyName());
        }
    }
    
}