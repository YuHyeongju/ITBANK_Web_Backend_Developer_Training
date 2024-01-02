select * from board order by idx desc;

select * from member;

select idx, title, writer, writeDate from board order by  idx desc; -- 내용을 제외한 데이터 출력

-- 댓글 테이블 추가
create table reply(
    idx             number                GENERATED as IDENTITY primary key, -- 시퀀스를 대체하는 구문(GENERATED as IDENTITY)
    board_idx    number                   not null,     --  원본 게시글 번호
    writer         varchar2(100)            not null,
    content      varchar2(2000)           not null,
    writeDate    date                         default sysdate,
    
    CONSTRAINT  reply_board_idx_fk              -- 제약 조건 정의
    foreign key(board_idx)                     -- 외래키(board_idx)가 
    references  board(idx),                     -- board(idx)를 참조한다.
    
    constraint reply_member_fk              -- 제약 조건 정의
    foreign key(writer)                           -- writer 외래키
    REFERENCES member(userid)            -- member(userid)를 참조함

);

commit;

desc reply;

select * from reply;

insert into reply (board_idx, writer, content) values(1,'root','가입을 환영합니다. 동키님');
-- 댓글을 작성할 게시글의 번호
-- 댓글을 작성할 회원의 userid
-- 내용
insert into reply (board_idx, writer, content) values(2,'donky','안녕하세요 관리자님');

commit;

select * from board order by idx desc; -- 게시판에 있는 댓글 

select * from reply
    where board_idx = 1
    order by idx;

commit;

select  A.idx, A.title, A.writer, count(*) as replyCount from board A, reply B
    where A.idx = B.board_idx group by A.idx, A.title, A.writer;
-- Alias(별칭, 별명)

select idx,title,writer, (select count(*) from reply where board_idx = board.idx) 
    as replyCount
    from board
    order by idx;
-- 서브쿼리를 사용하여 불러오기

select B.idx,B.title,B.writer,B.writeDate,
    count(B.idx) as replyCount
    from board B
    join reply R
        on B.idx = R.board_idx
        group by
            B.idx, B.title, B.writer, B.writeDate;
--집계함수를 같이 조회하면 집계함수가 아닌 컬럼들은 group By에 적어주어야한다.
-- 조인을 사용하여 불러오기  

-- 모든 댓글 개수
select count(*) from reply;
select * from reply;

-- 특정 게시글에 작성된 댓글의 개수
-- 서로 다른 테이블에서 컬럼을 불러올때는 테이블.컬럼 형식으로 명확하게 테이블을 지정한다.
select count(*) from reply where board_idx = 2;

select 
    (select count(*) from reply where board_idx  = board.idx) as replyCount, -- 서브 쿼리
    board.*
    from board
    order by idx desc;
 
select * from board; 
    
delete board where idx = 3;    
rollback;

delete reply where board_idx = 3;
commit;

delete board where idx = 3;    
    