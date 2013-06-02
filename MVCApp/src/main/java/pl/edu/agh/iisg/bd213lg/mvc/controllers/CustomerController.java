package pl.edu.agh.iisg.bd213lg.mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.edu.agh.iisg.bd213lg.mvc.dao.CustomerDAO;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerDAO customers;
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView customerList(HttpServletRequest request) {
        return new ModelAndView("customers", "customers", customers);
    }

}
