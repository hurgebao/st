drop database if exists bossdb;
create database bossdb;
use bossdb;
drop table if exists b_account;
create table b_account(
	id int(1) primary key auto_increment comment '主键', 
	account_no varchar(20) comment '交易账号',
	account_name varchar(20) comment '交易账号名称',
	username varchar(20) comment '登陆用户名',
	password varchar(20) comment '密码',
	org_no varchar(20) comment '机构代码',
	mobile varchar(20) comment '手机号',
	account_status char(1) comment '账户状态'
) comment '账户信息表'; 
insert into b_account (account_no,account_name,username,password,org_no,mobile,account_status) values('6000012','张三','zhangsan','123456','12','15800000000','1');