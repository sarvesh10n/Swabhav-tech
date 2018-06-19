SELECT stno, sname, relationship, age
FROM Student s JOIN Dependent d
ON s.stno=d.pno

SELECT *
FROM Course c JOIN Prereq p
ON c.course_number=p.course_number

SELECT *
FROM Course INNER JOIN Prereq
ON Course.course_number=Prereq.course_number

SELECT *
FROM Course c, Prereq p
WHERE c.course_number= p.course_number

SELECT *
FROM Course CROSS JOIN Prereq p

SELECT 'SENIORITY' = x.sname + ' is in a higher class than ' + y.sname
FROM Student AS x, Student AS y
WHERE y.class = 3
AND x.class > y.class

SELECT c.course_name, c.course_number, d2m.dname
FROM department_to_major d2m JOIN
(course c JOIN prereq  p
ON c.course_number=p.course_number)
ON c.offering_dept=d2m.dcode

SELECT c.course_name, c.course_number, d.dname
FROM (course c JOIN department_to_major d
ON c.offering_dept = d.dcode)
JOIN prereq p
ON p.course_number = c.course_number

SELECT *
FROM Course c LEFT OUTER JOIN Prereq p
ON c.course_number = p.course_number

SELECT *
FROM Prereq p RIGHT OUTER JOIN Course c
ON p.course_number = c.course_number

SELECT *
FROM Prereq p FULL OUTER JOIN Course c
ON p.course_number = c.course_number

