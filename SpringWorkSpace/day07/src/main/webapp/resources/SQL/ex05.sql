-- UPDATE: 갱신

update person
    set name = '홍진호'
    where name = '홍길동';
    
update person
    set
        name = '홍진호'
        height = 172.22,
        birth = '87/02/22',
    where name = '홍길동';    

-- 조건을 생략하면 모든 행이 적용  
update person set name ='김민수'; 
    
rollback;    