create table student1(
    name        varchar2(50),   
    age           number,
    kor     number,
    eng    number,
    math     number 
);

desc student1;  -- 테이블 컬럼의 이름과 타입 출력

drop table student1;

insert into student1 values('이상혁',27,100,99,87);
insert into student1 values('박재혁',27,98,97,86);
insert into student1 values('서진혁',27,85,92,88);

select * from student1;

update student1
    set age = 24
    where name = '박재혁';
    
    
select      -- 각각  학생들의 평균
    name,
    age,
    kor,
    eng,
    math,
    kor + eng + math as total,  -- 계산결과 값을 total이라는 이름으로 불러옴
    --round((kor + eng + math) / 3) as average  -- 소수점 이하 숫자 잘라냄
    to_char((kor + eng + math)/ 3, 'fm999.00') as average -- 결과값을 fm999.00 서식으로 변환해줌
        from student1
    order by 
        total desc;   -- total을 기준으로 내림차순 정렬

select avg(kor) from student1;
select avg(eng) from student1;
select avg(math) from student1;

select 
    to_char(avg(kor + eng + math) / 3, 'fm999.00') as average                -- to_char(값, 서식)
        from student1;                                                                     -- avg(컬럼  or 컬럼포함수식)  
-- 각각 학생들의 평균을 다시 평균낸 것.   

-- TO_CHAR('숫자열', 'FM999.00')
-- 이렇게 FM에 출력하고 싶은 형식을 넣어주면된다.

-- - FM : 좌우 공백 제거.

-- - 9 : 가변적인 값으로 0이거나 숫자가 없을 시 값을 버린다.

-- - 0 : 고정적인 값으로 변환된 숫자의 길이를 맞추고 싶으면 원하는 길이만큼 0으로 채워주면 된다.


select 10 + 20 as result 
    from dual;  -- dual은 가상테이블
    
-- db에 반영되지않은 상태에서 테이블에 있는 값을 가져와서 함수를 사용하여 계산을 할 수 있다.    
   
   
    
    