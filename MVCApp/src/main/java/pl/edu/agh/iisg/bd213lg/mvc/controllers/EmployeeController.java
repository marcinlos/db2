package pl.edu.agh.iisg.bd213lg.mvc.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.edu.agh.iisg.bd213lg.mvc.dao.EmployeeDAO;
import pl.edu.agh.iisg.bd213lg.mvc.domain.EmployeeStats;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Resource(name = "EmployeeDAO")
    private EmployeeDAO employees;

    @RequestMapping(value = "/best", method = RequestMethod.GET)
    public ModelAndView bestEmployees(
            @RequestParam("top") int top,
            @RequestParam("year") int year,
            @RequestParam("quantity") int quantity) {
        List<EmployeeStats> stats = employees.getBestEmployees(top, year,
                quantity);
        return new ModelAndView("best", "employees", stats);
    }
}
