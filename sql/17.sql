
-- 17. Поиск сотрудников, менеджеры которых покинули компанию

-- Напишите SQL-запрос, который вернет идентификаторы сотрудников, чья зарплата строго меньше $30 000
-- и чей руководитель покинул компанию.
-- Когда сотрудник покидает компанию, его информация удаляется из таблицы Employees, но у его подчиненных
-- остается его идентификатор.

-- Таблица: Employees
-- +-------------+----------+
-- | Column Name | Type     |
-- +-------------+----------+
-- | employee_id | int      |
-- | name        | varchar  |
-- | manager_id  | int      |
-- | salary      | int      |
-- +-------------+----------+
-- В таблице employee_id является первичным ключом для этой таблицы.
-- Эта таблица содержит информацию о сотрудниках, их зарплате и идентификаторе их руководителя.
-- У некоторых сотрудников нет руководителя (manager_id имеет значение null).
-- Верните таблицу результатов (идентификатор, зарплата), упорядоченную по идентификатору сотрудника.

create table Employees (
	employee_id int primary key,
	"name" varchar not null,
	manager_id int,
	salary int not null
);

-- Нужны кейсы:
-- менеджер не покинул компанию и з/п <30к
-- менеджер не покинул компанию и з/п >30к
-- менеджер покинул компанию и з/п <30к
-- менеджер покинул компанию и з/п >30к

insert into Employees(employee_id, name, manager_id, salary) values (1, 'Владимир', null, 45000);
insert into Employees(employee_id, name, manager_id, salary) values (2, 'Андрей', 1, 29000);	-- менеджер не покинул компанию и з/п <30к
insert into Employees(employee_id, name, manager_id, salary) values (3, 'Алексей', 2, 31000);	-- менеджер не покинул компанию и з/п >30к
insert into Employees(employee_id, name, manager_id, salary) values (4, 'Яна', 6, 29000);		-- менеджер покинул компанию и з/п <30к
insert into Employees(employee_id, name, manager_id, salary) values (5, 'Дмитрий', 7, 31000); 	-- менеджер покинул компанию и з/п >30к
select * from Employees;

-- Нужно найти работников, у которых заполнен manager_id значением, которого уже нет в таблице в колонке employee_id
select e.employee_id from Employees m right join Employees e on m.employee_id=e.manager_id where e.salary < 30000 and m.employee_id is null order by e.employee_id;
