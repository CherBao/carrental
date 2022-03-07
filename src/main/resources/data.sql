insert into users(id,name,phone,password) values(1,'Adam','18888888888','88888888');
insert into users(id,name,phone,password) values(2,'Bob','19999999999','88888888');
insert into users(id,name,phone,password) values(3,'Cris','17777777777','88888888');
insert into users(id,name,phone,password) values(4,'Dan','16666666666','88888888');

insert into car(id,model,status,price) values('A888888','Toyota Carmy','0',100.00);
insert into car(id,model,status,price) values('B888888','Toyota Carmy','0',100.00);
insert into car(id,model,status,price) values('C888888','BMW 650','0',120.00);
insert into car(id,model,status,price) values('D888888','BMW 650','0',120.00);

insert into booking(order_no,user_id,car_id,status,rent,pickup_date,return_date,create_time)
values('1646653009428',1,'A888888','9',200.00,'2022-3-1 13:12:21','2022-3-1 13:12:21','2022-3-2 13:12:21');
insert into booking(order_no,user_id,car_id,status,rent,pickup_date,return_date,create_time)
values('1646652526300',2,'B888888','9',200.00,'2022-3-1 13:12:21','2022-3-1 13:12:21','2022-3-2 13:12:21');
insert into booking(order_no,user_id,car_id,status,rent,pickup_date,return_date,create_time)
values('1646311932705',3,'C888888','9',200.00,'2022-3-1 13:12:21','2022-3-1 13:12:21','2022-3-2 13:12:21');

