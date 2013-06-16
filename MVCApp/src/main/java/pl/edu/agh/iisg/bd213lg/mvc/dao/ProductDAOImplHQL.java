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

@Repository("ProductDAOHQL")
@Scope("singleton")
public class ProductDAOImplHQL extends DAOImpl<Product, Integer> implements
        ProductDAO {

    private static final String query = "select new pl.edu.agh.iisg.bd213lg.mvc.domain.ProductStats(\n"
            + "    p.ProductName,\n"
            + "    sum(od.unitPrice * od.quantity) as Total\n"
            + ") \n"
            + "from Product p\n"
            + "join p.category c\n"
            + "join p.orderDetails od\n"
            + "join od.order o\n"
            + "join o.employee e\n"
            + "join e.supervisor s\n"
            + "where c.CategoryName = 'Condiments' and s.country = 'USA'\n"
            + "group by p\n" + "order by Total desc";

    public ProductDAOImplHQL() {
        super(Product.class);
    }

    @Transactional
    @Override
    public List<ProductStats> getBestProducts() {
        Session s = getSession();
        Query q = s.createQuery(query).setMaxResults(5);
        for (Object o : q.list()) {
            System.out.println(o);
        }
        return q.list();
    }

}
