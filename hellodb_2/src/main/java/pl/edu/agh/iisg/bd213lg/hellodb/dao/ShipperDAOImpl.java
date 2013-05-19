package pl.edu.agh.iisg.bd213lg.hellodb.dao;

import pl.edu.agh.iisg.bd213lg.hellodb.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.hellodb.domain.Shipper;

public class ShipperDAOImpl extends DAOImpl<Shipper, Integer> implements
        ShipperDAO {

    public ShipperDAOImpl() {
        super(Shipper.class);
    }

}
