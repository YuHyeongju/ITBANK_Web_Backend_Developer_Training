drop table phonebook;
drop table phonebook purge;

select * from tab;

select * from recyclebin;  -- 휴지통

purge recyclebin; -- 휴지통 비우기

rollback;

-- 롤백은 DML에 대해 작동한다.
-- drop은 DDL임으로 삭제된 테이블 복구가 안된다.

flashback table phonebook to before drop;
-- drop하기 이전으로 돌아감

select * from phonebook;

flashback table "**" to before drop;    -- **에는 오브젝트 이름을 넣어줌