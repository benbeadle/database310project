import java.sql.*;
import java.util.Scanner;

public class PartFive
{
	public static void one(Connection conn) throws SQLException {
		Statement s = conn.createStatement(); 
	 	System.out.println("This query will show all of the organizations and their leaders if they have any.");

		s.executeQuery ("SELECT Faculty.FacultyID, Faculty.Name AS LeaderName, " +
				"StudentOrganization.StudentOrganizationID, StudentOrganization.Name AS Organization" + 
				", Category FROM Faculty RIGHT JOIN(StudentOrganization LEFT JOIN Leads ON Leads.StudentOrganizationID" +
				"= StudentOrganization.StudentOrganizationID) ON Faculty.FacultyID = Leads.FacultyID");
		ResultSet rs = s.getResultSet();
		while (rs.next ())
		{
		   int idVal = rs.getInt ("Faculty.FacultyID");
		   String nameVal = rs.getString ("LeaderName");
		   System.out.println (
				   "Organization '" + rs.getString("Organization")
				   + "' with leader '" + rs.getString("LeaderName") + "'");
		}
		rs.close ();
		s.close ();
	}
	public static void two(Connection conn) throws SQLException {
		
	}
	public static void three(Connection conn) throws SQLException {
		Statement s = conn.createStatement ();
		Scanner scanner = new Scanner( System.in );
		System.out.print("You're going to be removing a studet from an organization.\n");
		System.out.print("Below are the current organizations and their perspective ids.\n");

		//Printing current organizations they selected assuming this works
		s.executeQuery ("SELECT Name, StudentOrganizationID FROM StudentOrganization");
		ResultSet rs = s.getResultSet ();
		while (rs.next ())
		{
		   String nameVal = rs.getString ("Name");
		   int idVal = rs.getInt ("StudentOrganizationID");
		   System.out.println (
				   "Organization Name = " + nameVal
				   + ", ID = " + idVal);
		}
		rs.close ();
		
		System.out.print("Type in the ogranization ID that you want to select: ");
		String organizationID = scanner.nextLine();
		
		//For testing purposes to check that it prints what you entered.
		System.out.print(organizationID);
		
		System.out.print("\nYou selected the organization with this id:" + organizationID + ".\n");
		System.out.print("Below are the current members for said organization and their perspective UINs\n");
		
		// Now, I'm printing the current members of organization they selected.
		// I ran the query through PHPMyAdmin and it ran successfully
		s.executeQuery ("SELECT Student.Name, Student.UIN FROM Student, MemberOf WHERE MemberOf.StudentOrganizationID = " + organizationID +" AND Student.UIN = MemberOf.UIN");
		rs = s.getResultSet ();
		while (rs.next ())
		{
		   String nameVal = rs.getString ("Student.Name");
		   int idVal = rs.getInt ("Student.UIN");
		   System.out.println (
				   "Student = " + nameVal
				   + ", UIN = " + idVal);
		}
		rs.close ();	
		
		System.out.print("\nType in the student UIN that you want to delete from the orgnanization: ");
		String studentUIN = scanner.nextLine();
		
		System.out.print(studentUIN);
		
		System.out.print("\nCreating the statement...\n");

		String sqlStatment = "DELETE FROM MemberOf WHERE UIN=" + studentUIN + " AND StudentOrganizationID =" + organizationID;
		s.executeUpdate(sqlStatment);

		System.out.print("\nBelow is the organization you initally selectd and the current members.\n");
		//Now, Let's see the results. We're printing out the members of the organization selected.	
		s.executeQuery ("SELECT Student.Name, Student.UIN FROM Student, MemberOf WHERE MemberOf.StudentOrganizationID = " + organizationID +" AND Student.UIN = MemberOf.UIN");
		rs = s.getResultSet ();
		while (rs.next ())
		{
		   String nameVal = rs.getString ("Student.Name");
		   int idVal = rs.getInt ("Student.UIN");
		   System.out.println (
				   "Student = " + nameVal
				   + ", UIN = " + idVal);
		}
		rs.close ();	
		
		s.close ();
		scanner.close();
	}
	public static void four(Connection conn) throws SQLException {
		
	}
	public static void five(Connection conn) throws SQLException {
		
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
	       String url = "jdbc:mysql://mysql.benbeadle.com/csce310project";
	       
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
		   try {
			   switch(in) {
				   case 1: one(conn);			break;
				   case 2: two(conn); 			break;
				   case 3: three(conn); 		break;
				   case 4: four(conn); 			break;
				   case 5: five(conn); 			break;
				   case 6: keepGoing = false; 	break;
			   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("There was an error in the SQL Statement.");
				e.printStackTrace();
				System.exit(0);
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