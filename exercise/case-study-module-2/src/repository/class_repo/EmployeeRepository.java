package repository.class_repo;

import data.ReadAnhWriteFile;
import model.person.Employee;
import repository.interface_repo.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository extends Repository implements IEmployeeRepository {

    static ReadAnhWriteFile readAnhWriteFile = new ReadAnhWriteFile();

//    static List<Employee> employeeList = new ArrayList<>();
    static List<Employee> employeeList = new ArrayList<>();

    static {
        List<String> employeeArrList = readAnhWriteFile.readFile(readAnhWriteFile.EMPLOYEE_FILE);
        String[] line;
        for (String s : employeeArrList) {
            line = s.split(",");
            employeeList.add(new Employee(line[0], line[1], line[2], Boolean.parseBoolean(line[3]), line[4], line[5], line[6], Integer.parseInt(line[7]), Integer.parseInt(line[8]), Integer.parseInt(line[9])));
        }
//        employeeList.add(new Employee("NV-0000", "Bùi Hữu Hải", "31/08/96", true, "222222222", "0942409424", "hai@gmail.com", 1, 5, 1000));
//        employeeList.add(new Employee("NV-0001", "Nguyễn Hoàng Nguyên", "31/08/96", true, "222222222", "0942409424", "hai@gmail.com", 2, 4, 1000));
//        employeeList.add(new Employee("NV-0002", "Lê Công Hoàn Thiện", "31/08/96", true, "222222222", "0942409424", "hai@gmail.com", 3, 3, 1000));
//        String line;
//        for (Employee employee : employeeList) {
//            line = employee.getId() + "," +
//                    employee.getName() + "," +
//                    employee.getDateOfBirth() + "," +
//                    employee.isGender() + "," +
//                    employee.getIdentityId() + "," +
//                    employee.getTelephone() + "," +
//                    employee.getEmail() + "," +
//                    employee.getLevel() + "," +
//                    employee.getPosition() + "," +
//                    employee.getSalary();
//            readAnhWriteFile.writeFile(readAnhWriteFile.EMPLOYEE_FILE, line);
//        }
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
