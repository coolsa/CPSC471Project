package server.database;

import java.sql.Connection;
import java.util.Scanner;

public class MXMenu {

    private Connection con;
    private Scanner scan;

    MXMenu(Connection con, Scanner scan){
        this.con = con;
        this.scan = scan;
    }
}
