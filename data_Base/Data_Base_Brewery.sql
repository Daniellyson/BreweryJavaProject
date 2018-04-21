/*
drop table orderline;
drop table product;
drop table productorder;
drop table sale;
drop table costumer;
drop table city;
*/

/*Doing auto_increment*/

create table City 
	 (Code int(7) primary key,
     Name varchar(30) not null,
     PostCode integer(5) not null,
     unique(Name, PostCode)) ENGINE=INNODB;
     
     
create table Costumer
	(CostomerNumber varchar(7) primary key,
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
     

create table ProductOrder
	(OrderCode varchar(7) primary key,
     CreationDate date not null,
     TargetDate date not null,
     CostomerNumber varchar(7) not null,
     foreign key fk_Costomer (CostomerNumber) references Costumer(CostomerNumber)) ENGINE=INNODB;
     

create table Sale
	(SaleCode varchar(7) primary key,
     CreationDate date not null,
     TargetDate date not null,
     CostomerNumber varchar(7) not null,
     foreign key fk_CustomerNumber(CostomerNumber) references Costumer(CostomerNumber)) ENGINE=INNODB;
     
     
create table Product
	(ProductCode varchar(7) primary key,
     Name varchar(30) not null,
     Price decimal(6,2) not null,
     ReductionPercentage decimal(5,2) not null,
     AmountInventory int(7) not null) ENGINE=INNODB;

     
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


