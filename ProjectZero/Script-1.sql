create table customers(
username varchar(30) primary key,
user_password varchar(30) not null,
first_name varchar(30),
last_name varchar(30),
email varchar(50),
phone_number numeric(10, 0),
str_number varchar(10),
str_name varchar(30),
city varchar(30),
state varchar(2),
zip numeric(5, 0),
checking_account boolean default(false),
savings_account boolean default(false)
);

create table accounts(
active boolean default(false) primary key,
checking_account boolean default(false),
savings_account boolean default(false)
);

create table employees(
employee_id serial primary key,
first_name varchar(30),
last_name varchar(30),
access_code varchar(30) not null
);

create table bank_admin(
admin_id serial primary key,
first_name varchar(30),
last_name varchar(30),
access_code varchar(30) not null
);

drop table if exists accounts cascade;


insert into customers(username,user_password,first_name,last_name,email,phone_number,str_number,str_name,city,state,zip,checking_account, savings_account) values 
('test123','test321','test first','test last','test@email.com',8001001000,'01','test dr.','test city','VA', 11111,true,true);

insert into employees(first_name,last_name,access_code) values 
('test first','test last','test123');

insert into bank_admin (first_name,last_name,access_code) values 
('test first','test last','test123');

update customers set username = 'tester' where user_password = 'test321';

select * from customers where username = 'tester';