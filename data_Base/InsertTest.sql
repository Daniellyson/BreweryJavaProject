
/*Insert Test*/



insert into Customer (LastName, FirstName, FirstName2, FirstName3, VIP, NationalResgistrationNumber, AccountNumber, Street, HouseNumber, MobilePhone, LandlinePhone, DateOfBirth, Code)
values('Teixeira de Vasconcelos', 'Daniellyson', null, null, null, '9102.18-000-00', 'BE00 1234 1234 1234', 'Rue de la Vallée', '10', null, null, '2000-05-12', 105);

insert into Customer (LastName, FirstName, FirstName2, FirstName3, VIP, NationalResgistrationNumber, AccountNumber, Street, HouseNumber, MobilePhone, LandlinePhone, DateOfBirth, Code)
values('Servais', 'Jordan', 'JS', null, null, '00.00.00-000-00', 'BE00 0000 0000 0000 0000', 'NeverLand', '777', null, null, '1996-05-14', 1000);

insert into Customer (LastName, FirstName, FirstName2, FirstName3, VIP, NationalResgistrationNumber, AccountNumber, Street, HouseNumber, MobilePhone, LandlinePhone, DateOfBirth, Code)
values('Teixeira', 'Denis', 'Jhune', 'Elpone', null, '9102.18-000-00', 'BE00 1234 1234 1234', 'Rue de Bruxelles', '1110', null, null, '1998-11-22', 1000);

insert into Customer (LastName, FirstName, FirstName2, FirstName3, VIP, NationalResgistrationNumber, AccountNumber, Street, HouseNumber, MobilePhone, LandlinePhone, DateOfBirth, Code)
values('Caudron', 'Marie', 'Christine', null, null, '00.00.00-000-00', 'BE00 0000 3211 0000 8977', 'Rue de la Vallée', '777', null, null, '1994-02-11', 101);




insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Bud Light', 4.25, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Miller Light', 4.25, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Yuengling', 4.25, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Blue Moon', 6, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Sierra Nevada', 6, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Fat Tire', 6.5, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Lagunitas IPA', 6.5, 10, 10);


insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Bud', 4, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Bud Light Lime', 4, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Miller lite', 4, 10, 10);


insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Amstel Light', 5.5, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Corona', 5.5, 10, 10);

insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Corona Light', 5.5, 10, 10);


insert into Product (Name, Price, ReductionPercentage, AmountInventory)
values('Coors NA', 4, 10, 10);



insert into ProductOrder(CreationDate, TargetDate, CustomerNumber)
values('2018-05-8', '2018-05-8', 2);

insert into ProductOrder(CreationDate, TargetDate, CustomerNumber)
values('2018-05-8', '2018-05-8', 1);





insert into Sale(CreationDate, TargetDate, CustomerNumber)
values('2018-05-8', '2018-05-8', 1);

insert into Sale(CreationDate, TargetDate, CustomerNumber)
values('2018-05-8', '2018-05-8', 2);





insert into OrderLine (LineNumber, Price, ReductionPercentage, Amount, OrderCode, SaleCode, ProductCode)
values(1, 4, 10, 1, 1, 1, 7);



insert into OrderLine (LineNumber, Price, ReductionPercentage, Amount, OrderCode, SaleCode, ProductCode)
values(1, 6.5, 10, 1, 1, 1, 8);


insert into OrderLine (LineNumber, Price, ReductionPercentage, Amount, OrderCode, SaleCode, ProductCode)
values(1, 5.5, 10, 1, 1, 1, 8);


insert into OrderLine (LineNumber, Price, ReductionPercentage, Amount, OrderCode, SaleCode, ProductCode)
values(1, 4.25, 10, 1, 1, 1, 2);


insert into OrderLine (LineNumber, Price, ReductionPercentage, Amount, OrderCode, SaleCode, ProductCode)
values(1, 4.25, 10, 1, 1, 1, 2);


insert into OrderLine (LineNumber, Price, ReductionPercentage, Amount, OrderCode, SaleCode, ProductCode)
values(2, 6.5, 10, 1, 1, 1, 3);


insert into OrderLine (LineNumber, Price, ReductionPercentage, Amount, OrderCode, SaleCode, ProductCode)
values(1, 4, 10, 1, 1, 1, 7);


insert into OrderLine (LineNumber, Price, ReductionPercentage, Amount, OrderCode, SaleCode, ProductCode)
values(2, 4.25, 10, 1, 1, 1, 1);




/*OTHER TEST*/
/*
select prod.Name, prod.ReductionPercentage, prod.Price
from Product prod, Customer cust, ProductOrder ord, OrderLine line
where line.ProductCode = prod.ProductCode AND
line.OrderCode = ord.OrderCode AND
cust.CustomerNumber = ord.CustomerNumber AND
ord.CreationDate >= '01-05-2018' and ord.TargetDate <= '2018-06-01';
*/

/*
select customer.LastName, customer.FirstName, customer.Street, customer.HouseNumber, city.Name, city.PostCode
from Customer, City, ProductOrder
where Customer.Code = City.Code and ProductOrder.CustomerNumber = Customer.CustomerNumber and 
ProductOrder.TargetDate <= '2018-08-01';
*/


