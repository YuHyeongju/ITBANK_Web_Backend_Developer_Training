select * from tab;
desc employees;


-- 전체 목록 조회
select * from employees order by employee_id; 

-- 단일 항목 조회(id를 조건으로 사용)

select * from employees where employee_id = 100;

-- 검색 결과 조회(first_name에 검색어를 포함하는 조건

select * from employees where first_name like '% s %';
-- s% first_name으로 시작하는 것들
-- %s first_name으로 끝나는 것들
-- %s% first_name이 포함하는 것들


-- 추가 
insert into employees  EMPLOYEE_ID = ?, first_name = ?  where  employee_id = 100;
-- 수정
update employees set first_name = ? , last_name = ? where  employee_id = 100;
-- 삭제
delete employees where employee_id = 100;