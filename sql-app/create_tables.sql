create table Student
(STNO SMALLINT PRIMARY KEY NOT NULL,
 SNAME NVARCHAR(20) NULL,
 MAJOR NVARCHAR(4) NULL,
 CLASS SMALLINT NULL,
 BDATE SMALLDATETIME NULL)
;
create table Grade_report
(STUDENT_NUMBER SMALLINT NOT NULL,
 SECTION_ID SMALLINT NOT NULL,
 GRADE CHAR(1),
 CONSTRAINT stno_secid PRIMARY KEY (STUDENT_NUMBER, SECTION_ID))
;
create table Section
(SECTION_ID SMALLINT PRIMARY KEY NOT NULL,
 COURSE_NUM NVARCHAR(8),
 SEMESTER NVARCHAR(6),
 YEAR CHAR(2),
 INSTRUCTOR NVARCHAR(10),
 BLDG SMALLINT,
 ROOM SMALLINT)
;
create table Department_to_major
(Dcode NVARCHAR(4) PRIMARY KEY NOT NULL,
 DNAME NVARCHAR(20))
;
create table Plants
(COMPANY NVARCHAR(20),
 PLANTLO NVARCHAR(15))
;
create table Prereq
(COURSE_NUMBER NVARCHAR(8),
 PREREQ NVARCHAR(8),
 CONSTRAINT couno_pre PRIMARY KEY(COURSE_NUMBER, PREREQ))
;
create table Course
(COURSE_NAME NVARCHAR(20),
 COURSE_NUMBER NVARCHAR(8) PRIMARY KEY NOT NULL,
 CREDIT_HOURS SMALLINT,
 OFFERING_DEPT NVARCHAR(4))
;
create table Cap
(NAME NVARCHAR(9),
 LANGU NVARCHAR(7))
;
create table Room
 (BLDG SMALLINT NOT NULL,
 ROOM SMALLINT NOT NULL,
 CAPACITY SMALLINT,
 OHEAD NVARCHAR(1),
 CONSTRAINT bldg_room PRIMARY KEY(BLDG, ROOM))
;
create table Dependent
(PNO SMALLINT NOT NULL,
 DNAME NVARCHAR(20) NULL,
 RELATIONSHIP NVARCHAR(8) NULL,
 SEX CHAR(1) NULL,
 AGE SMALLINT NULL)
;
