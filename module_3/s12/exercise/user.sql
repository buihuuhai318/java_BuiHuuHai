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

