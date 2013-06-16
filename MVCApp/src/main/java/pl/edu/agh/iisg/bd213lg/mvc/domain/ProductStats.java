package pl.edu.agh.iisg.bd213lg.mvc.domain;

import java.math.BigDecimal;

public class ProductStats {

    private String productName;
    private int total;
    
    public ProductStats() {
        // TODO Auto-generated constructor stub
    }
    
    
    public ProductStats(String productName, BigDecimal total) {
        this.productName = productName;
        this.total = total.intValue();
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public int getTotal() {
        return total;
    }


    public void setTotal(BigDecimal total) {
        this.total = total.intValue();
    }
    
    @Override
    public String toString() {
        return String.format("%s %d", productName, total);
    }
    
    
}
