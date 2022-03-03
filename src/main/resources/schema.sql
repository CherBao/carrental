--User info
create table users(
id int not null primary key comment 'user id',
name char(20) not null default '0' comment 'user name',
phone char(11) not null comment 'user phone',
password char(8) not null comment 'user password'
);

--Car info
create table car(
id char(7) not null primary key comment 'registration number',
model char(20) not null comment 'car model',
status char(1) not null default '0' comment 'car status',
price decimal not null default 0 comment 'rent per day'
);

--booking info
create table booking(
order_no char(13) not null primary key comment 'booking order number',
user_id char(6) not null comment 'user id',
car_id char(7) not null comment 'car id',
status char(1) not null default '0' comment 'booking status',
rent decimal default 0 comment 'total rent',
pickup_date datetime not null comment 'pick up date',
return_date datetime not null comment 'return date',
create_time datetime not null default current_timestamp comment 'create time'
);