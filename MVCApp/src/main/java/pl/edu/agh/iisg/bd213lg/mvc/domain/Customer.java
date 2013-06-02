package pl.edu.agh.iisg.bd213lg.mvc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = -4239703014047011028L;
    
    @Id
    @Column(length = 5)
    private String CustomerID;
    
    @Column(length = 40)
    private String CompanyName;
    
    @Column(length = 30)
    private String ContactName;
    
    @Column(length = 30)
    private String ContactTitle;
    
    @Column(length = 60)
    private String Address;
    
    @Column(length = 15)
    private String City;
    
    @Column(length = 15)
    private String Region;
    
    @Column(length = 10)
    private String PostalCode;
    
    @Column(length = 15)
    private String Country;
    
    public String getCustomerID() {
        return CustomerID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactTitle() {
        return ContactTitle;
    }

    public void setContactTitle(String contactTitle) {
        ContactTitle = contactTitle;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Column(length = 24)
    private String Phone;
    
    @Column(length = 24)
    private String Fax;

}
