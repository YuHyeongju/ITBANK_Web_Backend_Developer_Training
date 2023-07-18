create table t_member(

id varchar2(10) primary key,
pwd VARCHAR2(10),
name VARCHAR2(50),
email VARCHAR2(50),
joinDate date default sysdate --입력하지않으면 시스템 시간 기본
);

--회원정보추가
insert into t_member
values('hong','1212','홍길동','hong@gmail.com',sysdate);

insert into t_member
values('lee','1212','이순신','lee@test.com',sysdate);

insert into t_member
values('kim','1212','김유신','kim@web.com',sysdate);
commit;

--테이블확인
select * from t_member;

