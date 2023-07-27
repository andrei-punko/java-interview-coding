
-- 01. Задача про студентов и их оценки

-- Найти:
-- 1. Среднюю оценку для каждого студента
-- 2. Среднюю оценку для каждого студента с его именем
-- 3. Имена студентов, кто получил только оценки 4 и 5
-- 4. Имена студентов, кто никогда не получал оценку 5
-- 5. Количество студентов в каждом городе
-- 6. Количество адресов для каждого студента
-- 7. Все города без студентов, кто получил оценку 1
-- 8. Имя студента, с второй по величине средней оценкой
-- 9. Запрос с использованием партиционирования

create table students (
	id int primary key,
	name varchar(255) not null
);

insert into students (id, name) values (1, 'Sasha');
insert into students (id, name) values (2, 'Pasha');
insert into students (id, name) values (3, 'Natasha');
insert into students (id, name) values (4, 'Dasha');

create table marks (
	student_id int not null,
	mark int not null,
	foreign key (student_id) references students(id)
);

insert into marks (student_id, mark) values (1, 4);
insert into marks (student_id, mark) values (1, 2);
insert into marks (student_id, mark) values (1, 5);
insert into marks (student_id, mark) values (2, 1);
insert into marks (student_id, mark) values (2, 1);
insert into marks (student_id, mark) values (2, 3);
insert into marks (student_id, mark) values (3, 4);
insert into marks (student_id, mark) values (3, 5);
insert into marks (student_id, mark) values (3, 5);
insert into marks (student_id, mark) values (4, 5);
insert into marks (student_id, mark) values (4, 4);
insert into marks (student_id, mark) values (4, 4);

create table city (
	id int primary key,
	name varchar(255) not null
);

insert into city (id, name) values (1, 'Minsk');
insert into city (id, name) values (2, 'Brest');
insert into city (id, name) values (3, 'Grodno');
insert into city (id, name) values (4, 'Gomel');

create table address (
	student_id int not null,
	city_id int not null,
	"text" varchar(255),
	foreign key (student_id) references students(id),
	foreign key (city_id) references city(id)
);

insert into address (student_id, city_id, text) values
 (1, 2, 'Esenina street, 99-12'),
 (2, 1, 'Goretskogo street, 13-56'),
 (2, 1, 'Goretskogo street, 13-57'),
 (3, 4, 'Rafieva street, 4-192'),
 (4, 3, 'Lenina street, 34-9'),
 (4, 2, 'Goretskogo street, 13-56'),
 (4, 4, 'Goretskogo street, 1-2');


-- 1. Средняя оценка для каждого студента:
select student_id, avg(mark) as avg_mark from marks group by student_id order by avg_mark desc;

-- 2. Средняя оценка для каждого студента с его именем:
-- 2.1. Join двух таблиц:
select * from marks m left join students s on m.student_id=s.id;

-- 2.2. Добавляем группировку и сортировку:
select s.name, avg(m.mark) as avg_mark from marks m
left join students s on m.student_id=s.id group by s.name order by avg_mark desc;

-- 3. Имена студентов, кто получил только оценки 4 и 5:
select s.name from marks m left join students s on m.student_id=s.id group by s.name having min(m.mark)>=4;

-- 4. Имена студентов, кто никогда не получал оценку 5:
select s.name from students s left join marks m on s.id=m.student_id group by s.name having max(m.mark)<5;
select s.name from marks m left join students s on s.id=m.student_id group by s.name having max(m.mark)<5; --another tables order in join

-- 5. Количество студентов в каждом городе:
select city_id, count(city_id) from address group by city_id;
select c.name, count(c.name) from address a left join city c on a.city_id=c.id group by c.name;

-- 6. Количество адресов для каждого студента:
select s.name, count(s.name) as addr_count from students s left join address a on s.id=a.student_id group by (s.name) order by addr_count desc;

-- 7. Все города без студентов, кто получил оценку 1:
select c.name from address a right join city c on a.city_id=c.id where a.student_id in(
    select s.id from students s left join marks m on s.id=m.student_id group by s.id having min(m.mark)>1
) group by c.name;

-- 8. Имя студента, с второй по величине средней оценкой

-- 8.1. Выводим средние оценки:
select m.student_id, avg(m.mark) as avg_mark from marks m group by m.student_id order by avg_mark desc;

-- 8.2. Выводим средние оценки с номерами строк:
select m.student_id, avg(m.mark), row_number() over(order by avg(m.mark) desc) as row_number
from marks m group by m.student_id;

-- 8.3. Выбираем вторую строку в предыдущем запросе:
select s.name, avg_mark from (
    select m.student_id, avg(m.mark) as avg_mark, row_number() over(order by avg(m.mark) desc) as row_number from marks m group by m.student_id
) as t inner join students s on t.student_id=s.id where row_number=2;

-- Проблема будет в том случае, когда существует более одной записи с одинаковым целевым средним значением.
-- В этом случае мы должны вывести несколько имен.
-- 8.4. Используем dense_rank() для этого:
select s.name, avg_mark from (
    select m.student_id, avg(m.mark) as avg_mark, dense_rank() over(order by avg(m.mark) desc) as d_rank from marks m group by m.student_id
) as t inner join students s on t.student_id=s.id where t.d_rank=2;

-- 9. Запрос с использованием партиционирования:
select s.name as student_name, a.text as address_text, c.name as city_name, row_number() over(partition by s.name) from
students s left join address a on s.id=a.student_id left join city c on c.id=a.city_id;
