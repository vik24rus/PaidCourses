PRAGMA foreign_keys=on;

CREATE TABLE Students (
	id integer PRIMARY KEY AUTOINCREMENT,
	FirstName string,
	LastName string,
	PatronymicName string,
	MainStudyGroup string
);

CREATE TABLE Teachers (
	id integer PRIMARY KEY AUTOINCREMENT,
	FirstName string,
	LastName string,
	PatronymicName string
);

CREATE TABLE CoursesCatalog (
	id integer PRIMARY KEY AUTOINCREMENT,
	NameCourse string,
	NameDepartment integer,
	StartTime datetime,
	FinishTime datetime,
	CostCourse integer,
	Newbie integer,
	FOREIGN KEY(NameDepartment) REFERENCES Departments(id)
);

CREATE TABLE CoursesTeachersLinks (
	id integer PRIMARY KEY AUTOINCREMENT,
	TeacherId integer,
	CourseId integer,
	FOREIGN KEY(TeacherId) REFERENCES Teachers(id),
	FOREIGN KEY(CourseId) REFERENCES CoursesCatalog(id)
);

CREATE TABLE ProgramUsers (
	id integer PRIMARY KEY AUTOINCREMENT,
	login string,
	pass string
);

CREATE TABLE PreliminaryRequirements (
	id integer PRIMARY KEY AUTOINCREMENT,
	CourseCatalogId integer,
	PreliminaryCourse integer,
	FOREIGN KEY(CourseCatalogId) REFERENCES CoursesCatalog(id),
	FOREIGN KEY(PreliminaryCourse) REFERENCES CoursesCatalog(id)
);

CREATE TABLE PaidGroups (
	id integer PRIMARY KEY AUTOINCREMENT,
	NameGroup string,
	StudentId integer,
	Year integer,
	CourseCatalogId integer,
	FOREIGN KEY(StudentId) REFERENCES Students(id),
	FOREIGN KEY(CourseCatalogId) REFERENCES CoursesCatalog(id)
);

CREATE TABLE Departments (
	id integer PRIMARY KEY AUTOINCREMENT,
	NameDepartment string
);


CREATE TABLE QueueStudents (
	id integer PRIMARY KEY AUTOINCREMENT,
	StudentId integer,
	CourseCatalogId integer,
	FOREIGN KEY(StudentId) REFERENCES Students(id),
	FOREIGN KEY(CourseCatalogId) REFERENCES CoursesCatalog(id)
);