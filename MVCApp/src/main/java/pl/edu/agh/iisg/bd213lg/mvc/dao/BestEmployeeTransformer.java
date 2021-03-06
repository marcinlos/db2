package pl.edu.agh.iisg.bd213lg.mvc.dao;

import java.util.List;

import org.hibernate.transform.ResultTransformer;

import pl.edu.agh.iisg.bd213lg.mvc.domain.EmployeeStats;

class BestEmployeeTransformer implements ResultTransformer {

    private static final long serialVersionUID = 1392019395114687777L;

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        String firstName = (String) tuple[0];
        String lastName = (String) tuple[1];
        String boss = (String) tuple[2];
        int orderCount = (int) tuple[3];
        float avgValue = (float) tuple[4];
        float maxValue = (float) tuple[5]; 
        String customer = (String) tuple[6];
        return new EmployeeStats(firstName, lastName, boss, orderCount, 
                avgValue, maxValue, customer);
    }

    @Override
    public List transformList(List collection) {
        return collection;
    }
    
}