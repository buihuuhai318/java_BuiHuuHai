create database quan_ly_ban_hang;

use quan_ly_ban_hang;

create table customers (
	id_cus			int primary key auto_increment,
    name_cus	varchar(50),
    age			int
);

create table orders (
	id_or			int primary key auto_increment,
    id_cus			int,
    order_date		date,
    total_price		int,
    foreign key (id_cus) references customers(id_cus)
);

create table products (
	id_pro			int primary key auto_increment,
    nam_pro			varchar(50),
    price_pro		int
);

create table order_details (
	id_or			int,
    id_pro			int,
    primary key (id_or, id_pro),
    quantity		int,
    foreign key (id_or) references orders(id_or),
    foreign key (id_pro) references products(id_pro)
);








