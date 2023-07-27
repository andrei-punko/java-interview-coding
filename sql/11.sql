
-- 11. Объединение результатов двух запросов с разными условиями

-- Есть таблица user(id, age, gender)
-- Необходимо посчитать (одним запросом) сколько записей, у которых age>20 И сколько записей, у которых gender='M'

create table users (
  id int primary key,
  age int not null,
  gender varchar(1) not null,
  check (gender in ('M','F'))
);

insert into users values (1, 23, 'M');
insert into users values (2, 42, 'F');
insert into users values (3, 18, 'M');
insert into users values (4, 39, 'M');
insert into users values (5, 55, 'F');

select * from users;

-- Используем union:
select count(u.id) from users u where u.age>20 union select count(u.id) from users u where u.gender='M';

-- в Postgres можно и так:
select count(id) filter (where age > 20) as age_res, count(id) filter (where gender='M') as gender_res from users;
