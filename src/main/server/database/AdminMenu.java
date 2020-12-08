package main.server.database;

import org.json.JSONObject;

import javax.swing.text.View;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Scanner;

public class AdminMenu {

    private Connection con;
    private Scanner scan;

    //Constructor
    AdminMenu(Connection con, Scanner scan) {
        this.con = con;
        this.scan = scan;
    }

    /**
     * Main admin menu for the admin to decide what to do
     * @param id ID of admin
     */
    public void AdminPortal(int id) {
        try {
            boolean loop = true;
            while (loop) {
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
                        ManageUser(id);
                        break;
                    case 2:
                        ManageAircraft(id);
                        break;
                    case 3:
                        ManageFlight(id);
                        break;
                    case 4:
                        AssignTeaches();
                        break;
                    case 5:
                        loop = false;
                        break;

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Bye Admin");
    }

    /**
     * Admin menu to decide what to do with Users
     * @param id ID of admin
     */
    public void ManageUser(int id) {
        try {
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
                    AddUser(id);
                    break;
                case 2:
                    RemoveUser(id);
                    break;
                case 3:
                    EditUser(id);
                    break;
                case 4:
                    ViewAllUsers();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Admin menu to select what kind of user you would like to add
     * @param id ID of the admin
     */
    public void AddUser(int id) {
        try {
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
                    AddStudent(id);
                    break;
                case 2:
                    AddInstructor(id);
                    break;
                case 3:
                    AddMX(id);
                    break;
                case 4:
                    AddAdmin(id);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Admin menu to select the type of user to remove
     */
    public void RemoveUser(int id) {
        try {
            System.out.println("\nAdd Users:\n" +
                    "Menu Options:\n " +
                    "1 - Remove Student\n " +
                    "2 - Remove Instructor\n " +
                    "3 - Remove Mechanical Engineer\n " +
                    "4 - Remove Admin\n " +
                    "Please enter your selection:");
            int caseID = scan.nextInt();
            switch (caseID) {
                case 1:
                    RemoveStudent(id);
                    break;
                case 2:
                    RemoveInstructor(id);
                    break;
                case 3:
                    RemoveMX(id);
                    break;
                case 4:
                    RemoveAdmin(id);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Admin menu to decide what the admin wants to do aircraft
     * @param id ID of Admin
     */
    public void ManageAircraft(int id){
        try {
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
                    AddAircraft(id);
                    break;
                case 2:
                    RemoveAircraft(id);
                    break;
                case 3:
                    System.out.println("Idk how we wanna edit aircraft");
                    EditAircraft(id);
                    break;
                case 4:
                    ViewAllAircraft();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Admin menu to decide what to do with Flights
     * @param id ID of admin
     */
    public void ManageFlight(int id){
        try {
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
                    AddFlight(id);
                    break;
                case 2:
                    RemoveFlight(id);
                    break;
                case 3:
                    System.out.println("Idk how we wanna edit flights");
                    EditFlight(id);
                    break;
                case 4:
                    ViewAllFlight();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void EditUser(int id){
        try {
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
                    EditStudent(id);
                    break;
                case 2:
                    EditInstructor(id);
                    break;
                case 3:
                    EditMX(id);
                    break;
                case 4:
                    EditAdmin(id);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Assign a instructor to teach a student
     */
    public void AssignTeaches() {
        try {
            System.out.println("Please enter the student ID");
            int sid = scan.nextInt();
            System.out.println("Please enter the instructor ID");
            int iid = scan.nextInt();
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
    public void ViewAllUsers() {
        try {
            CallableStatement cs = con.prepareCall("CALL SelectAllUsers");
            ResultSet allUsers = cs.executeQuery();
            while (allUsers.next()) {
                JSONObject jsonobj = new JSONObject("{\"user_id\":" + allUsers.getInt(1) + ", \"email\":" + allUsers.getString(2) +
                        ", \"user_first_name\":" + allUsers.getString(3) + ", \"user_last_name\":" + allUsers.getString(4) +
                        ", \"password\":" + allUsers.getString(5) + ", \"phone\":" + allUsers.getString(6) + "}");
                System.out.println(jsonobj); //send this to client
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds the user inputed student to the database
     */
    public void AddStudent(int id){
        try{
            scan.nextLine();
            System.out.println("Please enter the student email");
            String email = scan.nextLine();
            System.out.println("Please enter the student first name");
            String fname = scan.nextLine();
            System.out.println("Please enter the student lname");
            String lname = scan.nextLine();
            System.out.println("Please enter the student password");
            String pass = scan.nextLine();
            System.out.println("Please enter the student phone");
            String phone = scan.nextLine();
            System.out.println("Please enter the student Pilot License Number");
            String license = scan.nextLine();

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
    public void AddInstructor(int id){
        try {
            scan.nextLine();
            System.out.println("Please enter the instructor email");
            String email = scan.nextLine();
            System.out.println("Please enter the instructor first name");
            String fname = scan.nextLine();
            System.out.println("Please enter the instructor lname");
            String lname = scan.nextLine();
            System.out.println("Please enter the instructor password");
            String pass = scan.nextLine();
            System.out.println("Please enter the instructor phone");
            String phone = scan.nextLine();
            System.out.println("Please enter the instructor's Pilot License Number");
            String license = scan.nextLine();
            System.out.println("Please enter the instructor's Instructor Class");
            String iClass = scan.nextLine();

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
    public void AddMX(int id){
        try{
            scan.nextLine();
            System.out.println("Please enter the mechanical engineer email");
            String email = scan.nextLine();
            System.out.println("Please enter the mechanical engineer first name");
            String fname = scan.nextLine();
            System.out.println("Please enter the mechanical engineer lname");
            String lname = scan.nextLine();
            System.out.println("Please enter the mechanical engineer password");
            String pass = scan.nextLine();
            System.out.println("Please enter the mechanical engineer phone");
            String phone = scan.nextLine();
            System.out.println("Please enter the mechanical engineer's Engineer License Number");
            String license = scan.nextLine();
            System.out.println("Please enter the mechanical engineer's Rating");
            String rating = scan.nextLine();

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
    public void AddAdmin(int id){
        try{
            scan.nextLine();
            System.out.println("Please enter the admin email");
            String email = scan.nextLine();
            System.out.println("Please enter the admin engineer first name");
            String fname = scan.nextLine();
            System.out.println("Please enter the admin engineer lname");
            String lname = scan.nextLine();
            System.out.println("Please enter the admin engineer password");
            String pass = scan.nextLine();
            System.out.println("Please enter the admin engineer phone");
            String phone = scan.nextLine();
            System.out.println("Please enter the admin's role");
            String role = scan.nextLine();

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
    public void RemoveStudent(int id){
        try {
            System.out.println("Please enter the Student ID");
            int sid = scan.nextInt();
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
    public void RemoveInstructor(int id){
        try {
            System.out.println("Please enter the Instructor ID");
            int iid = scan.nextInt();
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
    public void RemoveMX(int id){
        try {
            System.out.println("Please enter the Mechanical Engineer ID");
            int mid = scan.nextInt();
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
    public void RemoveAdmin(int id){
        try {
            System.out.println("Please enter the Admin ID");
            int aid = scan.nextInt();
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
    public void EditStudent(int id){
        try {
            scan.nextLine();
            System.out.println("Please enter the student id");
            int sid = scan.nextInt();
            System.out.println("Please enter the student email");
            String email = scan.nextLine();
            System.out.println("Please enter the student first name");
            String fname = scan.nextLine();
            System.out.println("Please enter the student lname");
            String lname = scan.nextLine();
            System.out.println("Please enter the student password");
            String pass = scan.nextLine();
            System.out.println("Please enter the student phone");
            String phone = scan.nextLine();
            System.out.println("Please enter the student Pilot License Number");
            String license = scan.nextLine();

            CallableStatement cs = con.prepareCall("CALL EditStudent(?,?,?,?,?,?,?,?)");
            cs.setInt(1, sid);
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
    public void EditInstructor(int id){
        try {
            scan.nextLine();
            System.out.println("Please enter the instructor id");
            int iid = scan.nextInt();
            System.out.println("Please enter the instructor email");
            String email = scan.nextLine();
            System.out.println("Please enter the instructor first name");
            String fname = scan.nextLine();
            System.out.println("Please enter the instructor lname");
            String lname = scan.nextLine();
            System.out.println("Please enter the instructor password");
            String pass = scan.nextLine();
            System.out.println("Please enter the instructor phone");
            String phone = scan.nextLine();
            System.out.println("Please enter the instructor's Pilot License Number");
            String license = scan.nextLine();
            System.out.println("Please enter the instructor's Instructor Class");
            String iClass = scan.nextLine();

            CallableStatement cs = con.prepareCall("CALL EditInstructor(?,?,?,?,?,?,?,?,?)");
            cs.setInt(1,iid);
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
    public void EditMX(int id){
        try{
            scan.nextLine();
            System.out.println("Please enter the mechanical engineer id");
            int mid = scan.nextInt();
            System.out.println("Please enter the mechanical engineer email");
            String email = scan.nextLine();
            System.out.println("Please enter the mechanical engineer first name");
            String fname = scan.nextLine();
            System.out.println("Please enter the mechanical engineer lname");
            String lname = scan.nextLine();
            System.out.println("Please enter the mechanical engineer password");
            String pass = scan.nextLine();
            System.out.println("Please enter the mechanical engineer phone");
            String phone = scan.nextLine();
            System.out.println("Please enter the mechanical engineer's Engineer License Number");
            String license = scan.nextLine();
            System.out.println("Please enter the mechanical engineer's Rating");
            String rating = scan.nextLine();

            CallableStatement cs = con.prepareCall("CALL EditMX_Engineer(?,?,?,?,?,?,?,?,?)");
            cs.setInt(1,mid);
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
    public void EditAdmin(int id){
        try{
            scan.nextLine();
            System.out.println("Please enter the admin id");
            int aid = scan.nextInt();
            System.out.println("Please enter the admin email");
            String email = scan.nextLine();
            System.out.println("Please enter the admin engineer first name");
            String fname = scan.nextLine();
            System.out.println("Please enter the admin engineer lname");
            String lname = scan.nextLine();
            System.out.println("Please enter the admin engineer password");
            String pass = scan.nextLine();
            System.out.println("Please enter the admin engineer phone");
            String phone = scan.nextLine();
            System.out.println("Please enter the admin's role");
            String role = scan.nextLine();

            CallableStatement cs = con.prepareCall("CALL AddAdmin(?,?,?,?,?,?,?,?)");
            cs.setInt(1,aid);
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
    public void AddAircraft(int id){
        try {
            scan.nextLine();
            System.out.println("Please enter the aircraft registration");
            String reg = scan.nextLine();
            System.out.println("Please enter the aircraft type");
            String type = scan.nextLine();
            System.out.println("Please enter the aircraft serial number");
            String serial = scan.nextLine();

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
    public void RemoveAircraft(int id){
        try {
            System.out.println("Please enter the Aircraft ID");
            int aid = scan.nextInt();

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
    public void EditAircraft(int id){
        try {
            scan.nextLine();
            System.out.println("Please enter the aircraft id");
            int aid = scan.nextInt();
            System.out.println("Please enter the aircraft registration");
            String reg = scan.nextLine();
            System.out.println("Please enter the aircraft type");
            String type = scan.nextLine();
            System.out.println("Please enter the aircraft serial number");
            String serial = scan.nextLine();

            CallableStatement cs = con.prepareCall("CALL AddAircraft(?,?,?,?,?)");
            cs.setInt(1,aid);
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
    public void ViewAllAircraft(){
        try {
            CallableStatement cs4 = con.prepareCall("CALL SelectAllAircrafts");
            ResultSet allAircraft = cs4.executeQuery();
            while (allAircraft.next()) {
                JSONObject jsonobj = new JSONObject("{\"Aircraft_ID\":" + allAircraft.getInt(1) + ", \"Registration\":" +
                        allAircraft.getString(2) + ", \"Type\":" + allAircraft.getString(3) + "}");
                System.out.println(jsonobj); //send this to client
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Add user inputed flight to the database
     */
    public void AddFlight(int id){
        try {
            scan.nextLine();
            System.out.println("Please enter the flight's aircraft ID");
            int aid = scan.nextInt();
            System.out.println("Please enter the flight's student ID");
            int sid = scan.nextInt();
            System.out.println("Please enter the flight's instructor ID");
            int iid = scan.nextInt();
            System.out.println("Please enter the flight exercise");
            scan.nextLine();
            String ex = scan.nextLine();
            //System.out.println("Please enter the flight scheduled start time in DATETIME format");
            //String start = scan.nextLine();
            //System.out.println("Please enter the flight scheduled end time in DATETIME format");
            //String end = scan.nextLine();

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
                CallableStatement cs = con.prepareCall("CALL AddFlight(?,?,?,?,?,?,?)");
                cs.setInt(1, aid);
                cs.setInt(2, sid);
                cs.setInt(3, iid);
                cs.setString(4, ex);
                cs.setString(5, start);
                cs.setString(6, end);
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
    public void RemoveFlight(int id){
        try {
            System.out.println("Please enter the Flight ID");
            int fid = scan.nextInt();
            System.out.println("Please enter the Aircraft ID");
            int aid2 = scan.nextInt();

            CallableStatement cs2 = con.prepareCall("CALL DeleteFlight(?,?,?)");
            cs2.setInt(1, fid);
            cs2.setInt(2, aid2);
            cs2.setInt(3,id);
            cs2.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to delete Flight");
            System.out.println(e);
        }
    }

    /**
     * Edit desired flight from the database
     */
    public void EditFlight(int id){
        try {
            scan.nextLine();
            System.out.println("Please enter the flight's id");
            int fid = scan.nextInt();
            System.out.println("Please enter the flight's aircraft ID");
            int aid = scan.nextInt();
            System.out.println("Please enter the flight's student ID");
            int sid = scan.nextInt();
            System.out.println("Please enter the flight's instructor ID");
            int iid = scan.nextInt();
            System.out.println("Please enter the flight exercise");
            String ex = scan.nextLine();
            System.out.println("Please enter the flight scheduled start time in DATETIME format");
            String start = scan.nextLine();
            System.out.println("Please enter the flight scheduled end time in DATETIME format");
            String end = scan.nextLine();

            System.out.println("\n!!!!!!!!!!!We need to implement a check here for conflicting times in the Aircraft schedule!!!!!!!!!!!\n");

            CallableStatement cs = con.prepareCall("CALL AddFlight(?,?,?,?,?,?,?,?)");
            cs.setInt(1,fid);
            cs.setInt(2, aid);
            cs.setInt(3, sid);
            cs.setInt(4, iid);
            cs.setString(5, ex);
            cs.setString(6, start);
            cs.setString(7, end);
            cs.setInt(8,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * View all flights
     */
    public void ViewAllFlight(){
        try {
            CallableStatement cs4 = con.prepareCall("CALL SelectAllFlights");
            ResultSet allFlights = cs4.executeQuery();
            while (allFlights.next()) {
                String start = allFlights.getObject(6, LocalDateTime.class).toString();
                String end = allFlights.getObject(7, LocalDateTime.class).toString();
                JSONObject jsonobj = new JSONObject("{\"FlightID\":" + allFlights.getInt(1) + ", \"Aircraft_id\":" +
                        allFlights.getInt(2) + ", \"Student_id\":" + allFlights.getInt(3) + ", \"Instructor_id\":" +
                        allFlights.getInt(4) + ", \"Exercise\":" + allFlights.getString(5) + ", \"Flight_start\":" +
                        "'" + start + "'" + ", \"Flight_end\":" + "'" + end + "'" + "}");
                System.out.println(jsonobj); //send this to client
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
