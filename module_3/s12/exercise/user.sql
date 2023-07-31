create table users(
id  int primary key AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120)
);
insert into users(name,email,country)
values("tri","tri@gmail.com","viet nam"),("quy","quy@gmail.com","viet nam");
insert into users(name,email,country)
values("a","aaa","lao");

DELIMITER //
create procedure select_all()
begin
select*
from users;
end ; //
DELIMITER ;
call select_all();

DELIMITER //
create procedure insert_data(IN name varchar(50),IN email varchar(50),IN country varchar(50))
begin 
insert into users(name,email,country)
values(name,email,country);
end ; //
DELIMITER ;
call insert_data("name","email","country");

DELIMITER //
create procedure delete_data(IN id_data int) 
begin
delete from users where id = id_data;
end ; //
DELIMITER ; 


DELIMITER //
create procedure edit_data(IN id_data int,IN name_data varchar(250),IN email_data varchar(250))
begin
update users set name = name_data , email = email_data, country = country_data 
where id = id_data;
end ; //
DELIMITER ;
call edit_data(1,"tri vo","tri@gmail.com","viet nam");