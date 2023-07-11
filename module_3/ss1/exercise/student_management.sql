create database student_management;

use student_management;

create table student (
	id_student int auto_increment,
    name_student varchar(60),
    age_student int,
    country_student varchar(60),
    primary key (id_student)
);

create table class (
	id_class int auto_increment,
    name_class varchar(60),
    primary key (id_class)
);

create table teacher (
	id_teacher int auto_increment,
    name_teacher varchar(60),
    age_teacher int,
    country_teacher varchar(60),
    primary key (id_teacher)
);

insert into student_management.student (name_student, age_student, country_student) value ("hai", 18, "da nang"), ("thien", 19, "hue");

select * from student_management.student;