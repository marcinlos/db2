package pl.edu.agh.iisg.bd213lg.hellodb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shippers")
public class Shipper implements Serializable {

    private static final long serialVersionUID = 4152742428120658920L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String shipperId;


    public String getShipperId() {
        return shipperId;
    }
    @Column
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    @Column(length = 9)
    private String phone;
    
    public void setPhone(String phone){
    	this.phone = phone;
    }
    
    public String getPhone(){
    	return phone;
    }

}
