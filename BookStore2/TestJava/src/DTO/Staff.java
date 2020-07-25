/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author root
 */
public class Staff {
    private int staff_id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private String sex;
    private int role_id;
    private int state;

    public Staff() {
    }

    public Staff(int staff_id, String name, String email, String password, String phone_number, String sex, int role_id, int state) {
        this.staff_id = staff_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.sex = sex;
        this.role_id = role_id;
        this.state = state;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "Staff{" + "staff_id=" + staff_id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone_number=" + phone_number + ", sex=" + sex + '}';
    }


    
}
