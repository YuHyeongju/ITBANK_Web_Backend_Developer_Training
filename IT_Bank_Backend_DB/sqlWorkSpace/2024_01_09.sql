desc board2;

-- 이미 만들어진 테이블에 컬럼을 추가하기
alter table board2 add
    deleted number default 0 check(deleted in(0,1)); 
 
-- 만들어진 제약 조건을 제거하기   
alter table board2 drop CONSTRAINT
    board2_member_fk;
-- 비회원으로도 글 작성이 가능해짐    

-- 만들어진 제약 조건 추가하기
alter table board2 add 
    CONSTRAINT board2_member_fk
    foreign key(writer)
    references member(userid)
    on delete set null;               -- member table이 삭제되어도 board2 table은 유지된다.
    
select * from board2;    
    
desc board2;        

select idx, title,  deleted from board2 order by idx desc;

select * from board2  order by writer desc;

update board2 -- 대상 게시글의 deleted상태를 반전시킬 수 있음.
    set
        deleted = 1-deleted
    where
        idx = 23;
commit;

-- 이미 등록된 데이터를 그대로 다시 넣기(복제) 
insert into board2(title, writer, content, image, ipaddr) select title, writer , content, image, ipaddr from board2;


-- 페이징 쿼리문
select * from board2
    where deleted = 0
    order by idx desc
    offset 0 rows                   --전체 내용 중, 앞에서 0개를 건너뛰고,
    fetch next 10 rows only;    -- 그 다음 10개 행을 불러온다.
    
delete board2 where idx > 500;

select * from board2 where  idx = 500 order by idx desc;

commit;
select count(*) from board2 where deleted = 0; -- => boardCount
        