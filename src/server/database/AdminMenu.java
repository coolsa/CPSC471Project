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
                        "1 - Manage Users\n " +
                        "2 - Manage Aircraft\n " +
                        "3 - Manage Flight\n " +
                        "4 - Assign Instructors\n " +
                        "5 - Exit\n" +
                        "Please enter your selection:");
                int caseID = scan.nextInt();
                switch (caseID) {
                    case 1:
                        manageUser(id);
                        break;
                    case 2:
                        manageAircraft(id);
                        break;
                    case 3:
                        manageFlight(id);
                        break;
                    case 4:
                        try {
                            System.out.println("Please enter the student ID");
                            int sid = scan.nextInt();
                            System.out.println("Please enter the instructor ID");
                            int iid = scan.nextInt();
                            stmt.executeUpdate("INSERT INTO Teaches(Student_id, Instructor_id) " + "VALUES (" + sid + ", " + iid + ")" );
                        }catch(Exception e){
                            System.out.println("Unable to assign instructor to student");
                            System.out.println(e);
                        }

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

    public void manageUser(int id){
        try {
            Statement stmt = con.createStatement();
            System.out.println("\nManage Users:\n" +
                    "Menu Options:\n " +
                    "1 - Add Users\n " +
                    "2 - Remove Users\n " +
                    "3 - Edit User\n " +
                    "4 - View All Users\n " +
                    "Please enter your selection:");
            int caseID = scan.nextInt();
            switch (caseID) {
                case 1:
                    addUser(id);
                    break;
                case 2:
                    removeUser(id);
                    break;
                case 3:
                    System.out.println("Idk how we wanna edit users");
                    break;
                case 4:
                    ResultSet allUsers = stmt.executeQuery("SELECT * FROM User");
                    while (allUsers.next()) {
                        JSONObject jsonobj = new JSONObject("{\"user_id\":" + allUsers.getInt(1) + ", \"user_first_name\":" +
                                allUsers.getString(3) + ", \"user_last_name\":" + allUsers.getString(3) + "}");
                        System.out.println(jsonobj); //send this to client
                    }
                    break;
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }


    public void addUser(int id) {
        try {
            Statement stmt = con.createStatement();
            System.out.println("\nAdd Users:\n" +
                    "Menu Options:\n " +
                    "1 - Add Student\n " +
                    "2 - Add Instructor\n " +
                    "3 - Add Mechanical Engineer\n " +
                    "4 - Add Admin\n " +
                    "Please enter your selection:");
            int caseID = scan.nextInt();
            switch (caseID) {
                case 1:
                    try {
                        scan.nextLine();
                        System.out.println("Please enter the student email");
                        String email = scan.nextLine();
                        System.out.println("Please enter the student first name");
                        String fname = scan.nextLine();
                        System.out.println("Please enter the student lname");
                        String lname = scan.nextLine();
                        System.out.println("Please enter the student password");
                        String password = scan.nextLine();
                        System.out.println("Please enter the student phone");
                        String phone = scan.nextLine();
                        stmt.executeUpdate("INSERT INTO User(UserID, Email, First_name, Last_name, Password, Phone_number) "
                                + "VALUES (NULL, " + email + ", " + fname + ", " + lname + ", " + password + ", " + phone + ")" );
                        System.out.println("Please enter the student Pilot License Class");
                        String license = scan.nextLine();
                        stmt.executeUpdate("INSERT INTO Student(StudentID,Pilot_license_no) "
                                + "VALUES (LAST_INSERT_ID(), " + license + ")" );
                    }catch(Exception e){
                        System.out.println("Unable to add new Student");
                        System.out.println(e);
                    }
                    break;
                case 2:
                    removeUser(id);
                    break;
                case 3:
                    System.out.println("Idk how we wanna edit users");
                    break;
                case 4:
                    ResultSet allUsers = stmt.executeQuery("SELECT * FROM User");
                    while (allUsers.next()) {
                        JSONObject jsonobj = new JSONObject("{\"user_id\":" + allUsers.getInt(1) + ", \"user_first_name\":" +
                                allUsers.getString(3) + ", \"user_last_name\":" + allUsers.getString(3) + "}");
                        System.out.println(jsonobj); //send this to client
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeUser(int id){
        try {
            Statement stmt = con.createStatement();
            System.out.println("\nRemove Users:\n" +
                    "Menu Options:\n " +
                    "1 - Remove Student\n " +
                    "2 - Remove Instructor\n " +
                    "3 - Remove Mechanical Engineer\n " +
                    "4 - Remove Admin\n " +
                    "Please enter your selection:");
            int caseID = scan.nextInt();
            switch (caseID) {
                case 1:
                    addUser(id);
                    break;
                case 2:
                    removeUser(id);
                    break;
                case 3:
                    System.out.println("Idk how we wanna edit users");
                    break;
                case 4:
                    ResultSet allUsers = stmt.executeQuery("SELECT * FROM User");
                    while (allUsers.next()) {
                        JSONObject jsonobj = new JSONObject("{\"user_id\":" + allUsers.getInt(1) + ", \"user_first_name\":" +
                                allUsers.getString(3) + ", \"user_last_name\":" + allUsers.getString(3) + "}");
                        System.out.println(jsonobj); //send this to client
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void manageAircraft(int id){
        try {
            Statement stmt = con.createStatement();
            System.out.println("\nManage Aircraft:\n" +
                    "Menu Options:\n " +
                    "1 - Add Aircraft\n " +
                    "2 - Remove Aircraft\n " +
                    "3 - Edit Aircraft\n " +
                    "4 - View All Aircrafts\n " +
                    "Please enter your selection:");
            int caseID = scan.nextInt();
            switch (caseID) {
                case 1:
                    addUser(id);
                    break;
                case 2:
                    removeUser(id);
                    break;
                case 3:
                    System.out.println("Idk how we wanna edit aircraft");
                    break;
                case 4:
                    ResultSet allAircraft = stmt.executeQuery("SELECT * FROM Aircraft");
                    while (allAircraft.next()) {
                        JSONObject jsonobj = new JSONObject("{\"Aircraft_ID\":" + allAircraft.getInt(1) + ", \"Registration\":" +
                                allAircraft.getString(2) + ", \"Type\":" + allAircraft.getString(3) + "}");
                        System.out.println(jsonobj); //send this to client
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void manageFlight(int id){
        try {
            Statement stmt = con.createStatement();
            System.out.println("\nManage Flights:\n" +
                    "Menu Options:\n " +
                    "1 - Add Flights\n " +
                    "2 - Remove Flights\n " +
                    "3 - Edit Flights\n " +
                    "4 - View All Flights\n " +
                    "Please enter your selection:");
            int caseID = scan.nextInt();
            switch (caseID) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Idk how we wanna edit flights");
                    break;
                case 4:
                    ResultSet allFlights = stmt.executeQuery("SELECT * FROM Flight");
                    while (allFlights.next()) {
                        JSONObject jsonobj = new JSONObject("{\"FlightID\":" + allFlights.getInt(0) + ", \"Aircraft_id\":" +
                                allFlights.getString(1) + ", \"Student_id\":" + allFlights.getString(2) + ", \"Instructor_id\":" +
                                allFlights.getString(3) + ", \"Exercise\":" + allFlights.getString(5) + ", \"Sched_start\":" +
                                allFlights.getString(4) + ", \"Sched_end\":" + allFlights.getString(6) +"}");
                        System.out.println(jsonobj); //send this to client
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
