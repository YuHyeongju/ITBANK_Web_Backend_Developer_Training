-- ���� ������ ���� ���̺� 
select * from tab;

-- book ������ �����͸� �����ϱ� ���� ���̺� ����
-- �����ͺ��̽� ��ü(���̺�, ��, �ε���, ������ ��)�� ����/����/����
-- DDL(Data Definition Language, ������ ���Ǿ�)
create  table book(

    name            varchar2(100),    
    author           varchar2(100),
    publisher       varchar2(100),
    price             number
);

-- ������ ���̽� ��ü�� �����͸� ��ȸ(Q)/����/����/����
-- DML(Data Manipulation Language, ������ ���۾�)
-- DQL(DATA Query Language, ������ ��ȸ��)
select name, author,publisher, price from book;
select * from book;

insert into book (name,author,publisher, price)
    values ('������ Ǫ�ٿ� ����','�ۿ���','��������',19800);
    
insert into book values('���翡 �д� �����Ͽ��','���μ�','����Ͻ�',13800);    
-- �÷��� �����ϸ� ���̺� �������ִµ��� �����͸� ���ʷ� �ְڴٴ� ���̴�.

update book 
    set 
        author  = '�ۿ���',
        publisher = '����� �Ͽ콺'
    where 
            name = '������ Ǫ�ٿ� ����'; 
            
update book
    set
        price = price - 10000
    where 
        name = '������ Ǫ�ٿ� ����'; 

delete book;

-- DCL (Data Control Language, ������ �����)
commit; -- ��������� ������ ���� ������ �ݿ��Ѵ�. (����) 
            -- �ڹٿ����� Auto Commit�� ����Ǿ��־� �ڵ� ����ȴ�.
rollback; --  ��������� ������ ���� ������ �ǵ�����.







