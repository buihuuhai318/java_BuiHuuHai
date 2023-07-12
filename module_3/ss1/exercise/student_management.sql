create database student_management;

use student_management;

create table student (
	id_student int primary key auto_increment,
    name_student varchar(60),
    age_student int,
    country_student varchar(60)
);

create table class (
	id_class int primary key auto_increment,
    name_class varchar(60)
);

create table teacher (
	id_teacher int primary key auto_increment,
    name_teacher varchar(60),
    age_teacher int,
    country_teacher varchar(60)
);

insert into student (name_student, age_student, country_student) 
value ("hai", 18, "da nang"), ("thien", 19, "hue");

select * 
from student;