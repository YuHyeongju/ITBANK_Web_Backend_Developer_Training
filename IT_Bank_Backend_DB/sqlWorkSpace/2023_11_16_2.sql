show user;

drop table phonebook;

create table phonebook (
    name        varchar2(100), --가변길이문자열 최대 100바이트
    pnum        varchar2(20),  --오라클에서 한글은 1글자에 3바이트(varchar2)
    age         number,        --정수 및 실수
    favorite    char(1)        --고정길이문자열, (Y, N)
);

-- phonebook 테이블에 10줄의 더미 데이터 삽입 (한국 이름, favorite 컬럼 값 설정)
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

select * from phonebook;

select * from phonebook      -- phonebook 테이블의 모든 내용 조회
    order by                        -- 정렬 기준 지정하기
        favorite desc, name;     -- favorite 기준 내림차순, name기준 오름차순

delete from phonebook 
    where name = '김지연';
    
 update phonebook
    set
        pnum = '123-560-7890'
    where 
        name = '김지연';   

update phonebook
    set 
        favorite = decode(favorite, 'Y', 'N', 'N', 'Y')
    where
        name = '한지원';

    

rollback;

commit; 