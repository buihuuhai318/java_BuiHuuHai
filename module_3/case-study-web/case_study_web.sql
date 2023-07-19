create database thehome;

use thehome;

create table item_types (
type_id int primary key auto_increment,
type_name varchar(50)
);

create table items (
item_id int primary key auto_increment,
item_code varchar(50) not null unique,
item_name varchar(50),
item_price double,
item_inventory int not null default 0,
item_decreption varchar(200),
type_id int,
foreign key (type_id) references item_types(type_id)
);

create table roles_account (
role_id int primary key auto_increment,
role_name varchar(50)
);

create table accounts (
account_id int primary key auto_increment,
account_address varchar(100),
account_birthday date,
account_email varchar(100) not null,
account_phone varchar(20),
account_username varchar(50) unique not null,
account_password varchar(50) not null,
account_create_date date,
account_status bit(1) default 0,
role_id int default 0,
foreign key (role_id) references roles_account(role_id)
);

create table cart (
cart_id int primary key auto_increment,
account_id int,
order_date date,
foreign key (account_id) references accounts(account_id)
);

create table order_detail (
cart_id int,
item_id int,
order_quantity int,
primary key (cart_id, item_id),
foreign key (item_id) references items(item_id),
foreign key (cart_id) references cart(cart_id)
);