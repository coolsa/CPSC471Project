package server.database;

import org.json.JSONObject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static java.nio.file.attribute.AclEntryPermission.DELETE;

public class MXMenu {

    private Connection con;
    private Scanner scan;

    //Constructor
    MXMenu(Connection con, Scanner scan) {
        this.con = con;
        this.scan = scan;
    }

    /**
     * Mechanical engineer portal to decide what to do
     * @param id ID of mechanical engineer
     */
    public void MXPortal(int id) {
        try {
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
                        CancelFlight(id);
                        break;
                    case 2:
                        ModifyFlight(id);
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

    /**
     * Allows mechanical engineers to cancel a flight
     */
    public void CancelFlight(int id){
        try {
            System.out.println("Please enter the flight ID");
            int fid = scan.nextInt();
            System.out.println("Please enter the aircraft ID");
            int aid = scan.nextInt();
            CallableStatement cs = con.prepareCall("CALL CancelMXFlight(?,?,?)");
            cs.setInt(1, fid);
            cs.setInt(2, aid);
            cs.setInt(3,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to cancel flight");
            System.out.println(e);
        }
    }

    /**
     * Allows mechanical engineers to modify the time of a flight
     */
    public void ModifyFlight(int id){
        try {
            System.out.println("Please enter the flight ID");
            int fid = scan.nextInt();
            System.out.println("Please enter the aircraft ID");
            int aid = scan.nextInt();
            System.out.println("Please enter the flight scheduled start time in DATETIME format");
            String start = scan.nextLine();
            System.out.println("Please enter the flight scheduled end time in DATETIME format");

            System.out.println("IMPLEMENT TIME CHECK FOR CONFLICTS!!!!!!!!!!");

            String end = scan.nextLine();
            CallableStatement cs = con.prepareCall("CALL ModifyMXFlight(?,?,?,?,?)");
            cs.setInt(1, fid);
            cs.setInt(2, aid);
            cs.setString(3,start);
            cs.setString(4,end);
            cs.setInt(5,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to cancel flight");
            System.out.println(e);
        }
    }
}


