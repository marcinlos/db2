package pl.edu.agh.iisg.bd213lg.hellodb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = 
                new ClassPathXmlApplicationContext("Spring-Module.xml")) {
            ConfigurableApplicationContext ctx = 
                    new ClassPathXmlApplicationContext("Spring-Module.xml");
            HelloDatabase obj = (HelloDatabase) ctx.getBean("helloBean");
//            obj.printCustomers();
//            obj.printCategories();
//            obj.printShippers();
//            obj.printProducts();
//            obj.printSuppliers();
        }
    }
}
