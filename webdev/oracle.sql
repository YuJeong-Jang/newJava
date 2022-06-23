--DROP TABLE m1board;
--DROP SEQUENCE m1board_seq;
create table m1board(
no			number			primary key,
title		varchar2(100)	not null,
name		varchar2(30)	not null,
password	varchar2(30)	not null,
content		varchar2(4000)	not null,
writeday	date			default sysdate,
readcount	number			default 0
);

create sequence m1board_seq nocache;

select * from m1board;

delete from m1board where no = 4;