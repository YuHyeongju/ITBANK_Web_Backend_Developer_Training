select * from board order by idx desc;

-- 1.select 결과를 insert 하기 (=테이블 부풀리기)
insert into board(title, contents, writer, vcount)
    select title, contents, writer, vcount 
        from board order by idx desc;
     
commit;        
-- 2.테이블 전체 행 갯수 
select count(*) from board;

-- 3.전체 테이블을 부분적으로 select하기
select * from board
    order by idx desc
        offset 0 rows
        fetch first 10 row only;
-- 0번에서 부터 10줄 가져와라