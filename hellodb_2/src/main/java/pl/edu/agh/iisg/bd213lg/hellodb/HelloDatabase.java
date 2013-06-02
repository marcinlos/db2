package pl.edu.agh.iisg.bd213lg.hellodb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    
    @Autowired
    private SessionFactory session;
    
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
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private String query = "select employees.firstName, employees.lastName, orderId" + 
            " from Orders as o " + 
                    "where o.orderId = (" + 
                            "select od.id.orderId from OrderDetails as od" +
                                    //"where extract (year from o.orderDate) <> 1997" + 
                                    " group by od.id.orderId " + 
                                    "order by sum(od.unitPrice * od.quantity) desc)";
    private String query2 = "select employees.firstName, orderId from Orders as o where extract(year from orderDate) <> 1997";
    private String query3 = "select employeeId.firstName, employeeId.lastName, orderId"+ 
            "from Order as o"+  
            "where o.OrderID = ("+
              "select orderId"+
              "from OrderDetails as od"+ 
             // "inner join od.orderId as o"+ 
              "where extract (year from orderDate) <> 1997"+
              "group by orderId"+ 
              "order by sum(od.unitPrice * od.quantity) desc"+ 
              "limit 1)";

    private String query4 = "select orderr.employees.firstName, orderr.employees.lastName, orderr.orderId "
            + "from OrderDetails as odet inner join odet.orders as orderr "
            + "where not exists ("
            + "select o.orderId "
            + "from OrderDetails od inner join od.orders o "
            + "where extract (year from o.orderDate) <> 1997 "
            + "group by o.orderId "
            + "having sum(od.unitPrice * od.quantity) > sum(odet.unitPrice * odet.quantity) ) "
            + "group by orderr.employees.firstName, orderr.employees.lastName, orderr.orderId";
    
    
    private String query5 = "select orderr.employees.firstName, orderr.employees.lastName, orderr.orderId "
            + "from OrderDetails as odet inner join odet.orders as orderr "
            + "group by orderr.employees.firstName, orderr.employees.lastName, orderr.orderId "
            + "having sum(odet.unitPrice * odet.quantity) >= ("
            + "select max(select sum(od.unitPrice * od.quantity) "
            + "from OrderDetails od inner join od.orders o "
            + "where extract (year from o.orderDate) <> 1997 "
            + "group by o.orderId "
            + " )      ) ";
    
    String query6 = "select o.orderId, sum(od.unitPrice * od.quantity)"
            + "from OrderDetails od inner join od.orders o, "
            + "OrderDetails od2 inner join od2.orders o2 "
            + "where extract (year from o.orderDate) <> 1997 and extract (year from o2.orderDate) <> 1997"
            + "group by o.orderId "
            + "having sum(od.unitPrice * od.quantity) < sum(od2.unitPrice * od2.quantity)"
            + " ";
    
    
    String query7 = "select o.orderId, o.employees.firstName "
            + "from OrderDetails od inner join od.orders o "
            + "where extract (year from o.orderDate) <> 1997"
            + "group by o.orderId "
            + "order by sum(od.unitPrice * od.quantity) desc";

    @Transactional
    public void getBestOrder() {
        Session session = getSession();
        List<Object[]> ret = session.createQuery(query7).setMaxResults(1).list();
        for (Object[] o: ret) {
            for (Object oo: o) {
                System.out.print(oo + ", ");
            }
            System.out.println(o);
        }
    }
    
}
