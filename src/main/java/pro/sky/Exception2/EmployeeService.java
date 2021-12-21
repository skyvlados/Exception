package pro.sky.Exception2;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final Employee[] employees;
    private int size;

    public EmployeeService() {
        this.employees=new Employee[2];
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (firstName == "" && lastName == "") {
            throw new EmployeeStorageOverflowException();
        }else {
        if (size >= employees.length) {
            throw new EmployeeStorageOverflowException();
        }
        Employee newEmployees=new Employee(firstName,lastName);
        employees[size++]=newEmployees;
        return newEmployees;
        }
    }

    public Employee removeEmployees(String firstName, String lastName){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (firstName.equals(employees[i].getFirstName()) && lastName.equals(employees[i].getLastName())) {
                Employee employee = employees[i];
                if (i != employees.length - 1) {
                    System.arraycopy(employees, i + 1, employees, i, size - i);
                }
                size--;
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

        public Employee findEmployee(String firstName, String lastName){
            if (firstName == "" && lastName == ""){
                throw new EmployeeNotFoundException();
            }
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    continue;
                }
                if (firstName.equals(employees[i].getFirstName()) && lastName.equals(employees[i].getLastName())) {
                    return employees[i];
                }
            }
        throw new EmployeeNotFoundException();
    }
}
