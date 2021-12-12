package pro.sky.Exception2;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final Employee[] employees;
    private int size;

    public EmployeeService() {
        this.employees=new Employee[2];
    }

    public String addEmployee(String firstName, String lastName) {
        if (firstName == "" && lastName == "") {
            throw new EmployeeStorageOverflowException();
        }else {
        if (size >= employees.length) {
            throw new EmployeeStorageOverflowException();
        }
        Employee newEmployees=new Employee(firstName,lastName);
        employees[size++]=newEmployees;
        return "Сотрудник "+firstName+" "+lastName+" успешно создан.";
        }
    }

    public String removeEmployees(String firstName,String lastName){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (firstName.equals(employees[i].getFirstName()) && lastName.equals(employees[i].getLastName())) {
                String saveFirstName=employees[i].getFirstName();
                String saveLastName=employees[i].getLastName();
                employees[i] = null;
                if (i != employees.length - 1) {
                    System.arraycopy(employees, i + 1, employees, i, size - i);
                }
                size--;
                return "Сотрудник " + saveFirstName + " " + saveLastName + " удален";
            }
        }
        throw new EmployeeNotFoundException();
    }

        public Employee findEmployee(String firstName, String lastName){
            if (firstName == "" && lastName == ""){
                throw new EmployeeNotFoundException();
            }else {
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i] == null) {
                        break;
                    }
                    if (firstName.equals(employees[i].getFirstName()) && lastName.equals(employees[i].getLastName())) {
                        return employees[i];
                    }
                }
            }
        throw new EmployeeNotFoundException();
    }
}
