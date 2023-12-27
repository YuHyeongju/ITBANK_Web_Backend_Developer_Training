select sysdate from dual;

select extract(year from start_date) from schedule;
select extract(month from start_date)from schedule;
select extract(day from start_date)from schedule;


-- 날짜 연도끼리만 추출하여 비교하기
select 
    extract(year from end_date)
    -
    extract(year from start_date) as year_diff
        from schedule;
-- 0이면 당일을 의미하고 1은 하루차이가 난다를 의미함.
-- 끝날짜에서 시작날짜를 빼면 기간이 나옴

select 
    end_date - start_date + 1
        from schedule;
