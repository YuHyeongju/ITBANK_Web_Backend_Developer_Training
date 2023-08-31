select writer from board group by writer;
delete from board where writer = 'ㄴㅇㅁㄴㅇ';
commit;

-- 외래키
-- - 다른 테이블의 열을 참조하는 제약 조건
-- - 참조 중인 테이블에 데이터가 없으면 자신의 테이블에 데이터 추가 불가
-- - 우리는 board(writer) -> account(nick) 형태로 지정한다.


create table account(
    userid  varchar2(20)    constraint acc_idx primary key,
    userpw  varchar2(20)    not null,
    nick    varchar2(20)    constraint acc_nick unique not null,
    email   varchar2(100)   not null,
    jdate   date            default sysdate
);

insert into 
    account (userid, userpw, nick, email)
    values('itbank','it','아뱅', 'itbank@gmail.com');

insert into 
    account (userid, userpw, nick, email)
    values('spring','boot','유저1', 'spring@kakao.com'); 


insert into 
    account (userid, userpw, nick, email)
    values('root','qwe','관리자', 'root@naver.com');
    
  



select * from account;
commit;


insert into 
    board(title, writer, contents)
    values('외래키 테스트', '유저1', 'Account에 없는 작성자 입니다.');
    
select * from board order by idx;  
rollback;

insert into 
    board(title, writer, contents)
    values('외래키테스트', '스프링', 'Account에 있는 작성자 입니다.');
    
delete from account where nick ='스프링';
commit;
    