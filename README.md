# Springboot-Mybatis-MySQL

## 1.MySQL세팅
```sql
create user 'spring'@'%'identified by 'bitc5600';
create database spring;
grant all privileges on spring.* to 'spring'@'%';
use spring;

CREATE TABLE mem(
	id int AUTO_INCREMENT PRIMARY KEY,
	username varchar(100) not null,
	password varchar(100),
	email varchar(100) not null,
	createTime timestamp
)ENGINE=InnoDB CHARSET=utf8;
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
