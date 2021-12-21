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
    public Employee findEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        return employeeService.findEmployee(firstName,lastName);
    }

    @GetMapping(path ="/add")
    public String addEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return "Сотрудник "+firstName+" "+lastName+" успешно создан.";
    }

    @GetMapping(path ="/remove")
    public String removeEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        employeeService.removeEmployees(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " удален";
    }

}
