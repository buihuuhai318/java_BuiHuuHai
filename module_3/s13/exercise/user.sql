create database users;

use users;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(120) NOT NULL,
    email VARCHAR(220) NOT NULL,
    country VARCHAR(120)
);
insert into users(name,email,country)
values("hai","buihuuhai@gmail.com","viet nam"),("thien","thien@gmail.com","viet nam");
insert into users(name,email,country)
values("nghia","nghia@yahoo.com","thai lan");

DELIMITER //
create procedure select_all()
begin
select *
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
create procedure edit_data(IN id_data int,IN name_data varchar(250),IN email_data varchar(250), IN country_data varchar(250))
begin
update users 
set name = name_data , email = email_data, country = country_data 
where id = id_data;
end ; //
DELIMITER ;

call edit_data(1,"hai","huuhai@gmail.com","india");