package pro.sky.Exception2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService=employeeService;
    }
    @GetMapping(path ="/employee/find{firstName}{lastName}")
    public Object findEmployee(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        if (firstName == "" && lastName == "") {
            throw new BadParamsException404();
        }
        return employeeService.findEmployee(firstName,lastName);
    }

    @GetMapping(path ="/employee/add{firstName}{lastName}")
    public String addEmployee(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        if (firstName == "" && lastName == "") {
            throw new BadParamsException500();
        }
        return employeeService.addEmployee(firstName,lastName);
    }

    @GetMapping(path ="/employee/remove{firstName}{lastName}")
    public String removeEmployee(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeService.removeEmployees(firstName,lastName);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class BadParamsException404 extends RuntimeException {
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static class BadParamsException500 extends RuntimeException {
    }

}
