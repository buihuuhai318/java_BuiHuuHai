create database thehome;

use thehome;

create table item_types (
item_type_id int primary key auto_increment,
item_type_name varchar(50)
);


create table items (
item_id int primary key auto_increment,
item_code varchar(50) not null unique,
item_name varchar(50) not null,
item_price int not null,
item_inventory int not null default 0,
item_decreption varchar(200),
item_type_id int,
foreign key (item_type_id) references item_types(item_type_id)
);

create table item_images (
image_id int primary key auto_increment,
image_url varchar(100),
item_id int,
foreign key (item_id) references items(item_id)
);

create table roles (
role_id int primary key auto_increment,
role_name varchar(50) not null
);

create table accounts (
account_id int primary key auto_increment,
account_email varchar(100) unique not null,
account_username varchar(50) unique not null,
account_password varchar(50) not null,
account_create_date date,
account_status int not null default 0,
role_id int default 0,
foreign key (role_id) references roles(role_id)
);

create table employees (
employee_id int primary key auto_increment,
employee_name varchar(100) not null,
employee_salary int,
employee_gender int not null,
employee_birthday date,
employee_phone varchar(20) not null,
account_email varchar(100) not null,
employee_adress varchar(100),
employee_status int not null default 0,
employee_image varchar(100),
account_id int unique not null,
foreign key (account_id) references accounts(account_id)
);
create table customer_types (
customer_type_id int primary key auto_increment,
customer_type_name varchar(50) not null
);

insert into customer_types value
(1, "Diamond"),
(2, "Gold"),
(3, "Sliver");

create table customers (
customer_id int primary key auto_increment,
customer_name varchar(100) not null,
customer_gender int not null,
customer_birthday date,
customer_phone varchar(20) not null,
customer_email varchar(100) not null,
customer_address varchar(100),
customer_status int default 0,
customer_image varchar(100),
customer_type_id int,
account_id int unique not null,
foreign key (account_id) references accounts(account_id),
foreign key (customer_type_id) references customer_types(customer_type_id)
);

create table carts (
cart_id int primary key auto_increment,
account_id int,
order_date date not null,
payment_date date,
payment_status int default 0,
foreign key (account_id) references accounts(account_id)
);

create table order_details (
cart_id int,
item_id int,
detail_quantity int not null,
detail_price_total int,
primary key (cart_id, item_id),
foreign key (item_id) references items(item_id),
foreign key (cart_id) references carts(cart_id)
);

-- update accounts
-- set account_status = 1
-- where account_id = 1;

insert into roles value (1, "admin"), (2, "employee"), (3, "customer");

insert into accounts value (1, "buihuuhai318@gmail.com", "admin", "123", "2023-07-07", 0, 1), 
(2, "buihuuhai3108@gmail.com", "employee", "123", "2023-07-07", 0, 2), 
(3, "buihuuhai201738707@gmail.com", "customer", "123", "2023-07-07", 0, 3);

select * from customers;
select * from accounts;
insert into customers value (1, "bui huu hai", 0, "1996-08-31", "0942409424", "buihuuhai318@gmail.com", "da nang", 0, "", 1, 1);
















