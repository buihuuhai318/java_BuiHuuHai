package ss5;

public class Employee {
    private static String companyName = "ABC";
    private String name;
    private String position;
    private String ctyName;

    public Employee() {
        this.ctyName = companyName;
    }

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        this.ctyName = companyName;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCtyName() {
        return ctyName;
    }

    public void setCtyName(String ctyName) {
        this.ctyName = ctyName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", ctyName='" + ctyName + '\'' +
                '}';
    }
}
