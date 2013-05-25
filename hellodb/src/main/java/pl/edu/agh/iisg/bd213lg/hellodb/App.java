package pl.edu.agh.iisg.bd213lg.hellodb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = 
                new ClassPathXmlApplicationContext("Spring-Module.xml")) {
            Operations obj = (Operations) context.getBean("operationsBean");
            
            if (obj.addCustomer()) System.out.println("Customer added");
            else System.out.println("Adding failed");
            //the remaining operations work the same
            
            //to delete and update you have to manually find ID
            //can you automate the process?
            
            obj.printUsers();
        }
    }
}
