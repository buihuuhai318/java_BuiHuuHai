package model.person;

import java.util.HashMap;
import java.util.Map;

public class Employee extends Person {
    private int level;
    private int position;
    private int salary;

    static Map<Integer, String> levelMap = new HashMap<>();
    static Map<Integer, String> positionMap = new HashMap<>();

    static {
        levelMap.put(1, "Trung cấp");
        levelMap.put(2, "Cao đẳng");
        levelMap.put(3, "Đại học");
        levelMap.put(4, "Sau đại học");
        positionMap.put(1, "lễ tân");
        positionMap.put(2, "phục vụ");
        positionMap.put(3, "chuyên viên");
        positionMap.put(4, "giám sát");
        positionMap.put(5, "quản lý");
        positionMap.put(6, "giám đốc");
    }

    public Employee() {
    }

    public Employee(String id, String name, String dateOfBirth, boolean gender, String identityId, String telephone, String email, int level, int position, int salary) {
        super(id, name, dateOfBirth, gender, identityId, telephone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String sex;
        if (gender) {
            sex = "nam";
        } else {
            sex = "nữ";
        }
        return String.format(
                "| %8s | %20s | %8s | %13s | %10s | %11s | %14s | %8s | %11s | %20s |",
                id, name, sex, identityId, dateOfBirth, telephone, positionMap.get(position), salary, levelMap.get(level), email);
    }
}
