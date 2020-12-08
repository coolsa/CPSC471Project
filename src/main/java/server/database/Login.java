package server.database;

import org.json.JSONObject;
import org.openapitools.model.Student;
import org.openapitools.model.User;

import java.sql.*;
import java.util.Scanner;

public class Login {

    private Connection con;

    public Login(Connection con){
        this.con = con;
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
            rs.next();
            
            User user = new User();
            user.setId((long)rs.getInt(1));
            user.setEmail(rs.getString(2));
            user.setFirstName(rs.getString(3));
            user.setLastName(rs.getString(4));
            user.setPassword(rs.getString(5));
            user.setPhone(rs.getString(6));
            
            int tempID = rs.getInt(1);

            if(tempID != -1) {
                AdminMenu am = new AdminMenu(con);
                if(am.isStudent(tempID)) {
                	System.out.println("STUDENT LOGGED IN");
                }
                
                if(am.isInstructor(tempID)) {
                	System.out.println("INSTRUCTOR LOGGED IN");
                }
                
                if(am.isMX(tempID)) {
                	System.out.println("MECHANICAL ENGINEER LOGGED IN");
                }
                
                if(am.isAdmin(tempID)) {
                	System.out.println("ADMIN LOGGED IN");
                }
            }else{
                System.out.println("Login failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
}
