
-- 10. Вывести все значения, которые есть в колонке одной таблицы (T1.col1) и отсутствуют в колонке другой таблицы (T2.col2)

create table T1 (
    id int primary key,
    name VARCHAR
);

create table T2 (
    id int primary key,
    name VARCHAR
);

insert into T1(id, name) values (1, 'Alexey');
insert into T1(id, name) values (2, 'Pavel');
insert into T1(id, name) values (3, 'Tikhon');

insert into T2(id, name) values (1, 'John');
insert into T2(id, name) values (2, 'Pavel');
insert into T2(id, name) values (3, 'Yury');

select * from T1 t1 left join T2 t2 on t1.name=t2.name;
select * from T1 t1 left join T2 t2 on t1.name=t2.name where t2.name is null;
select t1.name from T1 t1 left join T2 t2 on t1.name=t2.name where t2.name is null;
