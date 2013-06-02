package pl.edu.agh.iisg.bd213lg.mvc.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Product;

@Repository("ProductDAO")
@Scope("singleton")
public class ProductDAOImpl extends DAOImpl<Product, Integer> implements
        ProductDAO {

    public ProductDAOImpl() {
        super(Product.class);
    }

}
