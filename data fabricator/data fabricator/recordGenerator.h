//#include <iostream>
#include <random>
#include <time.h>
#include <string>

using namespace std;

static int universalID = 100000000;
static int universalOrgID = 100;

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
	word.insert(word.end(), (char)(rand()%26 + 65));	//first letter is capital

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
		salary = (rand() % 100000) + 40000;
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

		courseLoad = 0;
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

//enum SemCode{ Fall = 0, Winter, Spring, Summer };
//enum GradeCode { F = 0, D,C,B,A };

struct EnrolledIn{
	int semester;
	string subject;
	int number;
	int UIN;
	int grade;

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
};

struct Teaches{
	string subject;
	int number;
	int facultyID;
	int semester;

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
};

struct MemberOf{
	int UIN;
	int studentOrgID;
	int joinedMo;
	int joinedYr;

	MemberOf(){
		Organization *org;
		org = &organizations[rand() % organizations.size()];	//unlimited members

		Student *student;
		student = &students[rand() % students.size()];		//a student can be in unlimited organizations

		UIN = student->UIN;
		studentOrgID = org->ID;
		joinedMo = rand() % 12 + 1;
		joinedYr = rand() % 5 + 2008;
	}
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
		joinedYr = rand() % 13 + 2000;
	}
};
