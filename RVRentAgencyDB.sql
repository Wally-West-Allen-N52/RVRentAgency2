-- Create database
create database RVRentAgencyDB2;
-- Stsrt DB
USE RVRentAgencyDB2;

--============================================================
-- Create the tables--

CREATE TABLE Destination (
	DestinationID int IDENTITY(1,1) primary key NOT NULL,
	TakeHere varchar(max) NOT NULL,
	DeliverThere varchar(max) NOT NULL,
	);
-- To enter new data
insert into Destination (TakeHere, DeliverThere) values ('São Paulo', 'Mato grosso');
select * from Destination;


CREATE TABLE Promotion(
	PromotionID int IDENTITY(1,1) primary key NOT NULL,
	Promotion varchar(max) NOT NULL,
	Price float NOT NULL,
);
insert into Promotion (Promotion, Price) values ('Natal do Natal', 500);
select * from Promotion;
s
CREATE TABLE ContactUs(
	ContactID int IDENTITY(1,1) primary key NOT NULL,
	Email varchar(max) NOT NULL,
	Phone varchar(20),
	NewMessage varchar(max) NOT NULL,
);
insert into ContactUs (Email, Phone, NewMessage) values ('hoosgetquery@theflash.com', '11 95898-4576', 'This is it the fester message alive');
select * from ContactUs;

CREATE TABLE Home (
	HomeID int IDENTITY(1,1) primary key NOT NULL,
	ClientName varchar(max) NOT NULL,
	fkDestinationID  int NULL,
	fkPromotionID  int NULL,
	fkContactID int null,
);
insert into Home (ClientName, fkDestinationID, fkPromotionID, fkContactID) value ('Cliford Devue');
	select * from Home;

--============================================================

-- Modify the tables
alter table Home add constraint fkDestinationID
foreign key (fkDestinationID)
references Destination (DestinationID)
on delete cascade;

alter table Home add constraint fkPromotionID
foreign key (fkPromotionID)
references Promotion (PromotionID)
on delete cascade;

alter table Home add constraint fkContactID
foreign key (fkContactID)
references ContactUs (ContactID)
on delete cascade;
--===========================================

-- To select tables with foreign key
select * from Home as Home
inner join Destination as d on Home.fkDestinationID = d.DestinationID
inner join Promotion as p on Home.fkPromotionID = p.PromotionID
inner join ContactUs as h on Home.fkContactID = h.ContactID;

-- If of the first conflict mode ...?
-- To select tables with foreign key to another call mode 

--=================== REFAZER TODA ESSA PARTE ===============================
select h.HomeID, h.ClientName, 
d.DestinationID, d.TakeHere, d.DeliverThere,
p.PromotionID, p.Promotion, p.Price,
c.ContactID, c.Email, c.Phone, c.NewMessage
from Home as h
inner join Destination as d on h.fkDestinationID = d.DestinationID
inner join Promotion as p on h.fkPromotionID = p.PromotionID
inner join ContactUs as c on h.fkContactID = c.ContactID


-- To select a trable
select * from Destination; -- Ok
select * from Promotion; -- OK
select * from ContactUs; -- OK
select * from  Home; -- OK



W471984wN250299n






--============================================
-- To delete a table
drop table Destination;
drop table Promotion;
drop table ContactUs;
drop table Home;

use master;
drop database RVRentAgencyDB2;