package pl.edu.agh.iisg.bd213lg.hellodb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Shippers")
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int ShipperID;
    
    @Column(length = 40, nullable = false)
    private String CompanyName;
    
    @Column(length = 24)
    private String Phone;

    public int getShipperID() {
        return ShipperID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
    
}
