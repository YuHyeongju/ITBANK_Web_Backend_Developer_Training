
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

insert into product(name, price) values('고디바 다크 크런치', 5000); 
insert into product(name, price) values('고디바 바닐라 초코카라멜', 4500);
insert into product(name, price) values('도라에몽의 팥붕! 슈붕!', 4000);
insert into product(name, price) values('팝핑 스타 라이즈', 4500);
insert into product(name, price) values('엄마는 외계인', 4500);
insert into product(name, price) values('초코나무 숲', 4000);
insert into product(name, price) values('초콜릿 무스', 4500);
insert into product(name, price) values('이상한 나라의 솜사탕', 4500);





