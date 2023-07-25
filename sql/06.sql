
-- 06. Есть 2 таблицы:
-- Books(id, name, year, auth_id),
-- Authors(id, name).
-- Написать запрос, чтобы вывести имена тех авторов, кто написал не более 3 книг в 2016 году, отсортированными по имени

create table Books (
  id int primary key,
  name varchar(255) not null,
  year int not null,
  auth_id int not null
);

create table Authors (
  id int primary key,
  name varchar(255) not null
);

select a.id, a.name, count(a.id) from Authors a left join Books b on a.id=b.auth_id group by a.id having count(a.id) <=3 order by a.name;
