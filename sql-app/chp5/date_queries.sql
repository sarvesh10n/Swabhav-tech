CREATE TABLE DateTable     (birthdate        SMALLDATETIME,
                                school_date      SMALLDATETIME,
                                names            VARCHAR(20))
INSERT INTO DateTable
    VALUES ('10-oct-01', '12/01/2006', 'Mala Sinha')

SELECT *
    FROM   DateTable

SET DATEFORMAT dmy
    SELECT 'Format is yyyy/mon/dd' = CONVERT(datetime, '10/2/2003')

SELECT names, 'Add 2 days to birthday' = DATEADD(dd, 2, birthdate)
    FROM   Datetable

SELECT names, 'Add 2 days to birthday' = DATEADD(dd, -2, birthdate)
    FROM   Datetable

SELECT names, 'Months between birth date and school date' = DATEDIFF(mm, birthdate,
    school_date)
    FROM Datetable
SELECT names, YEAR(school_date) AS [Kindergarten Year]
    FROM   Datetable

SELECT names, 'Number of years ' = DATEDIFF(yy, birthdate, GETDATE(  ))
    FROM   Datetable
