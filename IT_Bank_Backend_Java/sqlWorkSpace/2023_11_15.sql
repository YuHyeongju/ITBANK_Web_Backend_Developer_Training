-- 현재 접속한 계정 테이블 
select * from tab;

-- book 형태의 데이터를 저장하기 위해 테이블 생성
-- 데이터베이스 객체(테이블, 뷰, 인덱스, 시퀀스 등)를 생성/수정/삭제
-- DDL(Data Definition Language, 데이터 정의어)
create  table book(

    name            varchar2(100),    
    author           varchar2(100),
    publisher       varchar2(100),
    price             number
);

-- 데이터 베이스 객체에 데이터를 조회(Q)/생성/수정/삭제
-- DML(Data Manipulation Language, 데이터 조작어)
-- DQL(DATA Query Language, 데이터 조회어)
select name, author,publisher, price from book;
select * from book;

insert into book (name,author,publisher, price)
    values ('전지적 푸바오 시점','송영관','에버랜드',19800);
    
insert into book values('마흔에 읽는 쇼펜하우어','강민수','유노북스',13800);    
-- 컬럼을 생략하면 테이블에 구성되있는데로 데이터를 차례로 넣겠다는 뜻이다.

update book 
    set 
        author  = '송영관',
        publisher = '위즈덤 하우스'
    where 
            name = '전지적 푸바오 시점'; 
            
update book
    set
        price = price - 10000
    where 
        name = '전지적 푸바오 시점'; 

delete book;

-- DCL (Data Control Language, 데이터 제어어)
commit; -- 현재까지의 데이터 변경 내용을 반영한다. (적용) 
            -- 자바에서는 Auto Commit이 적용되어있어 자동 적용된다.
rollback; --  현재까지의 데이터 변경 내용을 되돌린다.







