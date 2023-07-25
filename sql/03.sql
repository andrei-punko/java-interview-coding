
-- 03. Даны две таблицы:
-- Employee (id, salary,  dpt_id)
-- Department (id, name)
-- Написать sql-запрос, который выберет все названия отделов, суммарная зарплата сотрудников в которых больше 1000

create table Employee (
  id int primary key,
  salary int not null,
  dpt_id int not null
);

create table Department (
  id int primary key,
  name varchar(80) not null unique
);

insert into Department(id, name) values (1, 'industrial');
insert into Department(id, name) values (2, 'finance');
insert into Department(id, name) values (3, 'sales');

insert into Employee(id, salary, dpt_id) values (1, 300, 1);
insert into Employee(id, salary, dpt_id) values (2, 600, 1);
insert into Employee(id, salary, dpt_id) values (3, 600, 2);
insert into Employee(id, salary, dpt_id) values (4, 100, 2);
insert into Employee(id, salary, dpt_id) values (5, 900, 3);
insert into Employee(id, salary, dpt_id) values (7, 400, 2);

select * from Employee;
select d.name from Department d where d.id in (select dpt_id from Employee group by dpt_id having sum(salary)>1000);
