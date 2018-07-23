-----init
CREATE SCHEMA hw;
--users
create table hw.users(user_id int not null AUTO_INCREMENT, name varchar(32) not null, age int not null, primary key(user_id));

--items
create table hw.items(item_id int not null AUTO_INCREMENT, name varchar(32) not null, price int not null, primary key(item_id));

--orders
create table hw.orders(order_id int not null AUTO_INCREMENT, item_id int not null, user_id int not null, volume int not null, primary key(order_id));

--purchases
create table hw.purchases(p_id int not null AUTO_INCREMENT, order_id int not null, p_date date not null, primary key(p_id));

-----inserts
--users
insert into hw.users(name, age) values ('Dima', 28);
insert into hw.users(name, age) values ('Anton', 25);
insert into hw.users(name, age) values ('Sasha', 20);
insert into hw.users(name, age) values ('Oleg', 30);
insert into hw.users(name, age) values ('Ivan', 28);

--items
insert into hw.items(name, price) values ('Samsung Galaxy A5 2017', '19000');
insert into hw.items(name, price) values ('Samsung Galaxy A5 2016', '15000');
insert into hw.items(name, price) values ('Samsung Galaxy A5', '10000');
insert into hw.items(name, price) values ('Samsung Galaxy S8+', '45000');
insert into hw.items(name, price) values ('Samsung Galaxy S8', '40000');
insert into hw.items(name, price) values ('Samsung Galaxy S9+', '65000');
insert into hw.items(name, price) values ('Samsung Galaxy S9', '60000');
insert into hw.items(name, price) values ('Apple Iphone x', '70000');
insert into hw.items(name, price) values ('Apple Iphone 8+', '50000');
insert into hw.items(name, price) values ('Apple Iphone 8', '45000');
insert into hw.items(name, price) values ('Apple Iphone 7+', '40000');
insert into hw.items(name, price) values ('Apple Iphone 7', '35000');

--orders
insert into hw.orders(item_id, user_id, volume) values (1, 2, 1);
insert into hw.orders(item_id, user_id, volume) values (12, 5, 2);
insert into hw.orders(item_id, user_id, volume) values (3, 1, 10);
insert into hw.orders(item_id, user_id, volume) values (6, 4, 2);
insert into hw.orders(item_id, user_id, volume) values (3, 3, 3);
insert into hw.orders(item_id, user_id, volume) values (1, 2, 1);
insert into hw.orders(item_id, user_id, volume) values (5, 2, 1);
insert into hw.orders(item_id, user_id, volume) values (8, 2, 1);

--purchases
insert into hw.purchases(order_id, p_date) values(1, parsedatetime('17-09-2017', 'dd-MM-yyyy'));
insert into hw.purchases(order_id, p_date) values(2, parsedatetime('17-11-2017', 'dd-MM-yyyy'));
insert into hw.purchases(order_id, p_date) values(3, parsedatetime('29-09-2017', 'dd-MM-yyyy'));
insert into hw.purchases(order_id, p_date) values(4, parsedatetime('01-01-2018', 'dd-MM-yyyy'));
insert into hw.purchases(order_id, p_date) values(5, parsedatetime('05-05-2018', 'dd-MM-yyyy'));
insert into hw.purchases(order_id, p_date) values(6, sysdate);
insert into hw.purchases(order_id, p_date) values(7, sysdate);
insert into hw.purchases(order_id, p_date) values(8, sysdate);

drop table hw.purchases

--selects
select p.p_id, p.p_date, i.name as item, i.price, o.volume, u.name as user
from hw.purchases p, hw.orders o, hw.items i, hw.users u
where p.order_id = o.order_id
      and o.item_id = i.item_id
      and o.user_id = u.user_id

create or replace view hw.purchases_view as
  select p.p_id, p.p_date, i.name as item, i.price, o.volume, u.name as user
  from hw.purchases p, hw.orders o, hw.items i, hw.users u
  where p.order_id = o.order_id
        and o.item_id = i.item_id
        and o.user_id = u.user_id

select * from  hw.purchases_view where p_date > sysdate - 180