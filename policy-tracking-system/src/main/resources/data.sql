insert into Customer(first_name,last_name,tck_number,phone_number,address,birth_date) values ('sencer','seven','1234','000','Göztepe','2019-12-23');
insert into Policy(description,expiry,product_name,product_type,total) values ('Özel Sağlık Sigortası',4,'Sağlık Sigortası','SS',1000);
insert into Policy(description,expiry,product_name,product_type,total) values ('Eğitim Sigortası',5,'Eğitim Sigortası','ES',900);
insert into customers_policies(customer_id,policy_id) values (1,1);
insert into customers_policies(customer_id,policy_id) values (1,2);