drop database if exists treningsdagbok;
create schema treningsdagbok;
use treningsdagbok;

create table treningsøkt
	(treningsid INT NOT NULL AUTO_INCREMENT,
    dato date,
    tidspunkt time,
    varighet int,
    form int check(form >= 0 and form <= 10),
    prestasjon int check(prestasjon >= 0 and prestasjon <= 10),
    primary key(treningsid));

create table notat
	(notatid int not null,
    informasjon text,
    treningsid int not null,
    primary key(notatid),
    foreign key(treningsid) references treningsøkt(treningsid) 
		on delete cascade);
    
create table apparat
	(apparatid int not null,
    navn varchar(30),
    beskrivelse text,
    primary key(apparatid));

create table øvelse
	(øvelsesid int not null,
	navn varchar(30),
    primary key(øvelsesid));

create table øvelseutenapparat
	(øvelsesid int not null,
    beskrivelse text,
    primary key(øvelsesid),
    foreign key(øvelsesid) references øvelse(øvelsesid)
		on delete cascade);

create table øvelsemedapparat
	(øvelsesid int not null,
    kilo float,
    sett int,
    apparatID int,
    primary key(øvelsesid),
    foreign key(apparatID) references apparat(apparatid)
		on delete set null,
    foreign key(øvelsesid) references øvelse(øvelsesid)
		on delete cascade); 
    
create table øvelsesgruppe
	(gruppeid int not null,
    primary key(gruppeid));
    
create table øvelseigruppe
	(gruppeid int not null,
    øvelsesid int not null,
    primary key(gruppeid, øvelsesid),
    foreign key(gruppeid) references øvelsesgruppe(gruppeid)
		on delete cascade,
    foreign key(øvelsesid) references øvelse(øvelsesid)
		on delete cascade);

create table øvelsepåøkt
	(treningsid int not null,
    øvelsesid int not null,
    primary key(treningsID, øvelsesid),
    foreign key(treningsid) references treningsøkt(treningsid)
		on delete cascade,
    foreign key(øvelsesid) references øvelse(øvelsesid)
		on delete cascade);