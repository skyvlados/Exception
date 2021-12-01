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
        if (size >= employees.length) {
            throw new EmployeeController.BadParamsException500();
        }
        Employee newEmployees=new Employee(firstName,lastName);
        employees[size++]=newEmployees;
        return "Сотрудник "+firstName+" "+lastName+" успешно создан.";
    }

    public String removeEmployees(String firstName,String lastName) {
        for (int i = 0; i < employees.length; i++) {
            try {
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
            }catch (NullPointerException exception){
                throw new EmployeeController.BadParamsException404();
            }
        }
        throw new EmployeeController.BadParamsException404();
    }

    public Object findEmployee(String firstName, String lastName) {
        try {
            for (int i = 0; i < employees.length; i++) {
                if (firstName.equals(employees[i].getFirstName()) && lastName.equals(employees[i].getLastName())) {
                    return employees[i];
                }
            }
        } catch (NullPointerException exception) {
            throw new EmployeeController.BadParamsException404();
        }
        throw new EmployeeController.BadParamsException404();
    }
}
