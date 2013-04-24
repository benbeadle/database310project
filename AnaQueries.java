//The Select query 
public static void selectStatement(Connection conn){ 
	Statement s = conn.createStatement(); 
 	System.out.print("This query will show all of the organizations and their leaders if they have any.\n");

	s.executeQuery ("SELECT Faculty.FacultyID, Faculty.Name AS "Leader Name", StudentOrganization.StudentOrganizationID, StudentOrganization.Name AS "Organization", Category FROM Faculty RIGHT JOIN(StudentOrganization LEFT JOIN Leads ON Leads.StudentOrganizationID = StudentOrganization.StudentOrganizationID) ON Faculty.FacultyID = Leads.FacultyID");
	ResultSet rs = s.getResultSet ();
	while (rs.next ())
	{
	   int idVal = rs.getInt ("Faculty.FacultyID");
	   String nameVal = rs.getString ("Faculty.Name");
	   System.out.println (
			   "id = " + idVal
			   + ", name = " + nameVal);
	}
	rs.close ();
	s.close ();
}
   
//Drop a student from an organization
public static void dropStudent(Connection conn){
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
	
	System.out.print("Type in the ogranization ID that you want to select:\n");
	String organizationID = scanner.nextLine();
	
	//For testing purposes to check that it prints what you entered.
	System.out.print(organizationID);
	
	System.out.print("\nYou selected the organization with this id:" + organizationID + ".\n");
	System.out.print("Below are the current members for said organization and their perspective UINs\n");
	
	// Now, I'm printing the current members of organization they selected.
	// I ran the query through PHPMyAdmin and it ran successfully
	s.executeQuery ("SELECT Student.Name, Student.UIN FROM Student, MemberOf WHERE MemberOf.StudentOrganizationID = " + organizationID +" AND Student.UIN = MemberOf.UIN");
	ResultSet rs = s.getResultSet ();
	while (rs.next ())
	{
	   String nameVal = rs.getString ("Student.Name");
	   int idVal = rs.getInt ("Student.UIN");
	   System.out.println (
			   "Student = " + nameVal
			   + ", UIN = " + idVal);
	}
	rs.close ();	
	
	System.out.print("\nType in the student UIN that you want to delete from the orgnanization:\n");
	String studentUIN = scanner.nextLine();
	
	System.out.print(studentUIN);
	
	System.out.print("\nCreating the statement...\n");

	String sqlStatment = "DELETE FROM StudentOrganization WHERE UIN=" + studentUIN + " AND StudentOrganizationID =" + organizationID;
	s.executeUpdate(sqlStatment);

	System.out.print("\nBelow is the organization you initally selectd and the current members.\n");
	//Now, Let's see the results. We're printing out the members of the organization selected.	
	s.executeQuery ("SELECT Student.Name, Student.UIN FROM Student, MemberOf WHERE MemberOf.StudentOrganizationID = " + organizationID +" AND Student.UIN = MemberOf.UIN");
	ResultSet rs = s.getResultSet ();
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