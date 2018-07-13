--create table foo
--(id int,name varchar(20),dno int);

--insert into foo values(20,'sarvesh',1001);

--insert into foo values(25,'santosh',1022);

--insert into foo values(10,'vipul',1020);

--insert into foo values(1,'pratik',1029);

BEGIN TRANSACTION

insert into foo values(10,'HELLO',1020);
insert into foo values(10,'THERE',1020);
SELECT * FROM foo;
ROLLBACK;


SELECT * FROM foo;

