create table jun081_snack(
	s_name varchar2(10 char) not null,
	s_price number(5) not null
);

insert into jun081_snack
values ('초코파이정',25000);
insert into jun081_snack
values ('빼빼로',2000);
insert into jun081_snack
values ('새우깡',4000);
insert into jun081_snack
values ('포테토칩',2500);
insert into jun081_snack
values ('초코칩',3000);

select * from jun081_snack;

create table jun081_coffee(
	c_name varchar2(20 char) not null,
	c_price number(5) not null
);

insert into jun081_coffee values('아메리카노', 2500);
insert into jun081_coffee values('카페라떼', 3000);
insert into jun081_coffee values('카페모카', 3500);
insert into jun081_coffee values('돌체라떼', 4000);
insert into jun081_coffee values('블루베리스무디', 5500);

select * from jun081_coffee;
