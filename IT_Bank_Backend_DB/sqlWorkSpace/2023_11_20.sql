create table student1(
    name        varchar2(50),   
    age           number,
    kor     number,
    eng    number,
    math     number 
);

desc student1;  -- ���̺� �÷��� �̸��� Ÿ�� ���

drop table student1;

insert into student1 values('�̻���',27,100,99,87);
insert into student1 values('������',27,98,97,86);
insert into student1 values('������',27,85,92,88);

select * from student1;

update student1
    set age = 24
    where name = '������';
    
    
select      -- ����  �л����� ���
    name,
    age,
    kor,
    eng,
    math,
    kor + eng + math as total,  -- ����� ���� total�̶�� �̸����� �ҷ���
    --round((kor + eng + math) / 3) as average  -- �Ҽ��� ���� ���� �߶�
    to_char((kor + eng + math)/ 3, 'fm999.00') as average -- ������� fm999.00 �������� ��ȯ����
        from student1
    order by 
        total desc;   -- total�� �������� �������� ����

select avg(kor) from student1;
select avg(eng) from student1;
select avg(math) from student1;

select 
    to_char(avg(kor + eng + math) / 3, 'fm999.00') as average                -- to_char(��, ����)
        from student1;                                                                     -- avg(�÷�  or �÷����Լ���)  
-- ���� �л����� ����� �ٽ� ��ճ� ��.   

-- TO_CHAR('���ڿ�', 'FM999.00')
-- �̷��� FM�� ����ϰ� ���� ������ �־��ָ�ȴ�.

-- - FM : �¿� ���� ����.

-- - 9 : �������� ������ 0�̰ų� ���ڰ� ���� �� ���� ������.

-- - 0 : �������� ������ ��ȯ�� ������ ���̸� ���߰� ������ ���ϴ� ���̸�ŭ 0���� ä���ָ� �ȴ�.


select 10 + 20 as result 
    from dual;  -- dual�� �������̺�
    
-- db�� �ݿ��������� ���¿��� ���̺� �ִ� ���� �����ͼ� �Լ��� ����Ͽ� ����� �� �� �ִ�.    
   
   
    
    