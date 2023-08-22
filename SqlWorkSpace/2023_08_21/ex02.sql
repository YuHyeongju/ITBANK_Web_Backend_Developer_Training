-- 시퀀스: 번호를 증가시키는 객체 
-- 주로 자동증가 열에 사용한다.

create sequence board_seq
    start with 1001
    increment by 1
    minvalue 1001
    maxvalue 999999999999999999999999
    nocache;
    
drop table board;

create table Board(
    idx         number          default board_seq.nextval,
    title       varchar2(20)    not null,
    contents    clob            not null,
    writer      varchar2(20)    not null,
    vcount      number          default 0,
    wdate       date            default sysdate,
    constraint board_idx primary key(idx) --길어서 밑으로 빼고 idx의 조건임을 명시 
);

insert into 
    board(title, contents, writer) values('공지사항', '바른말을 사용합시다','관리자');

insert into 
    board(title, contents, writer) values('가입인사', '안녕하세요','유저1');
    
insert into 
    board(title, contents, writer) values('오늘 저녁은....', '추천받아요','아뱅');  
    
select * from board order by idx desc; 

delete from board where idx ='1001';

select * from board order by idx desc; 

select banner from v$version;

desc person
select * from person;