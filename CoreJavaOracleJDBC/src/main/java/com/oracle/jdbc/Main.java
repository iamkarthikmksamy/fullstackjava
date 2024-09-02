package com.oracle.jdbc;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orclpdb", "hr", "hr");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from hr.employees");
        while (rs.next()) {
            int id = rs.getInt("employee_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            double salary = rs.getDouble("salary");
            System.out.println(id + " " + firstName + " " + lastName + " " + salary);
        }
        stmt.close();
        con.close();
    }
}