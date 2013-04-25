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
		Statement s = conn.createStatement();

		s.executeQuery ("SELECT Student.Name, Faculty.Name AS Advisor FROM Student, Faculty WHERE Student.Advisor=Faculty.FacultyID");
		ResultSet rs = s.getResultSet();
		while (rs.next ())
		{
		   System.out.println (
				   rs.getString("Student.Name")
				   + "'s advisor is '" + rs.getString("Advisor") + "'");
		}
		rs.close ();
		s.close ();
	}
	public static void three(Connection conn) throws SQLException {
		Statement s = conn.createStatement ();
		Scanner scanner = new Scanner( System.in );
		System.out.print("You're going to be removing a student from an organization.\n");
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
		String percentage = "0";
		String facultyid = "-1";
		String upperfacultyid = "-1";
		int option = 0;
		
       try
       {
			//Get desired action and parameters
    	   Scanner input = new Scanner(System.in);

			System.out.println("Options:\n	1:  Alter salary of a specific faculty id\n	2:  Alter salary of a specific range of faculty ids\n	3:  Give a sweeping raise/cut to all faculty");
			option = input.nextInt();
			if(option == 1){
				System.out.println("Enter ID of faculty member");
				facultyid = input.next();
			}else if(option == 2){
				System.out.println("Enter lower bounding ID");
				facultyid = input.next();
				System.out.println("Enter upper bounding ID");
				upperfacultyid = input.next();
			}else if(option > 3){
				System.out.println("Invalid option");
				return;
			}
			
			System.out.println("Enter percentage change salary by");
			percentage = input.next();
			percentage = percentage.replace("%", "");
			
			//Assemble the SQL command
			PreparedStatement s;
			if(option == 1){
				s = conn.prepareStatement("UPDATE Faculty SET Salary = (Salary + Salary * ? / 100) WHERE FacultyID = ?");
				s.setInt(2, Integer.parseInt(facultyid));
			}else if(option == 2){
				s = conn.prepareStatement("UPDATE Faculty SET Salary = (Salary + Salary * ? / 100) WHERE FacultyID >= ? AND FacultyID <= ?");
				s.setInt(2, Integer.parseInt(facultyid));
				s.setInt(3, Integer.parseInt(upperfacultyid));
			}else{
				s = conn.prepareStatement("UPDATE Faculty SET Salary = (Salary + Salary * ? / 100)");
			}
			
			int modCount = 0;
			s.setString(1, percentage);
			modCount = s.executeUpdate();	//execute the command and find how many rows were altered
			s.close();
			
			//instruct the user of success or failure
			if(modCount == 0)
				System.out.println("No faculty found with that id");
			else
				System.out.println(modCount + " row(s) modified");

			input.close();
       }
       catch (SQLException sql){
    	   System.err.println(sql.getSQLState());
    	   
       }
       catch (Exception e)
       {
           System.err.println ("Some random error occured");
       }
	}
	public static void five(Connection conn) throws SQLException {
		int UIN;
		String student;
		String major;
			
		
		try{
			//Get the student's information from the user
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the name of the student you wish to add");
			student = input.nextLine();
			System.out.println("What is the student's major?");
			major = input.next();
						
			//Assigne the student's UIN
			PreparedStatement s;
			s = conn.prepareStatement("SELECT MAX(UIN) AS UIN FROM Student");
			s.execute();
			ResultSet results = s.getResultSet();
			results.next();
			UIN = results.getInt("UIN");
			UIN++;							//increment the UIN to get the next student's id;
			System.out.println(student + " has been assigned UIN " + UIN);
			
			int advisorid;
			String advisor;	
			//Choose an advisor for the student
			s = conn.prepareStatement("SELECT FacultyID FROM Teaches WHERE Subject = '" + major + "' ORDER BY RAND() LIMIT 1");
			s.execute();
			results = s.getResultSet();
			results.next();
			advisorid = results.getInt("FacultyID");
			
			//Fetch the name of the advisor, for our own knowledge
			s = conn.prepareStatement("SELECT Name FROM Faculty WHERE FacultyID = " + advisorid);
			s.execute();
			results = s.getResultSet();
			results.next();
			advisor = results.getString("Name");
			System.out.println(student + " has been assigned" + advisor + " as an advisor");
			
			//Actually insert the student into the system
			s = conn.prepareStatement("INSERT INTO Student VALUES (" + UIN + ", '" + student + "', '" + major +  "', " + advisorid  + ")");
			
			s.execute();
			
			results.close();
			s.close();
		}
		catch (SQLException sql){
			System.err.println(sql.getSQLState());
	    }
		catch(Exception e)
		{
			System.err.println("Some problem occured");
		}
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
		   System.out.println("1. List all organizations and their corresponding leaders.");
		   System.out.println("2. List all student's and their Advisor's name.");
		   System.out.println("3. Remove a student from a class.");
		   System.out.println("4. Alter all faculty's salary by a certain percentage.");
		   System.out.println("5. Add a student to the database.");
		   System.out.println("6. Quit application.");
		   
		   
		   System.out.print("Please enter an option: ");
		   
		   //Get the input and execute accordingly
		   String in = inputer.nextLine();
		   try {
			   switch(in) {
				   case "1": one(conn);				break;
				   case "2": two(conn); 			break;
				   case "3": three(conn); 			break;
				   case "4": four(conn); 			break;
				   case "5": five(conn); 			break;
				   case "6": keepGoing = false; 	break;
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