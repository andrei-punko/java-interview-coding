
-- 13. Рассказать о наследовании таблиц в БД

-- https://langtoday.com/?p=319
-- https://www.postgresql.org/docs/current/ddl-inherit.html

create TABLE insects (
	id int primary key,
	name text,
	size float
);

create TABLE bees (
	can_collect_honey smallint
) INHERITS (insects);

-- Если мы сделаем insert в одну из этих таблиц, то добавляемая строка появится только в той таблицу, в которую мы ее добавляем.
-- Если сделать select из таблицы insects, то в выборку попадут удовлетворяющие критериям записи из ОБОИХ таблиц.
-- Если мы хотим выбирать из строк только родительской таблицы, нужно использовать ключевое слово ONLY: select * from only insects
--
-- Любые связки с другими таблицами (Reference), первичные ключи (Primary Key), ограничения на уникальность (Unique) и
-- другие ограничения (Constraints), существующие для родительской таблицы, не наследуются потомком. Для него нужно
-- создавать свои ключи и ограничения. Отсюда следует, что, например, если мы хотим видеть поле id уникальным, то оно
-- будет таковым только в пределах родительской таблицы.
--
-- Одна таблица может наследовать сразу от нескольких, также и у одного родителя может быть много потомков (с помощью
-- пустой родительской таблицы и потомков можно создавать т.н. партиции (Partition), например, чтобы разнести большие
-- массивы данных по какому-то параметру по разным таблицам для более быстрого доступа и т.п. — в этом случае в каждой
-- партиционной таблице надо поставить проверку на те данные, которые туда пишутся).
---
create TABLE insects (
	id INT primary key,
	name VARCHAR(255),
	size float
);

create TABLE bees (
	can_collect_honey BOOLEAN
) INHERITS (insects);

insert into insects(id, name, size) values (1, 'комар', 3.1);
insert into insects(id, name, size) values (2, 'муха', 7.2);
select * from insects;

insert into bees(id, name, size, can_collect_honey) values (2, 'пчела', 11, true);
insert into bees(id, name, size, can_collect_honey) VALUES (3, 'оса', 8.5, false);
select * from bees;
select * from insects;
