
-- 12. Задачка про турникет: есть таблица T(id, timestamp), куда сохраняются проходы через турникет каждого сотрудника.
-- Написать запрос, чтобы посчитать, сколько людей сейчас в здании (часть может быть на обеде).
-- Интервал рабочего времени - известный, фиксированный

create table T (
  id int not null,
  ts timestamp not null
);

insert into T VALUES (1, CURRENT_TIMESTAMP);
insert into T VALUES (2, CURRENT_TIMESTAMP);
insert into T VALUES (2, CURRENT_TIMESTAMP);
insert into T VALUES (3, CURRENT_TIMESTAMP);

SELECT *, date(TS) FROM T;
SELECT *, date(TS) FROM T where date(TS) = date(CURRENT_DATE);
SELECT ID, COUNT(ID) FROM T where date(TS) = date(CURRENT_DATE) group by ID;
select ID from T where date(TS) = date(CURRENT_DATE) group by id having count(id) % 2 = 1;
select count(*) from (select ID from T where date(TS) = date(CURRENT_DATE) group by id having count(id) % 2 = 1) as SUB;
