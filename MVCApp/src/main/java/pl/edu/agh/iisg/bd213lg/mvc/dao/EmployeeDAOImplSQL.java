package pl.edu.agh.iisg.bd213lg.mvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Employee;
import pl.edu.agh.iisg.bd213lg.mvc.domain.EmployeeStats;

@Repository("EmployeeDAOSQL")
@Scope("singleton")
public class EmployeeDAOImplSQL extends DAOImpl<Employee, Integer> implements
        EmployeeDAO {
    
    String query = 
        "select                                                      " +
        "    e.firstName, e.lastName,                                " +
        "    concat(b.TitleOfCourtesy, ' ', b.FirstName,' ',         " +
        "           b.LastName) as boss,                             " +
        "    count(o.OrderID) as orderCount,                         " +
        "    avg(o.OrderVal) as avgValue,                            " +
        "    max(o.OrderVal) as `maxValue`,                          " +
        "    c.CompanyName as customer                               " +
        "from Employees as e                                         " +
        "join Employees as b on e.ReportsTo = b.EmployeeId           " +
        "join (                                                      " +
        "    select o.*, sum(od.UnitPrice * od.Quantity) as OrderVal " +
        "    from Orders as o                                        " +
        "    join `Order Details` as od on o.OrderID = od.OrderID    " +
        "    where extract(year from o.OrderDate) = :year            " +
        "    group by o.OrderID                                      " +
        "    having sum(od.Quantity) < :maxQuantity                  " +
        ") as o on o.EmployeeID = e.EmployeeID                       " +
        "join Customers as c on c.CustomerID = (                     " +
        "    select o.CustomerID                                     " +
        "    from Orders as o                                        " +
        "    join `Order Details` as od on o.OrderID = od.OrderID    " +
        "    where o.EmployeeID = e.EmployeeID and                   " +
        "          extract(year from o.OrderDate) = :year            " +
        "    group by o.OrderID                                      " +
        "    having sum(od.Quantity) < :maxQuantity                  " +
        "    order by sum(od.UnitPrice * od.Quantity) desc           " +
        "    limit 1                                                 " +
        ")                                                           " +
        "group by e.EmployeeID                                       " +
        "order by avg(o.OrderVal) desc                               " +
        "limit :results";
    

    public EmployeeDAOImplSQL() {
        super(Employee.class);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<EmployeeStats> getBestEmployees(int top, int year,
            int maxQuantity) {
        System.out.println("Best employees, object way");
        Session s = getSession();
        Query q = s.createSQLQuery(query)
            .addScalar("firstName")
            .addScalar("lastName")
            .addScalar("boss")
            .addScalar("orderCount", IntegerType.INSTANCE)
            .addScalar("avgValue", FloatType.INSTANCE)
            .addScalar("maxValue", FloatType.INSTANCE)
            .addScalar("customer")
            .setInteger("results", top)
            .setInteger("year", year)
            .setInteger("maxQuantity", maxQuantity)
            .setResultTransformer(Transformers.aliasToBean(EmployeeStats.class))
            ;
        return q.list();
    }

}
