-- 1.Board 테이블을 작성
-- idx :숫자 , 기본키
-- title: 문자열, null(x)
-- contents: clob, null(x)
-- writer: 문자열, null(x)
-- vcount:  숫자, 기본값 0
-- wdate : date

create table Board(
    idx         number          constraint board_idx primary key,
    title       varchar2(20)    not null,
    contents    clob            not null,
    writer      varchar2(20)    not null,
    vcount      number          default 0,
    wdate       date            default sysdate
);

drop table board;

insert into Board (idx, title, contents, writer)
            values(1001, '테스트 입니다.' '헬로~', '유저1');
 
insert into Board (idx, title, contents, writer)
            values(1002, '공지사항' '없음', '관리자');
            
insert into Board (idx, title, contents, writer)
            values(1003, '가입' '안녕하세요', '유저2');

select * from Board;
