package server.database;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static java.nio.file.attribute.AclEntryPermission.DELETE;

public class MXMenu {

    private Connection con;
    private Scanner scan;

    MXMenu(Connection con, Scanner scan) {
        this.con = con;
        this.scan = scan;
    }

    public void MXPortal(int id) {
        try {
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            boolean loop = true;
            while (loop) {
                System.out.println("\nWelcome to the mechanical engineer portal\n" +
                        "Menu Options:\n " +
                        "1 - Cancel Flight\n " +
                        "2 - Modify Flight\n " +
                        "3 - Exit\n" +
                        "Please enter your selection:");
                int caseID = scan.nextInt();
                switch (caseID) {
                    case 1:
                        try {
                            System.out.println("Please enter the flight ID");
                            int fid = scan.nextInt();
                            System.out.println("Please enter the aircraft ID");
                            int aid = scan.nextInt();
                            stmt.executeQuery("DELETE FROM Flight WHERE Flight_id = " + fid + " AND Aircraft_id = " + aid);
                            stmt.executeQuery("DELETE FROM Aircraft_Schedule WHERE Flight_id = " + fid + " AND Aircraft_id = " + aid);
                        }catch(Exception e){
                            System.out.println("Unable to cancel flight");
                            System.out.println(e);
                        }

                        break;
                    case 2:
                        System.out.println("idk how we should do modify tbh");
                    case 3:
                        loop = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Bye Admin");
    }
}
