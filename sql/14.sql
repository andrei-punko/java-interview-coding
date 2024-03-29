
-- 14. Поиск сотрудника с второй по величине зарплатой

-- Есть таблица EMPLOYEE(ID, NAME, SALARY).
-- Написать запрос, который выведет имя сотрудника с второй по величине зарплатой.
-- Учесть случай, когда таких сотрудников может быть более одного.

create table EMPLOYEE (
    ID int primary key,
    NAME varchar(255) not null,
    SALARY decimal(11,3) not null
);

insert into EMPLOYEE (ID, NAME, SALARY) values (1, 'Andrei', 100.0);
insert into EMPLOYEE (ID, NAME, SALARY) values (2, 'Elena', 10.0);
insert into EMPLOYEE (ID, NAME, SALARY) values (3, 'Alexey', 60.0);
insert into EMPLOYEE (ID, NAME, SALARY) values (4, 'Mihail', 123.0);
insert into EMPLOYEE (ID, NAME, SALARY) values (5, 'Boba', 123.0);
insert into EMPLOYEE (ID, NAME, SALARY) values (7, 'Vladimir', 100.0);

-- Решаем, используя под-запрос c limit+offset:
select E.ID, E.NAME from EMPLOYEE E where E.SALARY in
(select SALARY from EMPLOYEE group by SALARY order by salary desc limit 1 offset 1);

-- Решаем, используя под-запрос с оконной функцией:
select ID, NAME from (
    select E.*, dense_rank() over(order by E.SALARY desc) as d_rank from EMPLOYEE E
) as sub_result where sub_result.d_rank=2;
-- Здесь используем dense_rank(), а не rank(), чтобы учесть случай наличия нескольких
-- сотрудников с одинаковой з/п
