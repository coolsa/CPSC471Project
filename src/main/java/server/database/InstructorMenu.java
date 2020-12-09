package server.database;

import org.json.JSONObject;
import org.openapitools.model.Flight;
import org.openapitools.model.Instructor;
import org.openapitools.model.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstructorMenu {

    private Connection con;
    
    public InstructorMenu(Connection con){
        this.con = con;
    }

    
    /**
     * Allows instructors to view their schedule
     * @param id ID of instructor
     */
    public List<Flight> ViewInstructorSchedule(int id){
    	try {
			CallableStatement cs1 = con.prepareCall("CALL SelectInstructorFlight(?)");
			cs1.setInt(1, id);
			ResultSet allUsersFlights = cs1.executeQuery();
			
			AdminMenu am = new AdminMenu(con);

			List<Flight> flights = new ArrayList<Flight>();

			while (allUsersFlights.next()) {
				Flight newFlight = new Flight();
				newFlight.setFlightId((long)allUsersFlights.getInt(1));
				newFlight.setAircraftId(am.SelectAircraft(allUsersFlights.getInt(2)));
				newFlight.setStudentId(am.SelectStudent(allUsersFlights.getInt(3)));
				newFlight.setInstructorId(am.SelectInstructor(id));
				newFlight.setExercise(allUsersFlights.getString(5));
				LocalDateTime start = allUsersFlights.getObject(6, LocalDateTime.class);
            	LocalDateTime end = allUsersFlights.getObject(7, LocalDateTime.class);
            	
            	newFlight.setFlightStart(start.atOffset(ZoneOffset.UTC));
            	newFlight.setFlightEnd(end.atOffset(ZoneOffset.UTC));
				flights.add(newFlight);
			}
			return flights;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
    }

    /**
     * Allows instructor to view their profile
     * @param id ID of instructor
     */
    public Instructor ViewInstructorProfile(int id){
		try {
			AdminMenu am = new AdminMenu(con);
			return am.SelectInstructor(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
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
    public List<Student> ViewAssignedStudents(int id){
		try {
			CallableStatement cs5 = con.prepareCall("CALL SelectInstructorsTeaches(?)");
			cs5.setInt(1, id);
			ResultSet allStudents = cs5.executeQuery();

			AdminMenu am = new AdminMenu(con);

			List<Student> students = new ArrayList<Student>();
			while (allStudents.next()) {
				students.add(am.SelectStudent(allStudents.getInt(1)));
			}
			
			return students;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
    }
}
