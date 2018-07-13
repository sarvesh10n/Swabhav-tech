use aurionpro;

create table log(
EMPNO int,
ENAME varchar(10),
JOB varchar(9),
MGR int,
HIREDATE datetime,
SAL money,
COMM money,
DEPTNO int,
UPDATE_DATE datetime default getdate()); 

CREATE PROCEDURE aurionpro.updateEmp
(
	@EMPNO int
)
AS
BEGIN
INSERT INTO log (
EMPNO,
ENAME,
JOB,
MGR,
HIREDATE,
SAL,
COMM,
DEPTNO
)
SELECT * FROM EMP
WHERE EMPNO=@EMPNO
END
GO

--EXEC aurionpro.updateEmp 7839
select * from log;

ALTER TRIGGER GENERATE_LOGS
ON EMP
FOR UPDATE
AS
BEGIN 
	DECLARE @EMPNO INTEGER;
	set @EMPNO=(SELECT EMPNO FROM DELETED);
	EXEC aurionpro.updateEmp @EMPNO
END;

update emp set ENAME='sarvesh' where Ename='smith'
select * from log;

select * from EMP