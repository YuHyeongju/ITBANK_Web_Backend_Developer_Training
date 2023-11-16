select * from tab;

create table book(
    name        varchar2(100),
    author      varchar2(100),
    publisher   varchar2(100),
    price       number
    );

select name, author,publisher, price from book;
select * from book;

insert into book(name,author,publisher, price)
    values('전지적 푸바오 시점','송영관','에버랜드',19800);
    
insert into book values('마흔에 읽는 쇼펜하우어','강민수','유노북스',13800);

update book
    set 
        author = '송영관',
        publisher = '위즈덤 하우스'
    where
        name = '전지적 푸바오 시점';
        
update book
    set
        price = price - 10000
    where 
        name = '전지적 푸바오 시점'; 
        
delete book;

commit;
rollback;
