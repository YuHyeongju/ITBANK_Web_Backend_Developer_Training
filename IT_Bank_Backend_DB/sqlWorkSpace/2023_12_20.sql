
drop sequence bugs_seq;
drop table bugs purge;


create SEQUENCE bugs_seq
    start with 1
    maxvalue 99999
    increment by 1
    nocycle
    nocache;



create table bugs(
    id                  number          default bugs_seq .nextval primary key,
    artist_name     varchar2(500)   not null,
    artist_img        varchar2(500)   not null,
    album_img      varchar2(500)   not null,
    album_name    varchar2(500)   not null,
    name             varchar2(500)   not null,
    genre             varchar2(500)   not null,
    playTime         number           default   0   check(playTime >= 0),
    lyrics              varchar2(4000)  default '-' not null,
    isTitle             number           default 0 check(isTitle in(1,0))
);

desc bugs;

select * from bugs order by id; -- order by�� �� �� �̻� ���� �� �ִ�.

select * from bugs
    where
        name like '%' || '����' || '%'
        or
        artist_name like '%' || '��' || '%'
    order by 
            artist_name,
            name;
            
select * from bugs  -- ��ü ����ϴ°Ŷ� ��������
    where
        name like '%' || '' || '%'
        or
        artist_name like '%' || '' || '%'
    order by 
            artist_name,
            name;            

update bugs
    set
        artist_name ='1',
        album_name ='2',
        name = '3',
        genre = '4',
        playTime = '5',
        isTitle = '0',
        lyrics = '7'
   where
            id = 3;


