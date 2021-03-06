package server.database;

import org.json.JSONObject;
import org.openapitools.model.Admin;
import org.openapitools.model.AdminUserId;
import org.openapitools.model.Aircraft;
import org.openapitools.model.AircraftSchedule;
import org.openapitools.model.AircraftScheduleAircraftId;
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
import java.time.ZoneOffset;
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
    public int AssignTeaches(int sid, int iid) {
        try {
            CallableStatement cs = con.prepareCall("CALL AssignTeaches(?,?)");
            cs.setInt(1, sid);
            cs.setInt(2, iid);
            cs.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("Unable to assign instructor to student");
            System.out.println(e);
            return -1;
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
    public int AddStudent(Student student, int id){
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
            return 1;
        }catch(Exception e){
            System.out.println("Unable to add new Student");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Adds the user inputed instructor to the database
     */
    public int AddInstructor(Instructor instructor, int id){
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
            return 1;
        }catch(Exception e){
            System.out.println("Unable to add new Instructor");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Adds the user inputed mechanical engineer to the database
     */
    public int AddMX(MXEngineer mx, int id){
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
            return 1;
        }catch(Exception e){
            System.out.println("Unable to add new Mechanical Engineer");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Adds the user inputed admin to the database
     */
    public int AddAdmin(Admin admin, int id){
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
            return 1;
        }catch(Exception e){
            System.out.println("Unable to add new Admin");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Admin menu to remove the user selected student
     */
    public int RemoveStudent(int sid, int id){
        try {
        	if(SelectStudent(sid) == null) {
        		return -1;
        	}
            CallableStatement cs1 = con.prepareCall("CALL RemoveStudent(?,?)");
            cs1.setInt(1, sid);
            cs1.setInt(2, id);
            cs1.executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println("Unable to delete Student");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Admin menu to remove the user selected instructor
     */
    public int RemoveInstructor(int iid, int id){
        try {
        	if(SelectInstructor(iid) == null) {
        		return -1;
        	}
            CallableStatement cs2 = con.prepareCall("CALL RemoveInstructor(?,?)");
            cs2.setInt(1, iid);
            cs2.setInt(2,id);
            cs2.executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println("Unable to delete Instructor");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Admin menu to remove the user selected mechanical engineer
     */
    public int RemoveMX(int mid, int id){
        try {
            CallableStatement cs3 = con.prepareCall("CALL RemoveMX_Engineer(?,?)");
            cs3.setInt(1, mid);
            cs3.setInt(2,id);
            cs3.executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println("Unable to delete Mechanical Engineer");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Admin menu to remove the user selected admin
     */
    public int RemoveAdmin(int aid, int id){
        try {
        	if(SelectAdmin(aid) == null) {
        		return -1;
        	}
            CallableStatement cs4 = con.prepareCall("CALL RemoveAdmin(?,?)");
            cs4.setInt(1, aid);
            cs4.setInt(2,id);
            cs4.executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println("Unable to delete Admin");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Admin menu to edit the desired student
     */
    public int EditStudent(Student student, int id){
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
            return 1;
        }catch(Exception e){
            System.out.println("Unable to add new Student");
            System.out.println(e);
            return -1;
        }
    }
    
    /**
     * Admin menu to edit the desired user
     */
    public int EditUser(User user, int id){
        try {
            String email = user.getEmail();
            String fname = user.getFirstName();
            String lname = user.getLastName();
            String pass = user.getPassword();
            String phone = user.getPhone();

            CallableStatement cs = con.prepareCall("CALL EditUser(?,?,?,?,?,?,?)");
            cs.setInt(1, user.getId().intValue());
            cs.setString(2, email);
            cs.setString(3,fname);
            cs.setString(4,lname);
            cs.setString(5,pass);
            cs.setString(6,phone);
            cs.setInt(7,id);
            cs.executeQuery();
            return 1;
        }catch(Exception e){
            System.out.println("Unable to add new Student");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Admin menu to edit the desired instructor
     */
    public int EditInstructor(Instructor instructor, int id){
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
            return 1;
        }catch(Exception e){
            System.out.println("Unable to add new Instructor");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Admin menu to edit the desired mechanical engineer
     */
    public int EditMX(MXEngineer mx, int id){
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
            return 1;
        }catch(Exception e){
            System.out.println("Unable to add new Mechanical Engineer");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Admin menu to edit the desired admin
     */
    public int EditAdmin(Admin admin, int id){
        try{
            String email = admin.getUserId().getEmail();
            String fname = admin.getUserId().getFirstName();
            String lname = admin.getUserId().getLastName();
            String pass = admin.getUserId().getPassword();
            String phone = admin.getUserId().getPhone();
            String role = admin.getRole();

            CallableStatement cs = con.prepareCall("CALL EditAdmin(?,?,?,?,?,?,?,?)");
            cs.setInt(1,admin.getUserId().getId().intValue());
            cs.setString(2, email);
            cs.setString(3,fname);
            cs.setString(4,lname);
            cs.setString(5,pass);
            cs.setString(6,phone);
            cs.setString(7,role);
            cs.setInt(8,id);
            cs.executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println("Unable to add new Admin");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Add the inputed aircraft to the database
     */
    public int AddAircraft(Aircraft aircraft, int id){
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
            return 1;
        }catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Remove the desired aircraft from the database
     */
    public int RemoveAircraft(int aid, int id){
        try {
        	if(SelectAircraft(aid) == null) {
        		return -1;
        	}
            CallableStatement cs2 = con.prepareCall("CALL RemoveAircraft(?,?)");
            cs2.setInt(1, aid);
            cs2.setInt(2,id);
            cs2.executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println("Unable to delete Aircraft");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Edit the desired aircraft from the database
     */
    public int EditAircraft(Aircraft aircraft, int id){
        try {
            String reg = aircraft.getRegistration();
            String type = aircraft.getType();
            String serial = aircraft.getSerialNo();

            CallableStatement cs = con.prepareCall("CALL EditAircraft(?,?,?,?,?)");
            cs.setInt(1,aircraft.getId().intValue());
            cs.setString(2, reg);
            cs.setString(3, type);
            cs.setString(4, serial);
            cs.setInt(5,id);
            cs.executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println(e);
            return -1;
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
    public int AddFlight(Flight flight, int id){
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
                return 1;
            }else{
                System.out.println("Flight already booked during this time");
                return -2;
            }
        }catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Remove desired flight from the database
     */
    public int RemoveFlight(int fid, int id){
        try {
        	if(SelectFlight(fid) == null) {
        		return -1;
        	}
        	CallableStatement cs = con.prepareCall("CALL SelectFlight(?)");
        	cs.setInt(1, fid);
        	ResultSet rs = cs.executeQuery();
        	rs.next();
        	
            CallableStatement cs2 = con.prepareCall("CALL RemoveFlight(?,?,?)");
            cs2.setInt(1, fid);
            cs2.setInt(2, rs.getInt(2));
            cs2.setInt(3, id);
            cs2.executeUpdate();
            return 1;
        }catch(Exception e){
            System.out.println("Unable to delete Flight");
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Edit desired flight from the database
     */
    public int EditFlight(Flight flight, int id){
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
            	CallableStatement cs = con.prepareCall("CALL EditFlight(?,?,?,?,?,?,?,?)");
            	cs.setInt(1,flight.getFlightId().intValue());
            	cs.setInt(2, aid);
            	cs.setInt(3, sid);
            	cs.setInt(4, iid);
            	cs.setString(5, ex);
            	cs.setString(6, newStart.toString());
            	cs.setString(7, newEnd.toString());
            	cs.setInt(8,id);
            	cs.executeUpdate();
            	return 1;
            }
            return -2;
        }catch(Exception e){
            System.out.println(e);
            return -1;
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
            	flight.setAircraftId(SelectAircraft(allFlights.getInt(2)));
            	flight.setStudentId(SelectStudent(allFlights.getInt(3)));
            	flight.setInstructorId(SelectInstructor(allFlights.getInt(4)));
            	flight.setExercise(allFlights.getString(5));

            	LocalDateTime start = allFlights.getObject(6, LocalDateTime.class);
            	LocalDateTime end = allFlights.getObject(7, LocalDateTime.class);
            	
            	flight.setFlightStart(start.atOffset(ZoneOffset.UTC));
            	flight.setFlightEnd(end.atOffset(ZoneOffset.UTC));
            	temp.add(flight);
            }
            return temp;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    /**
     * Returns true if a student, false if not
     */
    public boolean isStudent(int id) {
    	try {
	        CallableStatement cs4 = con.prepareCall("CALL SelectStudent(?)");
	        cs4.setInt(1,id);
	        ResultSet student = cs4.executeQuery();
	        if(student.next()){
	        	return true;
	        }else {
	        	return false;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
    
    /**
     * Returns true if a instructor, false if not
     */
    public boolean isInstructor(int id) {
    	try {
	        CallableStatement cs4 = con.prepareCall("CALL SelectInstructor(?)");
	        cs4.setInt(1,id);
	        ResultSet instructor = cs4.executeQuery();
	        if(instructor.next()){
	        	return true;
	        }else {
	        	return false;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
    
    /**
     * Returns true if a mechanical engineer, false if not
     */
    public boolean isMX(int id) {
    	try {
	        CallableStatement cs4 = con.prepareCall("CALL SelectMX_Engineer(?)");
	        cs4.setInt(1,id);
	        ResultSet mx = cs4.executeQuery();
	        if(mx.next()){
	        	return true;
	        }else {
	        	return false;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
    
    /**
     * Returns true if a admin, false if not
     */
    public boolean isAdmin(int id) {
    	try {
	        CallableStatement cs4 = con.prepareCall("CALL SelectAdmin(?)");
	        cs4.setInt(1,id);
	        ResultSet admin = cs4.executeQuery();
	        if(admin.next()){
	        	return true;
	        }else {
	        	return false;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
    
    /**
     * Returns true if a student, false if not
     */
    public Student SelectStudent(int id) {
    	try {
    		CallableStatement cs3 = con.prepareCall("CALL SelectUser(?)");
	        cs3.setInt(1,id);
	        ResultSet user = cs3.executeQuery();
	        CallableStatement cs4 = con.prepareCall("CALL SelectStudent(?)");
	        cs4.setInt(1,id);
	        ResultSet student = cs4.executeQuery();
	        if(student.next() && user.next()){
	        	Student newStudent = new Student();
	        	AdminUserId aUser = new AdminUserId();
	        	aUser.setId((long)user.getInt(1));
	        	aUser.setEmail(user.getString(2));
	        	aUser.setFirstName(user.getString(3));
	        	aUser.setLastName(user.getString(4));
	        	aUser.setPassword(user.getString(5));
	        	aUser.setPhone(user.getString(6));
	        	newStudent.setUserId(aUser);
	        	newStudent.setPilotLicenseNo(student.getString(2));
	        	return newStudent;
	        }else {
	        	return null;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }
    
    /**
     * Returns true if a student, false if not
     */
    public User SelectUser(int id) {
    	try {
    		CallableStatement cs3 = con.prepareCall("CALL SelectUser(?)");
	        cs3.setInt(1,id);
	        ResultSet user = cs3.executeQuery();
	        if(user.next()){
	        	User newUser = new User();
	        	newUser.setId((long)user.getInt(1));
	        	newUser.setEmail(user.getString(2));
	        	newUser.setFirstName(user.getString(3));
	        	newUser.setLastName(user.getString(4));
	        	newUser.setPassword(user.getString(5));
	        	newUser.setPhone(user.getString(6));
	        	return newUser;
	        }else {
	        	return null;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }
    
    /**
     * Returns true if a instructor, false if not
     */
    public Instructor SelectInstructor(int id) {
    	try {
    		CallableStatement cs3 = con.prepareCall("CALL SelectUser(?)");
	        cs3.setInt(1,id);
	        ResultSet user = cs3.executeQuery();
	        CallableStatement cs4 = con.prepareCall("CALL SelectInstructor(?)");
	        cs4.setInt(1,id);
	        ResultSet instructor = cs4.executeQuery();
	        if(instructor.next() && user.next()){
	        	Instructor newInstructor = new Instructor();
	        	AdminUserId aUser = new AdminUserId();
	        	aUser.setId((long)user.getInt(1));
	        	aUser.setEmail(user.getString(2));
	        	aUser.setFirstName(user.getString(3));
	        	aUser.setLastName(user.getString(4));
	        	aUser.setPassword(user.getString(5));
	        	aUser.setPhone(user.getString(6));
	        	newInstructor.setUserId(aUser);
	        	newInstructor.setPilotLicenseNo(instructor.getString(2));
	        	newInstructor.setInstructorClass(instructor.getString(3));
	        	return newInstructor;
	        }else {
	        	return null;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }
    
    /**
     * Returns true if a mechanical engineer, false if not
     */
    public MXEngineer SelectMX(int id) {
    	try {
    		CallableStatement cs3 = con.prepareCall("CALL SelectUser(?)");
	        cs3.setInt(1,id);
	        ResultSet user = cs3.executeQuery();
	        CallableStatement cs4 = con.prepareCall("CALL SelectMX_Engineer(?)");
	        cs4.setInt(1,id);
	        ResultSet mx = cs4.executeQuery();
	        if(mx.next() && user.next()){
	        	MXEngineer newMX = new MXEngineer();
	        	AdminUserId aUser = new AdminUserId();
	        	aUser.setId((long)user.getInt(1));
	        	aUser.setEmail(user.getString(2));
	        	aUser.setFirstName(user.getString(3));
	        	aUser.setLastName(user.getString(4));
	        	aUser.setPassword(user.getString(5));
	        	aUser.setPhone(user.getString(6));
	        	newMX.setUserId(aUser);
	        	newMX.setEngLicenseNo(mx.getString(2));
	        	newMX.setRating(mx.getString(3));
	        	return newMX;
	        }else {
	        	return null;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }
    
    /**
     * Returns admin if it can be found
     */
    public Admin SelectAdmin(int id) {
    	try {
    		CallableStatement cs3 = con.prepareCall("CALL SelectUser(?)");
	        cs3.setInt(1,id);
	        ResultSet user = cs3.executeQuery();
	        CallableStatement cs4 = con.prepareCall("CALL SelectAdmin(?)");
	        cs4.setInt(1,id);
	        ResultSet admin = cs4.executeQuery();
	        if(admin.next() && user.next()){
	        	Admin newAdmin = new Admin();
	        	AdminUserId aUser = new AdminUserId();
	        	aUser.setId((long)user.getInt(1));
	        	aUser.setEmail(user.getString(2));
	        	aUser.setFirstName(user.getString(3));
	        	aUser.setLastName(user.getString(4));
	        	aUser.setPassword(user.getString(5));
	        	aUser.setPhone(user.getString(6));
	        	newAdmin.setUserId(aUser);
	        	newAdmin.setRole(admin.getString(2));
	        	return newAdmin;
	        }else {
	        	return null;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }
    
    public Aircraft SelectAircraft(int aid) {
    	try {
	        CallableStatement cs4 = con.prepareCall("CALL SelectAircraft(?)");
	        cs4.setInt(1,aid);
	        ResultSet aircraft = cs4.executeQuery();
	        if(aircraft.next()) {
	        	Aircraft newAircraft = new Aircraft();
	        	newAircraft.setId((long)aid);
	        	newAircraft.setRegistration(aircraft.getString(2));
	        	newAircraft.setType(aircraft.getString(3));
	        	newAircraft.setSerialNo(aircraft.getString(4));
	        	return newAircraft;
	        }else {
	        	return null;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }
    
    public Flight SelectFlight(int fid) {
    	try {
	        CallableStatement cs4 = con.prepareCall("CALL SelectFlight(?)");
	        cs4.setInt(1,fid);
	        ResultSet flight = cs4.executeQuery();
	        
	        if(flight.next()) {
            	Flight newFlight = new Flight();
            	newFlight.setFlightId((long)flight.getInt(1));
            	newFlight.setAircraftId(SelectAircraft(flight.getInt(2)));
            	newFlight.setStudentId(SelectStudent(flight.getInt(3)));
            	newFlight.setInstructorId(SelectInstructor(flight.getInt(4)));
            	newFlight.setExercise(flight.getString(5));
            	LocalDateTime start = flight.getObject(6, LocalDateTime.class);
            	LocalDateTime end = flight.getObject(7, LocalDateTime.class);
            	
            	newFlight.setFlightStart(start.atOffset(ZoneOffset.UTC));
            	newFlight.setFlightEnd(end.atOffset(ZoneOffset.UTC));
            	return newFlight;
	        }else {
	        	return null;
	        }
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }
    
    public List<AircraftSchedule> SelectAircraftSchedule(int id){
    	try {
	        CallableStatement cs4 = con.prepareCall("CALL SelectAllAircraftsSchedule(?)");
	        cs4.setInt(1,id);
	        ResultSet flight = cs4.executeQuery();
	        
	        List<AircraftSchedule> schedule = new ArrayList<AircraftSchedule>();
	        
	        while(flight.next()) {
	        	AircraftSchedule newSchedule = new AircraftSchedule();
	        	AircraftScheduleAircraftId aid = new AircraftScheduleAircraftId();
	        	aid.setId((long)flight.getInt(1));
	        	newSchedule.setAircraftId(aid);
            	newSchedule.setFlightId((long)flight.getInt(2));
            	
            	LocalDateTime start = flight.getObject(3, LocalDateTime.class);
            	LocalDateTime end = flight.getObject(4, LocalDateTime.class);
            	
            	newSchedule.setSchedStart(start.atOffset(ZoneOffset.UTC));
            	newSchedule.setSchedEnd(end.atOffset(ZoneOffset.UTC));
            	schedule.add(newSchedule);
	        }
	        return schedule;
    	}catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}
    }

}
