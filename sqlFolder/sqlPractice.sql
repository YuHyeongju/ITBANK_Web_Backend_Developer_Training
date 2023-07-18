create table member(

id VARCHAR2(10),
pw VARCHAR2(10),
name VARCHAR2(50)
);

insert into member
values('202301','1111','È«±æµ¿');

insert into member
values('202302','2222','ÀÌ¼ø½Å');

insert into member
values('202303','3333','ÀÌ¸ù·æ');

commit;

select * from member;

update member set name = '¼ºÃáÇâ' where id ='202301';

select * from member;

delete member where id ='202301';

select * from member;

drop table member;