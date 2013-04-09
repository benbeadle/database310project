/*A Student who must be EnrolledIn >=1 Course. A student must have one advisor in FacultyID*/
CREATE TABLE Student (
    UIN INT,
    Name VARCHAR(25),
    Major VARCHAR(25),
    Advisor INT,        /* Foreign key FacultyID in Table Faculty */
    PRIMARY KEY(UIN)
);

/* A Course that >=1 Student(s) are EnrolledIn*/
CREATE TABLE Course (
    Subject CHAR(4),
    CourseNumber INT,
    Hours INT,
    Title CHAR(25),
    PRIMARY KEY(Subject, CourseNumber)
);

/*A Student who is enrolled in a Course for a certain semester*/
CREATE TABLE EnrolledIn (
    Semester CHAR(6),
    ClassSubject CHAR(4),
    ClassNumber INT,
    UIN INT,
    Grade CHAR(1),
    PRIMARY KEY(Semester, ClassSubject, ClassNumber, UIN)
);

/*A member of the faculty who Leads >=0 StudentOrganization and can teach >=0 Class*/
CREATE TABLE Faculty (
    FacultyID INT,
    Name CHAR(20),
    Salary INT,
    PRIMARY KEY(FacultyID)
);

/*A Faculty who Teaches a Course. A course must have one Faculty per semester*/
CREATE TABLE Teaches (
    Subject CHAR(4),
    CourseNumber INT,
    FacultyID INT,
    Semester CHAR(6),
    PRIMARY KEY(Subject, CourseNumber, Semester)
);

/*Represents an organization that >1 Student must be a MemberOf and 0 or 1 Faculty Leads*/
CREATE TABLE StudentOrganization (
    StudentOrganizationID INT,
    Name CHAR(30),
    Category CHAR(30),
    PRIMARY KEY(StudentOrganizationID)
);

/*The connection that a Student is a MemberOf a StudentOrganization */
CREATE TABLE MemberOf (
    UIN INT,
    StudentOrganizationID INT,
    Joined Date,
    PRIMARY KEY(UIN, StudentOrganizationID)
);
/*The connection that a Faculty Leads a StudentOrganization*/
CREATE TABLE Leads (
    FacultyID INT,
    StudentOrganizationID INT,
    Joined Date,
    PRIMARY KEY(FacultyID, StudentOrganizationID)
);
