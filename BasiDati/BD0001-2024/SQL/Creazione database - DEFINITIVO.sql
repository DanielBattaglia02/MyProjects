drop database if exists Aereoporto;
create database Aereoporto;
use Aereoporto;

create table TipoStrumenti(
ID int not null auto_increment,
nome varchar(50) not null,
descrizione varchar(500) default null,
primary key(ID),
unique(nome)
);

create table CompagniaAerea(
ID int not null auto_increment,
nome varchar(50) not null,
nazionalita varchar(32) not null,
note varchar(500) default null,
primary key(ID),
unique(nome)
);

create table Documentazione(
ID int not null auto_increment,
altezza double not null,
larghezza double not null,
lunghezza double not null,
peso double not null,
carico_Max double not null,
num_Passeggeri int not null,
num_Equipaggio int not null,
num_Motori int not null,
data_Costruzione date not null,
luogo_Costruzione varchar(50) not null,
note varchar(500) default null,
primary key(ID)
);

create table Zona(
ID int not null auto_increment,
nome varchar(50) unique not null,
note varchar(500) default null,
primary key(ID)
);
	
		/*in aereo non servono le note poichè già sono in documentazione*/
create table Aereo(
ID int not null auto_increment,
ID_CompagniaAerea int not null,
ID_Documentazione int not null,
nome varchar(50) unique not null,
stato ENUM('disponibile', 'indisponibile') not null,
note varchar(500) default null,
primary key(ID),
foreign key (ID_CompagniaAerea) references CompagniaAerea(ID),
foreign key (ID_Documentazione) references Documentazione(ID)
);

create table Strumento(
ID int not null auto_increment,
ID_TipoStrumenti int not null,
nr int not null, 							
note varchar(500) default null,
primary key(ID),
foreign key (ID_TipoStrumenti) references TipoStrumenti(ID)
);

create table Hangar(
ID int not null auto_increment,
ID_Zona int not null,
nome varchar(50) not null,
stato enum('disponibile', 'indisponibile') not null,
num_Aerei_Max int not null,
larghezza double not null,
lunghezza double not null,
altezza double not null,
num_Personale int not null,			/*personale attivo al momento*/
data_Costruzione date not null,
note varchar(500) default null,
unique(nome),
primary key(ID),
foreign key (ID_Zona) references Zona(ID)
);

create table TorreDiControllo(
ID int not null auto_increment,
ID_Zona int not null,
nome varchar(50) not null,
stato enum('disponibile', 'indisponibile') not null,
frequenza_Radio varchar(50) not null,
larghezza double not null,
lunghezza double not null,
altezza double not null,
num_Personale int not null,
data_Costruzione date not null,
note varchar(500) default null,
unique(nome),
primary key(ID),
foreign key (ID_Zona) references Zona(ID)
);

create table Pista(
ID int not null auto_increment,
ID_Zona int not null,
nome varchar(50) not null,
stato enum('disponibile', 'indisponibile') not null,
tipo_Superficie varchar(50) not null,
larghezza double not null,
lunghezza double not null,
num_Personale int not null,
data_Costruzione date not null,
note varchar(500) default null,
unique(nome),
primary key(ID),
foreign key (ID_Zona) references Zona(ID)
);

create table Gate(
ID int not null auto_increment,
ID_Zona int not null,
nome varchar(50) not null,
stato enum('disponibile', 'indisponibile') not null,
larghezza double not null,
lunghezza double not null,
altezza double not null,
num_Personale int not null,
data_Costruzione date not null,
note varchar(500) default null,
unique(nome),
primary key(ID),
foreign key (ID_Zona) references Zona(ID)
);

create table RegistroHangar(
ID int not null auto_increment,
ID_Hangar int not null,
ID_Aereo int not null,
data_Inizio datetime not null,
data_Fine datetime not null,
tempo_Utilizzo VARCHAR(20) GENERATED ALWAYS AS (
    CONCAT(
        FLOOR(TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) / (24 * 60 * 365)), 'y ',
        FLOOR((TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % (24 * 60 * 365)) / (24 * 60)), 'd ',
        FLOOR((TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % (24 * 60)) / 60), 'h ',
        TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % 60, 'm'
    )
) STORED not null,
note varchar(500) default null,
unique(ID_Hangar, ID_Aereo, data_Inizio),
unique(ID_Aereo, data_Inizio),	-- un aereo non può essere custodito in un altro hangar nella stessa data
check (data_Inizio < data_Fine),	
primary key(ID),
foreign key (ID_Hangar) references Hangar(ID),
foreign key (ID_Aereo) references Aereo(ID) on delete cascade		--  quando un aereo viene eliminato, vengono eliminate tutte le sue occorrenze nel registro
);

create table RegistroGate(
ID int not null auto_increment,
ID_Gate int not null,
ID_CompagniaAerea int not null,
data_Inizio datetime not null,
data_Fine datetime not null,
tempo_Utilizzo VARCHAR(20) GENERATED ALWAYS AS (
    CONCAT(
        FLOOR(TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) / (24 * 60 * 365)), 'y ',
        FLOOR((TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % (24 * 60 * 365)) / (24 * 60)), 'd ',
        FLOOR((TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % (24 * 60)) / 60), 'h ',
        TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % 60, 'm'
    )
) STORED not null,
note varchar(500) default null,
unique(ID_Gate, ID_CompagniaAerea, data_Inizio),
unique(ID_Gate, data_Inizio),
check (data_Inizio < data_Fine),
primary key(ID),
foreign key (ID_Gate) references Gate(ID),
foreign key (ID_CompagniaAerea) references CompagniaAerea(ID)
);

create table RegistroStrumenti(
ID int not null auto_increment,
ID_Gate int not null,
ID_Strumento int not null,
data_Inizio datetime not null,
data_Fine datetime not null,
tempo_Utilizzo VARCHAR(20) GENERATED ALWAYS AS (
    CONCAT(
        FLOOR(TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) / (24 * 60 * 365)), 'y ',
        FLOOR((TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % (24 * 60 * 365)) / (24 * 60)), 'd ',
        FLOOR((TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % (24 * 60)) / 60), 'h ',
        TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % 60, 'm'
    )
) STORED not null,
note varchar(500) default null,
unique(ID_Gate, ID_Strumento, data_Inizio),
unique(ID_Strumento, data_Inizio),
check (data_Inizio < data_Fine),
primary key(ID),
foreign key (ID_Gate) references Gate(ID),
foreign key (ID_Strumento) references Strumento(ID)
);

create table Volo(
ID int not null auto_increment,
ID_Aereo int not null,
ID_TorreDiControllo int not null,
ID_Pista int not null,
ID_Gate int not null,
orario time not null,
data date not null,
tipo enum('in arrivo','in partenza') not null,
luogo varchar(50) not null,
note varchar(500) default null,
unique(ID_Pista, ID_Gate, orario, data),
unique(ID_Pista, orario, data),		-- non è possibile usare la stessa pista in data e orario uguali
unique(ID_Gate, orario, data),		-- non è possibile usare lo stesso gate in data e orario uguali
primary key(ID),
foreign key (ID_Aereo) references Aereo(ID) on delete cascade,  --  quando un aereo viene eliminato, vengono eliminate tutte le sue occorrenze nel registro
foreign key (ID_TorreDiControllo) references TorreDiControllo(ID),
foreign key (ID_Pista) references Pista(ID),
foreign key (ID_Gate) references Gate(ID)
);




