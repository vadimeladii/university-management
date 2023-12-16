create table university (
    id serial primary key ,
    shortName varchar(15) not null,
    fullName varchar(100) not null,
    address varchar(100)
);