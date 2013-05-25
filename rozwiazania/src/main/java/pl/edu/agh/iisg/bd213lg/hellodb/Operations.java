package pl.edu.agh.iisg.bd213lg.hellodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.iisg.bd213lg.hellodb.dao.CustomerDAO;
import pl.edu.agh.iisg.bd213lg.hellodb.dao.ShipperDAO;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Customer;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Shipper;

public class Operations {
	
	@Autowired
    private CustomerDAO customers;
	@Autowired
	private ShipperDAO shippers;
    
    private String name;
    
    public void setCustomers(CustomerDAO customers) {
        this.customers = customers;
    }
    public void setUsers(ShipperDAO shippers) {
		this.shippers = shippers;
	}
    
    public void setName(String name) {
    	this.name = name;
    }
    
    @Transactional
    public boolean addCustomer() {
    	System.out.println(name + " adding user");
    	Customer cust = new Customer();
    	cust.setCustomerID("IIDDD");
    	cust.setContactName("takiejnazwytamjesczeniema");
    	cust.setCompanyName("takiejnazwytezniema");
    	return customers.save(cust);
    }
    
    @Transactional
    public boolean updateCustomer(String id, String newCompanyName) {
    	System.out.println(name + " updating user");
    	Customer c = customers.find(id);
    	c.setCompanyName(newCompanyName);
    	return customers.update(c);
    }
    
    @Transactional
    public boolean deleteCustomer(String id){
    	System.out.println(name + " deleting user");
    	Customer c = customers.find(id);
    	return customers.delete(c);
    }
    
    @Transactional
    public void printShippers(){
    	for (Shipper shipper: shippers.findAll()) {
            System.out.println(shipper.getCompanyName());
        }
    }
	

	

}
