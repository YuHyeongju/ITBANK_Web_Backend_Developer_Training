-- sqlplus / as sysdba;

-- �н����尡���� �Ǿ��ٴ� ���� ǥ�� - �ذ�
alter user c##itbank identified by it; -- ���̵� ��й�ȣ �缳��

alter user c##itbank account unlock; -- ������ ������� Ǫ�� ����

select sysdate from dual;
select * from member;

desc member;

commit;

desc member;