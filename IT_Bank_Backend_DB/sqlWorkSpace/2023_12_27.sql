create table member(
    USERID          VARCHAR2(500)   PRIMARY key,
    USERPW        VARCHAR2(500)  NOT NULL,
    USERNAME     VARCHAR2(500)  NOT NULL,
    GENDER          VARCHAR2(100) check(gender in('남성','여성')),
    EMAIL             VARCHAR2(100) NOT NULL
);

desc member;

insert into member (userid,userpw,userName,gender,email) values('root','1','관리자','남성','root@naver.com');
insert into member (userid,userpw,userName,gender,email) values('itbank','1','아뱅','여성','itbank@naver.com');

select * from member order by userid;