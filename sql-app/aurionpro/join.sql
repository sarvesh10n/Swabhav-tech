select COUNT(*) as employees_count
from emp;

--Job wise no of employees
select job,COUNT(*) as count
from EMP
group by job;

--dept wise,job wise no. of employees
select DEPTNO,job,COUNT(*) as count
from EMP
group by DEPTNO,job;

--disp employee with their dept name
select EMP.ename,DEPT.DNAME 
from EMP 
JOIN dept
on EMP.DEPTNO=DEPT.DEPTNO

--disp all dept with employee if any
select EMP.*,DEPT.DNAME 
from DEPT 
LEFT OUTER JOIN EMP
on DEPT.DEPTNO=EMP.DEPTNO;

--all dept which does not have an employee
select DEPT.DNAME
from DEPT
left join EMP
on DEPT.DEPTNO=EMP.DEPTNO
where ENAME IS NULL


--ALL EMP NAME AND THEIR BOSS NAME
select E1.ENAME,E2.ENAME AS BOSS
FROM EMP E1
left JOIN EMP E2
ON E1.MGR=E2.EMPNO;

--ALL EMP NAME DEPT NAME AND MANAGER NAME
SELECT E1.ENAME,D.DNAME,E2.ENAME AS BOSS
FROM EMP E1
LEFT JOIN DEPT D
ON E1.DEPTNO=D.DEPTNO
LEFT JOIN EMP E2
ON E1.MGR=E2.EMPNO;