select sysdate from dual;

select start_date from schedule;

select sysdate, start_date from schedule;

select sysdate - start_date from schedule;

select
    to_char(sysdate - start_date,'fm999')
        from schedule;
       
-- ����Ŭ���� ||�� ���ڿ� ���ϱ��̴�.
select
    title,
    'D' || to_char(sysdate - start_date,'fm999') as d_day -- as ���� �̸��� rs.getString���� �ҷ��� �����̴�.
        from schedule
    order by start_date;    