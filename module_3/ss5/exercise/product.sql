create database product;

use product;

create table products (
id int primary key auto_increment,
product_code varchar(10),
product_name varchar(20),
product_price double,
product_amount int,
product_description varchar(50),
product_status bit(1) not null default 0
);

insert products value (1, "p_001", "iphone", 1000, 1, "iphone 13 pro max", 0);
insert products value (2, "p_002", "samsung", 1000, 1, "iphone 13 pro max", 0);
insert products value (3, "p_003", "sony", 1000, 1, "iphone 13 pro max", 0);
insert products value (4, "p_004", "honda", 1000, 1, "iphone 13 pro max", 0);
insert products value (5, "p_005", "yamaha", 1000, 1, "iphone 13 pro max", 0);


create unique index idx_productCode on products (product_code);

create index idx_productName_price on Products (product_name, product_price);

explain select * from products where product_name = 'iphone';

create view product_view as
select product_code, product_name, product_price, product_status
from products;

alter view product_view as
select product_code, product_name, product_price, product_status, product_amount
from products;

drop view product_view;

delimiter //
create procedure get_all_product()
begin
select * from product;
end //
delimiter ;

delimiter //
create procedure add_new_product(
in id int,
in product_code varchar(10),
in product_name varchar(20),
in product_price double,
in product_amount int,
in product_description varchar(50),
in product_status bit(1))
begin
insert into products value (id, product_code, product_name, product_price, product_amount, product_description, product_status);
end
// delimiter ;

delimiter //
create procedure update_product_by_id(
in product_id int,
in product_code varchar(10),
in product_name varchar(20),
in product_price double,
in product_amount int,
in product_description varchar(50),
in product_status bit(1))
begin
update products
set 
product_code = product_code,
product_name = product_name,
product_price = product_price,
product_amount = product_amount,
product_description = product_description,
product_status = product_status
where id = product_id;
end
// delimiter ;

delimiter //
create procedure delete_product_by_id(
in product_id int)
begin
delete from products
where id = product_id;
end
// delimiter ;





