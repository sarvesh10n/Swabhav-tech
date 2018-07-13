USE aurionpro;
GO

CREATE PROCEDURE uspGetEmployee
AS
SELECT * FROM EMP;
GO

CREATE PROCEDURE uspGetEmployeesTest   
    @ENAME nvarchar(50),   
    @SAL MONEY
AS   
    SELECT EMPNO, ENAME, JOB
    FROM EMP  
    WHERE ENAME = @ENAME AND SAL = @SAL    
GO 

--EXECUTE uspGetEmployeesTest N'ALLEN', N'1600';  
 EXEC uspGetEmployeesTest @ENAME = N'JONES', @SAL = N'2975';
-- uspGetEmployeesTest @ENAME = N'SMITH', @SAL = N'800';  
GO

EXEC uspGetEmployee;
-- uspGetEmployee;
GO

DROP PROCEDURE uspGetEmployee;
DROP PROCEDURE uspGetEmployeesTest;
