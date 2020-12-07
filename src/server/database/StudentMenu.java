package server.database;

import org.json.JSONObject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentMenu {

    private Connection con;
    private Scanner scan;

    //Constructor
    StudentMenu(Connection con, Scanner scan){
        this.con = con;
        this.scan = scan;
    }

    /**
     * Student main menu to decide what to do
     * @param id ID of student
     */
    void StudentPortal(int id){
        try {
            boolean loop = true;
            while(loop) {
                System.out.println("\nWelcome to the Student portal\n" +
                        "Menu Options:\n " +
                        "1 - View Student Schedule\n " +
                        "2 - View Student Profile\n " +
                        "3 - Book My Flight\n " +
                        "4 - Cancel My Flight\n " +
                        "5 - View Assigned Instructors\n " +
                        "6 - Exit\n" +
                        "Please enter your selection:");
                int caseID = scan.nextInt();
                switch (caseID) {
                    case 1:
                        ViewStudentSchedule(id);
                        break;
                    case 2:
                        ViewStudentProfile(id);
                        break;
                    case 3:
                        BookFlight(id);
                        break;
                    case 4:
                        CancelFlight(id);
                        break;
                    case 5:
                        ViewAssignedInstructors(id);
                        break;
                    case 6:
                        loop = false;
                        break;

                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("Bye Student");
    }

    /**
     * Allows students to see their upcoming flights
     */
    public void ViewStudentSchedule(int id){
        try {
            CallableStatement cs1 = con.prepareCall("SelectStudentFlight(?)");
            cs1.setInt(1, id);
            ResultSet allUsersFlights = cs1.executeQuery();
            while (allUsersFlights.next()) {
                JSONObject jsonobj = new JSONObject("{\"FlightID\":" + allUsersFlights.getInt(1) + ", \"aircraft_id\":" +
                        allUsersFlights.getInt(2) + ", \"instructor_id\":" + allUsersFlights.getInt(4) + ", \"exercise\":" +
                        allUsersFlights.getString(5) + ", \"sched_start\":" + allUsersFlights.getDate(6) + ", \"sched_end\":" +
                        allUsersFlights.getDate(7) + "}");
                System.out.println(jsonobj); //send this to client
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Allows students to view their profile
     */
    public void ViewStudentProfile(int id){
        try {
            CallableStatement cs2 = con.prepareCall("SelectUser(?)");
            cs2.setInt(1, id);
            ResultSet allUsers = cs2.executeQuery();
            JSONObject jsonobj = new JSONObject("{\"user_id\":" + allUsers.getInt(1) + ", \"email\":" + allUsers.getString(2) +
                        ", \"user_first_name\":" + allUsers.getString(3) + ", \"user_last_name\":" + allUsers.getString(4) +
                        ", \"password\":" + allUsers.getString(5) + ", \"phone\":" + allUsers.getString(6) + "}");
            System.out.println(jsonobj); //send this to client
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Allows students to book flights with or without a instructor
     */
    public void BookFlight(int id){
        try {
            scan.nextLine();
            System.out.println("Please enter the flight's aircraft ID");
            int aid = scan.nextInt();
            int sid = id;
            System.out.println("Please enter the flight's instructor ID");
            int iid = scan.nextInt();
            scan.nextLine();
            System.out.println("Please enter the flight exercise");
            String ex = scan.nextLine();
            System.out.println("Please enter the flight scheduled start time in DATETIME (YYYY-MM-DD hh: mm: ss.nnn)");
            String start = scan.nextLine();
            System.out.println("Please enter the flight scheduled end time in DATETIME (YYYY-MM-DD hh: mm: ss.nnn)");
            String end = scan.nextLine();

            System.out.println("\n!!!!!!!!!!!We need to implement a check here for conflicting times in the Aircraft schedule!!!!!!!!!!!\n");

            CallableStatement cs3 = con.prepareCall("BookFlight(?,?,?,?,?,?)");
            cs3.setInt(1, aid);
            cs3.setInt(2, sid);
            cs3.setInt(3, iid);
            cs3.setString(4, ex);
            cs3.setString(5, start);
            cs3.setString(6, end);
            cs3.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Allows students to cancel their own flights
     */
    public void CancelFlight(int id){
        try {
            System.out.println("Please enter the Flight ID");
            int fid = scan.nextInt();
            System.out.println("Please enter the Aircraft ID");
            int aid2 = scan.nextInt();
            System.out.println("\n==============================\nImplement check to see if the user is on the current Flight\n==================================\n");
            //stmt.executeUpdate("DELETE FROM Flight WHERE FlightID = " + fid + " AND Aircraft_id = " + aaid);
            //stmt.executeUpdate("DELETE FROM Aircraft_Schedule WHERE Flight_id = " + fid + " AND Aircraft_id = " + aaid);
            CallableStatement cs4 = con.prepareCall("CancelUserFlight(?,?)");
            cs4.setInt(1, fid);
            cs4.setInt(2, aid2);
            cs4.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to delete Flight");
            System.out.println(e);
        }
    }

    /**
     * Allows students to view their instructors
     */
    public void ViewAssignedInstructors(int id){
        try {
            CallableStatement cs5 = con.prepareCall("SelectStudentsTeaches(?)");
            cs5.setInt(1, id);
            ResultSet allInstructors = cs5.executeQuery();
            while (allInstructors.next()) {
                JSONObject jsonobj = new JSONObject("{\"user_id\":" + allInstructors.getInt(1) + ", \"instructor_id\":"
                        + allInstructors.getInt(2) + "}");
                System.out.println(jsonobj); //send this to client
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
