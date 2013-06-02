package pl.edu.agh.iisg.bd213lg.mvc.dao;

import java.util.List;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAO;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Employee;
import pl.edu.agh.iisg.bd213lg.mvc.domain.EmployeeStats;

public interface EmployeeDAO extends DAO<Employee, Integer> {
    
    List<EmployeeStats> getBestEmployees(int top, int year, int maxQuantity);  
    
}
