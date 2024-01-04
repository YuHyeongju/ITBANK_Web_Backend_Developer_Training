drop  table review purge;
drop sequence review_seq;

create sequence review_seq
 	increment by 1
 	start with 1
 	maxvalue 99999
 	nocache
 	nocycle;
 
 
 
 create table review(
 	idx 		number 				default review_seq.nextval primary key,
 	image 		varchar2(500) 		not null,
 	storeName	varchar2(100)		not null,
 	content		varchar2(2000)		not null,
 	visitDate	    date				         not null --(다른 방문날짜로 한다면), default sysdate(오늘날짜로 한다면)
 );

commit;
 
delete  from review; -- 테이블 안에 값만 삭제

select * from review;