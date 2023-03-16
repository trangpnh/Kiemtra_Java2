package dao;

import connection.MyConnection;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setNgaySinh(rs.getString("ngaySinh"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGqa(rs.getDouble("gpa"));
                studentList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public void insert(Student s) {
        String sql = String.format("INSERT INTO students VALUES ('%s','%s','%d','%s','%s','%s','%s','%f')",
                s.getId(), s.getFull_name(), s.getGender(), s.getNgaySinh(), s.getAddress(), s.getPhone(), s.getEmail(),s.getGpa()
        );

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            int rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Thêm thất bại!");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Student getById(String id) {
        final String sql = "SELECT * FROM `students` WHERE  `id` = '" + id + "'";
        Student s = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                s = new Student();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setNgaySinh(rs.getString("ngaySinh"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGqa(rs.getDouble("gpa"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public void update(Student student, String id) {
        Student tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Sinh viên không tồn tại!");
        }

        final String sql = String.format("UPDATE `students` SET `id`='%s',`full_name`='%s',`gender`='%d',`ngaySinh`='%s',`address`='%s',`phone` = '%s',`email` = '%s',`gpa` = '%f' WHERE `id` = '%s'",
                student.getId(), student.getFull_name(), student.getGender(), student.getNgaySinh(), student.getAddress(), student.getPhone(), student.getEmail(),
                student.getGpa(), id
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void delete(String id) {
        Student student = getById(id);
        if (student == null) {
            throw new RuntimeException("Sinh viên không tồn tại!");
        }

        final String sql = "DELETE FROM `students` WHERE  `id` = '" + id + "'";
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
