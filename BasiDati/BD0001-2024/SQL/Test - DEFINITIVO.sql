use aereoporto;

select *
from aereo
left join Registrohangar on aereo.id=registrohangar.id_aereo;

delete from RegistroHangar
where id=1;

insert into RegistroHangar (ID, ID_Hangar, ID_Aereo, data_Inizio, data_Fine, note)
values 
(1, 1, 1, '2022-02-01', '2022-02-15', '');

update RegistroHangar 
set data_Inizio='2022-02-02'
where id=1;

select *
from registroHangar;

drop table RegistroHangar;

create table RegistroHangar(
ID int primary key not null auto_increment,
ID_Hangar int not null,
ID_Aereo int not null,
data_Inizio datetime not null,
data_Fine datetime not null,
tempo_Utilizzo VARCHAR(1000) GENERATED ALWAYS AS (
    CONCAT(
        FLOOR(TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) / (24 * 60 * 365)), 'y ',
        FLOOR((TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % (24 * 60 * 365)) / (24 * 60)), 'd ',
        FLOOR((TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % (24 * 60)) / 60), 'h ',
        TIMESTAMPDIFF(MINUTE, data_Inizio, data_Fine) % 60, 'm'
    )
) STORED,
note varchar(500) default null,
unique(ID_Hangar, ID_Aereo, data_Inizio, data_Fine),
unique(ID_Aereo, data_Inizio),
unique(ID_Aereo, data_Fine),
check (data_Inizio < data_Fine),
foreign key (ID_Hangar) references Hangar(ID),
foreign key (ID_Aereo) references Aereo(ID)
);

insert into RegistroHangar (ID, ID_Hangar, ID_Aereo, data_Inizio, data_Fine, note)
values 
(1, 1, 1, '2022-02-01', '2022-02-15', ''),
(2, 1, 1, '2022-03-01 10:00:00', '2022-03-01 10:50', ''),
(3, 2, 3, '2022-01-05', '2022-01-20', ''),
(4, 2, 3, '2023-01-05', '2024-01-20', '');

show columns from RegistroHangar;

alter table registroHangar
drop column note;

select *
from registroHangar;

alter table registroHangar
add note varchar(500) default null;

select *from aereo;

delete from a, d
using Aereo a
join Documentazione d on a.ID_Documentazione=d.ID
where a.ID=1;

select * from Documentazione;



