use Aereoporto;

-- Una selezione ordinata su un attributo di una tabella con condizioni AND e OR;
-- seleziona le documentazioni che hanno o num passeggeri < 20 oppure se hanno lunghezza < 50 e larghezza < 50 ordinando per l'id in modo crescente
select * 
from Documentazione 
where (lunghezza<50 and larghezza<50) or (num_passeggeri <20)
order by ID asc;

-- Una selezione su due o più tabelle con condizioni;
-- seleziona la documentazione dell'aereo con nome Boeing 747
select * 
from Documentazione d 
join Aereo a on a.ID_Documentazione=d.id
where a.nome='Boeing 747';

-- Una selezione aggregata su tutti i valori (es. somma di tutti gli stipendi)
-- il numero di aerei con stato = disponibile
select count(*) as NUM 
from Aereo a 
where a.stato='disponibile';

-- Una selezione aggregata su raggruppamenti (es. somma stipendi per dipartimenti)
-- seleziona il numero di hangar per ogni zona
select z.nome, count(*) as Num_Hangar
from Hangar h
join Zona z on h.ID_Zona=z.id 
group by ID_Zona;

-- Una selezione aggregata su raggruppamenti con condizioni (es. dipartimenti la cui somma degli stipendi dei dipendenti è > 100k)
-- seleziona le zone che hanno il numero di hangar <2
select z.nome, count(*)as Numero_Hangar
from Hangar h 
join Zona z on z.id=h.ID_Zona
group by ID_Zona
having Numero_Hangar<2;

-- Una selezione aggregata su raggruppamenti con condizioni che includano un’altra funzione
-- di raggruppamento (es. dipartimenti la cui somma degli stipendi è la più alta)
-- seleziona le zone che hanno il numero di hangar massimo
create view Num_Hangar_Zona as
select z.nome, count(*)as Numero_Hangar
from Hangar h 
join Zona z on z.id=h.ID_Zona 
group by ID_Zona; 

select *
from Num_Hangar_Zona
where Numero_Hangar = 
	(select max(Numero_Hangar) from Num_Hangar_Zona);

-- Una selezione con operazioni insiemistiche
-- differenza (seleziona gli aerei che hanno effettuato voli in arrivo ma non in partenza)
select a.ID, a.nome
from aereo a
join Volo v on v.ID_Aereo=a.ID
where v.tipo='in arrivo' and a.ID not in(
	select ID_Aereo 
    from Volo
    where tipo='in partenza');

-- Una selezione con l’uso appropriato della divisione
-- restituisce tutti i gate che hanno utilizzato tutti gli strumenti
select g.*
from Gate g
where not exists (
	select s.ID
    from strumento s
    where not exists (
		select r.*
        from RegistroStrumenti r
        where r.ID_Strumento=s.ID and			
			r.ID_Gate=g.ID));