package model;

public class Student implements Comparable<Student> {
    private String id;
    private String full_name;
    private int gender;
    private String ngaySinh;
    private String address;
    private String phone;
    private String email;
    private double gpa;

    public Student() {
    }

    public Student(String id, String full_name, int gender, String ngaySinh, String address, String phone, String email, double gpa) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.ngaySinh = ngaySinh;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gpa = gpa ;
    }

    public Student(String full_name, int gender, String ngaySinh, String address, String phone, String email, double gpa) {
        this.full_name = full_name;
        this.gender = gender;
        this.ngaySinh = ngaySinh;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGqa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student[" +
                "id='" + id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender=" + gender +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gpa=" + gpa +
                ']';
    }

    @Override
    public int compareTo(Student o) {
        if (this.gpa > o.gpa) {
            return 1;
        } else if (this.gpa < o.gpa) {
            return -1;
        }
        return 0;
    }
}
