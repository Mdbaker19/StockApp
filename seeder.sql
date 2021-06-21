create database if not exists stock_db;

use stock_db;

# drop table if exists user_stocks;
# drop table if exists stock;
# drop table if exists user_ledger;
# drop table if exists users;
# drop table if exists account;
# drop table if exists ledger;


delete from users where id = 1;
select * from users;
select * from account;
select * from stock;
select * from ledger;
select * from user_ledger;

insert into stock (price, ticker) values (558.43, 'TZLUH'), (8.40, 'CLOHVE'), (221.99, 'GEEEME'), (.89, 'DOHGGE'), (28999.99, 'COSTALOT');