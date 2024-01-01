select * from employees;
select count(*) from employees;
select * from departments;
select count(*) from departments;

/*
    부서 이름(departments)별 직원수(employees)를 파악하고 싶다.
    department_name from departments
    count(*) from employees
    
    부서 테이블에는 부서 이름이 있고,
    직원 테이블에서는 직원의 이름과 부서의 id(숫자)만 있다.
    
    부서이름과 부서별 인원수를 파악하려면 어떻게 써야할까?

*/

select 
    D.department_name,
    count(*)
        from employees E -- 별명 지정
        join departments D
            on E.department_id = D.department_id
          group by D.department_name              -- 집계 함수가 아닌 내용(department_name)을 group by 해줌. 
        order by count(*) desc;
        
        
        
        
-- join의 기본식
select * from employees, departments; /*  카티션  프로덕트 (수량곱셈) 카테이션 곱*/
select count(*) from departments;
select count(*) from employees;
select 107 * 27 from dual; -- 모든 경우의 수를 구함. 두 테이블의 컬럼수를 곱함. -> 중복을 유발함.


--카티션 곱을 방지하기 위해서 부서id가 일치하는 조건을 지정
select * from employees, departments
    where   
        employees.department_id = departments.department_id;
   
-- 두개 이상의 테이블 조인 + 조인에 필요한 조건을 별도 문법으로 분리함.        
select * from employees
    join departments
        on employees.department_id = departments.department_id;
 
 
-- 내가 원하는 컬럼의 값을 불러온다.
-- 컬럼이름앞에 테이블을 명시하여 어느 테이블에서 불러올지 작성한다.
select 
    employees.first_name,
    departments.department_name
    from employees        
        join departments
        on employees.department_id = departments.department_id;
        --      foreign key(child key)    ->참조->      parent key(참조 당하는 키, (선택)식별을 하고싶으면, primary key나 unique를 걸어줌)
        