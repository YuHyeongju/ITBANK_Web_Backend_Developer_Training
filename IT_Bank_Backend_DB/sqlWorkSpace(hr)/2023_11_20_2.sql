select * from tab;

desc employees;

select * from employees;

select * from employees where employee_id = 101;

select * from employees where first_name = 'Neena';

select * from employees where employee_id = 206;
-- first_name�� �����ϰ� ���� ����� �θ�

select * from employees where first_name = 'William' and
    last_name = 'Gietz';    -- last_name�� Gietz�� ��� ã�ƶ� ���� �߰�

-- id, �̸����� �ҷ����� �� ����

select * from employees
    where 
        salary >= 10000;            -- �޿��� 10000�޷��̻��� ��� ��ȸ
        
select * from employees
    where
        salary between 10000 and 15000;  -- between A and B A���� B����  
        
select * from employees
    where 
        10000 <= salary         -- ������ ������ �� ����.
        and 
        salary <= 14000;
        
select * from employees
    where 
        hire_date  between '02/01/01' and '04/12/31'    -- ��¥�� �༭ ���̿� �ִ� �� ���
    order by
        hire_date;

select * from employees
    where 
        last_name like 'K%';        -- last_name��  ���� K�� �����ϴ� ��� ��ȸ
        
        
 select * from employees    -- last_name�� ���� e�� ������ ��� ��ȸ
    where 
        last_name like '%e';        
 
 select * from employees    -- last_name�� ���� e�� ������ ��� ��ȸ
    where 
        last_name like '%er%';        -- last_name �̸��� er�� ���ԵǴ� ��� ��ȸ
                                            -- ���� ����� �̸��� ���� �� ������ �ڹٿ��� ����Ʈ�� �޾ƾ���.

select 
    first_name,
    salary,
    hire_date,
    sysdate,     -- �ý��� ���� �ð� �ҷ�����
    sysdate - hire_date     -- ��ǻ�ʹ� 1970�� 1��1�� 0�� 0���� �������� �󸶳� �������� ������ �ð��� ������.
        from employees;
                                            
                                            
select employees_seq.nextval from dual;

select employees_seq.currval from dual;

