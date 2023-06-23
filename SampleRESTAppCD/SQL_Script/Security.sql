use security_credentials;

drop table if exists `authorities`;
drop table if exists `=users`;

create table `users` (
	`username` varchar(50) not null,
	`password` varchar(50) not null,
	`enabled` tinyint(1) not null,
	primary key (`username`)
) engine=InnoDB default charset=latin1;

insert into `users` values 
	('sundhar_sg', '{noop}test123', 1),
	('kishore_k', '{noop}test123', 1),
	('siddharrth_gm', '{noop}test123', 1);
	
create table `authorities` (
	`username` varchar(50) not null,
	`authority` varchar(50) not null,
	unique key `authorities_idx_1` ('username', 'authority'),
	constraint `authorities_ibfk_1` foreign key ('username') references `users` (`username`)
) engine=InnoDB default charset=latin1;

insert into `authorities` values
	('sundhar_sg', 'ROLE_EMPLOYEE'),
	('kishore_k', 'ROLE_EMPLOYEE'),
	('kishore_k', 'ROLE_MANAGER'),
	('siddharrth_gm', 'ROLE_EMPLOYEE'),
	('siddharrth_gm', 'ROLE_MANAGER'),
	('siddharrth_gm', 'ROLE_ADMIN');
	
	
// Custom Tables for Authentication

use `employee_credentials`;

drop table if exists `roles`;
drop table if exists `members`;

create table `members` (
	`userID` varchar(50) not null,
	`password` char(68) not null,
	`active` tinyint not null,
	primay key (`userID`)
) engine=InnoDB default charset=latin1;

create table `roles` (
	`userID` varchar(50) not null,
	`role` varchar(50) not null,
	unique key `authorities_idx_1` (`userID`, `role`),
	constraint `authorities_ibfk_1` foreign key (`userID`) references `members` (`userID`)
) engine=InnoDB default charset=latin1;