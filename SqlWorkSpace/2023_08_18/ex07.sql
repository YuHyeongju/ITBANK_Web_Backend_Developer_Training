--제약조건: 불필요한 데이터의 입력을 막기 위한 속성
-- 1.primary key: 기본키, 중복 입력과 null 입력이 방지된다. 테이블만 1개만 적용 가능
-- 2.not null: null 입력이 방지됨.
--3. unique: 고유, 중복입력이 방지됨. null은 입력가능 
create table test(
    idx     number          constraint test_idx primary key,
    name    varchar2(20)    not null,
    salary  number          not null,
    h_date  date,
    email   varchar2(50)    constraint test_email unique not null
);
--아래 구문을 2번이상 실행해본다.
insert into test values(1000, '홍길동', 3000, '23/08/01', 'hong@naver.com');

insert into test values(1001, '홍길동', 3000, '23/08/01', 'hong@gmail.com');

--이름이나 연봉에 null을 넣어본다.
insert into test values(1002, '홍길동', null, '23/08/01', 'hong@gmail.com');

select * from test;

drop table test;