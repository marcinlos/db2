package pl.edu.agh.iisg.bd213lg.hellodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.iisg.bd213lg.hellodb.dao.CategoryDAO;
import pl.edu.agh.iisg.bd213lg.hellodb.dao.CustomerDAO;
import pl.edu.agh.iisg.bd213lg.hellodb.dao.ProductDAO;
import pl.edu.agh.iisg.bd213lg.hellodb.dao.ShipperDAO;
import pl.edu.agh.iisg.bd213lg.hellodb.dao.SupplierDAO;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Category;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Customer;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Product;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Shipper;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Supplier;

public class HelloDatabase {

    @Autowired 
    private CustomerDAO customers;
    
    @Autowired
    private CategoryDAO categories;
    
    @Autowired
    private ShipperDAO shippers;
    
    @Autowired
    private SupplierDAO suppliers;
    
    @Autowired
    private ProductDAO products;
    
    private String name;
    
    public void setCustomers(CustomerDAO customers) {
        this.customers = customers;
    }
    
    public void setCategories(CategoryDAO categories) {
        this.categories = categories;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    @Transactional
    public void printCustomers() {
    	System.out.println("Hello, " + name);
        for (Customer customer: customers.findAll()) {
            System.out.println(customer.getCompanyName());
        }
    }
    
    @Transactional
    public void printCategories() {
        System.out.println("Categories:");
        for (Category category: categories.findAll()) {
            System.out.println(category.getCategoryName() + ": " + 
                    category.getDescription());
        }
    }
    
    @Transactional
    public void printShippers() {
        System.out.println("Shippers:");
        for (Shipper shipper: shippers.findAll()) {
            System.out.println(shipper.getCompanyName() + ": " + 
                    shipper.getPhone());
        }
    }
    
    @Transactional
    public void printProducts() {
        System.out.println("Products:");
        for (Product product : products.findAll()) {
            Supplier s = product.getSupplier();
            System.out.println(product.getProductName() + ": " + 
                    product.getUnitPrice() + "(supplier: " + 
                    s.getCompanyName() + ")");
        }
    }

    @Transactional
    public void printSuppliers() {
        System.out.println("Suppliers:");
        for (Supplier supplier : suppliers.findAll()) {
            System.out.println(supplier.getCompanyName() + " ("
                    + supplier.getContactTitle() + " "
                    + supplier.getContactName() + ")");
            for (Product p: supplier.getProducts()) {
                System.out.println("  * " + p.getProductName());
            }
        }
    }
    
}
