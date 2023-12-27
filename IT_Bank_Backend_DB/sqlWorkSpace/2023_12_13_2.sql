create sequence youtube_seq
    start with 1
    MAXVALUE 99999
    INCREMENT by 1
    nocycle
    nocache;

drop table youtube;

create table youtube(
    idx                 number          default youtube_seq.nextval primary key,
    title               varchar2(500)   not null,
    name             varchar2(500)   not null,       
    thumbnail       varchar2(500)  not null ,
    tag                varchar2(500)  not null    
    
);

select * from youtube;

desc youtube;

commit;

