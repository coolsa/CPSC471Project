package server.database;

import org.json.JSONObject;

import java.sql.*;
import java.util.Scanner;

public class Login {

    private Connection con;
    private Scanner scan;

    Login(Connection con, Scanner scan){
        this.con = con;
        this.scan = scan;
    }

    public void login(int id, String password){
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");

            //Calls the login function and returns the user
            //ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE UserID = " + id + " and Password = '" + password + "'");
            CallableStatement cs = con.prepareCall("CALL Login(?,?)");
            cs.setInt(1,id);
            cs.setString(2,password);
            ResultSet rs = cs.executeQuery();

            JSONObject jsonobj = new JSONObject("{\"user_id\":" + rs.getInt(1) + ", \"user_first_name\":" + rs.getString(3)+", \"user_last_name\":" + rs.getString(4) +"}");
            int tempID = rs.getInt(1);
            System.out.println(jsonobj); //send this to client

            if(tempID != -1) {
                //ResultSet studentFind = stmt.executeQuery("SELECT * FROM Student WHERE StudentID = " + tempID);
                //If user is a student, open the student menu
                try {
                    CallableStatement cs2 = con.prepareCall("CALL SelectStudent(?)");
                    cs2.setInt(1, tempID);
                    ResultSet studentFind = cs2.executeQuery();
                    if (studentFind != null){
                        System.out.println("User is a student");
                        StudentMenu st = new StudentMenu(con, scan);
                        st.StudentPortal(id);
                    }
                }catch(Exception e) {
                    System.out.println(e);
                    System.out.println("Finding student failed");
                }

                //ResultSet instructorFind = stmt.executeQuery("SELECT * FROM Instructor WHERE InstructorID = " + tempID);
                //If user is a instructor, open the instructor menu
                try {
                    CallableStatement cs3 = con.prepareCall("CALL SelectInstructor(?)");
                    cs3.setInt(1, tempID);
                    ResultSet instructorFind = cs3.executeQuery();
                    if (instructorFind != null){
                        System.out.println("User is a instructor");
                        InstructorMenu in = new InstructorMenu(con, scan);
                        in.InstructorPortal(id);
                    }
                }catch(Exception e) {
                    System.out.println(e);
                    System.out.println("Finding student instructor failed");
                }

                //ResultSet MXFind = stmt.executeQuery("SELECT * FROM MX_Engineer WHERE MX_EngineerID = " + tempID);
                //If user is a mechanical engineer, open the mx menu
                try {
                    CallableStatement cs4 = con.prepareCall("CALL SelectMX_Engineer(?)");
                    cs4.setInt(1, tempID);
                    ResultSet mxFind = cs4.executeQuery();
                    if (mxFind != null){
                        System.out.println("User is a mechanical engineer failed");
                        MXMenu mx = new MXMenu(con, scan);
                        mx.MXPortal(id);
                    }
                }catch(Exception e) {
                    System.out.println(e);
                    System.out.println("Finding student mechanical engineer");
                }

                //ResultSet adminFind = stmt.executeQuery("SELECT * FROM Admin WHERE AdminID = " + tempID);
                //If user is a admin, open the admin menu
                try {
                    CallableStatement cs5 = con.prepareCall("CALL SelectAdmin(?)");
                    cs5.setInt(1, tempID);
                    ResultSet adminFind = cs5.executeQuery();
                    if (adminFind != null){
                        System.out.println("User is a admin");
                        AdminMenu ad = new AdminMenu(con, scan);
                        ad.AdminPortal(id);
                    }
                }catch(Exception e) {
                    System.out.println(e);
                    System.out.println("Finding student admin failed");
                }
            }else{
                System.out.println("Login failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
