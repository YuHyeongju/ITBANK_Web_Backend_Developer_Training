
create SEQUENCE product_seq
    start with  1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;

select * from product;


create table product(
    idx          number          default product_seq.nextval primary key,
    name       varchar2(100)         not null unique,
    price       number            not null check(price  >= 0)
)

commit;

desc product;

insert into product(name, price) values('���� ��ũ ũ��ġ', 5000); 
insert into product(name, price) values('���� �ٴҶ� ����ī���', 4500);
insert into product(name, price) values('���󿡸��� �Ϻ�! ����!', 4000);
insert into product(name, price) values('���� ��Ÿ ������', 4500);
insert into product(name, price) values('������ �ܰ���', 4500);
insert into product(name, price) values('���ڳ��� ��', 4000);
insert into product(name, price) values('���ݸ� ����', 4500);
insert into product(name, price) values('�̻��� ������ �ػ���', 4500);





