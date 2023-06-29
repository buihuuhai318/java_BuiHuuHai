package test;

import java.util.HashMap;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        HashMap<Employee, String> hashMap = new HashMap<Employee, String>();
        hashMap.put(new Employee("a"), "employee1");
        hashMap.put(new Employee("b"), "employee2");
        hashMap.put(new Employee("a"), "employee1 overridden");

        System.out.print(hashMap.size());
    }
}


