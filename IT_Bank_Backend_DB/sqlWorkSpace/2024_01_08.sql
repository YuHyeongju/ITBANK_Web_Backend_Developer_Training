drop SEQUENCE member2_seq;
drop SEQUENCE board2_seq;
drop SEQUENCE reply2_seq;
drop table board2;

create SEQUENCE board2_seq
    
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;
    


create table board2(
    idx                 number                      default BOARD_SEQ.nextval primary key,
    title                varchar2(500)               not null,
    writer              varchar2(100)              not null,
    content           varchar2(4000)              not null,
    image             varchar2(500)               ,
    viewCount       number                      default 0,
    writeDate         date                          default sysdate,
    ipaddr              varchar2(100)              not null,
    
    CONSTRAINT board2_member_fk
    FOREIGN key (writer)
    REFERENCES member(userid)
);

select * from board2;
select * from member;

insert into board2 (title, writer, content, image, ipaddr) values('제목1', 'root','내용1','pTVoWDp5G09PGTRUTbCy8raXo9CB47uF2wcuzdUYTlPwRjU6zjl0Reoih4MIXXRTnfxVl-yKlPjTQSVhAbfSxA.webp', '1.1.1.1');
insert into board2 (title, writer, content, image, ipaddr) values('제목2', 'root','내용2',null, '1.1.1.1');
insert into board2 (title, writer, content, image, ipaddr) values('제목3', 'root','내용3','pTVoWDp5G09PGTRUTbCy8raXo9CB47uF2wcuzdUYTlPwRjU6zjl0Reoih4MIXXRTnfxVl-yKlPjTQSVhAbfSxA.webp', '1.1.1.1');
insert into board2 (title, writer, content, image, ipaddr) values('제목4', 'root','내용4',null, '1.1.1.1');
insert into board2 (title, writer, content, image, ipaddr) values('제목4', 'root','내용5','네네치킨.png', '1.1.1.1');


commit;

select * from board2 -- 검색 sql
        where 1=1 -- true
            and( title like '%' || '제목' || '%'
            or writer like '%' || 'test' || '%'
            or content like '%' || '내용' || '%')
        order by idx desc;    
