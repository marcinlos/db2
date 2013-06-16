package pl.edu.agh.iisg.bd213lg.mvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.mvc.domain.EmployeeStats;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Product;
import pl.edu.agh.iisg.bd213lg.mvc.domain.ProductStats;

@Repository("ProductDAOSQL")
@Scope("singleton")
public class ProductDAOImplSQL extends DAOImpl<Product, Integer> implements
        ProductDAO {
    
    private static final String query = "select \n" + 
    		"    p.ProductName, \n" + 
    		"    sum(od.UnitPrice * od.Quantity) as Total\n" + 
    		"from Products as p\n" + 
    		"join Categories as c on p.CategoryID = c.CategoryId\n" + 
    		"join `Order Details` as od on od.ProductId = p.ProductId\n" + 
    		"join Orders as o on o.OrderId = od.OrderId\n" + 
    		"join Employees as e on o.EmployeeId = e.EmployeeId\n" + 
    		"join Employees as b on e.ReportsTo = b.EmployeeId\n" + 
    		"where c.CategoryName = 'Condiments' and b.Country = 'USA'\n" + 
    		"group by p.ProductId\n" + 
    		"order by Total desc\n" + 
    		"limit 5";

    public ProductDAOImplSQL() {
        super(Product.class);
    }

    @Transactional
    @Override
    public List<ProductStats> getBestProducts() {
        Session s = getSession();
        Query q = s.createSQLQuery(query)
            .addScalar("productName")
            .addScalar("total")
            .setResultTransformer(Transformers.aliasToBean(ProductStats.class))
            ;
        for (Object o: q.list()) {
            System.out.println(o);
        }
        return q.list();
    }

}
