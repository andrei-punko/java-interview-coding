
-- 12. Задачка про турникет: есть таблица T(id, timestamp), куда сохраняются проходы через турникет каждого сотрудника.
-- Написать запрос, чтобы посчитать, сколько людей сейчас в здании (часть может быть на обеде).
-- Интервал рабочего времени - известный, фиксированный

create table T (
  id int not null,
  ts timestamp not null
);

-- 2023-07-25
insert into T VALUES (1, '2023-07-25 8:53');
insert into T VALUES (2, '2023-07-25 8:54');
insert into T VALUES (3, '2023-07-25 8:58');
insert into T VALUES (2, '2023-07-25 13:00');
insert into T VALUES (2, '2023-07-25 14:00');
insert into T VALUES (1, '2023-07-25 17:55');
insert into T VALUES (2, '2023-07-25 17:57');
insert into T VALUES (3, '2023-07-25 18:54');
-- 2023-07-26
insert into T VALUES (1, '2023-07-26 8:51');
insert into T VALUES (2, '2023-07-26 8:59');
insert into T VALUES (3, '2023-07-26 9:01');
insert into T VALUES (1, '2023-07-26 12:00');
insert into T VALUES (4, '2023-07-26 12:01');

-- select all columns and TS truncates to date
SELECT *, date(TS) FROM T;

-- select all columns and TS truncates to date with filtering
SELECT *, date(TS) FROM T where date(TS) = date('2023-07-26');

-- the same but group by ID
SELECT ID, COUNT(ID) FROM T where date(TS) = date('2023-07-26') group by ID;

-- show IDs of employees inside building
select ID from T where date(TS) = date(CURRENT_DATE) group by id having count(id) % 2 = 1;

-- show amount of employees inside building
select count(*) from (select ID from T where date(TS) = date('2023-07-26') group by id having count(id) % 2 = 1) as SUB;

-- the same but use CURRENT_DATE for date value
select count(*) from (select ID from T where date(TS) = date(CURRENT_DATE) group by id having count(id) % 2 = 1) as SUB;
