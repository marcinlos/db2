package pl.edu.agh.iisg.bd213lg.mvc.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.iisg.bd213lg.mvc.dao.generic.DAOImpl;
import pl.edu.agh.iisg.bd213lg.mvc.domain.Employee;
import pl.edu.agh.iisg.bd213lg.mvc.domain.EmployeeStats;

@Repository("EmployeeDAO")
@Scope("singleton")
public class EmployeeDAOImplHQL extends DAOImpl<Employee, Integer> implements
        EmployeeDAO {
    
    private String query = 
        "select new pl.edu.agh.iisg.bd213lg.mvc.domain.EmployeeStats(\n" +
        "    e.firstName as firstName,                               \n" +
        "    e.lastName as lastName,                                 \n" +
        "    concat(b.titleOfCourtesy, ' ', b.firstName, ' ',        \n" +
        "        b.lastName) as boss,                                \n" +
        "    count(distinct o) as orderCount,                        \n" +
        "    (                                                       \n" +
        "        select sum(odd.quantity * odd.unitPrice)            \n" +
        "        from e.orders as oo join oo.orderDetails as odd     \n" +
        "        where year(oo.orderDate) = :year                    \n" +
        "        and (                                               \n" +
        "            select sum(oddd.quantity)                       \n" +
        "            from oo.orderDetails oddd                       \n" +
        "        ) < :maxQuantity                                    \n" +
        "    ) / count(distinct o) as avgValue,                      \n" +
        "    (                                                       \n" +
        "    select sum(odd.quantity * odd.unitPrice)                \n" +
        "    from bestOrder.orderDetails odd                         \n" +
        "    ) as maxValue,                                          \n" +
        "    bestOrder.customer.CompanyName as customer)             \n" +
        "from Employee e                                             \n" +
        "join e.supervisor b                                         \n" +
        "join e.orders as o                                          \n" +
        "join o.orderDetails as od                                   \n" +
        "join e.orders as bestOrder                                  \n" +
        "where extract(year from o.orderDate) = :year                \n" +
        "and year(bestOrder.orderDate) = :year                       \n" +
        "and (                                                       \n" +
        "    select sum(odd.quantity)                                \n" +
        "    from o.orderDetails odd                                 \n" +
        ") < :maxQuantity                                            \n" +
        "and (                                                       \n" +
        "    select sum(odd.quantity)                                \n" +
        "    from bestOrder.orderDetails odd                         \n" +
        ") < :maxQuantity                                            \n" +
        "and (                                                       \n" +
        "    select sum(odd.quantity * odd.unitPrice)                \n" +
        "    from bestOrder.orderDetails odd                         \n" +
        ") >= all (                                                  \n" +
        "    select sum(odd.quantity * odd.unitPrice)                \n" +
        "    from e.orders oo join oo.orderDetails odd               \n" +
        "    where year(oo.orderDate) = :year                        \n" +
        "    and (                                                   \n" +
        "        select sum(odd.quantity)                            \n" +
        "        from oo.orderDetails oddd                           \n" +
        "    ) < :maxQuantity                                        \n" +
        "    group by oo                                             \n" +
        ")                                                           \n" +
        "group by e                                                  \n" +
        "order by avgValue desc                                      \n";


    public EmployeeDAOImplHQL() {
        super(Employee.class);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<EmployeeStats> getBestEmployees(int top, int year,
            int maxQuantity) {
        System.out.println("Best employees, object way");
        Session s = getSession();

        
        Query q = s.createQuery(query)
            .setInteger("year", year)
            .setInteger("maxQuantity", maxQuantity)
            .setMaxResults(top);
            //.setResultTransformer(new BestEmployeeHQLTransformer());
        return q.list();
    }

}
