create table student (
     idnp varchar(13) primary key,
     fistName varchar(50) not null,
     lastName varchar(50) not null ,
     email varchar(100) not null unique ,
     media double precision,
     universityId int,
     foreign key (universityId) references university(id)
);