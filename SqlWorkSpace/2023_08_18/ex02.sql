--SELECT: 조회
--구문:select 열1, 열2...from 테이블명;
select * from person;
select name from person;
select name, birth from person;  -- *는 모든 열을 조회
select birth, name from person;  -- 여러 열은 콤마로 구분 
                                 -- 열 순서는 원하는 순서대로 작성 가능 

-- where :조건절 조건에 일치하는 행 을 지정한다.
-- 비교연산자: >,<,>=,<=,=,!= ,<>(같지않음)
select * from person where name = '홍길동'; --sql에서 문자열 ' '사용
select name, birth from person where height >= 170; 
--조건을 사용하지만 출력을 안할때도있다.

--null은 is 라는 연산으로 판별 가능
select * from person where height = null;
select * from person where height is null;
select * from person where height is not null;

--논리연산자 : AND, OR ,NOT
select * from person where birth >= '00/01/01' --2000년생이상

--구문이 너무 길면 줄을 나누어 실행
select * from person
        where birth < '00/01/01'
        and height >= 170;

--3. order by : 정렬
-- - ASC: 오름차순 . 기본값
-- - DESC: 내림차순
select * from person order by height;
select * from person order by height asc;
select * from person order by height desc;

select * from person order by name;
select * from person order by name asc;

select * from person  -- 테이블 , 조건 ,정렬 순
    where birth>='00/01/01' 
    order by name asc;

--연습 : 나이가 많은 순으로 정렬
select * from person 
    order by birth; --나이가 많으면 숫자가 적어지니 오름차순
