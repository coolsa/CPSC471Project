package server.database;

import java.sql.*;
//import com.mysql.cj.jdbc.*;
import java.net.HttpURLConnection;
import org.json.*;


public class testing {
	public static void main(String[] args){

		testing test = new testing();
		System.out.println("\nCorrect login for User 3");
		test.login(3,"p3");
		System.out.println("\nIncorrect login for User 3");
		test.login(3,"p4");
		System.out.println("\nCorrect login for User 6");
		test.login(6,"p6");

	}

	public void login(int id, String password){
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://158.69.217.205:12345/Airport_Scheduling_Database", "user",
					"something_fun");
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
				}
			}else{
				System.out.println("Login failed");
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}


	//CLOUD OLD TEST MAIN
	/*
	public static void main(String[] args) {
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://158.69.217.205:12345/Airport_Scheduling_Database", "user",
					"something_fun");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User;");
			int id = 0;
			while (rs.next()) {
				JSONObject jsonobj = new JSONObject("{\"user_id\":" + rs.getInt(1) + ", \"user_first_name\":" + rs.getString(3)+", \"user_last_name\":" + rs.getString(3) +"}");
				System.out.println(jsonobj); //send this to client
				id = jsonobj.getInt("user_id");
			}
			stmt.executeUpdate("INSERT INTO `Airport_Scheduling_Database`.`User` (`UserID`, `Email`, `First_name`, `Last_name`, `Password`, `Phone_number`) VALUES ('"+(id+1)+"', 'aaaaaa', 'sdfasdf', 'fdsafdsa', 'fdsaasdf', '4324324234');");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	 */
}
