-- CREATE: DB의 객체를 생성하는 구문

create table test(
    name    varchar2(20),
    salary  number,
    h_date  date
    

);
--1.아래 구문을 2번 이상 실행 
insert into test values('홍길동', 3500,'23/01/05');

--2. 결과: 데이터가 중복되어 들어간다.
select * from test;

--3. 중복이 발생하면 연쇄 수정/삭제가 발생할 수 있다.
delete from test where name = '홍길동';

--DROP: DB의 객체를 제거
drop table test;



