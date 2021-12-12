package pro.sky.Exception2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService=employeeService;
    }
    @GetMapping(path ="/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName,lastName);
    }

    @GetMapping(path ="/add")
    public String addEmployee(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName,lastName);
    }

    @GetMapping(path ="/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeService.removeEmployees(firstName,lastName);
    }

}
