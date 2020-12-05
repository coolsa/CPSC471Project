package server.database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class StudentMenu {

    private Connection con;
    private Scanner scan;

    StudentMenu(Connection con, Scanner scan){
        this.con = con;
        this.scan = scan;
    }

    void studentPortal(int id){
        try {
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            boolean loop = true;
            while(loop) {
                System.out.println("\nWelcome to the admin portal\n" +
                        "Menu Options:\n " +
                        "1 - View Student Schedule\n " +
                        "2 - View Student Profile\n " +
                        "3 - Book My Flight\n " +
                        "4 - Cancel My Flight\n " +
                        "5 - View Assigned Instructors\n " +
                        "6 - Exit\n" +
                        "Please enter your selection:");
                int caseID = scan.nextInt();
                switch (caseID) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        break;
                    case 6:
                        loop = false;
                        break;

                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("Bye Admin");
    }
}
