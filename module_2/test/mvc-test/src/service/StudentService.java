package service;

import model.Student;
import repository.StudentRepo;

import static view.Main.input;

public class StudentService implements IStudentService {

    StudentRepo studentRepo = new StudentRepo();
    @Override
    public void addNew() {
        System.out.println("nhap ten hoc sinh");
        String name = input.nextLine();
        System.out.println("nhap gioi tinh (1 = nam, 2 = nu");
        int choiceGender = Integer.parseInt(input.nextLine());
        while (choiceGender != 1 && choiceGender != 2) {
            System.out.println("nhap gioi tinh (1 = nam, 2 = nu");
            choiceGender = Integer.parseInt(input.nextLine());
        }
        boolean gender;
        gender = choiceGender == 1;
        System.out.println("nhap ngay sinh");
        String date = input.nextLine();
        System.out.println("nhap ten lop");
        String clasName = input.nextLine();
        System.out.println("nhap diem");
        int point = Integer.parseInt(input.nextLine());
        Student student = new Student(name, gender, date, clasName, point);
        studentRepo.addNew(student);
    }

    @Override
    public void remove() {
        int index = searchId();
        if (index != -1) {
            studentRepo.remove(index);
        } else {
            System.out.println("k tim thay");
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < studentRepo.display().size(); i++) {
            System.out.println(studentRepo.display().get(i));
        }
    }

    @Override
    public int searchId() {
        System.out.println("nhap id ban");
        int id = Integer.parseInt(input.nextLine());
        return studentRepo.searchId(id);
    }
}
