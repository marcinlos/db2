package pl.edu.agh.iisg.bd213lg.mvc.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int ProductID;
    
    @Column(length = 40, nullable = false)
    private String ProductName;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>(0);
    
    //@Column
    //private int SupplierID;
    
    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;
    
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;
    
    @Column(length = 20)
    private String QuantityPerUnit;
    
    @Column(precision=10, scale=4)
    private BigDecimal UnitPrice = BigDecimal.ZERO;
    
    @Column
    private short UnitsInStock = 0;
    
    @Column
    private short UnitsOnOrder = 0;
    
    @Column
    private short ReorderLevel = 0;
    
    @Column(columnDefinition ="BIT", nullable = false)
    private boolean Discontinued = false;

    public int getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    /*
    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int supplierID) {
        SupplierID = supplierID;
    }
    */
    
    public Supplier getSupplier() {
        return supplier;
    }
    
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        QuantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        UnitPrice = unitPrice;
    }

    public short getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(short unitsInStock) {
        UnitsInStock = unitsInStock;
    }

    public short getUnitsOnOrder() {
        return UnitsOnOrder;
    }

    public void setUnitsOnOrder(short unitsOnOrder) {
        UnitsOnOrder = unitsOnOrder;
    }

    public short getReorderLevel() {
        return ReorderLevel;
    }

    public void setReorderLevel(short reorderLevel) {
        ReorderLevel = reorderLevel;
    }

    public boolean isDiscontinued() {
        return Discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        Discontinued = discontinued;
    }
    
    public Set<OrderDetails> getOrderDetails() {
        return this.orderDetails;
    }

}
