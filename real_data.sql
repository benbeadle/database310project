INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (412783520, "Ben Beadle", "English", 220);
INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (419006061, "Ana Parra", "Math", 125);
INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (427893426, "Alek Poteet", "International Studies", 132);
INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (227147356, "Amanda Cofsky", "English", 220);
INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (987654567, "Kimberly Lewis", "Kinesology", 210);
INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (127654832, "Mathew McFadden", "Accounting", 305);
INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (654312391, "Patrick Cumming", "Math", 125);
INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (423732855, "Paul Hagseth", "Kinesology", 210);
INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (293466365, "Blake Pavel", "International Studies", 132);
INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (888765234, "Nick Melynk", "Math", 125);
INSERT INTO Course (`Subject`, `CourseNumber`, `Hours`, `Title`) VALUES ("MATH", 151, 4, "Enginerring Math");
INSERT INTO Course (`Subject`, `CourseNumber`, `Hours`, `Title`) VALUES ("HIST", 104, 3, "Government");
INSERT INTO Course (`Subject`, `CourseNumber`, `Hours`, `Title`) VALUES ("ENGL", 101, 4, "College level English");
INSERT INTO Course (`Subject`, `CourseNumber`, `Hours`, `Title`) VALUES ("ARTS", 111, 3, "Fine Arts");
INSERT INTO Course (`Subject`, `CourseNumber`, `Hours`, `Title`) VALUES ("CHEM", 102, 4, "Chemistry 2");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "MATH", 151, 419006061, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "MATH", 151, 412783520, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "MATH", 151, 987654567, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "MATH", 151, 654312391, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "MATH", 151, 227147356, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "MATH", 151, 888765234, "C");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "MATH", 151, 423732855, "C");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "HIST", 104, 127654832, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "HIST", 104, 987654567, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "HIST", 104, 423732855, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "HIST", 104, 427893426, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "HIST", 104, 412783520, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ENGL", 101, 412783520, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ENGL", 101, 127654832, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ENGL", 101, 888765234, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ENGL", 101, 987654567, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ENGL", 101, 293466365, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ENGL", 101, 427893426, "C");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ENGL", 101, 423732855, "C");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ENGL", 101, 654312391, "C");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ARTS", 111, 427893426, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ARTS", 111, 127654832, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "ARTS", 111, 987654567, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "CHEM", 102, 419006061, "A");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "CHEM", 102, 293466365, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "CHEM", 102, 888765234, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "CHEM", 102, 227147356, "B");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "CHEM", 102, 423732855, "C");
INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES ("SP13", "CHEM", 102, 654312391, "C");
INSERT INTO Faculty (`FacultyID`, `Name`, `Salary`) VALUES (125, "Radu Stoleru", 50000);
INSERT INTO Faculty (`FacultyID`, `Name`, `Salary`) VALUES (220, "John Keyser", 47000);
INSERT INTO Faculty (`FacultyID`, `Name`, `Salary`) VALUES (132, "Adam Thomas", 51000);
INSERT INTO Faculty (`FacultyID`, `Name`, `Salary`) VALUES (210, "James Caverlee", 52500);
INSERT INTO Faculty (`FacultyID`, `Name`, `Salary`) VALUES (305, "Jennifer Welch", 49000);
INSERT INTO Teaches (`Subject`, `CourseNumber`, `FacultyID`, `Semester`) VALUES ("Math", 151, 305, "SP13");
INSERT INTO Teaches (`Subject`, `CourseNumber`, `FacultyID`, `Semester`) VALUES ("Hist", 104, 132, "SP13");
INSERT INTO Teaches (`Subject`, `CourseNumber`, `FacultyID`, `Semester`) VALUES ("Engl", 101, 210, "SP13");
INSERT INTO Teaches (`Subject`, `CourseNumber`, `FacultyID`, `Semester`) VALUES ("Arts", 111, 125, "SP13");
INSERT INTO Teaches (`Subject`, `CourseNumber`, `FacultyID`, `Semester`) VALUES ("Chem", 102, 220, "SP13");
INSERT INTO StudentOrganization (`StudentOrganizationID`, `Name`, `Category`) VALUES (23450, "Texas Aggie Traditions", "School Related");
INSERT INTO StudentOrganization (`StudentOrganizationID`, `Name`, `Category`) VALUES (79549, "Aggie Swamp", "Theather & Entertainment");
INSERT INTO StudentOrganization (`StudentOrganizationID`, `Name`, `Category`) VALUES (33657, "Math Nerds", "Major Related");
INSERT INTO StudentOrganization (`StudentOrganizationID`, `Name`, `Category`) VALUES (76539, "Ultimate Frisbee", "Sports");
INSERT INTO StudentOrganization (`StudentOrganizationID`, `Name`, `Category`) VALUES (18390, "Texas A&M Swimming", "Sports");
INSERT INTO MemberOf (`UIN`, `StudentOrganizationID`, `Joined`) VALUES (419006061, 79549, "2013-02-13");
INSERT INTO MemberOf (`UIN`, `StudentOrganizationID`, `Joined`) VALUES (427893426, 23450, "2013-03-20");
INSERT INTO MemberOf (`UIN`, `StudentOrganizationID`, `Joined`) VALUES (127654832, 33657, "2013-01-16");
INSERT INTO MemberOf (`UIN`, `StudentOrganizationID`, `Joined`) VALUES (227147356, 18390, "2012-03-10");
INSERT INTO MemberOf (`UIN`, `StudentOrganizationID`, `Joined`) VALUES (888765234, 23450, "2012-09-10");
INSERT INTO MemberOf (`UIN`, `StudentOrganizationID`, `Joined`) VALUES (293466365, 76539, "2012-11-04");
INSERT INTO MemberOf (`UIN`, `StudentOrganizationID`, `Joined`) VALUES (654312391, 79549, "2012-10-22");
INSERT INTO Leads (`FacultyID`, `StudentOrganizationID`, `Joined`) VALUES (305, 23450, "2010-05-11");
INSERT INTO Leads (`FacultyID`, `StudentOrganizationID`, `Joined`) VALUES (210, 79549, "2010-02-21");
INSERT INTO Leads (`FacultyID`, `StudentOrganizationID`, `Joined`) VALUES (132, 33657, "2011-10-28");
INSERT INTO Leads (`FacultyID`, `StudentOrganizationID`, `Joined`) VALUES (220, 76539, "2009-07-01");
INSERT INTO Leads (`FacultyID`, `StudentOrganizationID`, `Joined`) VALUES (125, 18390, "2009-08-22");