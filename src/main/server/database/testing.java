package main.server.database;

import java.sql.*;
//import com.mysql.cj.jdbc.*;
import java.net.HttpURLConnection;
import java.util.Scanner;

import org.json.*;


public class testing {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter UserID: ");
		int id = scan.nextInt();
		System.out.println("Please enter Password: ");
		String password = scan.next();

		Connection con = DriverManager.getConnection("jdbc:mysql://158.69.217.205:12345/Airport_Scheduling_Database", "user",
				"something_fun");

		Login login = new Login(con,scan);
		login.login(id,password);

		con.close();
		scan.close();

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
