create table may26_bbs(
	b_no number(3) primary key,
	b_title varchar2(100 char) not null,
	b_txt varchar2(300 char) not null,
	b_daate date not null
);
create table may261_bbs(
	b_no number(3) primary key,
	b_title varchar2(100 char) not null,
	b_txt varchar2(300 char) not null,
	b_date date not null
);

create sequence may26_bbs_seq;
create sequence may261_bbs_seq;

insert into may26_bbs
values(may26_bbs_seq.nextval,'테스트','테스트트트', sysdate);
insert into may261_bbs
values(may261_bbs_seq.nextval,'테스트','테스트트트', sysdate);

select *from may26_bbs;
select *from may261_bbs;

select *
from( 
	select rownum as rn, b_no, b_title, b_date
	from ( 
		select * 
		from may261_bbs
		order by b_date desc
		)
	)
where rn >=2 and rn<=5;

delete from may261_bbs
where b_no =16;

update may261_bbs set b_title =?,b_txt=?
from may261_bbs 
where condition

-- 파일은 결국 웹서버에 있어야 사용자가 다운받을 수 있고
-- DB서버 -> 웹서버 -> 사용자???
-- db에 파일 - x
-- DB서버에는 파일명만
-- 실전이면 파일명이 길어야한다
create table may30_dataroom(
	d_no number(3) primary key,
	d_title varchar2(100 char) not null,
	d_file varchar2(100 char) not null,
	d_date date not null
);
create sequence may30_dataroom_seq;

insert into may30_dataroom
values(may30_dataroom_seq.nextval,"테스트","",sysdate);

select *from may30_dataroom;

select *
from( 
	select rownum as rn, d_no, d_title, d_date
	from ( 
		select * 
		from may30_dataroom
		order by d_date desc
		)
	)
where rn >=2 and rn<=5;
select *
from( 
	select rownum as rn, d_no, d_title, d_date
	from ( 
		select d_no, d_title, d_date
		from may30_dataroom
		order by d_date desc
		)
	)
where rn >=2 and rn<=5;


