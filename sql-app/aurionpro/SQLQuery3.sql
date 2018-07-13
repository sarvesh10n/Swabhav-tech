--*Displaying all employees in descending order of name
select * 
from EMP
order by ENAME desc


--*Display all employees in dept 10;
select * 
from EMP
where DEPTNO=10;

--*Display all employees whose commision is null
select * 
from EMP
where COMM=NULL;

--*Display employee name starting with 's'
select * 
from EMP
where ENAME like 's%';

--*Display employee who are managers
select *
from EMP
where JOB='MANAGER'

--*Display top 2 salary earning employee
select top 2 *
from EMP
order by SAL

--*Display employee name in small case
select LOWER(ENAME) from EMP;

--*Display employee details with CTC column
select ENAME,(SAL+isnull(COMM,0))*12
from EMP

--*All employees in dept 10 and 20
select * 
from EMP
where DEPTNO=10 or
DEPTNO=20 

--*sum of salary of all employees
select SUM(SAL) as 'total salary'
from EMP

--*avg salary of all emplyees
select AVG(SAL) as 'average salary'
from EMP

--*all employees in same department of 'Smith'
  select *
  from EMP
  where DEPTNO=
  (select DEPTNO
  from EMP 
  where ENAME='SMITH')


--*Employee having same salary of 'blake'
  select *
  from EMP
  where SAL=
  (select SAL
  from EMP 
  where ENAME='BLAKE')