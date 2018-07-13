USE aurionpro;
GO

create schema aurionpro;
--CREATE PROCEDURE TO GIVE A HIKE TO PRATICULAR EMPLOYEE
CREATE PROCEDURE aurionpro.giveHike
(
	@EMPNO INT, 
	@PERCENTAGE FLOAT
)
AS
BEGIN
UPDATE EMP
SET SAL=SAL+SAL*(@PERCENTAGE/100)
WHERE EMPNO=@EMPNO;
END
GO

SELECT * FROM EMP WHERE EMPNO=7839;

EXEC aurionpro.giveHike 7839, 10 ;

SELECT * FROM EMP WHERE EMPNO=7839;
--CALL PROCEDURE TO GIVE A HIKE TO PARTICULAR EMPLOYEE


