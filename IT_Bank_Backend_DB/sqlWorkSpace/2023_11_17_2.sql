
drop sequence phonebook_seq;
drop table phonebook purge;

create sequence phonebook_seq
    start with 1
    maxvalue 99999
    increment   by 1    -- 1씩 증가
    nocycle
    nocache;
    
select phonebook_seq.nextval from dual;  -- 현재값을 1 증가시키고 값을 불러온다.
select phonebook_seq.currval from dual;  -- 증가없이 현재값(마지막값)을 불러옴 
-- . : ~의

-- insert into phonebook(idx) (select max(idx) from phonebook); 시퀀스를 안쓰면 이렇게 사용해야함.

create table phonebook(
    idx         number              default phonebook_seq.nextval primary key,  -- 기본값
    name     varchar2(100)       unique not null,                     -- 고유값, 빈 거 없음
    pnum    varchar2(20)          not null,                               -- 빈 거 없음
    age       number                check(age >= 0),                    -- 나이가 0보다 커야함.
    favorite  char(1)                  check(favorite in ('Y','N'))         -- Y, N만 들어갈 수 있음
    
);




select * from phonebook
    order by
        favorite desc,  --  favorite 내림차순(descendant)
        name asc;      --  name 오름차순(ascendant)


-- where 조건절에 기본키를 사용하므로, 예상되는 레코드의 수 는 1 혹은 0 이다.
-- public phonebookDTO selectOne(int idx){
--      phonebookDTO dto = null;
--      dto = template.queryForObject(sql, idx);
--      return dto; dto는 객체가 하나 있거나 혹은 null
-- }

select * from phonebook where idx  = 5;

-- 모든 컬럼의 값을 지정하는 것이 아니므로, 컬럼이름을 직접 명시해야함.
insert into phonebook (name, pnum, age, favorite)
    values('홍길동','010-123-4567',20,'Y');

select * from phonebook  ;

    
update phonebook
    set
        age = 25
    where
        idx = 5;        -- 수정 및 삭제에서 기본키가 있다면
                          -- where 조건절에는 기본키를 포함하는 조건을 작성함. (기본키가 안되면 unique사용)
    
delete from phonebook
    where
        idx = 5;

commit;
