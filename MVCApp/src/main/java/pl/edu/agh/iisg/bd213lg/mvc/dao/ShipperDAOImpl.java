package pl.edu.agh.iisg.bd213lg.mvc.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Shipper;

@Repository("ShipperDAO")
@Scope("singleton")
public class ShipperDAOImpl extends DAOImpl<Shipper, Integer> implements
        ShipperDAO {

    public ShipperDAOImpl() {
        super(Shipper.class);
    }

}
