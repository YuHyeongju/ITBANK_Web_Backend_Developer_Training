--���̺� ����
create table t_member(
    id VARCHAR2(10) primary key,
    pwd VARCHAR2(10),
    name VARCHAR2(50),
    email VARCHAR2(50),
    joinDate date default sysdate
);  

--ȸ������ �߰�
insert into t_member
values('hong','1212','ȫ�浿','hong@gmail.com',sysdate);

insert into t_member
values('lee','1212','�̼���','lee@test.com',sysdate);

insert into t_member
values('kim','1212','������','kim@web.com',sysdate);
commit;

--���̺�Ȯ��
select * from t_member;

drop table t_member;

create table t_member(
    id VARCHAR2(20) ,
    name VARCHAR2(20),
    job VARCHAR2(20),
    address VARCHAR2(20)
);  

insert into t_member
values('1','ȫ�浿','����','�λ�');

insert into t_member
values('2','���浿','��ǻ��','����');

insert into t_member
values('3','���浿','�߱�','��õ');

insert into t_member
values('4','�ϱ浿','�౸','����');
commit  //�����ͺ��̽��� �ݿ��϶�


select * from t_member;

update t_member set name = '�̼���' where id ='1';

select * from t_member;

update t_member set job = '�౸' where id ='3';

select * from t_member;

delete t_member where id = '4';

select * from t_member;

drop table t_member;
