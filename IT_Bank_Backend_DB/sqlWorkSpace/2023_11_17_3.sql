

create table phonebook(
    idx         number              default phonebook_seq.nextval primary key,  -- 기본값
    name     varchar2(100)       unique not null,                     -- 고유값, 빈 거 없음
    pnum    varchar2(20)          not null,                               -- 빈 거 없음
    age       number                check(age >= 0),                    -- 나이가 0보다 커야함.
    favorite  char(1)                  check(favorite in ('Y','N'))         -- Y, N만 들어갈 수 있음
    
);


INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('김지연', '123-456-7890', 25, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('이성호', '987-654-3210', 30, 'N');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('박서연', '555-123-4567', 22, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('정민수', '111-222-3333', 28, 'N');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('송지영', '444-555-6666', 35, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('임성민', '777-888-9999', 40, 'N');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('이혜진', '123-789-4560', 27, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('강민준', '987-654-3211', 32, 'N');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('장수민', '555-444-3333', 29, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('한지원', '111-222-7777', 26, 'N');

commit;

select sysdate from dual;

select * from phonebook;

delete from phonebook where name = '홍길동';

commit;

update phonebook 
    set favorite = decode(favorite,'Y','N','N','Y')
    where 
        name = '홍길동';

update phonebook 
    set idx = 3
    where 
        name = '김지연';

commit;        