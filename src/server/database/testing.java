package server.database;

import java.sql.*;
//import com.mysql.cj.jdbc.*;
import java.net.HttpURLConnection;
import java.util.Scanner;

import org.json.*;


public class testing {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter UserID: ");
		int id = scan.nextInt();
		System.out.println("Please enter Password: ");
		String password = scan.next();

		testing test = new testing();
		test.login(id,password,scan);

	}

	public void login(int id, String password, Scanner scan){
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
					adminPortal(tempID,con,scan);
				}
			}else{
				System.out.println("Login failed");
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void adminPortal(int id, Connection con, Scanner scan){
		try {
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			boolean loop = true;
			while(loop) {
				System.out.println("\nWelcome to the admin portal\n" +
						"Menu Options:\n " +
						"1 - View Users\n " +
						"2 - View Aircraft\n " +
						"3 - View Aircraft Schedule\n " +
						"4 - View Flight\n " +
						"5 - Exit\n" +
						"Please enter your selection:");
				int caseID = scan.nextInt();
				switch (caseID) {
					case 1:
						ResultSet allUsers = stmt.executeQuery("SELECT * FROM User");
						while (allUsers.next()) {
							JSONObject jsonobj = new JSONObject("{\"user_id\":" + allUsers.getInt(1) + ", \"user_first_name\":" +
									allUsers.getString(3) + ", \"user_last_name\":" + allUsers.getString(3) + "}");
							System.out.println(jsonobj); //send this to client
						}
						break;
					case 2:
						ResultSet allAircraft = stmt.executeQuery("SELECT * FROM Aircraft");
						while (allAircraft.next()) {
							JSONObject jsonobj = new JSONObject("{\"Aircraft_ID\":" + allAircraft.getInt(1) + ", \"Registration\":" +
									allAircraft.getString(2) + ", \"Type\":" + allAircraft.getString(3) + "}");
							System.out.println(jsonobj); //send this to client
						}
						break;
					case 3:
						System.out.println("beep boop case 3 stuff");
						break;
					case 4:
						System.out.println("beep boop case 4 stuff");
						break;
					case 5:
						loop = false;
						break;

				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		scan.close();
		System.out.println("Bye Admin");
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
			while (rs.next()) {
				JSONObject jsonobj = new JSONObject("{\"user_id\":" + rs.getInt(1) + ", \"user_first_name\":" + rs.getString(3)+", \"user_last_name\":" + rs.getString(4) +"}");
				System.out.println(jsonobj); //send this to client
			}
			stmt.executeUpdate("INSERT INTO `Airport_Scheduling_Database`.`User` (`UserID`, `Email`, `First_name`, `Last_name`, `Password`, `Phone_number`) VALUES ('0', 'aaaaaa', 'sdfasdf', 'fdsafdsa', 'fdsaasdf', '4324324234');");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	 */
}
