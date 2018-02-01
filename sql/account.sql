drop table chris.account;
create table chris.account 
(id 			varchar(32) not null primary key,
 name 			varchar(40) not null,
 address		varchar(40) not null,
 state			varchar(40) not null,
 zip			varchar(40) not null,
 create_date	date not null,
 status			integer not null);
 
 create table chris.account_details (
 id 			varchar(32) not null primary key,
 mimetype		varchar(40) not null,
 filename		varchar(40) not null,
 picture		blob(16M),
 length			bigint not null,
 create_date	date
 );
 
insert into chris.account(id,name,address,state,zip,create_date,status)
values
('9191919', 'Account1', '100 Main Street', 'Virginia', '20171', CURRENT_DATE, 100);
