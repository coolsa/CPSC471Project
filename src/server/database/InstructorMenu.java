package server.database;

import java.sql.Connection;
import java.util.Scanner;

public class InstructorMenu {

    private Connection con;
    private Scanner scan;

    InstructorMenu(Connection con, Scanner scan){
        this.con = con;
        this.scan = scan;
    }
}
