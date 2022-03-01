CREATE TABLE user(
id int not null primary key,
name char(20),
phone char(11)
);

CREATE TABLE vehicle(
id int not null primary key,
type char(20),
status char(2),
price DECIMAL
);

CREATE TABLE booking(
userid int not null,
vehicleid int not null,
status char(2),
rent DECIMAL,
begdate DATE,
tenancy int,
constraint   PK_booking   primary   key(userid, vehicleid)   --复合主键
);