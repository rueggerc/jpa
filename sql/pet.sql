drop table chris.pet;
create table chris.pet 
(id 			integer not null primary key,
 species 		varchar(40) not null,
 color			varchar(40) not null,
 weight			float 		not null,
 name			varchar(49) not null);
 
insert into chris.pet(id,species,color,weight,name)
values
(838383, 'canine', 'golden', 75.0, 'Captain');