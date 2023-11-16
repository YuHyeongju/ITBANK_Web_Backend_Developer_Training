show user;

drop table phonebook;

create table phonebook (
    name        varchar2(100), --�������̹��ڿ� �ִ� 100����Ʈ
    pnum        varchar2(20),  --����Ŭ���� �ѱ��� 1���ڿ� 3����Ʈ(varchar2)
    age         number,        --���� �� �Ǽ�
    favorite    char(1)        --�������̹��ڿ�, (Y, N)
);

-- phonebook ���̺� 10���� ���� ������ ���� (�ѱ� �̸�, favorite �÷� �� ����)
INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('������', '123-456-7890', 25, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('�̼�ȣ', '987-654-3210', 30, 'N');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('�ڼ���', '555-123-4567', 22, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('���μ�', '111-222-3333', 28, 'N');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('������', '444-555-6666', 35, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('�Ӽ���', '777-888-9999', 40, 'N');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('������', '123-789-4560', 27, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('������', '987-654-3211', 32, 'N');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('�����', '555-444-3333', 29, 'Y');

INSERT INTO phonebook (name, pnum, age, favorite)
VALUES ('������', '111-222-7777', 26, 'N');

select * from phonebook;

select * from phonebook      -- phonebook ���̺��� ��� ���� ��ȸ
    order by                        -- ���� ���� �����ϱ�
        favorite desc, name;     -- favorite ���� ��������, name���� ��������

delete from phonebook 
    where name = '������';
    
 update phonebook
    set
        pnum = '123-560-7890'
    where 
        name = '������';   

update phonebook
    set 
        favorite = decode(favorite, 'Y', 'N', 'N', 'Y')
    where
        name = '������';

    

rollback;

commit; 