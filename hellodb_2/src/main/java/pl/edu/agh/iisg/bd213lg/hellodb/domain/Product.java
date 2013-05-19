package pl.edu.agh.iisg.bd213lg.hellodb.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    //@Column
    //private int SupplierID;
    
    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;
    
    @Column
    private int CategoryID;
    
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

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
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

}
