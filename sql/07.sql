
-- 07. Написать (двумя способами) sql-запрос, который выведет уникальные значения данного столбца

create table students (
    ID int primary key,
    NAME varchar(255) not null
);

insert into students (ID, NAME) values (1, 'Andrei');
insert into students (ID, NAME) values (2, 'Yulia');
insert into students (ID, NAME) values (3, 'Yana');
insert into students (ID, NAME) values (4, 'Andrei');
insert into students (ID, NAME) values (5, 'Elena');

-- 1й способ:
select distinct s.name from students t;

-- 2й способ:
select s.name from students s group by s.name;
