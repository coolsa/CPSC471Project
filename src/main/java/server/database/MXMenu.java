package server.database;

import org.json.JSONObject;
import org.openapitools.model.Flight;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

import static java.nio.file.attribute.AclEntryPermission.DELETE;

public class MXMenu {

    private Connection con;

    //Constructor
    public MXMenu(Connection con) {
        this.con = con;
    }

    /**
     * Allows mechanical engineers to cancel a flight
     */
    public void CancelFlight(int fid, int id){
        try {
        	CallableStatement cs2 = con.prepareCall("CALL SelectFlight(?)");
        	cs2.setInt(1, fid);
        	ResultSet rs = cs2.executeQuery();
        	
            CallableStatement cs = con.prepareCall("CALL CancelMXFlight(?,?,?)");
            cs.setInt(1, fid);
            cs.setInt(2, rs.getInt(2));
            cs.setInt(3,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to cancel flight");
            System.out.println(e);
        }
    }

    /**
     * Allows mechanical engineers to modify the time of a flight
     */
    public void ModifyFlight(Flight flight, int id){
        try {
            int fid = flight.getFlightId().intValue();
            int aid = flight.getAircraftId().getId().intValue();
            LocalDateTime start = flight.getFlightStart().toLocalDateTime();
            LocalDateTime end = flight.getFlightEnd().toLocalDateTime();
            
            CallableStatement cs = con.prepareCall("CALL ModifyMXFlight(?,?,?,?,?)");
            cs.setInt(1, fid);
            cs.setInt(2, aid);
            cs.setString(3,start.toString());
            cs.setString(4,end.toString());
            cs.setInt(5,id);
            cs.executeUpdate();
        }catch(Exception e){
            System.out.println("Unable to cancel flight");
            System.out.println(e);
        }
    }
}


