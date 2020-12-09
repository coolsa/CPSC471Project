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

public class StudentMenu {

	private Connection con;

	// Constructor
	public StudentMenu(Connection con) {
		this.con = con;
	}

	/**
	 * Allows students to see their upcoming flights
	 */
	public List<Flight> ViewStudentSchedule(int id) {
		try {
			CallableStatement cs1 = con.prepareCall("CALL SelectStudentFlight(?)");
			cs1.setInt(1, id);
			ResultSet allUsersFlights = cs1.executeQuery();
			
			AdminMenu am = new AdminMenu(con);

			List<Flight> flights = new ArrayList<Flight>();

			while (allUsersFlights.next()) {
				Flight newFlight = new Flight();
				newFlight.setFlightId((long)allUsersFlights.getInt(1));
				newFlight.setAircraftId(am.SelectAircraft(allUsersFlights.getInt(2)));
				newFlight.setStudentId(am.SelectStudent(id));
				newFlight.setInstructorId(am.SelectInstructor(allUsersFlights.getInt(4)));
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
	 * Allows students to view their profile
	 */
	public Student ViewStudentProfile(int id) {
		try {
			AdminMenu am = new AdminMenu(con);
			return am.SelectStudent(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Allows students to book flights with or without a instructor
	 */
	public void BookFlight(Flight flight, int id) {
		try {
			int aid = flight.getAircraftId().getId().intValue();
			int sid = id;
			int iid = flight.getInstructorId().getUserId().getId().intValue();
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
				cs.setInt(7,  id);
				cs.executeUpdate();
			} else {
				System.out.println("Flight already booked during this time");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Allows students to cancel their own flights
	 */
	public void CancelFlight(int fid, int id) {
		try {
			CallableStatement cs4a = con.prepareCall("CALL SelectFlight(?)");
			cs4a.setInt(1, fid);
			ResultSet rs = cs4a.executeQuery();
			rs.next();
			JSONObject jsonobj = new JSONObject(
					"{\"Student_id\":" + rs.getInt(3) + ", \"Aircraft_id\":" + rs.getInt(2) + "}");
			int tempID = (int) jsonobj.get("Student_id");
			int aid2 = (int) jsonobj.get("Aircraft_id");
			if (tempID == id) {
				CallableStatement cs4b = con.prepareCall("CALL CancelUserFlight(?,?)");
				cs4b.setInt(1, fid);
				cs4b.setInt(2, aid2);
				cs4b.executeUpdate();
			} else {
				System.out.println("The flight entered is not your flight");
			}
		} catch (Exception e) {
			System.out.println("Unable to delete Flight");
			System.out.println(e);
		}
	}

	/**
	 * Allows students to view their instructors
	 */
	public List<Instructor> ViewAssignedInstructors(int id) {
		try {
			CallableStatement cs5 = con.prepareCall("CALL SelectStudentsTeaches(?)");
			cs5.setInt(1, id);
			ResultSet allInstructors = cs5.executeQuery();

			AdminMenu am = new AdminMenu(con);

			List<Instructor> teachers = new ArrayList<Instructor>();
			while (allInstructors.next()) {
				teachers.add(am.SelectInstructor(allInstructors.getInt(1)));
			}
			
			return teachers;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
