package server.database;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentMenu {

    private Connection con;
    private Scanner scan;

    StudentMenu(Connection con, Scanner scan){
        this.con = con;
        this.scan = scan;
    }

    void StudentPortal(int id){
        try {
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
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
                        ResultSet allUsersFlights = stmt.executeQuery("SELECT * FROM Flight WHERE Student_id = " + id);
                        while (allUsersFlights.next()) {
                            JSONObject jsonobj = new JSONObject("{\"FlightID\":" + allUsersFlights.getInt(1) + ", \"aircraft_id\":" +
                                    allUsersFlights.getInt(2) + ", \"instructor_id\":" + allUsersFlights.getInt(4) + ", \"exercise\":" +
                                    allUsersFlights.getString(5) + ", \"sched_start\":" + allUsersFlights.getDate(6)+ ", \"sched_end\":" +
                                    allUsersFlights.getDate(7) + "}");
                            System.out.println(jsonobj); //send this to client
                        }
                        break;
                    case 2:
                        ResultSet allUsers = stmt.executeQuery("SELECT * FROM User WHERE UserID = " + id);
                        while (allUsers.next()) {
                            JSONObject jsonobj = new JSONObject("{\"user_id\":" + allUsers.getInt(1) + ", \"email\":" + allUsers.getString(2) +
                                    ", \"user_first_name\":" + allUsers.getString(3) + ", \"user_last_name\":" + allUsers.getString(4) +
                                    ", \"password\":" + allUsers.getString(5) + ", \"phone\":" + allUsers.getString(6) + "}");
                            System.out.println(jsonobj); //send this to client
                        }
                        break;
                    case 3:
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

                        stmt.executeUpdate("INSERT INTO Flight(FlightID, Aircraft_id, Student_id, Instructor_id, Exercise, Sched_start, Sched_end) "
                                + "VALUES (0, " + aid + ", " + sid + ", " + iid + ", '" + ex + "', '" + start + "', '" + end + "')" );
                        stmt.executeUpdate("INSERT INTO Aircraft_Schedule(Aircraft_id, Flight_id, Sched_start, Sched_end) "
                                + "VALUES (" + aid + ", LAST_INSERT_ID() , '" + start + "', '" + end + "')" );

                        break;
                    case 4:
                        try {
                            System.out.println("Please enter the Flight ID");
                            int fid = scan.nextInt();
                            System.out.println("Please enter the Aircraft ID");
                            int aaid = scan.nextInt();
                            System.out.println("\n==============================\nImplement check to see if the user is on the current Flight\n==================================\n");
                            stmt.executeUpdate("DELETE FROM Flight WHERE FlightID = " + fid + " AND Aircraft_id = " + aaid);
                            stmt.executeUpdate("DELETE FROM Aircraft_Schedule WHERE Flight_id = " + fid + " AND Aircraft_id = " + aaid);
                        }catch(Exception e){
                            System.out.println("Unable to delete Flight");
                            System.out.println(e);
                        }
                        break;
                    case 5:
                        ResultSet allInstructors = stmt.executeQuery("SELECT * FROM Teaches WHERE Student_id = " + id);
                        while (allInstructors.next()) {
                            JSONObject jsonobj = new JSONObject("{\"user_id\":" + allInstructors.getInt(1) + ", \"instructor_id\":"
                                    + allInstructors.getInt(2) + "}");
                            System.out.println(jsonobj); //send this to client
                        }
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
}
