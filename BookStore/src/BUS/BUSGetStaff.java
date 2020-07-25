/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConnectionUnit;
import DTO.Genre;
import DTO.Staff;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class BUSGetStaff {
    ConnectionUnit connect;

    public BUSGetStaff() {
        connect = DAO.DAO.getDAO();
    }

    public ArrayList<Staff> getStaff(String condition, String orderBy) throws Exception {
        ResultSet result = connect.Select("staff", condition+" AND state>=0 ", orderBy);
        ArrayList<Staff> staffList = new ArrayList<>();
        while (result.next()) {
            Staff staff = new Staff();
            staff.setStaff_id(result.getInt("staff_id"));
            staff.setName(result.getString("name"));
            staff.setEmail(result.getString("email"));
            staff.setPassword(result.getString("password"));
            staff.setPhone_number(result.getString("phone_number"));
            staff.setSex(result.getString("sex"));
            staff.setRole_id(result.getInt("role_id"));
            staff.setState(result.getInt("state"));
            staffList.add(staff);
        }
        return staffList;
    }

    public ArrayList<Staff> getStaff(String condition) throws Exception {
        return this.getStaff(condition, null);
    }

    public ArrayList<Staff> getStaff() throws Exception {
        return this.getStaff(null);
    }
    public ResultSet getTopStaffSelled(int top, String startDate, String endDate) throws Exception{
        String query = "SELECT staff.name as name, SUM(order_item.quantity) as quantity FROM book_order, order_item, staff WHERE book_order.order_id=order_item.order_id AND staff.staff_id=book_order.staff_id AND book_order.order_date BETWEEN '"+startDate+"' AND '"+endDate+"' GROUP BY staff.staff_id ORDER BY SUM(order_item.quantity) LIMIT 0,"+top;
        return this.connect.execute(query);
    }
    public void inserts(Staff staff) throws Exception{
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", staff.getName());
        map.put("email", staff.getEmail());
        map.put("password", staff.getPassword());
        map.put("phone_number", staff.getPhone_number());
        map.put("sex", staff.getSex());
        map.put("role_id", staff.getRole_id()+"");
        map.put("state", staff.getState() +"");
        this.connect.Insert("staff", map);
    }
    public void updates(Staff staff) throws Exception{
        HashMap<String, Object> map = new HashMap<>();
        map.put("staff_id", staff.getStaff_id());
        map.put("name", staff.getName());
        map.put("email", staff.getEmail());
        map.put("password", staff.getPassword());
        map.put("phone_number", staff.getPhone_number());
        map.put("sex", staff.getSex());
        map.put("role_id", staff.getRole_id()+"");
        map.put("state", staff.getState()+"");
        this.connect.Update("staff", map, "staff_id="+ staff.getStaff_id()+"");
    }
    public boolean checkStaff(Staff staff) throws Exception{
        ArrayList<Staff> staffList = this.getStaff("phone_number='"+staff.getPhone_number()+"'");
        
        if (staffList.isEmpty()) {
            System.out.print("Wrong phone number");
            JOptionPane.showMessageDialog(null, "Sai so dien thoai");
            return false;
        }
        if (!staff.getPassword().equals(staffList.get(0).getPassword())) {
            System.out.print("Wrong password");
            JOptionPane.showMessageDialog(null, "Sai mat khau");
            return false;
        }
        return true;
    }
    public boolean isUsePhoneNumber(String phoneNumber) throws Exception{
        ResultSet result = this.connect.Select("staff", "phone_number="+phoneNumber);
        result.last();
        int count = result.getRow();
        System.out.println("count phone number: " + count);
        if(count>0){
            return true;
        }
        return false;
    }
    public Staff getStaffByPhoneNumber(String phone_number) throws Exception{
        ArrayList<Staff> staffList = this.getStaff("phone_number='"+phone_number+"'");
        if(staffList.isEmpty()){
            return null;
        }
        return staffList.get(0);
    }
    public Staff getStaffById(int id) throws Exception{
        return this.getStaff("staff_id="+id).get(0);
    }
    public ArrayList<Staff> getStaffBySearchLikeIdName(String nameOrId) throws Exception{
        return this.getStaff(" staff_id LIKE '%"+nameOrId+"%' OR name LIKE '%"+nameOrId+"%' ");
    }
}
