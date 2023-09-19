select *
from gbraucp_sns_reply
where gsr_gs_no = 45

--------------------------------------------------------------------
create table gbraucp_sns_reply(
	gsr_no number(4) primary key,
	gsr_gs_no number(3) not null,			-- 소속 글 번호
	gsr_writer varchar2(10 char) not null, 	-- 댓글쓴사람 id
	gsr_txt varchar2(100 char) not null,
	gsr_date date not null,
	constraint sns_reply
		foreign key (gsr_gs_no) references gbraucp_sns(gs_no)
		on delete cascade,
	constraint sns_reply_writer
		foreign key (gsr_writer) references gbraucp_member(gm_id)
		on delete cascade
);
create sequence gbraucp_sns_reply_seq;
--------------------------------------------------------------------
create table gbraucp_sns(
	gs_no number(3) primary key,
	gs_writer varchar2(10 char) not null,
	gs_txt varchar2(300 char) not null,
	gs_date date not null,
	constraint sns_writer2
		foreign key (gs_writer) references gbraucp_member(gm_id)
		on delete cascade
);
create sequence gbraucp_sns_seq;
--------------------------------------------------------------------
create table gbraucp_member(
	gm_id varchar2(10 char) primary key,
	gm_pw varchar2(10 char) not null,
	gm_name varchar2(10 char) not null,
	gm_birthday date not null,
	gm_addr varchar2(100 char) not null,
	gm_photo varchar2(100 char) not null
);
--------------------------------------------------------------------
-- 로그인
-- 입력한 id/pw랑
-- db에 있는 id/pw랑 비교

-- 1) 모든 계정 다 가져와서
-- DAO에서 for + if으로 비교
-- 계정이 많으면...
select *
from gbraucp_member;

-- 2) id/pw 맞는 계정만 가져와서
-- DAO에서 로그인 성공처리하자
-- SQL injection공격에 취약
select *
from gbraucp_member
where gm_id='test' and gm_pw='a1111';

-- 3) id맞는 계정만 가져와서
-- DAO에서 비번검사
select *
from gbraucp_member
where gm_id='test';
--------------------------------------------------------------------
-- 1) 날짜순역순으로 글만 3 ~ 5번
select *
from (
	select rownum as rn, gs_no, gs_writer, gs_txt, gs_date
	from (
		select *
		from gbraucp_sns
		order by gs_date desc
	)
)
where rn >= 3 and rn <= 5;

-- 2) 날짜순역순으로 3 ~ 5번글 쓴 사람 id, 프사
select gm_id, gm_photo
from gbraucp_member
where gm_id in (
	select gs_writer
	from (
		select rownum as rn, gs_no, gs_writer, gs_txt, gs_date
		from (
			select *
			from gbraucp_sns
			order by gs_date desc
		)
	)
	where rn >= 3 and rn <= 5
);

-- 3) 1, 2 join
select *
from (1), (2)
where gs_writer = gm_id
order by gs_date desc;

select gs_no, gm_id, gm_photo, gs_txt, gs_date
from (
	select *
	from (
		select rownum as rn, gs_no, gs_writer, gs_txt, gs_date
		from (
			select *
			from gbraucp_sns
			where gs_txt like '%%'
			order by gs_date desc
		)
	)
	where rn >= 3 and rn <= 5
), (
	select gm_id, gm_photo
	from gbraucp_member
	where gm_id in (
		select gs_writer
		from (
			select rownum as rn, gs_no, gs_writer, gs_txt, gs_date
			from (
				select *
				from gbraucp_sns
				where gs_txt like '%%'
				order by gs_date desc
			)
		)
		where rn >= 3 and rn <= 5
	)
)
where gs_writer = gm_id
order by gs_date desc;










