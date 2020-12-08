package server.database;

import org.json.JSONObject;
import org.openapitools.model.Flight;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class InstructorMenu {

    private Connection con;
    
    InstructorMenu(Connection con){
        this.con = con;
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
            
            //IMPLEMENT LATER
            
            
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
            
            //IMPLEMENT LATER
            
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
    public void BookFlight(Flight flight, int id){
        try{
        	int aid = flight.getAircraftId().getId().intValue();
			int sid = flight.getStudentId().getUserId().getId().intValue();
			int iid = id;
			String ex = flight.getExercise();
			LocalDateTime newStart = flight.getFlightStart().toLocalDateTime();
			LocalDateTime newEnd = flight.getFlightEnd().toLocalDateTime();

			boolean isConflict = false;

			CallableStatement cs2 = con.prepareCall("CALL SelectAllFlights");
			ResultSet allFlights = cs2.executeQuery();
			while (allFlights.next()) {
				LocalDateTime flightStart = allFlights.getObject(6, LocalDateTime.class);
				LocalDateTime flightEnd = allFlights.getObject(7, LocalDateTime.class);

				if ((newStart.isBefore(flightStart) && newEnd.isAfter(flightEnd))
						|| (newStart.isAfter(flightStart) && newStart.isBefore(flightEnd))
						|| (newEnd.isAfter(flightStart) && newEnd.isBefore(flightEnd)) || (newStart.equals(flightStart))
						|| (newEnd.equals(flightEnd))) {
					isConflict = true;
				}

			}

			if (!isConflict) {
				CallableStatement cs = con.prepareCall("CALL BookFlight(?,?,?,?,?,?,?)");
				cs.setInt(1, aid);
				cs.setInt(2, sid);
				cs.setInt(3, iid);
				cs.setString(4, ex);
				cs.setString(5, newStart.toString());
				cs.setString(6, newEnd.toString());
				cs.executeUpdate();
			} else {
				System.out.println("Flight already booked during this time");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    /**
     * Allows instructors to cancel their own flight
     * @param id ID of instructor
     */
    public void CancelFlight(int fid, int id){
        try {

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
            
            // IMPLEMENT LATER
            
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
