package pl.edu.agh.iisg.bd213lg.hellodb.domain2;

// Generated May 29, 2013 9:12:47 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderDetailsId generated by hbm2java
 */
@Embeddable
public class OrderDetailsId implements java.io.Serializable {

    private int orderId;
    private int productId;

    public OrderDetailsId() {
    }

    public OrderDetailsId(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    @Column(name = "OrderID", nullable = false)
    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "ProductID", nullable = false)
    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof OrderDetailsId))
            return false;
        OrderDetailsId castOther = (OrderDetailsId) other;

        return (this.getOrderId() == castOther.getOrderId())
                && (this.getProductId() == castOther.getProductId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getOrderId();
        result = 37 * result + this.getProductId();
        return result;
    }

}
