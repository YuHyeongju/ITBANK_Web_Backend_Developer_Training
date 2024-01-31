drop table board3;

create table board3(
    idx             number              GENERATED as IDENTITY primary key,
    title           varchar2(500)       not null,
    writer         varchar2(100)       REFERENCES member(userid),
    content      varchar2(4000)     not null,
    writeDate    Date                   default sysdate,
    isNotice      char(1)                 default 0 check(isNotice in (0,1))

);

select * from member;
select * from board3;

insert into board3(title,writer,content,isNotice) values( '제목1','root','공지사항',1);
insert into board3(title,writer,content,isNotice) values( '제목2','test2','내용2',0);
insert into board3(title,writer,content,isNotice) values( '제목3','test2','내용3',0);
insert into board3(title,writer,content,isNotice) values( '제목4','test2','내용4',0);



commit;

select * from board3;

desc board3;

select * from board3
			order by isNotice desc, idx desc;
            
select * from member;
delete member where idx = 15;

update board3 set content = '���� ī�� ���簡 �ֽ����ϴ�' where idx = 5;
