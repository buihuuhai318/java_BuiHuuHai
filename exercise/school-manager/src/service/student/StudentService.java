package service.student;

import model.Student;
import repository.student.StudentRepository;

import static view.Main.input;

public class StudentService implements IStudentService {
    StudentRepository studentRepository = new StudentRepository();
    @Override
    public void addNew() {
        System.out.print("\nNhập tên của học sinh: ");
        String name = input.nextLine();


        System.out.print("Nhập ngày sinh của học sinh: ");
        String date = input.nextLine();

        boolean gender;
        int inputGender;
        do {
            System.out.print("Nhập giới tính của học sinh (nam = 1 || nữ = 0): ");
            inputGender = Integer.parseInt(input.nextLine());
            gender = inputGender == 1;
        } while (inputGender != 1 && inputGender != 0);

        System.out.print("Nhập lớp của học sinh: ");
        String room = input.nextLine();
        System.out.print("Nhập điểm của học sinh: ");
        double score = Double.parseDouble(input.nextLine());

        studentRepository.addNew(new Student(name, date, gender, room, score));
    }

    @Override
    public void remove(int id) {
        int findId = searchId(id);
        if (findId == -1) {
            System.out.println("\nKhông tìm thấy id: " + id);
        } else {
            studentRepository.remove(findId);
        }
    }

    @Override
    public void display() {
        System.out.println("\n---------------------------------------- Danh Sách Học Viên ------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------------");
        for (Student student : StudentRepository.students) {
            System.out.println(student);
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
    }

    @Override
    public int searchId(int id) {
        for (int i = 0; i < StudentRepository.students.size(); i++) {
            if (id == StudentRepository.students.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }
}
