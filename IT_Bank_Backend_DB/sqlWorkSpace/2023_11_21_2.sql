select sysdate from dual;

select extract(year from start_date) from schedule;
select extract(month from start_date)from schedule;
select extract(day from start_date)from schedule;


-- ��¥ ���������� �����Ͽ� ���ϱ�
select 
    extract(year from end_date)
    -
    extract(year from start_date) as year_diff
        from schedule;
-- 0�̸� ������ �ǹ��ϰ� 1�� �Ϸ����̰� ���ٸ� �ǹ���.
-- ����¥���� ���۳�¥�� ���� �Ⱓ�� ����

select 
    end_date - start_date + 1
        from schedule;
