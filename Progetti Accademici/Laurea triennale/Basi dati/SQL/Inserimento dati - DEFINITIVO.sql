use Aereoporto;

-- Inserimento di istanze nella tabella TipoStrumenti
insert into TipoStrumenti (nome, descrizione)
values 
('Bus', 'trasporto passeggeri o bagagli dal gate all aereo o viceversa'),
('Carrello portabagagli', 'trasporto bagagli nel/dal gate'),
('Scala mobile', 'Scale per il trasporto verticale delle persone');

-- Inserimento di istanze nella tabella CompagniaAerea
insert into CompagniaAerea (nome, nazionalita, note)
values 
('American Airlines', 'Stati Uniti', 'Compagnia aerea statunitense'),
('Lufthansa', 'Germania', 'Compagnia aerea tedesca'),
('Emirates', 'Emirati Arabi Uniti', 'Compagnia aerea degli Emirati Arabi Uniti'),
('Air France', 'Francia', 'Compagnia aerea francese'),
('British Airways', 'Regno Unito', 'Compagnia aerea britannica');

-- Inserimento di istanze nella tabella Documentazione(si usano metri e kg come unità di misura)
insert into Documentazione (altezza, lunghezza, larghezza, peso, carico_Max, num_Passeggeri, num_Equipaggio, num_Motori, data_Costruzione, luogo_Costruzione, note)
values 
(10.5, 50.2, 30.8, 15000, 20000, 150, 20, 2, '2022-01-01', 'Bangkok', 'Aereo di linea a lungo raggio'),
(3.2, 15.7, 7.5, 500, 1000, 5, 2, 1, '2020-05-15', 'New York', 'Aereo leggero per addestramento'),
(25.0, 80.5, 40.0, 80000, 120000, 500, 50, 4, '2021-11-30', 'Genova', 'Aereo cargo superjumbo'),
(8.5, 40.0, 28.0, 12000, 16000, 120, 15, 2, '2020-07-10', 'Seattle', 'Aereo di linea a medio raggio'),
(12.0, 60.0, 35.0, 20000, 25000, 180, 20, 4, '2019-04-22', 'Toulouse', 'Aereo di linea a lungo raggio');

-- Inserimento di istanze nella tabella Zona
insert into Zona (ID, nome)
values
(1, 'Zona 1'),
(2, 'Zona 2'),
(3, 'Zona 3');

-- --------------------------------------------------------------------------- --

-- Inserimento di istanze nella tabella Aereo
insert into Aereo (ID_CompagniaAerea, ID_Documentazione, nome, stato)
values 
(1, 1, 'Boeing 747', 'disponibile'),
(2, 2, 'Cessna 172', 'disponibile'),
(3, 3, 'Airbus A380', 'disponibile'),
(4, 4, 'Boeing 737', 'disponibile'),
(5, 5, 'Boeing 787', 'indisponibile');

-- Inserimento di istanze nella tabella Strumenti
insert into Strumento (ID, ID_TipoStrumenti, nr, note)
values
(1, 1, 101, 'Trasporto passeggeri');

insert into Strumento (ID, ID_TipoStrumenti, nr)
values
(2, 2, 201),
(3, 3, 301);

-- Inserimento di istanze nella tabella Hangar
insert into Hangar (ID, ID_Zona, nome, stato, num_Aerei_Max, larghezza, lunghezza, altezza, num_Personale, data_Costruzione, note)
values 
(1, 1, 'Hangar A', 'disponibile', 10, 40, 60, 20, 5, '2022-02-01', 'Hangar per aerei di linea'),
(2, 2, 'Hangar B', 'disponibile', 5, 30, 50, 15, 10, '2021-12-15', 'Hangar per aerei cargo'),
(3, 2, 'Hangar C', 'disponibile', 5, 30, 50, 15, 25, '2021-12-15', 'Hangar per tutti gli aerei'),
(4, 2, 'Hangar D', 'disponibile', 5, 30, 50, 15, 25, '2021-12-15', 'Hangar per tutti gli aerei'),
(5, 3, 'Hangar E', 'indisponibile', 5, 30, 50, 15, 30, '2021-12-15', 'Hangar per tutti gli aerei');

-- Inserimento di istanze nella tabella TorreDiControllo
insert into TorreDiControllo (ID, ID_Zona, nome, stato, frequenza_Radio, larghezza, lunghezza, altezza, num_Personale, data_Costruzione, note)
values 
(1, 1, 'Torre 1', 'disponibile', '123.45 MHz', 20, 20, 30, 8, '2022-03-10', 'Torre di controllo principale'),
(2, 3, 'Torre 2', 'disponibile', '118.65 MHz', 18, 18, 25, 6, '2021-11-28', 'Torre di controllo secondaria');

-- Inserimento di istanze nella tabella Pista
insert into Pista (ID, ID_Zona, nome, stato, tipo_Superficie, larghezza, lunghezza, num_Personale, data_Costruzione, note)
values 
(1, 1, 'Pista 1', 'disponibile', 'Asfalto', 45, 3000, 10, '2022-01-20', 'Pista principale'),
(2, 2, 'Pista 2', 'disponibile', 'Erba', 30, 2000, 8, '2021-12-05', 'Pista secondaria');

-- Inserimento di istanze nella tabella Gate
insert into Gate (ID, ID_Zona, nome, stato, larghezza, lunghezza, altezza, num_Personale, data_Costruzione)
values 
(1, 2, 'Gate A', 'disponibile', 25, 40, 15, 3, '2022-02-15'),
(2, 3, 'Gate B', 'disponibile', 20, 35, 12, 2, '2021-10-30');

-- --------------------------------------------------------------------------- --

-- Inserimento di istanze nella tabella RegistroHangar
insert into RegistroHangar (ID, ID_Hangar, ID_Aereo, data_Inizio, data_Fine)
values 
(1, 1, 1, '2022-02-01', '2022-02-15'),
(2, 1, 1, '2022-03-01 10:00:00', '2022-03-01 10:50'),
(3, 2, 3, '2022-01-05', '2022-01-20'),
(4, 2, 3, '2023-01-05', '2024-01-20');

-- Inserimento di istanze nella tabella RegistroGate
insert into RegistroGate (ID, ID_Gate, ID_CompagniaAerea, data_Inizio, data_fine)
values
(1, 1, 1, '2022-02-15', '2022-03-01'),
(2, 1, 1, '2021-02-15', '2023-03-01'),
(3, 2, 3, '2021-10-30', '2021-11-15');

-- Inserimento di istanze nella tabella RegistroStrumenti
insert into RegistroStrumenti (ID_Gate, ID_Strumento, data_Inizio, data_Fine)
values
(1, 1, '2010-02-15', '2011-02-20'),
(1, 1, '2012-02-15', '2013-02-20'),
(1, 1, '2013-02-16', '2014-02-20'),
(2, 1, '2015-02-15', '2016-02-20'),
(2, 1, '2017-02-10', '2018-02-20'),
(2, 2, '2017-02-10', '2018-02-20'),
(2, 3, '2017-02-10', '2018-02-20'),
(2, 1, '2019-02-15', '2020-02-19');

-- --------------------------------------------------------------------------- --

-- Inserimento di istanze nella tabella Voli
insert into Volo (ID_Aereo, ID_TorreDiControllo, ID_Pista, ID_Gate, orario, data, tipo, luogo, note)
values
(1, 1, 1, 1, '14:30:00', '2022-03-01', 'in partenza', 'Genova', 'Volo di linea AA123'),
(2, 2, 2, 2, '10:00:00', '2021-11-15', 'in partenza', 'Genova', 'Volo di linea BA456'),
(3, 2, 2, 2, '11:00:00', '2021-11-15', 'in partenza', 'Dubai', 'Volo internazionale QR789'),
(4, 1, 1, 1, '12:15:00', '2023-02-20', 'in arrivo', 'London', 'Volo internazionale EK456');

-- la vista contiene tutti gli aerei che sono ancora attualmente custoditi in un hangar
create view AEREI_ANCORA_CUSTODITI as
select a.ID as ID_AEREO, a.nome as NOME_AEREO, h.ID as ID_HANGAR, h.nome as NOME_HANGAR
from Aereo a
join RegistroHangar r on r.ID_Aereo=a.ID
join Hangar h on r.ID_Hangar=h.ID
where r.data_inizio<current_date() and r.data_Fine>current_date();

select * from AEREI_ANCORA_CUSTODITI;