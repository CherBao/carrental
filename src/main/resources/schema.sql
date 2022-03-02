--用户信息表
create table users(
id int not null primary key comment '用户Id',
name char(20) not null default '0' comment '用户姓名',
phone char(11) not null default '0' comment '用户手机号码'
);

--车辆信息表
create table vehicle(
id int not null primary key comment '车辆Id',
type char(20) not null comment '汽车型号',
status char(1) not null default '0' comment '车辆状态',
price decimal not null default 0 comment '每天租金'
);

--预定表
create table booking(
order_no char(13) not null primary key comment '预定单号',
user_id int not null comment '用户Id',
vehicle_id int not null comment '车辆Id',
status char(1) not null default '0' comment '订单状态',
rent decimal default 0 comment '租金',
take_date datetime not null comment '取车日期',
tenancy int not null default 0 comment '租期',
create_time datetime not null default current_timestamp comment '创建日期'
);