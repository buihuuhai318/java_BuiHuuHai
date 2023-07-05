package repository.class_repo;

import utils.ReadAnhWriteFile;
import model.person.Employee;
import repository.interface_repo.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    static ReadAnhWriteFile readAnhWriteFile = new ReadAnhWriteFile();
    static List<Employee> employeeList = new ArrayList<>();

    static {
        List<String> employeeArrList = readAnhWriteFile.readFile(readAnhWriteFile.EMPLOYEE_FILE);
        String[] line;
        for (String s : employeeArrList) {
            line = s.split(",");
            employeeList.add(new Employee(line[0], line[1], line[2], Boolean.parseBoolean(line[3]), line[4], line[5], line[6], Integer.parseInt(line[7]), Integer.parseInt(line[8]), Integer.parseInt(line[9])));
        }
    }

    @Override
    public void addNew(Employee employee) {
        String line;
        line = employee.getId() + "," +
                employee.getName() + "," +
                employee.getDateOfBirth() + "," +
                employee.isGender() + "," +
                employee.getIdentityId() + "," +
                employee.getTelephone() + "," +
                employee.getEmail() + "," +
                employee.getLevel() + "," +
                employee.getPosition() + "," +
                employee.getSalary();
        employeeList.add(employee);
        readAnhWriteFile.writeFile(readAnhWriteFile.EMPLOYEE_FILE, line);
    }

    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit(int index, Employee employee) {
        employeeList.set(index, employee);
        updateFile();
    }

    @Override
    public void updateFile() {
        String line;
        List<String> list = new ArrayList<>();
        for (Employee employee : employeeList) {
            line = employee.getId() + "," +
                    employee.getName() + "," +
                    employee.getDateOfBirth() + "," +
                    employee.isGender() + "," +
                    employee.getIdentityId() + "," +
                    employee.getTelephone() + "," +
                    employee.getEmail() + "," +
                    employee.getLevel() + "," +
                    employee.getPosition() + "," +
                    employee.getSalary();
            list.add(line);
        }
        readAnhWriteFile.updateFile(readAnhWriteFile.EMPLOYEE_FILE, list);
    }

    @Override
    public int checkID(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Employee getElement(int index) {
        return employeeList.get(index);
    }
}
