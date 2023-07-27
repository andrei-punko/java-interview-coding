
-- 07. Написать (разными способами) запрос, который выведет уникальные значения данного столбца

create table students (
    ID int primary key,
    NAME varchar(255) not null
);

insert into students (ID, NAME) values (1, 'Andrei');
insert into students (ID, NAME) values (2, 'Yulia');
insert into students (ID, NAME) values (3, 'Tatiana');
insert into students (ID, NAME) values (4, 'Andrei');
insert into students (ID, NAME) values (5, 'Elena');
insert into students (ID, NAME) values (6, 'Tatiana');

-- 1й способ:
select distinct name from students;

-- 2й способ:
select name from students group by name;
