package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){
        //Create an employee
        Employee employee = new Employee();
        employee.setName("Simeon Kakpovi");
        employee.setSsn("555-55-5555");

        //Create a laptop
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("XPS 15");

        //add laptop to employee
        employee.setLaptop(laptop);


        //Save employee to db
        employeeRepository.save(employee);

        //push to view
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

}
