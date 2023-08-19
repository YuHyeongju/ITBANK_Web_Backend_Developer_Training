--delete : 삭제 
-- 구문: delete from 테이블 where 조건;
delete from person where name = '홍길동';


--삭제 전에 조건이 올바른지 select로 디버그 후 삭제에 적용
select * from person where height >= 170; 
delete from person where height >= 170;

--조건을 생략하면 모든 행이 제거
delete from person;

rollback;