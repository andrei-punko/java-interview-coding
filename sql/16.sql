
-- 16. Задача про стадионы и матчи
-- Есть таблица s_m(stadium_id, match_date) c парами (ID стадиона, дата матча на нем).
-- Получить для каждого стадиона количество дней, прошедших с последнего матча.

create table s_m (
	stadium_id int not null,
	match_date date not null
);

insert into s_m(stadium_id, match_date) values (1, '2015-1-1');
insert into s_m(stadium_id, match_date) values (1, '2014-2-1');
insert into s_m(stadium_id, match_date) values (2, '2013-1-4');
insert into s_m(stadium_id, match_date) values (2, '2012-7-1');
insert into s_m(stadium_id, match_date) values (2, '2011-1-12');
insert into s_m(stadium_id, match_date) values (3, '2010-11-12');
insert into s_m(stadium_id, match_date) values (3, '2015-5-7');
insert into s_m(stadium_id, match_date) values (4, '2023-1-1');

-- show for each stadium last match date on it:
SELECT stadium_id, MAX(match_date) from s_m group by stadium_id;

-- show for each stadium days from last match till today:
SELECT stadium_id, (date_trunc('day', now()) - MAX(match_date)) as delta from s_m group by stadium_id order by delta;
