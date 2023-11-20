create table schedule(
    title           varchar2(100)     not null,
    start_date   date                 not null,          
    end_date    date                not null
);

insert into schedule values('데이터베이스 구현 평가','23/11/21', '23/11/21');
insert into schedule values('데이터베이스 구현 재평가','23/11/27', '23/11/27');

insert into schedule values('웹 표준 UI 구현 평가','23/12/19', '23/12/19');
insert into schedule values('웹 표준 UI 구현 재평가','23/12/26', '23/12/26');

insert into schedule values('크리스마스 연휴','23/12/23', '23/12/25');
insert into schedule values('새해 연휴','23/12/30', '24/01/01');

select * from schedule order by start_date;

delete from schedule where title ='새해 연휴';

commit;
rollback;

desc schedule;

select * from schedule 
    where 
        extract(month from start_date) = 12 -- 해당하는 월 
    order by start_date desc;
