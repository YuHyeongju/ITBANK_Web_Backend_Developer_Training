select * from tab;
desc employees;


-- ��ü ��� ��ȸ
select * from employees order by employee_id; 

-- ���� �׸� ��ȸ(id�� �������� ���)

select * from employees where employee_id = 100;

-- �˻� ��� ��ȸ(first_name�� �˻�� �����ϴ� ����

select * from employees where first_name like '% s %';
-- s% first_name���� �����ϴ� �͵�
-- %s first_name���� ������ �͵�
-- %s% first_name�� �����ϴ� �͵�


-- �߰� 
insert into employees  EMPLOYEE_ID = ?, first_name = ?  where  employee_id = 100;
-- ����
update employees set first_name = ? , last_name = ? where  employee_id = 100;
-- ����
delete employees where employee_id = 100;