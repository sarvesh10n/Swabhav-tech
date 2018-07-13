CREATE TABLE  Employee (names            VARCHAR(20),
                        address          VARCHAR(20),
                        employee_number  INT,
                        salary           SMALLMONEY)


INSERT INTO Names
VALUES ('Joe Smith')


INSERT INTO Employee
VALUES ('Joe Smith', '123 4th St.', 101, 2500)

INSERT INTO Employee (salary, names, employee_number, address)
VALUES (2500, 'Joe Smith', 101, '123 4th St.')

INSERT INTO Names(fullname)
  SELECT  names
  FROM    Employee

INSERT INTO Names(fullname)
  SELECT names
  FROM   Employee
  WHERE  salary > 2600



