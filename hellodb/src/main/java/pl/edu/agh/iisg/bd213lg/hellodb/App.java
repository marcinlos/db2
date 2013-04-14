package pl.edu.agh.iisg.bd213lg.hellodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = 
                new ClassPathXmlApplicationContext("Spring-Module.xml")) {
            HelloDatabase obj = (HelloDatabase) context.getBean("helloBean");
            obj.sayHello();
        }
    }
}
