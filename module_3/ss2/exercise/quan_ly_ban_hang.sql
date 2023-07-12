create database quan_ly_ban_hang;

use quan_ly_ban_hang;

create table customers (
	id_cus			int primary key auto_increment,
    name_cus		varchar(50),
    age				int
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
    name_pro		varchar(50),
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

select id_or, order_date, total_price
from orders;

select name_cus, name_pro
from customers
join orders on customers.id_cus = orders.id_cus
join order_details on orders.id_or = order_details.id_or
join products on order_details.id_pro = products.id_pro
where customers.id_cus = orders.id_cus;

select *
from customers
where not exists (select id_cus
from orders
where id_cus = customers.id_cus);

select orders.id_or, order_date, ifnull(sum(products.price_pro * order_details.quantity), 0) as total_price
from orders
join order_details on orders.id_or = order_details.id_or
join products on order_details.id_pro = products.id_pro
group by id_or;









