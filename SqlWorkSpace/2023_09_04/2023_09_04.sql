create sequence reply_seq
    start with 1001
    increment by 1
    minvalue 1001
    maxvalue 99999999999999999
    nocache;
    
create table reply (
    idx         number,             default reply_seq.nextval,
    board_idx   number,
    contents    clob,
    writer      varchar2(20),
    wdate       date                default sysdate,
    
    constraint reply_idx primary key(idx),
    constraint reply_writer foreign key(board_idx) references board(idx)
);

desc reply;

insert into 
    reply(board_idx, contents, writer)
    values(1775, '댓글테스트', '관리자');
