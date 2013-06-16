package pl.edu.agh.iisg.bd213lg.mvc.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pl.edu.agh.iisg.bd213lg.mvc.dao.EmployeeDAO;
import pl.edu.agh.iisg.bd213lg.mvc.dao.ProductDAO;
import pl.edu.agh.iisg.bd213lg.mvc.domain.EmployeeStats;
import pl.edu.agh.iisg.bd213lg.mvc.domain.ProductStats;

@Controller
@RequestMapping("/product")
public class ProductController {

    
    @Resource(name = "ProductDAOHQL")
    private ProductDAO products;
    
    @RequestMapping(value = "/best", method = RequestMethod.GET)
    @ResponseBody
    public String best() {
        List<ProductStats> best = products.getBestProducts();
        StringBuilder sb = new StringBuilder();
        for (ProductStats s: best) {
            sb.append(s).append("<br>");
        }
        return sb.toString();
    }
}
