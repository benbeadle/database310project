#include <iostream>
#include "recordGenerator.h"
#include "tableInsertMethods.h"


int main(){
	srand(time(0));
	cout<<"Generating records..."<<endl;

	int facultyCount = rand() % 2000 + 1000;	//average 2000 faculty
	int studentCount = facultyCount * 5 + rand() % 1000 - rand() % 1000;	//average 10k students
	int organizationCount = studentCount / 25 + rand() % 200 - rand() % 200;//average 400 organizations
	int courseCount = facultyCount / 5;			//average 400 courses offered

	cout<<facultyCount<<"  Faculty\n"<<studentCount<<"  Students \n"<<organizationCount<<"  Groups\n"<<courseCount<<"  Courses\n";

	//create our base objects for the university
	for(int i = 0; i < facultyCount; i++){
		faculty.push_back(Faculty());
	}
	for(int i = 0; i < studentCount; i++){
		students.push_back(Student());
	}
	for(int i = 0; i < organizationCount; i++){
		organizations.push_back(Organization());
	}
	for(int i = 0; i < courseCount; i++){
		//Class newCourse();

		courses.push_back(Class());
	}

	//create relations between these base objects (a.k.a the hard part).  I have a better way, but here is my prototypical setup
	for(int i = 0; i < 4 * studentCount; i++){
		enrollment.push_back(EnrolledIn());				//4 courses per student on average
		if(i % 4 == 0) membership.push_back(MemberOf());	//1 membership per student on average
	}
	for(int i = 0; i < courseCount; i++){
		instruction.push_back(Teaches());
		
	}
	for(int i = 0; i < rand() % facultyCount/2; i++){
		leadership.push_back(Leads());
	}

	cout<<"Done"<<endl;
	cout<<"Writing data to file...\n"<<endl;
	openFile();

	for(int i = 0; i < facultyCount; i++){
		writeFaculty(faculty[i].ID, faculty[i].name, faculty[i].salary);
	}
	for(int i = 0; i < studentCount; i++){
		writeStudent(students[i].UIN, students[i].name, students[i].major, students[i].advisorID);
	}
	for(int i = 0; i < organizationCount; i++){
		writeStudentOrganization(organizations[i].ID, organizations[i].name, organizations[i].category);
	}
	for(int i = 0; i < courseCount; i++){
		writeCourse(courses[i].subject, courses[i].number, courses[i].hours, courses[i].title);
	}


	closeFile();
	cout<<"Done"<<endl;
	cin.get();
}
