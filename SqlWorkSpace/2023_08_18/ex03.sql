--트랜잭션(transaction):작업의 최소한의 단위를 의미
--db에서는 테이블의 행에 변화가 발생시 트랜잭션이 적용됨
--테이블에 발새한 트랜잭션은 적용되지 않으면 실제로 변화가 발생하지 않음



-- INSERT : 추가
-- 구문1: insert into 테이블명 values(값1, 값2....);
-- 구문2: insert into 테이블명(열1,열2...) values(값1,값2....);
insert into person values('윤서준',175.1,'01/02/03');
insert into person(name,height) values('박준영',168.7);
insert into 
    person(height, name)
    values(156.9,'김지우');

rollback;   --현재 트랜잭션을 모두 취소 (=회수)
commit;     --현재 트랜잭션을 모두 적용 (=저장)