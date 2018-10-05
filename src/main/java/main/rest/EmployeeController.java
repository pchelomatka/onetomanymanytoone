package main.rest;

import main.Service.EmployeeService;
import main.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "getOneEmployee")
    public Employee getOneEmployee(Integer id) {
        return employeeService.getOneEmployee(id);
    }

    @RequestMapping(value = "saveEmployee")
    public Employee saveEmployee(@RequestParam String firstname, String lastname, Integer salary) {
        return employeeService.saveEmployee(firstname, lastname, salary);
    }

    @RequestMapping(value = "deleteEmployee")
    public void deleteEmployee(Integer id) {
        employeeService.deleteEmployee(id);
    }

}
