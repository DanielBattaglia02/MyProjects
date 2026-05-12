<?php
include 'connessione.php'; // include la connessione

if (!$conn) {
    die("Connessione al database fallita: " . mysqli_connect_error());
} else {
    echo "Connessione al database riuscita!<br>";
}

// --- Elimina tabelle esistenti (se ci sono) ---
$tables = ['dline_utenti', 'dline_ticket'];
foreach ($tables as $table) {
    $drop = mysqli_query($conn, "DROP TABLE IF EXISTS $table");
    if ($drop) {
        echo "Tabella $table eliminata se esiste.<br>";
    } else {
        die("Errore eliminazione tabella $table: " . mysqli_error($conn));
    }
}

// --- Creazione tabella utenti ---
$sql_utenti = "
CREATE TABLE dline_utenti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    ultimo_accesso DATETIME DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
";

if (mysqli_query($conn, $sql_utenti)) {
    echo "Tabella utenti creata.<br>";
} else {
    die("Errore creazione tabella utenti: " . mysqli_error($conn));
}

// --- Creazione tabella ticket ---
$sql_ticket = "
CREATE TABLE dline_ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    totale INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
";

if (mysqli_query($conn, $sql_ticket)) {
    echo "Tabella ticket creata.<br>";
} else {
    die("Errore creazione tabella ticket: " . mysqli_error($conn));
}

// --- Inserimento record iniziale ticket ---
$sql_insert = "INSERT INTO dline_ticket (numero, totale) VALUES (0, 50)";
if (mysqli_query($conn, $sql_insert)) {
    echo "Record iniziale ticket inserito con totale = 50";
} else {
    die("Errore inserimento record iniziale ticket: " . mysqli_error($conn));
}

?>
