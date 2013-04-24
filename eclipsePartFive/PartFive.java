import java.sql.*;
import java.util.Scanner;

public class PartFive
{
	public static void one(Connection conn) {
		System.out.println("one");
	}
	public static void two(Connection conn) {
		
	}
	public static void three(Connection conn) {
		
	}
	public static void four(Connection conn) {
		
	}
	public static void five(Connection conn) {
		
	}
	
	
	
	public static void main (String[] args)
	{
	   System.out.println("Welcome to our application created by Ben Beadle, Ana Parra, Alek Poteet.");
	   System.out.println("Connecting to database.");
	   
	   //Connect to the database
	   Connection conn = null;
	   try
	   {
	       String userName = "csce310user";
	       String password = "csce310pass";
	       String url = "jdbc:mysql://mysql.benbeadle.com/";
	       
	       Class.forName ("com.mysql.jdbc.Driver").newInstance();
	       conn = DriverManager.getConnection(url, userName, password);
	       System.out.println ("Database connection established");
	   }
	   catch (Exception e)
	   {
	       System.err.println ("Cannot connect to database server: " + e.getMessage());
	       System.out.println("Exiting.");
	       System.exit(0);
	   }
	   
	   System.out.println("Successfully connected to database.");
	   
	   //Keep looping until the user wants to quit
	   boolean keepGoing = true;
	   Scanner inputer = new Scanner(System.in);
	   while(keepGoing) {
		   System.out.println("1. List all organizations and their corresponding students.");
		   System.out.println("2. Figure out who a student's advisor is.");
		   System.out.println("3. Remove a student from a class.");
		   System.out.println("4. Alter all faculty's salary by a certain percentage.");
		   System.out.println("5. Add a student to the database.");
		   System.out.println("6. Quit application.");
		   
		   
		   System.out.print("Please enter an option: ");
		   
		   //Get the input and execute accordingly
		   int in = inputer.nextInt();
		   switch(in) {
			   case 1: one(conn); 			break;
			   case 2: two(conn); 			break;
			   case 3: three(conn); 		break;
			   case 4: four(conn); 			break;
			   case 5: five(conn); 			break;
			   case 6: keepGoing = false; 	break;
		   }
	   }

	   //Close the inputer and the connection
	   inputer.close();
	   System.out.println("Thanks for using our program! Goodbye!");
	   
	   if (conn != null)
	   {
	       try
	       {
	           conn.close ();
	       }
	       catch (Exception e) { /* ignore close errors */ }
	   }
	}
}