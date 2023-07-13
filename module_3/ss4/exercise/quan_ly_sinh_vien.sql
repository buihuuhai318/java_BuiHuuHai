create database quan_ly_sinh_vien_new;
use quan_ly_sinh_vien_new;
create table class(
class_id int not null auto_increment primary key,
class_name varchar(60) not null,
start_date datetime not null,
status bit);
create table student(
student_id int not null auto_increment primary key,
student_name varchar(30) not null,
address varchar(50),
phone varchar(20),
status bit,
class_id int not null,
foreign key (class_id) references class (class_id));

create table subject(
sub_id int not null auto_increment primary key,
sub_name varchar(30) not null,
credit tinyint not null default 1 check ( credit >= 1 ),
status bit default 1
);

create table mark(
mark_id int not null auto_increment primary key,
sub_id int not null,
student_id int not null,
mark float default 0 check ( mark between 0 and 100),
exam_times tinyint default 1,
unique (sub_id, student_id),
foreign key (sub_id) references subject (sub_id),
foreign key (student_id) references student (student_id));

insert into class
values (1, 'a1', '2008-12-20', 1);

insert into class
values (2, 'a2', '2008-12-22', 1);

insert into class
values (3, 'b3', current_date, 0);

insert into student (student_name, address, phone, status, class_id)
values ('hung', 'ha noi', '0912113113', 1, 1);

insert into student (student_name, address, status, class_id)
values ('hoa', 'hai phong', 1, 1);

insert into student (student_name, address, phone, status, class_id)
values ('manh', 'hcm', '0123123123', 0, 2);

insert into subject
values (1, 'cf', 5, 1),
      (2, 'c', 6, 1),
      (3, 'hdj', 5, 1),
      (4, 'rdbms', 10, 1);

insert into mark (sub_id, student_id, mark, exam_times)
values (1, 1, 8, 1),
      (1, 2, 10, 2),
      (2, 1, 12, 1);
      
select *
from student
where student_name like "h%";

select *
from student
join class on student.class_id = class.class_id
where month(start_date) = 12;

select *
from student
join mark on student.student_id = mark.student_id
join subject on mark.sub_id = subject.sub_id
where credit between 2 and 5;

update student
set class_id = 2 
where (student_id = 1);

select student_name, sub_name, mark
from student
join mark on student.student_id = mark.student_id
join subject on mark.sub_id = subject.sub_id
order by mark;

select *
from subject
where credit = (select max(credit) from subject);

select s.sub_id, s.sub_name, m.mark
from subject s
join mark m on s.sub_id = m.sub_id
where m.mark = (select max(mark) from mark);

select s.student_id, s.student_name, avg(m.mark) as avg_mark
from student s
join mark m on s.student_id = m.student_id
group by s.student_id, s.student_name
order by avg_mark desc;


















