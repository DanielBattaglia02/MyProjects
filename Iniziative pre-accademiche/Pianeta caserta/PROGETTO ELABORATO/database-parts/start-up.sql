-- alunno : Battaglia Daniel ;
-- classe : 5AI ;
-- progetto : elaborato ;

-- traccia : traccia elaborato .

DROP DATABASE IF EXISTS PIANETA_CASERTA;

CREATE DATABASE PIANETA_CASERTA;

USE PIANETA_CASERTA;

-- INT 4B (da -2^31 a 2^31-1)
-- VARCHAR 2B + NUMERO CARATTERI (max 8000 caratteri)
-- DATETIME 8B (dal 1 Gennaio 1753 al 31 Dicembre 9999)(datetime considera anche le ore, minuti,secondi)
-- TIME 3-5B (ore,minuti,secondi)
-- DATE 3B (da 01-01-0001 a 31-12-9999)
-- UNSIGNED = indica valori privi di segno, quindi tutti positivi


-- Tabella Utenti : memorizza le informazioni riguardo gli utenti abbonati e gli admin

CREATE TABLE PN_UTENTI
(
    ID INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,  
    NOME VARCHAR(12) NOT NULL,  
    COGNOME VARCHAR(20) NOT NULL,
    SESSO ENUM('UOMO','DONNA','ALTRO') NOT NULL,
    DATADINASCITA DATE NOT NULL,    
    LUOGODINASCITA VARCHAR(12) NOT NULL,
    RUOLO ENUM('abbonato','admin') NOT NULL,
    EMAIL VARCHAR(35) NOT NULL,
    PASSWORD VARCHAR(12) NOT NULL,     -- MINIMO 6 CARATTERI E MASSIMO 10
    DATACREAZIONE DATETIME DEFAULT CURRENT_TIMESTAMP,   -- CURRENT_TIMESTAMP ASSEGNA DATA ED ORARIO PRECISO DELLA CREAZIONE DI UN UTENTE
    PRIMARY KEY(ID),
    UNIQUE(EMAIL)
);

INSERT INTO PN_UTENTI (ID, NOME, COGNOME, SESSO, DATADINASCITA, LUOGODINASCITA, RUOLO, EMAIL, PASSWORD) VALUES
(1, 'Daniel', 'Battaglia', 'UOMO', '2002-07-03', 'NAPOLI', 'admin', 'admin@gmail.com', 'admin!!'),
(2, 'Antonio', 'Banderas', 'UOMO', '1899-01-01', 'HONOLULU', 'abbonato', 'abbonato@gmail.com', 'abbonato!!');

-- Tabella Categorie : memorizza tutti i nomi delle categoria a cui dovranno appartenere tutte le strutture lavorative

CREATE TABLE PN_CATEGORIE
(
    ID INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,  
    TIPO VARCHAR(30) NOT NULL,
    PRIMARY KEY(ID)
);

INSERT INTO PN_CATEGORIE(ID, TIPO) VALUES
(1,'RISTORANTI'),
(2,'CENTRI_ASSISTENZA'),
(3,'CENTRI_SPORTIVI'),
(4,'SCUOLE');

-- Tabella Strutture-Lavorative : memorizza le informazioni delle strutture lavorative che hanno stabilito un accordo di sponsorizzazione con l'azienda che gestisce la web app

CREATE TABLE PN_STRUTTURE_LAVORATIVE
(
    ID INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,  
    NOME VARCHAR(30) NOT NULL,
    EMAIL VARCHAR(35) NOT NULL,
    PIN VARCHAR(12) NOT NULL,   -- è UN CODICE ALFANUMERICO DI 5 CARATTERI
    IDCATEGORIA INT(4) UNSIGNED NOT NULL,
    DATACREAZIONE DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(ID),
    UNIQUE(PIN),
    FOREIGN KEY(IDCATEGORIA) REFERENCES PN_CATEGORIE(ID)
);

INSERT INTO PN_STRUTTURE_LAVORATIVE(ID, NOME, EMAIL, PIN, IDCATEGORIA) VALUES
(1, 'Ristorante Pepe Nero Caserta','pepenero@gmail.com', '1111A', 1),
(2, 'Trattoria Caprese Caserta','trattoriacaprese@gmail.com', '2222A', 1),
(3, 'ITIS-LS Francesco Giordani','itigiordani@gmail.com', '3333A', 4);

-- Tabella Labels : memorizza tutte le tipologie di informazioni che ogni struttura lavorativa mette a disposizione

CREATE TABLE PN_LABELS
(
    ID INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,  
    NOME VARCHAR(30) NOT NULL,  
    PRIMARY KEY(ID)
);

INSERT INTO PN_LABELS (ID, NOME) VALUES
(1,'POSIZIONE'),
(2,'INDIRIZZO'),
(3,'EMAILUFFICIO'),
(4,'TELEFONO');

-- Tabella Contatti : memorizza tutti i contatti di ogni struttura lavorativa

CREATE TABLE PN_CONTATTI
(
    ID INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,  
    DESCRIZIONE VARCHAR(500) NOT NULL,  
    IDSTRUTTURA INT(4) UNSIGNED NOT NULL,
    IDLABEL INT(4) UNSIGNED NOT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY(IDSTRUTTURA) REFERENCES PN_STRUTTURE_LAVORATIVE(ID),
    FOREIGN KEY(IDLABEL) REFERENCES PN_LABELS(ID)
);

INSERT INTO PN_CONTATTI(ID, DESCRIZIONE, IDSTRUTTURA, IDLABEL) VALUES
(1,'0823210012', 1, 4),
(2,'pepenero2@gmail.com', 1, 3),
(3,'Via Giuseppe Maria Bosco, 15', 1, 2),
(4,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d24065.21269584525!2d14.28649382785691!3d41.06567903148264!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133a55caa68071cd%3A0x935f80d7c5535817!2sRistorante%20PepeNero!5e0!3m2!1sit!2sit!4v1621281391500!5m2!1sit!2sit"', 1, 1),
(5,'0823354831', 2, 4),
(6,'trattoriacaprese2@gmail.com', 2, 3),
(7,'Via Roma, 75', 2, 2),
(8,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3007.9687227711943!2d14.334059614916477!3d41.069676323594145!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133a544d8671ad57%3A0x991b0240c7744ca7!2sTrattoria%20Caprese%20Caserta!5e0!3m2!1sit!2sit!4v1621353941523!5m2!1sit!2sit"', 2, 1),
(9,'0823325655', 3, 4),
(10,'cetf02000x@istruzione.it', 3, 3),
(11,'Via Laviano, 18', 3, 2),
(12,'https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12030.499105526505!2d14.3487637!3d41.0771939!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x865c465d20c0e2f4!2sITIS-LS%20%22F.%20Giordani%22!5e0!3m2!1sit!2sit!4v1621353731743!5m2!1sit!2sit"', 3, 1);

-- Tabella Eventi : memorizzare tutte le informazioni riguardo gli eventi organizzati dalle strutture lavorative

CREATE TABLE PN_EVENTI
(
    ID INT(4) UNSIGNED NOT NULL AUTO_INCREMENT, 
    TITOLO VARCHAR(35) NOT NULL,
    DESCRIZIONE VARCHAR(800) NOT NULL,  
    DATAINIZIO DATE NOT NULL,
    DATAFINE DATE NOT NULL,
    ORARIOINIZIO TIME NOT NULL,
    ORARIOFINE TIME NOT NULL,
    IDSTRUTTURA INT(4) UNSIGNED NOT NULL,
    DATACREAZIONE DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(ID),
    FOREIGN KEY(IDSTRUTTURA) REFERENCES PN_STRUTTURE_LAVORATIVE(ID)
);

-- Tabella Prenotazioni : memorizza tutte le prenotazioni effettuate dagli utenti abbonati

CREATE TABLE PN_PRENOTAZIONI
(
    ID INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,  
    DATA DATE NOT NULL,
    ORARIOINIZIO TIME NOT NULL,
    ORARIOFINE TIME NOT NULL,
    NOTE VARCHAR(500) NOT NULL,
    MOMENTOPRENOTAZIONE DATETIME DEFAULT CURRENT_TIMESTAMP,
    IDSTRUTTURA INT(4) UNSIGNED DEFAULT NULL,
    IDUTENTE INT(4) UNSIGNED DEFAULT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY(IDUTENTE) REFERENCES PN_UTENTI(ID),
    FOREIGN KEY(IDSTRUTTURA) REFERENCES PN_STRUTTURE_LAVORATIVE(ID)
);

-- Tabella Messaggi : memorizza tutti i messaggi che gli utenti inoltrano nella chat globale

CREATE TABLE PN_MESSAGGI
(
    ID INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,  
    DESCRIZIONE VARCHAR(1000) NOT NULL,  
    DATAINOLTRO DATETIME DEFAULT CURRENT_TIMESTAMP,   
    MITTENTE INT(4) UNSIGNED NOT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY(MITTENTE) REFERENCES PN_UTENTI(ID)
);

INSERT INTO PN_MESSAGGI (ID, DESCRIZIONE, MITTENTE) VALUES
(1, 'Ciao, mi chiamo Antonio', 2);

-- Tabella Recensioni : memorizza tutte le recensioni degli utenti abbonati riguardo le varie strutture lavorative

CREATE TABLE PN_RECENSIONI
(
    ID INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,  
    DESCRIZIONE VARCHAR(1000) NOT NULL,  
    VALUTAZIONE ENUM('1','2','3','4','5'),
    DATADICONDIVISIONE DATETIME DEFAULT CURRENT_TIMESTAMP,   
    IDUTENTE INT(4) UNSIGNED NOT NULL,
    IDSTRUTTURA INT(4) UNSIGNED NOT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY(IDUTENTE) REFERENCES PN_UTENTI(ID),
    FOREIGN KEY(IDSTRUTTURA) REFERENCES PN_STRUTTURE_LAVORATIVE(ID)
);