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

    public String login(int id, String password){
        try {
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
                	return "STUDENT LOGGED IN";
                }
                else if(am.isInstructor(tempID)) {
                	return "INSTRUCTOR LOGGED IN";
                }
                
                else if(am.isMX(tempID)) {
                	return "MECHANICAL ENGINEER LOGGED IN";
                }
                
                else if(am.isAdmin(tempID)) {
                	return "ADMIN LOGGED IN";
                }
                return "Login failed";
            }else{
                return "Login failed";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Login Failed";
        }
    }
   
}
