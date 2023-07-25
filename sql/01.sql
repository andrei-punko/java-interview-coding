
create table students (
	id int primary key,
	name varchar(255) not null
);

insert into students (id, name) values (1, 'Sasha');
insert into students (id, name) values (2, 'Pasha');
insert into students (id, name) values (3, 'Natasha');
insert into students (id, name) values (4, 'Dasha');

create table marks (
	student_id int not null,
	mark int not null,
	foreign key (student_id) references students(id)
);

insert into marks (student_id, mark) values (1, 4);
insert into marks (student_id, mark) values (1, 2);
insert into marks (student_id, mark) values (1, 5);
insert into marks (student_id, mark) values (2, 1);
insert into marks (student_id, mark) values (2, 1);
insert into marks (student_id, mark) values (2, 3);
insert into marks (student_id, mark) values (3, 4);
insert into marks (student_id, mark) values (3, 5);
insert into marks (student_id, mark) values (3, 5);
insert into marks (student_id, mark) values (4, 5);
insert into marks (student_id, mark) values (4, 4);
insert into marks (student_id, mark) values (4, 4);

create table city (
	id int primary key,
	name varchar(255) not null
);

insert into city (id, name) values (1, 'Minsk');
insert into city (id, name) values (2, 'Brest');
insert into city (id, name) values (3, 'Grodno');
insert into city (id, name) values (4, 'Gomel');

create table address (
	student_id int not null,
	city_id int not null,
	"text" varchar(255),
	foreign key (student_id) references students(id),
	foreign key (city_id) references city(id)
);

insert into address (student_id, city_id, text) values (1, 2, 'Esenina street, 99-12'),
 (2, 1, 'Goretskogo street, 13-56'),
 (2, 1, 'Goretskogo street, 13-57'),
 (3, 4, 'Rafieva street, 4-192'),
 (4, 3, 'Lenina street, 34-9'),
 (4, 2, 'Goretskogo street, 13-56'),
 (4, 4, 'Goretskogo street, 1-2');


-- print average mark for each student
select student_id, avg(mark) as avg_mark from marks group by student_id order by avg_mark desc;

-- print average mark for each student with his name
-- join 2 tables firstly:
select * from marks m left join students s on m.student_id=s.id;
-- now add grouping and sorting:
select s.name, avg(m.mark) as avg_mark from marks m left join students s on m.student_id=s.id group by s.name order by avg_mark desc;

-- print names of students who got only 4 and 5 marks
select s.name from marks m left join students s on m.student_id=s.id group by s.name having min(m.mark)>=4;

-- print names of students who never got 5 mark
select s.name from students s left join marks m on s.id=m.student_id group by s.name having max(m.mark)<5;
select s.name from marks m left join students s on s.id=m.student_id group by s.name having max(m.mark)<5; --another tables order in join

-- print amount of students from each city
select city_id, count(city_id) from address group by city_id;
select c.name, count(c.name) from address a left join city c on a.city_id=c.id group by c.name;

-- print amount of addresses for each student
select s.name, count(s.name) as addr_count from students s left join address a on s.id=a.student_id group by (s.name) order by addr_count desc;


-- print all cities without students who got 1 mark
select c.name from address a right join city c on a.city_id=c.id where a.student_id in(
    select s.id from students s left join marks m on s.id=m.student_id group by s.id having min(m.mark)>1
) group by c.name;


-- play with over function

-- prepare tables using join
select * from students s left join address a on s.id=a.student_id left join city c on c.id=a.city_id;

-- show row numbers using partitioning by s.name
select s.name as student_name, a.text as address_text, c.name as city_name, row_number() over(partition by s.name) from 
students s left join address a on s.id=a.student_id left join city c on c.id=a.city_id;


-- print name of student who has second average mark from top
-- print averages:
select m.student_id, avg(m.mark) as avg_mark from marks m group by m.student_id order by avg_mark desc;
-- print averages with row numbers:
select m.student_id, avg(m.mark), row_number() over(order by avg(m.mark) desc) as row_number from marks m group by m.student_id;
-- show second salary with student name:
select s.name, avg_mark from (
    select m.student_id, avg(m.mark) as avg_mark, row_number() over(order by avg(m.mark) desc) as row_number from marks m group by m.student_id
) as t inner join students s on t.student_id=s.id where row_number=2;

-- problem, when we have more than one same salaries. in that case we need to show several names
create table salary (
	student_id int not null unique,
	value decimal(11,3),
	foreign key (student_id) references students(id)
);

insert into salary(student_id,value) values 
(1, 1000.0), 
(3, 700.0),
(2, 700.0),
(4, 500.0);

-- row_number() shows different numbers for different values, rank() and dense_rank() show same numbers
select s.*, rank() over(order by s.value desc) from salary s;

-- show student_ids for second salary
select student_id from (
    select s.*, rank() over(order by s.value desc) as rank from salary s
) as s_ranked where s_ranked.rank=2;

-- show student names
select st.name from (
    select s.*, rank() over(order by s.value desc) as rank from salary s
) as s_ranked left join students st on s_ranked.student_id=st.id where s_ranked.rank=2;
