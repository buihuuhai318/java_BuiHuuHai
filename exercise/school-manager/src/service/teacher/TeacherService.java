package service.teacher;

import model.Teacher;
import repository.teacher.TeacherRepository;

import static view.Main.input;

public class TeacherService implements ITeacherService {
    TeacherRepository teacherRepository = new TeacherRepository();

    @Override
    public void addNew() {
        input.nextLine();
        System.out.print("\nNhập tên của giáo viên: ");
        String name = input.nextLine();


        System.out.print("Nhập ngày sinh của giáo viên: ");
        String date = input.nextLine();

        boolean gender;
        int inputGender;
        do {
            System.out.print("Nhập giới tính của giáo viên (nam = 1 || nữ = 0): ");
            inputGender = Integer.parseInt(input.nextLine());
            gender = inputGender == 1;
        } while (inputGender != 1 && inputGender != 0);

        System.out.print("Nhập chuyên môn của giáo viên: ");
        String major = input.nextLine();

        teacherRepository.addNew(new Teacher(name, date, gender, major));
    }

    @Override
    public void remove(int id) {
        int findId = searchId(id);
        if (findId == -1) {
            System.out.println("\nKhông tìm thấy id: " + id);
        } else {
            teacherRepository.remove(findId);
        }
    }

    @Override
    public void display() {
        System.out.println("\n------------------------------------ Danh Sách Giảng Viên -------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (Teacher teacher : TeacherRepository.teachers) {
            System.out.println(teacher);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    @Override
    public int searchId(int id) {
        for (int i = 0; i < TeacherRepository.teachers.size(); i++) {
            if (id == TeacherRepository.teachers.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }
}
