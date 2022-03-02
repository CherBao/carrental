insert into users(id,name,phone) values(1,'李白','18888888888');
insert into users(id,name,phone) values(2,'杜甫','19999999999');
insert into users(id,name,phone) values(3,'王安石','17777777777');
insert into users(id,name,phone) values(4,'苏轼','16666666666');

insert into vehicle(id,type,status,price) values(1,'丰田凯美瑞','0',100.00);
insert into vehicle(id,type,status,price) values(2,'丰田凯美瑞','0',100.00);
insert into vehicle(id,type,status,price) values(3,'宝马650','0',120.00);
insert into vehicle(id,type,status,price) values(4,'宝马650','0',120.00);

insert into booking(order_no,user_id,vehicle_id,status,rent,take_date,tenancy,create_time)
values('2022030200000',1,1,'0',200.00,'2022-3-1 13:12:21',2,'2022-3-2 13:12:21');
insert into booking(order_no,user_id,vehicle_id,status,rent,take_date,tenancy,create_time)
values('2022030200001',2,2,'0',200.00,'2022-3-1 13:12:21',2,'2022-3-2 13:12:21');
insert into booking(order_no,user_id,vehicle_id,status,rent,take_date,tenancy,create_time)
values('2022030200002',3,3,'0',200.00,'2022-3-1 13:12:21',2,'2022-3-2 13:12:21');

