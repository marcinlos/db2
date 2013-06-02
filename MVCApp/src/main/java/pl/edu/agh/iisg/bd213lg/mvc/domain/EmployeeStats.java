package pl.edu.agh.iisg.bd213lg.mvc.domain;

import java.math.BigDecimal;

public class EmployeeStats {

    private String firstName;
    private String lastName;
    private String boss;
    private int orderCount;
    private float avgValue;
    private float maxValue;
    private String customer;

    public EmployeeStats() {
        // empty
    }

    public EmployeeStats(String firstName, String lastName, String boss,
            int orderCount, float avgValue, float maxValue, String customer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.boss = boss;
        this.orderCount = orderCount;
        this.avgValue = avgValue;
        this.maxValue = maxValue;
        this.customer = customer;
    }
    
    public EmployeeStats(String firstName, String lastName, String boss,
            long orderCount, BigDecimal avgValue, BigDecimal maxValue, 
            String customer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.boss = boss;
        this.orderCount = (int) orderCount;
        this.avgValue = avgValue.floatValue();
        this.maxValue = maxValue.floatValue();
        this.customer = customer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public float getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(float avgValue) {
        this.avgValue = avgValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    @Override
    public String toString() {
        String fmt = "%s (boss: %s), %d orders, avg: %.2f, max: %.2f (by %s)";
        return String.format(fmt, firstName, lastName, orderCount, avgValue,
                maxValue, customer);
    }

}
