package pl.edu.agh.iisg.bd213lg.mvc.domain;

// Generated May 26, 2013 7:30:04 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name = "Orders", catalog = "northwind")
public class Order implements java.io.Serializable {

    private static final long serialVersionUID = 8515868564575705220L;
    
    private Integer orderId;
    private Employee employee;
    private Customer customer;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private Integer shipVia;
    private BigDecimal freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
    private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>(0);

    public Order() {
    }

    public Order(Employee employees, Customer customer, Date orderDate,
            Date requiredDate, Date shippedDate, Integer shipVia,
            BigDecimal freight, String shipName, String shipAddress,
            String shipCity, String shipRegion, String shipPostalCode,
            String shipCountry, Set<OrderDetails> orderDetails) {
        this.employee = employees;
        this.customer = customer;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.shipVia = shipVia;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
        this.orderDetails = orderDetails;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "OrderID", unique = true, nullable = false)
    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employees) {
        this.employee = employees;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID")
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OrderDate", length = 19)
    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RequiredDate", length = 19)
    public Date getRequiredDate() {
        return this.requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ShippedDate", length = 19)
    public Date getShippedDate() {
        return this.shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Column(name = "ShipVia")
    public Integer getShipVia() {
        return this.shipVia;
    }

    public void setShipVia(Integer shipVia) {
        this.shipVia = shipVia;
    }

    @Column(name = "Freight", precision = 10, scale = 4)
    public BigDecimal getFreight() {
        return this.freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    @Column(name = "ShipName", length = 40)
    public String getShipName() {
        return this.shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    @Column(name = "ShipAddress", length = 60)
    public String getShipAddress() {
        return this.shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    @Column(name = "ShipCity", length = 15)
    public String getShipCity() {
        return this.shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    @Column(name = "ShipRegion", length = 15)
    public String getShipRegion() {
        return this.shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    @Column(name = "ShipPostalCode", length = 10)
    public String getShipPostalCode() {
        return this.shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    @Column(name = "ShipCountry", length = 15)
    public String getShipCountry() {
        return this.shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    public Set<OrderDetails> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
