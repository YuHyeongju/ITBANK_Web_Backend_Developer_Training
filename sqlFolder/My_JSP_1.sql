create table t_member(

id varchar2(10) primary key,
pwd VARCHAR2(10),
name VARCHAR2(50),
email VARCHAR2(50),
joinDate date default sysdate --�Է����������� �ý��� �ð� �⺻
);

--ȸ�������߰�
insert into t_member
values('hong','1212','ȫ�浿','hong@gmail.com',sysdate);

insert into t_member
values('lee','1212','�̼���','lee@test.com',sysdate);

insert into t_member
values('kim','1212','������','kim@web.com',sysdate);
commit;

--���̺�Ȯ��
select * from t_member;

