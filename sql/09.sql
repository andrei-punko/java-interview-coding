
-- 09. Написать запрос с использованием агрегатной функции

-- Sql-запросы с агрегатными функциями
-- https://ru.wikipedia.org/wiki/%D0%90%D0%B3%D1%80%D0%B5%D0%B3%D0%B0%D1%82%D0%BD%D1%8B%D0%B5_%D1%84%D1%83%D0%BD%D0%BA%D1%86%D0%B8%D0%B8
-- Агрегатные функции используются для обобщения данных. К их числу относятся:
-- SUM (сумма)
-- MAX(максимальное значение)
-- MIN (минимальное значение)
-- COUNT (количество значений)
-- AVG (среднее значение, обычно среднее арифметическое)
-- MODE (мода)
-- MEDIAN (медиана)

create table Orders (
  id int primary key,
  amt int not null,
  ts timestamp not null
);

insert into Orders values (1, 3, '2015-07-25 8:53');
insert into Orders values (2, 4, '2016-07-25 8:54');
insert into Orders values (3, 5, '2018-07-25 8:58');
insert into Orders values (4, 6, '2016-09-21 11:00');
insert into Orders values (5, 7, '2016-01-13 13:01');

-- Show sum & average `amt` for Orders which `ts` belongs to definite range:
select sum(amt), avg(amt) from Orders where ts between '2016-01-01' and '2016-12-31';
