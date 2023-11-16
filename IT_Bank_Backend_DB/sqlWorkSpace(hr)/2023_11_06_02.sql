select tname from tab;

select * from countries;
select * from departments;
select * from departments order by department_id;
select * from departments order by department_name;

select * from employees;

select 
        E.first_name,
        d.department_name,
        E.salary
            from employees E
            join departments D
                on e.department_id = d.department_id
            order by salary desc;    