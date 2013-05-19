package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import pl.edu.agh.iisg.bd213lg.hellodb.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Product;

public class ProductDAOImpl extends DAOImpl<Product, Integer> implements
        ProductDAO {

    public ProductDAOImpl() {
        super(Product.class);
    }

}
