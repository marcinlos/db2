package pl.edu.agh.iisg.bd213lg.mvc.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Category;

@Repository("CategoryDAO")
@Scope("singleton")
public class CategoryDAOImpl extends DAOImpl<Category, Integer> implements
        CategoryDAO {

    public CategoryDAOImpl() {
        super(Category.class);
    }

}
