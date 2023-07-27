
-- 02. Определить, сколько строк будет получено в результате запроса

-- SELECT * FROM TABLE_A, TABLE_B

create table TABLE_A (
    ID int primary key,
    NAME varchar(255) not null
);

create table TABLE_B (
    ID int primary key,
    ADDRESS varchar(255) not null
);

insert into TABLE_A (ID, NAME) values (1, 'Andrei');
insert into TABLE_A (ID, NAME) values (2, 'Elena');
insert into TABLE_A (ID, NAME) values (3, 'Tatsiana');

insert into TABLE_B (ID, ADDRESS) values (1, 'Rafieva, 78');
insert into TABLE_B (ID, ADDRESS) values (2, 'Esenina, 32');

select * from table_a, table_b;
-- Будет получено 6 строк: все комбинации пар строк из двух таблиц (их кол-во 3*2 = 6).
