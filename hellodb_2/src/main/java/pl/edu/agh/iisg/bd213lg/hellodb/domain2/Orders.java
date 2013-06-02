package pl.edu.agh.iisg.bd213lg.hellodb.domain2;

// Generated May 29, 2013 9:12:47 AM by Hibernate Tools 4.0.0

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
public class Orders implements java.io.Serializable {

    private Integer orderId;
    private Employees employees;
    private String customerId;
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
    private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

    public Orders() {
    }

    public Orders(Employees employees, String customerId, Date orderDate,
            Date requiredDate, Date shippedDate, Integer shipVia,
            BigDecimal freight, String shipName, String shipAddress,
            String shipCity, String shipRegion, String shipPostalCode,
            String shipCountry, Set<OrderDetails> orderDetailses) {
        this.employees = employees;
        this.customerId = customerId;
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
        this.orderDetailses = orderDetailses;
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
    public Employees getEmployees() {
        return this.employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    @Column(name = "CustomerID", length = 5)
    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    public Set<OrderDetails> getOrderDetailses() {
        return this.orderDetailses;
    }

    public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
        this.orderDetailses = orderDetailses;
    }

}