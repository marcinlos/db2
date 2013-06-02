package pl.edu.agh.iisg.bd213lg.mvc.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Suppliers")
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int SupplierID;
    
    @Column(length = 40, nullable = false)
    private String CompanyName;
    
    @Column(length = 30)
    private String ContactName;
    
    @Column(length = 30)
    private String ContactTitle;
    
    @Column(length = 15)
    private String City;
    
    @Column(length = 15)
    private String Region;
    
    @Column(length = 10)
    private String PostalCode;
    
    @Column(length = 24)
    private String Phone;
    
    @Column(length = 24)
    private String Fax;
    
    @Column(columnDefinition = "mediumtext")
    private String HomePage;
    
    @OneToMany(mappedBy = "supplier")
    private Set<Product> products;
    

    public int getSupplierID() {
        return SupplierID;
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


    public String getHomePage() {
        return HomePage;
    }


    public void setHomePage(String homePage) {
        HomePage = homePage;
    }
    
    public Set<Product> getProducts() {
        return products;
    }
    
}
