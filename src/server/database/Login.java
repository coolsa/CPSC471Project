package server.database;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE UserID = " + id + " and Password = '" + password + "'");
            int tempID = -1;
            while (rs.next()) {
                JSONObject jsonobj = new JSONObject("{\"user_id\":" + rs.getInt(1) + ", \"user_first_name\":" + rs.getString(3)+", \"user_last_name\":" + rs.getString(4) +"}");
                tempID = rs.getInt(1);
                System.out.println(jsonobj); //send this to client
            }

            if(tempID != -1){
                ResultSet studentFind = stmt.executeQuery("SELECT * FROM Student WHERE StudentID = " + tempID);
                while(studentFind.next()){
                    System.out.println("User is a student");
                }

                ResultSet instructorFind = stmt.executeQuery("SELECT * FROM Instructor WHERE InstructorID = " + tempID);
                while(instructorFind.next()){
                    System.out.println("User is a instructor");
                }

                ResultSet MXFind = stmt.executeQuery("SELECT * FROM MX_Engineer WHERE MX_EngineerID = " + tempID);
                while(MXFind.next()){
                    System.out.println("User is a mechanical enginner");
                }

                ResultSet adminFind = stmt.executeQuery("SELECT * FROM Admin WHERE AdminID = " + tempID);
                while(adminFind.next()){
                    System.out.println("User is a admin");
                    AdminMenu admin = new AdminMenu(con,scan);
                    admin.adminPortal(tempID);
                }
            }else{
                System.out.println("Login failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
