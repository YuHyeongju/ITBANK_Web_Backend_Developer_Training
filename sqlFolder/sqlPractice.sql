create table member(

id VARCHAR2(10),
pw VARCHAR2(10),
name VARCHAR2(50)
);

insert into member
values('202301','1111','ȫ�浿');

insert into member
values('202302','2222','�̼���');

insert into member
values('202303','3333','�̸���');

commit;

select * from member;

update member set name = '������' where id ='202301';

select * from member;

delete member where id ='202301';

select * from member;

drop table member;