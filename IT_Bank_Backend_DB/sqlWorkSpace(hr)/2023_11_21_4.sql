select * from employees;
desc employees;

select first_name, salary, hire_date, extract(year from sysdate) - extract(year from hire_date) as jobLong
from employees order by jobLong;
    

  
        