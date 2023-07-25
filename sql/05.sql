
-- 05. Каков будет результат запроса по получению среднего значения по колонке,
-- если существует строка с null-значением в этой колонке?

create table SALARIES (
    ID int primary key,
    NAME varchar(255) not null,
    SALARY int not null
);

insert into salaries(id, name, salary) values (1, 'Tikhon', 1000);
insert into salaries(id, name, salary) values (2, 'Andrei', 1200);
insert into salaries(id, name) values (3, 'Olga');
insert into salaries(id, name, salary) values (4, 'Yulia', 300);
insert into salaries(id, name, salary) values (5, 'Yana', 600);

-- Получение среднего по колонке:
select avg(SALARY) from SALARIES;
-- При наличии строки с null-значением в колонке будет выведено среднее, как будто этой строки нет.

-- Чтобы получить честное среднее, заменяя null нулями надо использовать coalesce():
select avg(coalesce(SALARY,0)) from SALARIES;
