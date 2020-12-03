package server.database;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AdminMenu {

    private Connection con;
    private Scanner scan;

    AdminMenu(Connection con, Scanner scan){
        this.con = con;
        this.scan = scan;
    }

    public void adminPortal(int id){
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
        System.out.println("Bye Admin");
    }
}
