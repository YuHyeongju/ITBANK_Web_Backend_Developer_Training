select * from tab;

select banner from v$version;


select * from countries;

insert into countries values('KR','South Korea', 3);
rollback;

desc countries;

delete from countries where country_id = IN;