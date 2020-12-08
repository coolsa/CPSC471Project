package server.database;

import org.json.JSONObject;
import org.openapitools.model.Admin;
import org.openapitools.model.Aircraft;
import org.openapitools.model.Flight;
import org.openapitools.model.Instructor;
import org.openapitools.model.MXEngineer;
import org.openapitools.model.Student;
import org.openapitools.model.User;

import javax.swing.text.View;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private Connection con;
    
    public AdminMenu(Connection con) {
        this.con = con;
    }

    /**
     * Assign a instructor to teach a student
     */
    public void AssignTeaches(int sid, int iid) {
        try {
            CallableStatement cs = con.prepareCall("CALL AssignTeaches(?,?)");
            cs.setInt(1, sid);
            cs.setInt(2, iid);
            cs.executeUpdate();
        } catch (Exception e) {
            System.out.println("Unable to assign instructor to student");
            System.out.println(e);
        }
    }

    /**
     * View all users
     */
    public List<User> ViewAllUsers() {
        try {
            CallableStatement cs = con.prepareCall("CALL SelectAllUsers");
            ResultSet allUsers = cs.executeQuery();
            List<User> temp = new ArrayList<User>();
            while (allUsers.next()) {
            	User user = new User();
            	user.setId((long)allUsers.getInt(1));
            	user.setEmail(allUsers.getString(2));
            	user.setFirstName(allUsers.getString(3));
            	user.setLastName(allUsers.getString(4));
            	user.setPassword(allUsers.getString(5));
            	user.setPhone(allUsers.getString(6));
            	temp.add(user);
            }
            return temp;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Adds the user inputed student to the database
     */
    public void AddStudent(Student student, int id){
        try{;
            String email = student.getUserId().getEmail();
            String fname = student.getUserId().getFirstName();
            String lname = student.getUserId().getLastName();
            String pass = student.getUserId().getPassword();
            String phone = student.getUserId().getPhone();
            String license = student.getPilotLicenseNo();

            CallableStatement cs = con.prepareCall("CALL AddStudent(?,?,?,?,?,?,?)");
            cs.setString(1, email);
            cs.setString(2,fname);
            cs.setString(3,lname);
            cs.setString(4,pass);
            cs.setString(5,phone);
            cs.setString(6,license);
            cs.setInt(7,id);
            cs.executeQuery();
        }catch(Exception e){
            System.out.println("Unable to add new Student");
            System.out.println(e);
        }
    }

    /**
     * Adds the user inputed instructor to the database
     */
    public void AddInstructor(Instructor instructor, int id){
        try {
            String email = instructor.getUserId().getEmail();
            String fname = instructor.getUserId().getFirstName();
            String lname = instructor.getUserId().getLastName();
            String pass = instructor.getUserId().getPassword();
            String phone = instructor.getUserId().getPhone();
            String license = instructor.getPilotLicenseNo();
            String iClass = instructor.getInstructorClass();

            CallableStatement cs = con.prepareCall("CALL AddInstructor(?,?,?,?,?,?,?,?)");
            cs.setString(1, email);
            cs.setString(2,fname);
            cs.setString(3,lname);
            cs.setString(4,pass);
            cs.setString(5,phone);
            cs.setString(6,license);
            cs.setString(7,iClass);
            cs.setInt(8,id);
            cs.executeQuery();
        }catch(Exception e){
            System.out.println("Unable to add new Instructor");
            System.out.println(e);
        }
    }

    /**
     * Adds the user inputed mechanical engineer to the database
     */
    public void AddMX(MXEngineer mx, int id){
        try{
            String email = mx.getUserId().getEmail();
            String fname = mx.getUserId().getFirstName();
            String lname = mx.getUserId().getLastName();
            String pass = mx.getUserId().getPassword();
            String phone = mx.getUserId().getPhone();
            String license = mx.getEngLicenseNo();
            String rating = mx.getRating();

            CallableStatement cs = con.prepareCall("CALL AddMX_Engineer(?,?,?,?,?,?,?,?)");
            cs.setString(1, email);
            cs.setString(2,fname);
            cs.setString(3,lname);
            cs.setString(4,pass);
            cs.setString(5,phone);
            cs.setString(6,license);
            cs.setString(7,rating);
            cs.setInt(8,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to add new Mechanical Engineer");
            System.out.println(e);
        }
    }

    /**
     * Adds the user inputed admin to the database
     */
    public void AddAdmin(Admin admin, int id){
        try{
            String email = admin.getUserId().getEmail();
            String fname = admin.getUserId().getFirstName();
            String lname = admin.getUserId().getLastName();
            String pass = admin.getUserId().getPassword();
            String phone = admin.getUserId().getPhone();
            String role = admin.getRole();

            CallableStatement cs = con.prepareCall("CALL AddAdmin(?,?,?,?,?,?,?)");
            cs.setString(1, email);
            cs.setString(2,fname);
            cs.setString(3,lname);
            cs.setString(4,pass);
            cs.setString(5,phone);
            cs.setString(6,role);
            cs.setInt(7,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to add new Admin");
            System.out.println(e);
        }
    }

    /**
     * Admin menu to remove the user selected student
     */
    public void RemoveStudent(int sid, int id){
        try {
            CallableStatement cs1 = con.prepareCall("CALL RemoveStudent(?,?)");
            cs1.setInt(1, sid);
            cs1.setInt(2, id);
            cs1.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to delete Student");
            System.out.println(e);
        }
    }

    /**
     * Admin menu to remove the user selected instructor
     */
    public void RemoveInstructor(int iid, int id){
        try {
            CallableStatement cs2 = con.prepareCall("CALL RemoveInstructor(?,?)");
            cs2.setInt(1, iid);
            cs2.setInt(2,id);
            cs2.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to delete Instructor");
            System.out.println(e);
        }
    }

    /**
     * Admin menu to remove the user selected mechanical engineer
     */
    public void RemoveMX(int mid, int id){
        try {
            CallableStatement cs3 = con.prepareCall("CALL RemoveMXEngineer(?,?)");
            cs3.setInt(1, mid);
            cs3.setInt(2,id);
            cs3.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to delete  Mechanical Engineer");
            System.out.println(e);
        }
    }

    /**
     * Admin menu to remove the user selected admin
     */
    public void RemoveAdmin(int aid, int id){
        try {
            CallableStatement cs4 = con.prepareCall("CALL RemoveAdmin(?,?)");
            cs4.setInt(1, aid);
            cs4.setInt(2,id);
            cs4.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to delete Admin");
            System.out.println(e);
        }
    }

    /**
     * Admin menu to edit the desired student
     */
    public void EditStudent(Student student, int id){
        try {
            String email = student.getUserId().getEmail();
            String fname = student.getUserId().getFirstName();
            String lname = student.getUserId().getLastName();
            String pass = student.getUserId().getPassword();
            String phone = student.getUserId().getPhone();
            String license = student.getPilotLicenseNo();

            CallableStatement cs = con.prepareCall("CALL EditStudent(?,?,?,?,?,?,?,?)");
            cs.setInt(1, student.getUserId().getId().intValue());
            cs.setString(2, email);
            cs.setString(3,fname);
            cs.setString(4,lname);
            cs.setString(5,pass);
            cs.setString(6,phone);
            cs.setString(7,license);
            cs.setInt(8,id);
            cs.executeQuery();
        }catch(Exception e){
            System.out.println("Unable to add new Student");
            System.out.println(e);
        }
    }

    /**
     * Admin menu to edit the desired instructor
     */
    public void EditInstructor(Instructor instructor, int id){
        try {
            String email = instructor.getUserId().getEmail();
            String fname = instructor.getUserId().getFirstName();
            String lname = instructor.getUserId().getLastName();
            String pass = instructor.getUserId().getPassword();
            String phone = instructor.getUserId().getPhone();
            String license = instructor.getPilotLicenseNo();
            String iClass = instructor.getInstructorClass();

            CallableStatement cs = con.prepareCall("CALL EditInstructor(?,?,?,?,?,?,?,?,?)");
            cs.setInt(1,instructor.getUserId().getId().intValue());
            cs.setString(2, email);
            cs.setString(3,fname);
            cs.setString(4,lname);
            cs.setString(5,pass);
            cs.setString(6,phone);
            cs.setString(7,license);
            cs.setString(8,iClass);
            cs.setInt(9,id);
            cs.executeQuery();
        }catch(Exception e){
            System.out.println("Unable to add new Instructor");
            System.out.println(e);
        }
    }

    /**
     * Admin menu to edit the desired mechanical engineer
     */
    public void EditMX(MXEngineer mx, int id){
        try{
            String email = mx.getUserId().getEmail();
            String fname = mx.getUserId().getFirstName();
            String lname = mx.getUserId().getLastName();
            String pass = mx.getUserId().getPassword();
            String phone = mx.getUserId().getPhone();
            String license = mx.getEngLicenseNo();
            String rating = mx.getRating();

            CallableStatement cs = con.prepareCall("CALL EditMX_Engineer(?,?,?,?,?,?,?,?,?)");
            cs.setInt(1,mx.getUserId().getId().intValue());
            cs.setString(2, email);
            cs.setString(3,fname);
            cs.setString(4,lname);
            cs.setString(5,pass);
            cs.setString(6,phone);
            cs.setString(7,license);
            cs.setString(8,rating);
            cs.setInt(9,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to add new Mechanical Engineer");
            System.out.println(e);
        }
    }

    /**
     * Admin menu to edit the desired admin
     */
    public void EditAdmin(Admin admin, int id){
        try{
            String email = admin.getUserId().getEmail();
            String fname = admin.getUserId().getFirstName();
            String lname = admin.getUserId().getLastName();
            String pass = admin.getUserId().getPassword();
            String phone = admin.getUserId().getPhone();
            String role = admin.getRole();

            CallableStatement cs = con.prepareCall("CALL AddAdmin(?,?,?,?,?,?,?,?)");
            cs.setInt(1,admin.getUserId().getId().intValue());
            cs.setString(2, email);
            cs.setString(3,fname);
            cs.setString(4,lname);
            cs.setString(5,pass);
            cs.setString(6,phone);
            cs.setString(7,role);
            cs.setInt(8,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to add new Admin");
            System.out.println(e);
        }
    }

    /**
     * Add the inputed aircraft to the database
     */
    public void AddAircraft(Aircraft aircraft, int id){
        try {
            String reg = aircraft.getRegistration();
            String type = aircraft.getType();
            String serial = aircraft.getSerialNo();

            CallableStatement cs = con.prepareCall("CALL AddAircraft(?,?,?,?)");
            cs.setString(1, reg);
            cs.setString(2, type);
            cs.setString(3, serial);
            cs.setInt(4,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Remove the desired aircraft from the database
     */
    public void RemoveAircraft(int aid, int id){
        try {
            CallableStatement cs2 = con.prepareCall("CALL RemoveAircraft(?,?)");
            cs2.setInt(1, aid);
            cs2.setInt(2,id);
            cs2.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to delete Aircraft");
            System.out.println(e);
        }
    }

    /**
     * Edit the desired aircraft from the database
     */
    public void EditAircraft(Aircraft aircraft, int id){
        try {
            String reg = aircraft.getRegistration();
            String type = aircraft.getType();
            String serial = aircraft.getSerialNo();

            CallableStatement cs = con.prepareCall("CALL AddAircraft(?,?,?,?,?)");
            cs.setInt(1,aircraft.getId().intValue());
            cs.setString(2, reg);
            cs.setString(3, type);
            cs.setString(4, serial);
            cs.setInt(5,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * View all aircraft in the database
     */
    public List<Aircraft> ViewAllAircraft(){
        try {
            CallableStatement cs4 = con.prepareCall("CALL SelectAllAircrafts");
            ResultSet allAircraft = cs4.executeQuery();
            
            List<Aircraft> temp = new ArrayList<Aircraft>();
            while (allAircraft.next()) {
            	Aircraft aircraft = new Aircraft();
            	aircraft.setId((long)allAircraft.getInt(1));
            	aircraft.setRegistration(allAircraft.getString(2));
            	aircraft.setType(allAircraft.getString(3));
            	aircraft.setSerialNo(allAircraft.getString(4));
            	temp.add(aircraft);
            }
            return temp;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    /**
     * Add user inputed flight to the database
     */
    public void AddFlight(Flight flight, int id){
        try {
            int aid = flight.getAircraftId().getId().intValue();
            int sid = flight.getStudentId().getUserId().getId().intValue();
            int iid = flight.getInstructorId().getUserId().getId().intValue();
            String ex = flight.getExercise();
            LocalDateTime newStart = flight.getFlightStart().toLocalDateTime();
            LocalDateTime newEnd = flight.getFlightEnd().toLocalDateTime();

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
                CallableStatement cs = con.prepareCall("CALL AddFlight(?,?,?,?,?,?,?)");
                cs.setInt(1, aid);
                cs.setInt(2, sid);
                cs.setInt(3, iid);
                cs.setString(4, ex);
                cs.setString(5, newStart.toString());
                cs.setString(6, newEnd.toString());
                cs.setInt(7, id);
                cs.executeUpdate();
            }else{
                System.out.println("Flight already booked during this time");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Remove desired flight from the database
     */
    public void RemoveFlight(int fid, int aid, int id){
        try {
        	System.out.println(fid + " " + aid + " " + id);
            CallableStatement cs2 = con.prepareCall("CALL RemoveFlight(?,?,?)");
            cs2.setInt(1, fid);
            cs2.setInt(2, aid);
            cs2.setInt(3, id);
            cs2.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to delete Flight");
            System.out.println(e);
        }
    }

    /**
     * Edit desired flight from the database
     */
    public void EditFlight(Flight flight, int id){
        try {
            int aid = flight.getAircraftId().getId().intValue();
            int sid = flight.getStudentId().getUserId().getId().intValue();
            int iid = flight.getInstructorId().getUserId().getId().intValue();
            String ex = flight.getExercise();
            LocalDateTime newStart = flight.getFlightStart().toLocalDateTime();
            LocalDateTime newEnd = flight.getFlightEnd().toLocalDateTime();

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
            	CallableStatement cs = con.prepareCall("CALL AddFlight(?,?,?,?,?,?,?,?)");
            	cs.setInt(1,flight.getFlightId().intValue());
            	cs.setInt(2, aid);
            	cs.setInt(3, sid);
            	cs.setInt(4, iid);
            	cs.setString(5, ex);
            	cs.setString(6, newStart.toString());
            	cs.setString(7, newEnd.toString());
            	cs.setInt(8,id);
            	cs.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * View all flights
     */
    public List<Flight> ViewAllFlight(){
        try {
            CallableStatement cs4 = con.prepareCall("CALL SelectAllFlights");
            ResultSet allFlights = cs4.executeQuery();
            
            List<Flight> temp = new ArrayList<Flight>();
            while (allFlights.next()) {
            	Flight flight = new Flight();
            	flight.setFlightId((long)allFlights.getInt(1));
            	//INCOMPLETE
            	/*
            	flight.setAircraftId(allFlights.getInt(2));
            	flight.setStudentId(allFlights.getInt(3));
            	flight.setInstructorId(allFlights.getInt(4));
            	*/
            	flight.setExercise(allFlights.getString(5));
            	flight.setFlightStart(allFlights.getObject(6, OffsetDateTime.class));
            	flight.setFlightEnd(allFlights.getObject(7, OffsetDateTime.class));
            	temp.add(flight);
            }
            return temp;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

}
