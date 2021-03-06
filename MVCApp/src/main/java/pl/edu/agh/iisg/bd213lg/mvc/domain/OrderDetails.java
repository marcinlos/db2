package pl.edu.agh.iisg.bd213lg.mvc.domain;

// Generated May 26, 2013 7:30:04 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderDetails generated by hbm2java
 */
@Entity
@Table(name = "`Order Details`", catalog = "northwind")
public class OrderDetails implements java.io.Serializable {

    private static final long serialVersionUID = -928468204170317856L;
    
    private OrderDetailsId id;
    private Order order;
    private Product product;
    private BigDecimal unitPrice;
    private short quantity;
    private double discount;

    public OrderDetails() {
    }

    public OrderDetails(OrderDetailsId id, Order order, BigDecimal unitPrice,
            short quantity, double discount) {
        this.id = id;
        this.order = order;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(
            name = "orderId", 
            column = @Column(name = "OrderID", nullable = false)
        ),
        @AttributeOverride(
            name = "productId", 
            column = @Column(name = "ProductID", nullable = false)
        ) 
    })
    public OrderDetailsId getId() {
        return this.id;
    }

    public void setId(OrderDetailsId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID", nullable = false, insertable = false, updatable = false)
    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID", nullable = false, insertable = false, updatable = false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 4)
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Column(name = "Quantity", nullable = false)
    public short getQuantity() {
        return this.quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    @Column(name = "Discount", nullable = false, precision = 8, scale = 0)
    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}
