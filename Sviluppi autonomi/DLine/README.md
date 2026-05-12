DLine è un sistema IoT (Internet of Things) completo per la gestione intelligente delle code all'interno di attività commerciali. Nato come applicazione pratica di competenze multidisciplinari e ispirato dalle dinamiche operative osservate durante un'esperienza lavorativa presso Vanessa Sound, il progetto implementa un'architettura client-server integrata dal dispositivo fisico fino all'interfaccia web gestionale.

⚙️ Architettura e Funzionamento
Il sistema si basa sull'interazione in tempo reale tra un dispositivo fisico (Client) e un'infrastruttura di Web Hosting (Server):

Terminale Utente (Hardware): Attraverso il dispositivo fisico DLine, il cliente richiede un ticket premendo un pulsante. Il microcontrollore elabora la richiesta, comunica con il server, mostra il turno sul display integrato e stampa il biglietto fisico tramite una stampante termica.

Public Monitor (Interfaccia Web): Una pagina web dedicata alla sala d'attesa che mostra in tempo reale il numero in fase di servizio e il totale delle persone in coda.

Admin Dashboard (Interfaccia Web): Un pannello di controllo riservato al personale (es. cassieri) per gestire l'avanzamento dei numeri serviti o effettuare il reset globale del sistema.

🛠️ Stack Tecnologico
Il progetto unisce la programmazione embedded allo sviluppo web full-stack, utilizzando le seguenti tecnologie:

Hardware & Firmware:

Costruito utilizzando componenti dell'ecosistema Arduino (microcontrollore, display OLED, pulsanti, stampante termica).

Il firmware è stato interamente scritto e compilato tramite Arduino IDE.

Back-end & Database:

La logica server e la comunicazione con il database relazionale sono sviluppate in PHP.

Il server espone API proprietarie per la gestione centralizzata dei turni.

Front-end & Comunicazione:

Lo scambio di dati tra il dispositivo hardware e il server web avviene tramite payload in formato JSON.

Le interfacce web lato client utilizzano chiamate asincrone AJAX per comunicare con il backend PHP, garantendo aggiornamenti fluidi e in tempo reale delle code senza la necessità di ricaricare la pagina.
