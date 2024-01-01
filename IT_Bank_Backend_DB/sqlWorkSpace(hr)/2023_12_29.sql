select * from employees;
select count(*) from employees;
select * from departments;
select count(*) from departments;

/*
    �μ� �̸�(departments)�� ������(employees)�� �ľ��ϰ� �ʹ�.
    department_name from departments
    count(*) from employees
    
    �μ� ���̺��� �μ� �̸��� �ְ�,
    ���� ���̺����� ������ �̸��� �μ��� id(����)�� �ִ�.
    
    �μ��̸��� �μ��� �ο����� �ľ��Ϸ��� ��� ����ұ�?

*/

select 
    D.department_name,
    count(*)
        from employees E -- ���� ����
        join departments D
            on E.department_id = D.department_id
          group by D.department_name              -- ���� �Լ��� �ƴ� ����(department_name)�� group by ����. 
        order by count(*) desc;
        
        
        
        
-- join�� �⺻��
select * from employees, departments; /*  īƼ��  ���δ�Ʈ (��������) ī���̼� ��*/
select count(*) from departments;
select count(*) from employees;
select 107 * 27 from dual; -- ��� ����� ���� ����. �� ���̺��� �÷����� ����. -> �ߺ��� ������.


--īƼ�� ���� �����ϱ� ���ؼ� �μ�id�� ��ġ�ϴ� ������ ����
select * from employees, departments
    where   
        employees.department_id = departments.department_id;
   
-- �ΰ� �̻��� ���̺� ���� + ���ο� �ʿ��� ������ ���� �������� �и���.        
select * from employees
    join departments
        on employees.department_id = departments.department_id;
 
 
-- ���� ���ϴ� �÷��� ���� �ҷ��´�.
-- �÷��̸��տ� ���̺��� ����Ͽ� ��� ���̺��� �ҷ����� �ۼ��Ѵ�.
select 
    employees.first_name,
    departments.department_name
    from employees        
        join departments
        on employees.department_id = departments.department_id;
        --      foreign key(child key)    ->����->      parent key(���� ���ϴ� Ű, (����)�ĺ��� �ϰ������, primary key�� unique�� �ɾ���)
        