/*
drop table orderline;
drop table product;
drop table productorder;
drop table sale;
drop table costumer;
drop table city;
*/


SET @@GLOBAL.auto_increment_increment = 10;
/*SET @@SESSION.auto_increment_increment = 10;*/


create table City 
	 (Code int(7) primary key auto_increment,
     Name varchar(30) not null,
     PostCode integer(5) not null,
     unique(Name, PostCode)) ENGINE=INNODB;
alter table City auto_increment = 10;


     
create table Costumer
	(CostomerNumber varchar(7) primary key auto_increment,
     LastName varchar(25) not null,
     FirstName varchar(15) not null,
     FirstName2 varchar(15),
     FirstName3 varchar(15),
     VIP boolean,
     NationalResgistrationNumber varchar(15) not null,
     AccountNumber varchar(7) not null,
     Street varchar(30) not null,
     HouseNumber varchar(5) not null,
     MobilePhone varchar(13),
     LandlinePhone varchar(12),
     DateOfBirth date not null,
     Code int(7) not null, 
     foreign key fk_City (Code) references City(Code)) ENGINE=INNODB;
alter table Costumer auto_increment = 10;
     

create table ProductOrder
	(OrderCode varchar(7) primary key auto_increment,
     CreationDate date not null,
     TargetDate date not null,
     CostomerNumber varchar(7) not null,
     foreign key fk_Costomer (CostomerNumber) references Costumer(CostomerNumber)) ENGINE=INNODB;
alter table ProductOrder auto_increment = 10;


create table Sale
	(SaleCode varchar(7) primary key,
     CreationDate date not null,
     TargetDate date not null,
     CostomerNumber varchar(7) not null,
     foreign key fk_CustomerNumber(CostomerNumber) references Costumer(CostomerNumber)) ENGINE=INNODB;
alter table Sale auto_increment = 10;

     
create table Product
	(ProductCode varchar(7) primary key,
     Name varchar(30) not null,
     Price decimal(6,2) not null,
     ReductionPercentage decimal(5,2) not null,
     AmountInventory int(7) not null) ENGINE=INNODB;
alter table Product auto_increment = 10;

     
create table OrderLine
	(LineCode varchar(7) primary key,
     LineNumber int(2) not null,
     Price decimal(6,2) not null,
     ReductionPercentage decimal(5,2) not null,
     Amount int(3) not null,
     OrderCode varchar(7) not null,
     SaleCode varchar(7) not null,
     ProductCode varchar(7) not null,
     foreign key fk_Order (OrderCode) references ProductOrder(OrderCode),
     foreign key fk_Sale (SaleCode) references Sale(SaleCode),
     foreign key fk_Product (ProductCode) references Product(ProductCode)) ENGINE=INNODB;
alter table OrderLine auto_increment = 10;

