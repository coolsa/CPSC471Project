package server.database;

import java.sql.Connection;
import java.util.Scanner;

public class StudentMenu {

    private Connection con;
    private Scanner scan;

    StudentMenu(Connection con, Scanner scan){
        this.con = con;
        this.scan = scan;
    }
}
