drop table chris.customer_order;
create table chris.customer_order 
(id 			integer not null primary key,
 order_id 		integer not null,
 product_id		varchar(40) not null,
 customer_id	integer not null,
 quantity		integer not null,
 order_date		timestamp not null,
 region         varchar(40) not null,
 notes          varchar(4096),
 amount         decimal(15,2) not null,
 status			integer not null);
 
insert into chris.customer_order(id,order_id,product_id,customer_id,quantity,order_date,region,notes,amount,status)
values
(9191, 372, '8754322WE3H', 5420, 3, CURRENT_TIMESTAMP, 'North America', 'Notes go here', 132.12, 100);
 