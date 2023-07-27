
-- 15. Задача о пользователях и их телефонах

-- Есть таблицы:
-- CUSTOMER(ID,FIRST_NAME,LAST_NAME,MIDDLE_NAME,EMAIL)
-- PHONE(ID,PHONE_NUMBER,ID_CUSTOMER)

-- Вывести имена пользователей, которые имеют тезок (по имени)
-- Вывести ID пользователей c телефонами
-- Вывести ID пользователей без телефона

create table CUSTOMER (
    ID          int primary key,
    FIRST_NAME  varchar(50) not null,
    LAST_NAME   varchar(50) not null,
    MIDDLE_NAME varchar(50),
    EMAIL       varchar(50)
);

create table PHONE (
    ID            int primary key,
    PHONE_NUMBER  varchar(50) not null,
    ID_CUSTOMER   int,
    foreign key (FK_ID_CUSTOMER) references CUSTOMER(ID)
);

insert into CUSTOMER values (1,'Иван','Иванов','Иванович','ivan@mail.com');
insert into CUSTOMER values (2,'Петр','Петров','Петрович','petr@mail.com');
insert into CUSTOMER values (3,'Сидор','Сидоров','Сидорович','sidor@mail.com');
insert into CUSTOMER values (4,'Иван','Егоров','Андреевич','egorov@mail.com');
insert into PHONE values (1,'+375291111111',1);
insert into PHONE values (2,'+375292222222',1);
insert into PHONE values (3,'+375293333333',3);
insert into PHONE values (4,'+375294444444',4);

-- вывести имена пользователей,которые имеют тезок (по имени)
select c.FIRST_NAME from CUSTOMER c group by c.FIRST_NAME having count(c.FIRST_NAME) > 1;

-- вывести ID пользователей c телефонами
select c.ID from CUSTOMER c inner join PHONE p on c.ID = p.ID_CUSTOMER;

-- вывести ID пользователей без телефона
select c.ID from CUSTOMER c where c.ID is not in (select ID_CUSTOMER from PHONE);
