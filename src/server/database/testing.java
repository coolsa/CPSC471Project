package server.database;

import java.sql.*;
import com.mysql.cj.jdbc.*;
import org.json.*;


public class testing {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://158.69.217.205:12345/testing", "user",
					"something_fun");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from test");
			while (rs.next()) {
				JSONObject jsonobj = new JSONObject("{\"test_name\":" + rs.getInt(1) + ", \"test_number\":" + rs.getString(2)+"}");
				System.out.println(jsonobj); //send this to client
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
