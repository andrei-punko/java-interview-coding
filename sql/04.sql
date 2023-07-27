
-- 04. Переложить файловую систему на таблицу БД. Написать запрос к ней

-- Есть папки и файлы, в них могут быть другие папки и файлы. Свести всё в одну таблицу
-- Составить запрос на получение всех папок второго уровня вложенности (от находящихся в корневой директории)

-- С точки зрения файловой системы файлы и папки идентичны: они имеют некоторое имя и сами могут содержаться
-- в некоторой папке. Корневая директория имеет нулевую вложенность: PARENT_ID IS NULL.

create table FS (
    ID int primary key ,
    NAME varchar(255) not null,
    PARENT_ID int
);

insert into FS (ID, NAME) values (1, 'Program Files');
insert into FS (ID, NAME) values (2, 'Users');
insert into FS (ID, NAME, PARENT_ID) values (3, 'Andrei', 2);
insert into FS (ID, NAME, PARENT_ID) values (4, 'Docs', 3);
insert into FS (ID, NAME, PARENT_ID) values (5, 'Tikhon', 2);

-- Все папки:
select * from fs;

-- Папки в корневой директории:
select id from fs where parent_id is null;

-- Папки первого уровня вложенности:
select id from fs where parent_id in (select id from fs where parent_id is null);

-- Папки второго уровня вложенности:
select ID, NAME from fs where parent_id in (select id from fs where parent_id in (select id from fs where parent_id is null));
