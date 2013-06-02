package pl.edu.agh.iisg.bd213lg.mvc.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Supplier;

@Repository("SupplierDAO")
@Scope("singleton")
public class SupplierDAOImpl extends DAOImpl<Supplier, Integer> implements
        SupplierDAO {

    public SupplierDAOImpl() {
        super(Supplier.class);
    }

}
