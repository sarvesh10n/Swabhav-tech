create view tempEmp as
select * 
from EMP
where SAL>2000;

select * from tempEmp;