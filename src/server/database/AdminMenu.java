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
                                + "VALUES (0, '" + email + "', '" + fname + "', '" + lname + "', '" + password + "', '" + phone + "')" );
                        System.out.println("Please enter the student Pilot License Number");
                        String license = scan.nextLine();
                        stmt.executeUpdate("INSERT INTO Student(StudentID,Pilot_license_no) "
                                + "VALUES (LAST_INSERT_ID(), '" + license + "')" );
                    }catch(Exception e){
                        System.out.println("Unable to add new Student");
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        scan.nextLine();
                        System.out.println("Please enter the instructor email");
                        String email = scan.nextLine();
                        System.out.println("Please enter the instructor first name");
                        String fname = scan.nextLine();
                        System.out.println("Please enter the instructor lname");
                        String lname = scan.nextLine();
                        System.out.println("Please enter the instructor password");
                        String password = scan.nextLine();
                        System.out.println("Please enter the instructor phone");
                        String phone = scan.nextLine();
                        stmt.executeUpdate("INSERT INTO User(UserID, Email, First_name, Last_name, Password, Phone_number) "
                                + "VALUES (0, '" + email + "', '" + fname + "', '" + lname + "', '" + password + "', '" + phone + "')" );
                        System.out.println("Please enter the instructor's Pilot License Number");
                        String license = scan.nextLine();
                        System.out.println("Please enter the instructor's Instructor Class");
                        String iClass = scan.nextLine();
                        stmt.executeUpdate("INSERT INTO Instructor(InstructorID,Pilot_license_no,Instructor_Class) "
                                + "VALUES (LAST_INSERT_ID(), '" + license + "', '" + iClass + "')" );
                    }catch(Exception e){
                        System.out.println("Unable to add new Instructor");
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try{
                        scan.nextLine();
                        System.out.println("Please enter the mechanical engineer email");
                        String email = scan.nextLine();
                        System.out.println("Please enter the mechanical engineer first name");
                        String fname = scan.nextLine();
                        System.out.println("Please enter the mechanical engineer lname");
                        String lname = scan.nextLine();
                        System.out.println("Please enter the mechanical engineer password");
                        String password = scan.nextLine();
                        System.out.println("Please enter the mechanical engineer phone");
                        String phone = scan.nextLine();
                        stmt.executeUpdate("INSERT INTO User(UserID, Email, First_name, Last_name, Password, Phone_number) "
                                + "VALUES (0, '" + email + "', '" + fname + "', '" + lname + "', '" + password + "', '" + phone + "')" );
                        System.out.println("Please enter the mechanical engineer's Engineer License Number");
                        String license = scan.nextLine();
                        System.out.println("Please enter the mechanical engineer's Rating");
                        String rating = scan.nextLine();
                        stmt.executeUpdate("INSERT INTO MX_Engineer(MX_EngineerID,Eng_license_no,Rating) "
                                + "VALUES (LAST_INSERT_ID(), '" + license + "', '" + rating + "')" );
                    }catch(Exception e){
                        System.out.println("Unable to add new Mechanical Engineer");
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try{
                        scan.nextLine();
                        System.out.println("Please enter the admin email");
                        String email = scan.nextLine();
                        System.out.println("Please enter the admin engineer first name");
                        String fname = scan.nextLine();
                        System.out.println("Please enter the admin engineer lname");
                        String lname = scan.nextLine();
                        System.out.println("Please enter the admin engineer password");
                        String password = scan.nextLine();
                        System.out.println("Please enter the admin engineer phone");
                        String phone = scan.nextLine();
                        stmt.executeUpdate("INSERT INTO User(UserID, Email, First_name, Last_name, Password, Phone_number) "
                                + "VALUES (0, '" + email + "', '" + fname + "', '" + lname + "', '" + password + "', '" + phone + "')" );
                        System.out.println("Please enter the admin's role");
                        String role = scan.nextLine();
                        stmt.executeUpdate("INSERT INTO Admin(AdminID,Role) "
                                + "VALUES (LAST_INSERT_ID(), '" + role + "')" );
                    }catch(Exception e){
                        System.out.println("Unable to add new Admin");
                        System.out.println(e);
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
                    try {
                        System.out.println("Please enter the student ID");
                        int sid = scan.nextInt();
                        stmt.executeUpdate("DELETE FROM Student WHERE StudentID = " + sid);
                        stmt.executeUpdate("DELETE FROM User WHERE UserID = " + sid);
                    }catch(Exception e){
                        System.out.println("Unable to delete student");
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Please enter the Instructor ID");
                        int iid = scan.nextInt();
                        stmt.executeUpdate("DELETE FROM Instructor WHERE InstructorID = " + iid);
                        stmt.executeUpdate("DELETE FROM User WHERE UserID = " + iid);
                    }catch(Exception e){
                        System.out.println("Unable to delete instructor");
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Please enter the Mechanical Engineer ID");
                        int eid = scan.nextInt();
                        stmt.executeUpdate("DELETE FROM MX_Engineer WHERE MX_EngineerID = " + eid);
                        stmt.executeUpdate("DELETE FROM User WHERE UserID = " + eid);
                    }catch(Exception e){
                        System.out.println("Unable to delete mechanical engineer");
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Please enter the Admin ID");
                        int aid = scan.nextInt();
                        stmt.executeUpdate("DELETE FROM Admin WHERE AdminID = " + aid);
                        stmt.executeUpdate("DELETE FROM User WHERE UserID = " + aid);
                    }catch(Exception e){
                        System.out.println("Unable to delete admin");
                        System.out.println(e);
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
                    scan.nextLine();
                    System.out.println("Please enter the aircraft registration");
                    String reg = scan.nextLine();
                    System.out.println("Please enter the aircraft type");
                    String type = scan.nextLine();
                    System.out.println("Please enter the aircraft serial number");
                    String serial = scan.nextLine();
                    stmt.executeUpdate("INSERT INTO Aircraft(AircraftID, Registration, Type, Serial_no) "
                            + "VALUES (0, '" + reg + "', '" + type + "', '" + serial + "')" );
                    break;
                case 2:
                    try {
                        System.out.println("Please enter the Aircraft ID");
                        int aid = scan.nextInt();
                        stmt.executeUpdate("DELETE FROM Aircraft WHERE AircraftID = " + aid);
                    }catch(Exception e){
                        System.out.println("Unable to delete Aircraft");
                        System.out.println(e);
                    }
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
                    scan.nextLine();
                    System.out.println("Please enter the flight's aircraft ID");
                    String aid = scan.nextLine();
                    System.out.println("Please enter the flight's student ID");
                    String sid = scan.nextLine();
                    System.out.println("Please enter the flight's instructor ID");
                    String iid = scan.nextLine();
                    System.out.println("Please enter the flight exercise");
                    String ex = scan.nextLine();
                    System.out.println("Please enter the flight scheduled start time in DATETIME format");
                    String start = scan.nextLine();
                    System.out.println("Please enter the flight scheduled end time in DATETIME format");
                    String end = scan.nextLine();

                    System.out.println("\n!!!!!!!!!!!We need to implement a check here for conflicting times in the Aircraft schedule!!!!!!!!!!!\n");

                    stmt.executeUpdate("INSERT INTO Flight(FlightID, Aircraft_id, Student_id, Instructor_id, Exercise, Sched_start, Sched_end) "
                            + "VALUES (0, '" + aid + "', '" + sid + "', '" + iid + "', '" + ex + "', '" + start + "', '" + end + "')" );
                    stmt.executeUpdate("INSERT INTO Aircraft_Schedule(Aircraft_id, Flight_id, Sched_start, Sched_end) "
                            + "VALUES (" + aid + "', LAST_INSERT_ID() , '" + start + "', '" + end + "')" );

                    break;
                case 2:
                    try {
                        System.out.println("Please enter the Flight ID");
                        int fid = scan.nextInt();
                        System.out.println("Please enter the Aircraft ID");
                        int aaid = scan.nextInt();
                        stmt.executeQuery("DELETE FROM Flight WHERE Flight_id = " + fid + " AND Aircraft_id = " + aaid);
                        stmt.executeQuery("DELETE FROM Aircraft_Schedule WHERE Flight_id = " + fid + " AND Aircraft_id = " + aaid);
                    }catch(Exception e){
                        System.out.println("Unable to delete Flight");
                        System.out.println(e);
                    }
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
