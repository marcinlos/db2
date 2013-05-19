package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import pl.edu.agh.iisg.bd213lg.hellodb.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Supplier;

public class SupplierDAOImpl extends DAOImpl<Supplier, Integer> implements
        SupplierDAO {

    public SupplierDAOImpl() {
        super(Supplier.class);
    }

}
