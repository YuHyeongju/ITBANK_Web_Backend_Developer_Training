--테이블 생성
create table t_member(
    id VARCHAR2(10) primary key,
    pwd VARCHAR2(10),
    name VARCHAR2(50),
    email VARCHAR2(50),
    joinDate date default sysdate
);  

--회원정보 추가
insert into t_member
values('hong','1212','홍길동','hong@gmail.com',sysdate);

insert into t_member
values('lee','1212','이순신','lee@test.com',sysdate);

insert into t_member
values('kim','1212','김유신','kim@web.com',sysdate);
commit;

--테이블확인
select * from t_member;

drop table t_member;

create table t_member(
    id VARCHAR2(20) ,
    name VARCHAR2(20),
    job VARCHAR2(20),
    address VARCHAR2(20)
);  

insert into t_member
values('1','홍길동','음악','부산');

insert into t_member
values('2','서길동','컴퓨터','광주');

insert into t_member
values('3','남길동','야구','인천');

insert into t_member
values('4','북길동','축구','서울');
commit  //데이터베이스에 반영하라


select * from t_member;

update t_member set name = '이순신' where id ='1';

select * from t_member;

update t_member set job = '축구' where id ='3';

select * from t_member;

delete t_member where id = '4';

select * from t_member;

drop table t_member;
