select * from tab;

desc employees;

select * from employees;

select * from employees where employee_id = 101;

select * from employees where first_name = 'Neena';

select * from employees where employee_id = 206;
-- first_name을 동일하게 가진 사람이 두명

select * from employees where first_name = 'William' and
    last_name = 'Gietz';    -- last_name이 Gietz인 사람 찾아라 조건 추가

-- id, 이름으로 불러오는 것 가능

select * from employees
    where 
        salary >= 10000;            -- 급여가 10000달러이상인 사람 조회
        
select * from employees
    where
        salary between 10000 and 15000;  -- between A and B A에서 B사이  
        
select * from employees
    where 
        10000 <= salary         -- 범위를 지정할 수 있음.
        and 
        salary <= 14000;
        
select * from employees
    where 
        hire_date  between '02/01/01' and '04/12/31'    -- 날짜를 줘서 사이에 있는 값 출력
    order by
        hire_date;

select * from employees
    where 
        last_name like 'K%';        -- last_name의  값이 K로 시작하는 사람 조회
        
        
 select * from employees    -- last_name의 값이 e로 끝나는 사람 조회
    where 
        last_name like '%e';        
 
 select * from employees    -- last_name의 값이 e로 끝나는 사람 조회
    where 
        last_name like '%er%';        -- last_name 이름에 er이 포함되는 사람 조회
                                            -- 여러 사람의 이름이 나올 것 임으로 자바에서 리스트로 받아야함.

select 
    first_name,
    salary,
    hire_date,
    sysdate,     -- 시스템 현재 시간 불러오기
    sysdate - hire_date     -- 컴퓨터는 1970년 1월1일 0시 0분을 기준으로 얼마나 지났나를 가지고 시간을 측정함.
        from employees;
                                            
                                            
select employees_seq.nextval from dual;

select employees_seq.currval from dual;

