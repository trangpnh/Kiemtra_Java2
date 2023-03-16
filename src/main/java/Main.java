import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

;

public class Main {
    private static StudentDAO studentDAO = new StudentDAO();
    private static void mainMenu() {
        System.out.println("--- QUẢN LÝ THÔNG TIN NHÂN VIÊN ---");
        System.out.println("1. Danh sách sinh viên theo bảng");
        System.out.println("2. Nhập một sinh viên mới");
        System.out.println("3. Xóa sinh viên theo mã");
        System.out.println("4. Câp nhật thông tin sinh viên");
        System.out.println("5. Tìm một sinh viên theo họ tên hoặc mã");
        System.out.println("6. Sắp xếp sinh viên theo điểm GPA tăng dần");
        System.out.println("7. In ra tất cả sinh viên nữ ở Hà Nội có GPA trên 2.5");
        System.out.println("8. Sắp xếp sinh viên theo họ tên, sắp xếp theo bảng chữ cái abc");
    }
    private static void option1() {
        List<Student> studentList = studentDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Student p = studentList.get(i);
            System.out.printf("%-20s %-20s %-20d %-20s\n", p.getId(), p.getFull_name(), p.getGender(), p.getAddress());
        }
    }
    private static void option2(Scanner in){
        Student s = new Student();
        System.out.print("\tNhập id: ");
        s.setId(in.nextLine());
        System.out.print("\tNhập họ tên: ");
        s.setFull_name(in.nextLine());
        System.out.print("\tNhập giới tính: ");
        s.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập ngày sinh: ");
        s.setNgaySinh(in.nextLine());
        System.out.println("\tNhập địa chỉ: ");
        s.setAddress(in.nextLine());
        System.out.println("\tNhập số điện thoại: ");
        s.setPhone(in.nextLine());
        System.out.println("\tNhập email: ");
        s.setEmail(in.nextLine());
        System.out.println("\tNhập điểm GPA: ");
        s.setGqa(Double.parseDouble(in.nextLine()));
        studentDAO.insert(s);
        System.out.println("Thêm thành công");
    }
    private static void option3(Scanner in) {
        System.out.print("\tNhập id sinh viên cần xóa:");
        String id = in.nextLine();
        Student tmp = StudentDAO.getById(id);
        if (tmp == null) {
            System.out.println("Không tồn tại sinh viên này");
            return;
        }
        studentDAO.delete(id);
        System.out.println("Xóa thành công");
    }
    private static void option4(Scanner in) {
        System.out.print("\tNhập id cần cập nhật:");
        String id = in.nextLine();
        Student tmp = StudentDAO.getById(id);
        if (tmp == null) {
            System.out.println("Không tồn tại sinh viên này");
            return ;
        }
        Student s = new Student();
        System.out.print("\tNhập id: ");
        s.setId(in.nextLine());
        System.out.print("\tNhập họ tên: ");
        s.setFull_name(in.nextLine());
        System.out.print("\tNhập giới tính: ");
        s.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập ngày sinh: ");
        s.setNgaySinh(in.nextLine());
        System.out.println("\tNhập địa chỉ: ");
        s.setAddress(in.nextLine());
        System.out.println("\tNhập số điện thoại: ");
        s.setPhone(in.nextLine());
        System.out.println("\tNhập email: ");
        s.setEmail(in.nextLine());
        System.out.println("\tNhập điểm GPA: ");
        s.setGqa(Double.parseDouble(in.nextLine()));
        studentDAO.update(s, id);
        System.out.println("Cập nhật thành công!");
    }
    private static void option5(Scanner in) {
        List<Student> studentList = studentDAO.getAll();
        System.out.print("\tNhập id cần tìm:");
        String id = in.nextLine();
        Student tmp = StudentDAO.getById(id);
        if (tmp == null) {
            System.out.println("Không tồn tại sinh viên này");
            return ;
        }
        System.out.printf("%-20s %-20s %-20d %-20s %-20s %-20s %-20s %-20f","Mã sinh viên", "Họ tên", "Giới tính","Ngày Sinh", "Địa chỉ","Số điện thoại", "Email", "GPA");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Student p = studentList.get(i);
            System.out.printf("%-20s %-20s %-20d %-20s %-20s %-20s %-20s %-20f\n", p.getId(), p.getFull_name(), p.getGender(),p.getNgaySinh(), p.getAddress(),p.getPhone(),p.getEmail(),p.getGpa());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(in.nextLine());
            if (option < 1 || option > 8) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(in);
                    break;
                case 3:
                    option3(in);
                    break;
                case 4:
                    option4(in);
                    break;
                case 5:option5(in);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }

        }
        while (option != 0);
        in.close();
    }
}
