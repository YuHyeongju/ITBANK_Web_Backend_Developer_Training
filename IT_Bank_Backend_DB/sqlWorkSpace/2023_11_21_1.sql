select sysdate from dual;

select start_date from schedule;

select sysdate, start_date from schedule;

select sysdate - start_date from schedule;

select
    to_char(sysdate - start_date,'fm999')
        from schedule;
       
-- 오라클에서 ||는 문자열 더하기이다.
select
    title,
    'D' || to_char(sysdate - start_date,'fm999') as d_day -- as 다음 이름이 rs.getString에서 불러올 별명이다.
        from schedule
    order by start_date;    