
-- 08. Написать сиквел на использование оконной функции

-- https://en.wikipedia.org/wiki/SQL_window_function
-- https://mode.com/sql-tutorial/sql-window-functions/

create table people (
	id int primary key,
	name varchar(255) not null
);

insert into people (id, name) values (1, 'Alexey');
insert into people (id, name) values (2, 'Alexander');
insert into people (id, name) values (3, 'Andrei');
insert into people (id, name) values (4, 'Tikhon');
insert into people (id, name) values (5, 'Dmitry');

-- In the SQL, window functions allow access to data in the records right before and after the current record.

-- A window function defines a frame or window of rows with a given length around the current row, and performs
-- a calculation across the set of data in the window. For example next query extracts for each row the values of
-- a window with one preceding and one following row:
select
	LAG(name,1) OVER(ORDER BY name) as prev,
	name,
	LEAD(name,1) OVER(ORDER BY name) as next
	FROM people ORDER BY name

-- List of windows functions: SUM(),COUNT(),AVG(),ROW_NUMBER(),RANK(),DENSE_RANK(),NTILE(),LAG(),LEAD()

-- To narrow the window from the entire dataset to individual groups within the dataset, you can use PARTITION BY.
-- To write several window functions into the same query, using the same window, you can create an alias using WINDOW:
select
	lag(name,1) over name_window as prev,
	name,
	lead(name,1) over name_window as next
	from people
	WINDOW name_window AS (PARTITION BY country ORDER BY name)
	ORDER BY name;
