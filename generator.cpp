/*#include <unordered_set>
#include "recordGenerator.h"
//#include "tableInsertMethods.h"


int main(){
	srand(time(0));

	int facultyCount = rand() % 1200 + 500;	//average 2500 faculty	-- i have to cut all these down because phpmyadmin limits the filesize
	int studentCount = facultyCount * 5 + rand() % 1000 - rand() % 1000;	//average 12.5k students
	int organizationCount = studentCount / 25 + rand() % 200 - rand() % 200;//average 500 organizations
	int courseCount = facultyCount / 5;			//average 500 courses offered

	cout<<facultyCount<<"  Faculty\n"<<studentCount<<"  Students \n"<<organizationCount<<"  Groups\n"<<courseCount<<"  Courses\n";

	//create our base objects for the university
	cout<<"Hiring Faculty..."<<endl;
	for(int i = 0; i < facultyCount; i++){
		faculty.push_back(Faculty());
	}
	cout<<"Accepting Student Applications..."<<endl;
	for(int i = 0; i < studentCount; i++){
		students.push_back(Student());
	}
	cout<<"Founding Organizations..."<<endl;
	for(int i = 0; i < organizationCount; i++){
		organizations.push_back(Organization());
	}
	cout<<"Designing Curriculum..."<<endl;
	unordered_set<string> uniqueCourses;	//the set stores only unique values and determines duplicates in O(1) time.  This is how we keep from regenerating the same class twice
	for(int i = 0; i < courseCount; i++){

		Class newClass;
		string key;
		do{
			newClass = Class();	//regenerate a class if it already exists
			key = newClass.subject + itos(newClass.number);
		}while(uniqueCourses.find(key) != uniqueCourses.end());	//loop until we fail to find a course with this key value.  then we'll know it's unique

		uniqueCourses.insert(uniqueCourses.begin(), key);
		courses.push_back(newClass);
	}

	//create relations between these base objects (a.k.a the hard part).
	cout<<"Opening Registration & Open House..."<<endl;
	unordered_set<string> duplicateRegistration;

	for(int i = 0; i < studentCount; i++){
		for(int j = 0; j < rand() % 20 + 1; j++){	//multiple enrollments per student
			while(true){
				EnrolledIn temp(students[i]);
				string key = itos(temp.UIN) + itos(temp.semester) + temp.subject + itograde(temp.number);
				if(duplicateRegistration.find(key) == duplicateRegistration.end()){
					enrollment.push_back(temp);
					duplicateRegistration.insert(key);
					break;
				}else{
					cout<<"multiple enrollment found\n";
					temp.targetCourse->size--;
				}
			}
		}

		unordered_set<string> duplicateMembership;
		for(int j = 0; j < rand() % 4; j++){	//up to 3 memberships per student
		//	membership.push_back(MemberOf(students[i]));


			while(true){
				MemberOf temp(students[i]);
				string key = itos(temp.UIN) + itos(temp.studentOrgID);
				if(duplicateMembership.find(key) == duplicateMembership.end()){
					membership.push_back(temp);
					duplicateMembership.insert(key);
					break;
				}else
					cout<<"duplicate registration found\n";
				
			}



		}
	}
	cout<<"Assigning Professors..."<<endl;
	for(int i = 0; i < courseCount; i++){
		if(!courses[i].hasProf){
			instruction.push_back(Teaches(&courses[i]));
		}
	}
	cout<<"Volunteering Faculty to Organizations..."<<endl;
	for(int i = 0; i < organizationCount; i++){
		if(rand() % 5 == 0) leadership.push_back(Leads());	//a quarter of organizations have faculty leadership
	}

	cout<<"Checking constraints..."<<endl;

	for(int i = 0; i < courseCount; i++){
		if(courses[i].size == 0){
			cout<<"Empty course fixed\n";
			enrollment.push_back(EnrolledIn(&courses[i]));
		}
	}
	for(int i = 0; i < organizationCount; i++){
		if(organizations[i].size == 0){
			cout<<"Empty organization fixed\n";
			membership.push_back(MemberOf(&organizations[i]));
		}
	}

	cout<<"Writing data to file...\n"<<endl;	//self explanatory vvvvvv
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
	for(int i = 0; i < enrollment.size(); i++){
		writeEnrolledIn(itosem(enrollment[i].semester), enrollment[i].subject, enrollment[i].number, enrollment[i].UIN, itograde(enrollment[i].grade));
	}
	for(int i = 0; i < instruction.size(); i++){
		writeTeaches(instruction[i].subject, instruction[i].number, instruction[i].facultyID, itosem(instruction[i].semester));
	}
	for(int i = 0; i < leadership.size(); i++){
		writeLeads(leadership[i].facultyID ,leadership[i].studentOrgID, itos(leadership[i].joinedMo)+"/"+itos(leadership[i].joinedYr));
	}
	for(int i = 0; i < membership.size(); i++){
		writeMemberOf(membership[i].UIN, membership[i].studentOrgID, itos(membership[i].joinedMo)+"/"+itos(membership[i].joinedYr));
	}
	
	closeFile();
	cout<<"All data generated"<<endl;
}
*/