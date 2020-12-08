package server.database;

import org.json.JSONObject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class InstructorMenu {

    private Connection con;
    private Scanner scan;

    InstructorMenu(Connection con, Scanner scan){
        this.con = con;
        this.scan = scan;
    }

    /**
     * Menu for instructors to decide what to do
     * @param id ID of instructor
     */
    void InstructorPortal(int id){
        try {
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            boolean loop = true;
            while(loop) {
                System.out.println("\nWelcome to the Instructor portal\n" +
                        "Menu Options:\n " +
                        "1 - View Instructor Schedule\n " +
                        "2 - View Instructor Profile\n " +
                        "3 - Book My Flight\n " +
                        "4 - Cancel My Flight\n " +
                        "5 - View Assigned Students\n " +
                        "6 - Exit\n" +
                        "Please enter your selection:");
                int caseID = scan.nextInt();
                switch (caseID) {
                    case 1:
                        ViewInstructorSchedule(id);
                        break;
                    case 2:
                        ViewInstructorProfile(id);
                        break;
                    case 3:
                        BookFlight(id);
                        break;
                    case 4:
                        CancelFlight(id);
                        break;
                    case 5:
                        ViewAssignedStudents(id);
                        break;
                    case 6:
                        loop = false;
                        break;

                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("Bye Instructor");
    }

    /**
     * Allows instructors to view their schedule
     * @param id ID of instructor
     */
    public void ViewInstructorSchedule(int id){
        try{
            CallableStatement cs1 = con.prepareCall("CALL SelectInstructorFlight(?)");
            cs1.setInt(1, id);
            ResultSet allUsersFlights = cs1.executeQuery();
            while (allUsersFlights.next()) {
                JSONObject jsonobj = new JSONObject("{\"FlightID\":" + allUsersFlights.getInt(1) + ", \"aircraft_id\":" +
                        allUsersFlights.getInt(2) + ", \"student_id\":" + allUsersFlights.getInt(3) + ", \"exercise\":" +
                        allUsersFlights.getString(5) + ", \"sched_start\":" + allUsersFlights.getDate(6)+ ", \"sched_end\":" +
                        allUsersFlights.getDate(7) + "}");
                System.out.println(jsonobj); //send this to client
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Allows instructor to view their profile
     * @param id ID of instructor
     */
    public void ViewInstructorProfile(int id){
        try{
            CallableStatement cs2 = con.prepareCall("CALL SelectUser(?)");
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
     * Allows instructors to book a flight with or without a student
     * @param id ID of instructor
     */
    public void BookFlight(int id){
        try{
            scan.nextLine();
            System.out.println("Please enter the flight's aircraft ID");
            int aid = scan.nextInt();
            int iid = id;
            System.out.println("Please enter the flight's student ID");
            int sid = scan.nextInt();
            scan.nextLine();
            System.out.println("Please enter the flight exercise");
            String ex = scan.nextLine();
            System.out.println("Please enter the flight scheduled start time in YYYY/MM/DD/hh/mm/ss");
            String start = scan.nextLine();
            String[] startAt = start.split("/");
            int[] startInt = new int[startAt.length];
            for(int i = 0; i < startAt.length; i++)
                startInt[i] = Integer.parseInt(startAt[i]);
            LocalDateTime newStart = LocalDateTime.of(startInt[0],startInt[1],startInt[2],startInt[3],startInt[4],startInt[5]);

            System.out.println("Please enter the flight scheduled end time in YYYY/MM/DD/hh/mm/ss");
            String end = scan.nextLine();
            String[] endAt = start.split("/");
            int[] endInt = new int[endAt.length];
            for(int i = 0; i < endAt.length; i++)
                endInt[i] = Integer.parseInt(endAt[i]);
            LocalDateTime newEnd = LocalDateTime.of(startInt[0],startInt[1],startInt[2],startInt[3],startInt[4],startInt[5]);

            boolean isConflict = false;

            CallableStatement cs2 = con.prepareCall("CALL SelectAllFlights");
            ResultSet allFlights = cs2.executeQuery();
            while(allFlights.next()){
                LocalDateTime flightStart = allFlights.getObject(6, LocalDateTime.class);
                LocalDateTime flightEnd = allFlights.getObject(7, LocalDateTime.class);

                if((newStart.isBefore(flightStart) && newEnd.isAfter(flightEnd)) || (newStart.isAfter(flightStart) && newStart.isBefore(flightEnd)) ||
                        (newEnd.isAfter(flightStart) && newEnd.isBefore(flightEnd)) || (newStart.equals(flightStart)) || (newEnd.equals(flightEnd))){
                    isConflict = true;
                }

            }

            if(!isConflict) {
                CallableStatement cs = con.prepareCall("CALL BookFlight(?,?,?,?,?,?,?)");
                cs.setInt(1, aid);
                cs.setInt(2, sid);
                cs.setInt(3, iid);
                cs.setString(4, ex);
                cs.setString(5, start);
                cs.setString(6, end);
                cs.executeUpdate();
            }else{
                System.out.println("Flight already booked during this time");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Allows instructors to cancel their own flight
     * @param id ID of instructor
     */
    public void CancelFlight(int id){
        try {
            System.out.println("Please enter the Flight ID");
            int fid = scan.nextInt();
            //System.out.println("Please enter the Aircraft ID");
            //int aid2 = scan.nextInt();

            CallableStatement cs4a = con.prepareCall("CALL SelectFlight(?)");
            cs4a.setInt(1, fid);
            ResultSet rs = cs4a.executeQuery();
            rs.next();
            JSONObject jsonobj = new JSONObject("{\"Instructor_id\":" + rs.getInt(4) + ", \"Aircraft_id\":" + rs.getInt(2) + "}");
            int tempID = (int)jsonobj.get("Instructor_id");
            int aid2 = (int)jsonobj.get("Aircraft_id");
            if(tempID == id) {
                CallableStatement cs4b = con.prepareCall("CALL CancelUserFlight(?,?)");
                cs4b.setInt(1, fid);
                cs4b.setInt(2, aid2);
                cs4b.executeUpdate();
            }else{
                System.out.println("The flight entered is not your flight");
            }
        }catch(Exception e){
            System.out.println("Unable to delete Flight");
            System.out.println(e);
        }
    }

    /**
     * Allows instructors to view all of their students
     * @param id ID of instructor
     */
    public void ViewAssignedStudents(int id){
        try{
            CallableStatement cs5 = con.prepareCall("CALL SelectInstructorsTeaches(?)");
            cs5.setInt(1, id);
            ResultSet allStudents = cs5.executeQuery();
            while (allStudents.next()) {
                JSONObject jsonobj = new JSONObject("{\"user_id\":" + allStudents.getInt(1) + ", \"instructor_id\":"
                        + allStudents.getInt(2) + "}");
                System.out.println(jsonobj); //send this to client
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}