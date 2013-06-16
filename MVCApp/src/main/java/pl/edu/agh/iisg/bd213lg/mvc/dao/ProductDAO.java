package pl.edu.agh.iisg.bd213lg.mvc.dao;

import java.util.List;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAO;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Product;
import pl.edu.agh.iisg.bd213lg.mvc.domain.ProductStats;

public interface ProductDAO extends DAO<Product, Integer> {
    
    List<ProductStats> getBestProducts();
    
}
