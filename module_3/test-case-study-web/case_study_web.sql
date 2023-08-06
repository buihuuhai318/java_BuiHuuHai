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
item_description varchar(200),
item_available int default 0,
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
employee_address varchar(100),
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

create table payment_method (
payment_id int primary key auto_increment,
payment_name varchar(50),
payment_available int
);

select * from bill order by bill_id desc;

create table bill (
bill_id int primary key auto_increment,
cart_id int,
payment_id int,
bill_date date,
total_quantity int,
total_price int,
phone varchar(20),
address varchar(200),
payment_status int,
foreign key (cart_id) references carts(cart_id),
foreign key (payment_id) references payment_method(payment_id)
);


DELIMITER //
CREATE PROCEDURE search_items(IN searchKeyword VARCHAR(100))
BEGIN
    SELECT * FROM items
    join item_types on items.item_type_id = item_types.item_type_id
    WHERE item_type_name LIKE CONCAT('%', searchKeyword, '%') OR item_name LIKE CONCAT('%', searchKeyword, '%');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE hot_items ()
BEGIN
SELECT items.item_id, items.item_name, item_types.item_type_name, SUM(detail_quantity) AS total_quantity, (items.item_price * SUM(detail_quantity)) as total_price
FROM items
left JOIN order_details ON order_details.item_id = items.item_id
left join item_types on items.item_type_id = item_types.item_type_id
GROUP BY items.item_id, items.item_type_id
ORDER BY total_quantity DESC
limit 9;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE hot_accounts ()
BEGIN
SELECT customers.customer_id, accounts.account_username, customers.customer_name, customer_types.customer_type_name, count(bill.cart_id) AS total_bill, SUM(bill.total_price) as total_price
FROM accounts
left JOIN customers ON accounts.account_id = customers.account_id
left JOIN customer_types ON customers.customer_type_id = customer_types.customer_type_id
left JOIN carts ON accounts.account_id = carts.account_id
left join bill on carts.cart_id = bill.cart_id
GROUP BY customer_id, account_username having total_bill > 0
ORDER BY total_price DESC
limit 9;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE revenue_by_current_day()
BEGIN
    DECLARE currentDate DATE;
    SET currentDate = CURDATE();

    SELECT DATE(c.order_date) AS date,
           SUM(b.total_price) AS total_revenue
    FROM carts AS c
    JOIN bill AS b ON c.cart_id = b.cart_id
    WHERE DATE(c.order_date) = currentDate
    GROUP BY DATE(c.order_date);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE revenue_by_current_month()
BEGIN
    DECLARE currentYear INT;
    DECLARE currentMonth INT;

    SET currentYear = YEAR(CURDATE());
    SET currentMonth = MONTH(CURDATE());

    SELECT YEAR(c.order_date) AS year,
           MONTH(c.order_date) AS month,
           SUM(b.total_price) AS total_revenue
    FROM carts AS c
    JOIN bill AS b ON c.cart_id = b.cart_id
    WHERE YEAR(c.order_date) = currentYear AND MONTH(c.order_date) = currentMonth
    GROUP BY YEAR(c.order_date), MONTH(c.order_date);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE revenue_by_current_year()
BEGIN
    DECLARE currentYear INT;
    SET currentYear = YEAR(CURDATE());

    SELECT YEAR(c.order_date) AS year,
           SUM(b.total_price) AS total_revenue
    FROM carts AS c
    JOIN bill AS b ON c.cart_id = b.cart_id
    WHERE YEAR(c.order_date) = currentYear
    GROUP BY YEAR(c.order_date);
END //
DELIMITER ;






select * from bill
join carts on carts.cart_id = bill.cart_id
join accounts on carts.account_id = accounts.account_id
where accounts.account_id = 3
order by bill_id desc;

select accounts.account_id, carts.cart_id, bill.bill_id
from bill 
join carts on bill.cart_id = carts.cart_id
join order_details on carts.cart_id = order_details.cart_id
join accounts on carts.account_id = accounts.account_id
where accounts.account_id = 3;

select accounts.account_id, carts.cart_id, bill.bill_id, bill.bill_date, carts.payment_status, sum(detail_quantity) as quantity, bill.total_price
from bill 
join carts on bill.cart_id = carts.cart_id
join order_details on carts.cart_id = order_details.cart_id
join accounts on carts.account_id = accounts.account_id
group by bill_id;

insert into payment_method value (1, "Cash On Delivery", 0), (2, "VN-PAY", 0);

select * from order_details;

call search_items("Bracelet");

-- update accounts
-- set account_status = 1
-- where account_id = 1;

insert into roles value (1, "admin"), (2, "employee"), (3, "customer");

insert into accounts value (1, "buihuuhai318@gmail.com", "admin", "123", "2023-07-07", 0, 1), 
(2, "buihuuhai3108@gmail.com", "employee", "123", "2023-07-07", 0, 2), 
(3, "buihuuhai201738707@gmail.com", "customer", "123", "2023-07-07", 0, 3);

select * from customers;
select * from accounts;
select * from employees;

select * from item_images where item_id = 32;
select * from items;

select items.item_id, items.item_type_id, item_images.image_url, sum(detail_quantity) from items
join order_details on order_details.item_id = items.item_id
join item_images on item_images.item_id = items.item_id
group by items.item_id;

select * from order_details;
select * from carts;
select * from bill;

select * from items where item_type_id = 1;

SELECT items.item_id, items.item_type_id, GROUP_CONCAT(item_images.image_url) AS image_urls, SUM(detail_quantity) AS total_quantity
FROM items
left JOIN order_details ON order_details.item_id = items.item_id
left JOIN item_images ON item_images.item_id = items.item_id
GROUP BY items.item_id, items.item_type_id
ORDER BY total_quantity DESC
limit 9;

call hot_items;

call hot_accounts;

call hot_items;

call revenue_by_current_day;

call revenue_by_current_month;

call revenue_by_current_year;

-- delete from item_images where image_id = 1;
insert into customers value (1, "bui huu hai", 0, "1996-08-31", "0942409424", "buihuuhai318@gmail.com", "da nang", 0, "", 1, 1);


INSERT INTO `thehome`.`item_types` (`item_type_id`, `item_type_name`) VALUES ('1', 'Bracelet');					
INSERT INTO `thehome`.`item_types` (`item_type_id`, `item_type_name`) VALUES ('2', 'Earrings');					
INSERT INTO `thehome`.`item_types` (`item_type_id`, `item_type_name`) VALUES ('3', 'Necklace');					
INSERT INTO `thehome`.`item_types` (`item_type_id`, `item_type_name`) VALUES ('4', 'Ring');					

select * from item_types;

INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('1', 'BL-001', 'Cuban Twinkle', '50', '10', 'a', '1');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('2', 'BL-002', 'Gold Bracelet', '50', '10', 'a', '1');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('3', 'BL-003', 'Original Tram Huong', '50', '10', 'a', '1');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('4', 'BL-004', 'Skull Bling', '50', '10', 'a', '1');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('5', 'BL-005', 'Tennis Bracelet', '50', '10', 'a', '1');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('6', 'ER-001', 'Ancient Earrings', '5', '10', 'a', '2');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('7', 'ER-002', 'Athena Silver', '50', '10', 'a', '2');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('8', 'ER-003', 'Caba Silver', '50', '10', 'a', '2');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('9', 'ER-004', 'Clytze', '50', '10', 'a', '2');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('10', 'ER-005', 'CTB Bling', '5', '10', 'a', '2');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('11', 'NL-001', 'Cross Shi', '0', '10', 'a', '3');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('12', 'NL-002', 'Crucifix', '50', '10', 'a', '3');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('13', 'NL-003', 'Cuban Necklet', '50', '10', 'a', '3');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('14', 'NL-004', 'Pearl Pure', '50', '10', 'a', '3');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('15', 'NL-005', 'Tennis Necklet', '50', '10', 'a', '3');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('16', 'R-001', 'Lapis Lazuli', '50', '10', 'a', '4');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('17', 'R-002', 'Lotus Silver', '50', '10', 'a', '4');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('18', 'R-003', 'Minimal Star', '50', '10', 'a', '4');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('19', 'R-004', 'Six-mantra', '50', '10', 'a', '4');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('20', 'R-005', 'Snowflake', '50', '10', 'a', '4');											
INSERT INTO `thehome`.`items` (`item_id`, `item_code`, `item_name`, `item_price`, `item_inventory`, `item_decreption`, `item_type_id`) VALUES ('21', 'R-006', 'Way Bling', '50', '10', 'a', '4');											




INSERT INTO `thehome`.`employees` (`employee_id`, `employee_name`, `employee_salary`, `employee_gender`, `employee_phone`, `employee_address`, `employee_status`, `employee_image`, `account_id`) VALUES ('1', 'Le Cong Hoan Thien', '10000000', '1', '123456789', 'Hue', '0', 'a', '1');																						
INSERT INTO `thehome`.`employees` (`employee_id`, `employee_name`, `employee_salary`, `employee_gender`, `employee_phone`, `employee_address`, `employee_status`, `employee_image`, `account_id`) VALUES ('2', 'Bui Huu Hai', '10000000', '1', '123456789', 'Da Nang', '0', 'a', '2');																						
INSERT INTO `thehome`.`employees` (`employee_id`, `employee_name`, `employee_salary`, `employee_gender`, `employee_phone`, `employee_address`, `employee_status`, `employee_image`, `account_id`) VALUES ('3', 'Nguyen Phan Xuan Nghia', '10000000', '1', '123456789', 'Da Nang', '0', 'a', '3');																						
INSERT INTO `thehome`.`employees` (`employee_id`, `employee_name`, `employee_salary`, `employee_gender`, `employee_phone`, `employee_address`, `employee_status`, `employee_image`, `account_id`) VALUES ('4', 'Dinh Thanh Hai', '10000000', '1', '123456789', 'Da Nang', '0', 'a', '4');																						
INSERT INTO `thehome`.`employees` (`employee_id`, `employee_name`, `employee_salary`, `employee_gender`, `employee_phone`, `employee_address`, `employee_status`, `employee_image`, `account_id`) VALUES ('5', 'Vo Nhan Tri', '10000000', '1', '123456789', 'Da Nang', '0', 'a', '5');																						


INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('Cuban-Twinkle.PNG', '1');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('Cuban-Twinkle-1.PNG', '1');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('Cuban-Twinkle-2.PNG', '1');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('gold-bracelet.PNG', '2');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('gold-bracelet-1.PNG', '2');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('gold-bracelet-2.PNG', '2');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('original-tramhuong.PNG', '3');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('original-tramhuong-1.PNG', '3');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('original-tramhuong-2.PNG', '3');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('SkullBling-1.PNG', '4');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('SkullBling-2.PNG', '4');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('SkullBling-3.PNG', '4');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('Tennis bracelet - 2.PNG', '5');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('Tennis bracelet - 3.PNG', '5');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('Tennis bracelet.PNG', '5');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('ancient.PNG', '6');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('ancient-1.PNG', '6');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('ancient-2.PNG', '6');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('ancient-3.PNG', '6');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('athena-silver.PNG', '7');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('athena-silver-1.PNG', '7');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('athena-silver-2.PNG', '7');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('caba-silver.PNG', '8');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('caba-silver-1.PNG', '8');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('caba-silver-2.PNG', '8');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('caba-silver-3.PNG', '8');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('clytze.PNG', '9');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('clytze-1.PNG', '9');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('clytze-2.PNG', '9');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('clytze-3.PNG', '9');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('ctb-bling.PNG', '10');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('ctb-bling-1.PNG', '10');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('ctb-bling-2.PNG', '10');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('ctb-bling-3.PNG', '10');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('cross-shi.PNG', '11');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('cross-shi-1.PNG', '11');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('cross-shi-2.PNG', '11');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('cross-shi-3.PNG', '11');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('crucifix.PNG', '12');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('crucifix-1.PNG', '12');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('crucifix-2.PNG', '12');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('crucifix-3.PNG', '12');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('cuban-twinkle.PNG', '13');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('cuban-twinkle-1.PNG', '13');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('cuban-twinkle-2.PNG', '13');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('cuban-twinkle-3.PNG', '13');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('pearl-pure.PNG', '14');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('pearl-pure-1.PNG', '14');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('pearl-pure-2.PNG', '14');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('pearl-pure-3.PNG', '14');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('tennis-silver.PNG', '15');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('tennis-silver-1.PNG', '15');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('tennis-silver-2.PNG', '15');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('tennis-silver-3.PNG', '15');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('lapis-lazuli.PNG', '16');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('lapis-lazuli-1.PNG', '16');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('lapis-lazuli-2.PNG', '16');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('lotus-silver.PNG', '17');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('lotus-silver-1.PNG', '17');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('lotus-silver-2.PNG', '17');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('lotus-silver-3.PNG', '17');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('minimal-star.PNG', '18');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('minimal-star-1.PNG', '18');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('minimal-star-2.PNG', '18');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('minimal-star-3.PNG', '18');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('six-mantra.PNG', '19');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('six-mantra-1.PNG', '19');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('six-mantra-2.PNG', '19');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('six-mantra-3.PNG', '19');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('snowflake.PNG', '20');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('snowflake-1.PNG', '20');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('snowflake-2.PNG', '20');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('way-bling.PNG', '21');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('way-bling-1.PNG', '21');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('way-bling-2.PNG', '21');
INSERT INTO `thehome`.`item_images` (`image_url`, `item_id`) VALUES ('way-bling-3.PNG', '21');

