// basic file operations
#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <sstream>
using namespace std;

void write(string line) {
    ofstream myfile;
    myfile.open("synthetic_data.sql");
    myfile << line << "\n";
    myfile.close();
}
string itos(int in) {
    string Result;
    ostringstream convert;
    convert << in;
    return convert.str();
}

void Student(int uin, string name, string major, int advisor) {
    string uin_s = itos(uin);
    string adv_s = itos(advisor);
    string statement = "INSERT INTO Student (`UIN`, `Name`, `Major`, `Advisor`) VALUES (";
    statement += uin_s + ", '" + name + "', '" + major + "', " + adv_s + ");";
    write(statement);
}
void Course(string subj, int courseNumber, int hours, string title) {
    string crn_s = itos(courseNumber);
    string hrs_s = itos(hours);
    string statement = "INSERT INTO Course (`Subject`, `CourseNumber`, `Hours`, `Title`) VALUES (";
    statement += "'" + subj + "', " + crn_s + ", " + hrs_s + ", '" + title + "');";
    write(statement);
}
void EnrolledIn(string semester, string classSubj, int classNum, int uin, string grade) {
    string clsn_s = itos(classNum);
    string uin_s = itos(uin);
    string statement = "INSERT INTO EnrolledIn (`Semester`, `ClassSubject`, `ClassNumber`, `UIN`, `Grade`) VALUES (";
    statement += "'" + semester + "', '" + classSubj + "', " + clsn_s + ", " + uin_s + ", '" + grade + "');";
    write(statement);
}
void Faculty(int facultyID, string name, int salary) {
    string fctid_s = itos(facultyID);
    string sal_s = itos(salary);
    string statement = "INSERT INTO Faculty (`FacultyID`, `Name`, `Salary`) VALUES (";
    statement += fctid_s + ", '" + name + "', " + sal_s + ");";
    write(statement);
}
void Teaches(string subject, int courseNumber, int facultyID, string semester) {
    string crn_s = itos(courseNumber);
    string fctid_s = itos(facultyID);
    string statement = "INSERT INTO Teaches (`Subject`, `CourseNumber`, `FacultyID`, `Semester`) VALUES (";
    statement += "'" + subject + "', " + crn_s + ", " + fctid_s + ", '" + semester + "');";
    write(statement);
}
void StudentOrganization(int studentOrgID, string name, string category) {
    string soi_s = itos(studentOrgID);
    string statement = "INSERT INTO StudentOrganization (`StudentOrganizationID`, `Name`, `Category`) VALUES (";
    statement += soi_s + ", '" + name + "', '" + category + "');";
    write(statement);
}
void MemberOf(int uin, int studentOrgID, string joined) {
    string uin_s = itos(uin);
    string soi_s = itos(studentOrgID);
    string statement = "INSERT INTO MemberOf (`UIN`, `StudentOrganizationID`, `Joined`) VALUES (";
    statement += uin_s + ", " + soi_s + ", '" + joined + "');";
    write(statement);
}
void Leads(int facultyID, int studentOrgID, string joined) {
    string fid_s = itos(facultyID);
    string soi_s = itos(studentOrgID);
    string statement = "INSERT INTO Leads (`FacultyID`, `StudentOrganizationID`, `Joined`) VALUES (";
    statement += fid_s + ", " + soi_s + ", '" + joined + "');";
    write(statement);
}

int main() {
    return 0;
}
