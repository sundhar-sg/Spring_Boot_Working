create database SampleRESTApp;

use SampleRESTApp;

create table employees(
	id int not null auto_increment, 
    first_name varchar(45) default null,
    last_name varchar(45) default null,
    email varchar(45) default null,
    primary key(id)
);

insert into employees values
	(1, "Sundhar", "S G", "sundhargopal462@outlook.com"),
    (2, "Siddharrth", "G M", "siddhumahi01@gmail.com"),
	(3, "Kishore", "K", "kishorekannan96@gmail.com"),
    (4, "Gokul", "A P", "gokulap07@gmail.com"),
    (5, "Parthasarathi", "M K", "parthasarathimoorthik7@gmail.com");