//#include <iostream>
#include <random>
#include <time.h>
#include <string>

using namespace std;

static int universalID = 0;
static int universalOrgID = 0;

struct Faculty;
struct Student;
struct Class;
struct Organization;
struct EnrolledIn;
struct Teaches;
struct Leads;
struct MemberOf;

//objects
vector<Faculty> faculty;
vector<Student> students;
vector<Class> courses;
vector<Organization> organizations;

//relations
vector<EnrolledIn> enrollment;
vector<Teaches> instruction;
vector<Leads> leadership;
vector<MemberOf> membership;


string generateString(int length){

	string word;
	word.insert(word.end(), (char)(rand()%26 + 65));	//first letter is capitalized

	for(int i = 0; i < length-1; i++){
		word.insert(word.end(), (char)(rand()%26 + 97));
	}
	return word;
};

struct Faculty{
	int ID;
	int salary;
	string name;

	int workLoad;
	bool leadsOrg;

	Faculty(){
		ID = universalID++;
		salary = (rand() % 100000) + 50000;
		name = generateString(rand()%6+1) + " " + generateString(rand()%10+1);

		workLoad = 0;
		leadsOrg = false;
	}
};

struct Student{
	int UIN;
	string name;
	string major;
	int advisorID;

	int courseLoad;	//necessary for logical values
	
	Student(){
		UIN = universalID++;
		name = generateString(rand()%6+1) + " " + generateString(rand()%10+1);

		major = (char)(rand()%26 + 65);
		major.insert(major.end(), (char)(rand()%26 + 65));
		major.insert(major.end(), (char)(rand()%26 + 65));
		major.insert(major.end(), (char)(rand()%26 + 65));
		
		advisorID = faculty[rand() % faculty.size()].ID;
	}
};

struct Organization{
	string name;
	string category;
	int ID;

	Organization(){
		name = generateString(rand()%20);
		category = generateString(rand()%6);
		ID = universalOrgID++;
	}
};

struct Class{
	string title;
	int hours;
	string subject;
	int number;

	bool hasProf;
	int size;

	Class(){
		title = generateString(rand()%10 + 3) + " of " + generateString(rand()%10 + 3);
		hours = rand() % 4 + 1;
		subject = (char)(rand()%26 + 65);
		subject.insert(subject.end(), (char)(rand()%26 + 65));
		subject.insert(subject.end(), (char)(rand()%26 + 65));
		subject.insert(subject.end(), (char)(rand()%26 + 65));

		number = rand() % 900 + 100;

		size = 0;
		hasProf = false;
	}
};

struct EnrolledIn{
	int semester;
	string subject;
	int number;
	int UIN;
	int grade;

	EnrolledIn(Student student){

		Class *targetCourse;
		do{
			targetCourse = &courses[rand() % courses.size()];
		}while(targetCourse->size > 200);
		targetCourse->size++;

		semester = rand() % 4;
		subject = targetCourse->subject;
		number = targetCourse->number;
		UIN = student.UIN;	
		grade = rand() % 5;
	}
	/*
	EnrolledIn(){

		Class *targetCourse;
		do{
			targetCourse = &courses[rand() % courses.size()];
		}while(targetCourse->size > 200);
		targetCourse->size++;

		Student *enrolledStudent;
		do{
			enrolledStudent = &students[rand() % students.size()];
		}while(enrolledStudent->courseLoad >= 18);
		enrolledStudent->courseLoad += targetCourse->hours;

		semester = rand() % 4;
		subject = targetCourse->subject;
		number = targetCourse->number;
		UIN = enrolledStudent->UIN;	
		grade = rand() % 5;
	}
	*/
};

struct Teaches{
	string subject;
	int number;
	int facultyID;
	int semester;

	Teaches(Faculty faculty){
		Class *targetCourse;
		int tryLimit = 0;
		do{
			targetCourse = &courses[rand() % courses.size()];
			tryLimit++;
		}while(targetCourse->hasProf && tryLimit < 5);	//if all courses seem to be accounted for, bail out
		targetCourse->hasProf = true;

		subject = targetCourse->subject;
		number = targetCourse->number;
		facultyID = faculty.ID;
		semester = rand() % 4;
	}

	/*
	Teaches(){
		Class *targetCourse;
		do{
			targetCourse = &courses[rand() % courses.size()];
		}while(targetCourse->hasProf);
		targetCourse->hasProf = true;

		Faculty *professor;
		do{
			professor = &faculty[rand() % faculty.size()];
		}while(professor->workLoad > 3);
		professor->workLoad ++;

		subject = targetCourse->subject;
		number = targetCourse->number;
		facultyID = professor->ID;
		semester = rand() % 4;
	}
	*/
};

struct MemberOf{
	int UIN;
	int studentOrgID;
	int joinedMo;
	int joinedYr;


	MemberOf(Student student){	
		Organization *org;
		org = &organizations[rand() % organizations.size()];	//unlimited members


		UIN = student.UIN;
		studentOrgID = org->ID;
		joinedMo = rand() % 12 + 1;
		joinedYr = rand() % 6 + 2008;
	}
	/*
	MemberOf(){
		Organization *org;
		org = &organizations[rand() % organizations.size()];	//unlimited members

		Student *student;
		student = &students[rand() % students.size()];		//a student can be in unlimited organizations

		UIN = student->UIN;
		studentOrgID = org->ID;
		joinedMo = rand() % 12 + 1;
		joinedYr = rand() % 6 + 2008;
	}
	*/
};

struct Leads{
	int facultyID;
	int studentOrgID;
	int joinedMo;
	int joinedYr;

	Leads(){
		Organization *org;
		org = &organizations[rand() % organizations.size()];

		Faculty *leader;
		do{
			leader = &faculty[rand() % faculty.size()];	
		}while(leader->leadsOrg);
		leader->leadsOrg = true;

		facultyID = leader->ID;
		studentOrgID = org->ID;
		joinedMo = rand() % 12 + 1;
		joinedYr = rand() % 14 + 2000;
	}
};

string itosem(int semCode){
	string semester;
	switch(semCode){
		case 0:
			semester = "Fall";
			break;
		case 1:
			semester = "Spring";
			break;
		case 2:
			semester = "Summer I";
			break;
		case 3:
			semester = "Summer II";
			break;
		}
	return semester;
}

string itograde(int gradeCode){
	string grade;

	switch(gradeCode){
		case 0:
			grade = 'F';
			break;
		case 1:
			grade = 'D';
			break;
		case 2:
			grade = 'C';
			break;
		case 3:
			grade = 'B';
			break;
		case 4:
			grade = 'A';
			break;
		}
	return grade;
}
