
-- 06. Поиск авторов, кто написал не более указанного кол-ва книг в заданном году

-- Есть 2 таблицы:
-- Books(id, name, year, auth_id)
-- Authors(id, name)
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

insert into Authors values (1, 'Pushkin');	-- 3 books in 2016
insert into Authors values (2, 'Esenin');	-- 0 books in 2016
insert into Authors values (3, 'Leskov');	-- 2 books in 2016
insert into Authors values (4, 'Krylov');	-- 4 books in 2016

insert into Books(id, year, auth_id, name) values (1, 2015, 1, 'Евгений Онегин');
insert into Books(id, year, auth_id, name) values (2, 2016, 1, 'Пугачев');
insert into Books(id, year, auth_id, name) values (3, 2016, 1, 'Сказка о рыбаке и рыбке');
insert into Books(id, year, auth_id, name) values (4, 2016, 1, 'Стихи');

insert into Books(id, year, auth_id, name) values (5, 2016, 3, 'Левша');
insert into Books(id, year, auth_id, name) values (6, 2016, 3, 'Премудрый карась');

insert into Books(id, year, auth_id, name) values (8, 2016, 4, 'Ворона и лисица');
insert into Books(id, year, auth_id, name) values (9, 2016, 4, 'Лебедь, рак и щука');
insert into Books(id, year, auth_id, name) values (10, 2016, 4, 'Тришкин кафтан');
insert into Books(id, year, auth_id, name) values (11, 2016, 4, 'Лиса и виноград');
insert into Books(id, year, auth_id, name) values (12, 2017, 4, 'Повар и кот');

select a.id, a.name, count(b.id) from Authors a left join Books b on a.id=b.auth_id
where b.year=2016 or b.year is null group by a.id having count(a.id) <=3 order by a.name;
