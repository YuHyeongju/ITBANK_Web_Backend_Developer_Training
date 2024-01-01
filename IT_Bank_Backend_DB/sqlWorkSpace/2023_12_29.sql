-- 부서
create table department (
    name        varchar2(100)          primary key,
    location    varchar2(100)           not null
);
--직원
create table employees(
    idx                              number                       GENERATED  AS IDENTITY primary key, 
    name                            varchar2(100)              not null,
    start_date                      date                           not null,
    department_name           varchar2(100)               not null,
    
    constraint employees_department_fk  -- 제약조건을 생성, 제약조건 이름 지정
    foreign key(department_name)              -- 제약조건의 종류, 조건을 걸 컬럼이름
    References department(name)                -- 외래키가 참조하는 대상 테이블(컬럼)
);

drop table purge;
drop table employees purge;

insert into department values('게임기획','서울');
insert into department values('게임프로그래밍','구로');
insert into department values('게임아트','제주도');
insert into department values('3D 게임아트','제주도');
select * from department;
commit;

insert into employees (name,start_date ,department_name)
    values('홍길동', '2022-12-01', '게임기획');
insert into employees (name,start_date, department_name)
    values('홍진호', '2022-12-22', '게임아트');  
    -- 부서가 생성되지 않은 상태에서 홍진호를 프로게임단 부서에 소속시키려고하니 문제가 생김
 
insert into employees (name,start_date, department_name)
    values('김유빈', '2024-05-30', '게임프로그래밍'); 
insert into employees (name,start_date, department_name)
    values('최현웅', '2024-05-25', '게임프로그래밍'); 
insert into employees (name,start_date, department_name)
    values('신유진', '2024-06-01', '3D 게임아트');     
    
select * from employees;

select  employees.*, department.location
        from employees
        join  department
            on employees.department_name = department.name;

-- fk가 없어도 join이 가능함.

select department_name, count(*) from employees
    group by department_name; -- 다른 컬럼이랑 집계함수를 같이 조회할 경우에는 group by를 사용한다.  

commit;            
        