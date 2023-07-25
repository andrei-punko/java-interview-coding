
-- 11. Имеется таблица user(id, age, gender)
-- Необходимо посчитать сколько записей у которых age>20, и сколько записей, у которых gender='M'

create table user (
  id int primary key,
  age int not null,
  gender varchar(1) not null,
  check (gender in ('M','F'))
);

insert into user values (1, 23, 'M');
insert into user values (2, 42, 'F');
insert into user values (3, 18, 'M');
insert into user values (4, 39, 'M');
insert into user values (5, 55, 'F');

-- Используем union:
select count(u.id) from user u where u.age>20 union select count(u.id) from User u where u.gender='M';

-- в Postgres можно и так:
select count(u.age>20), count(u.gender='M') from user u;
