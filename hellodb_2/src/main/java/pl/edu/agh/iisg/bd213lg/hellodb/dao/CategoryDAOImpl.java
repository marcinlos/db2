package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import pl.edu.agh.iisg.bd213lg.hellodb.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Category;

public class CategoryDAOImpl extends DAOImpl<Category, Integer> implements
        CategoryDAO {

    public CategoryDAOImpl() {
        super(Category.class);
    }

}
