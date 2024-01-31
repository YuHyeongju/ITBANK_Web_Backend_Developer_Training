-- sqlplus / as sysdba;

-- 패스워드가만료 되었다는 오류 표시 - 해결
alter user c##itbank identified by it; -- 아이디 비밀번호 재설정

alter user c##itbank account unlock; -- 계정이 잠겼을때 푸는 구문

select sysdate from dual;
select * from member;

desc member;

commit;

desc member;