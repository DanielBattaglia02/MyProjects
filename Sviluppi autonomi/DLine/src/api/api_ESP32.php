<?php
include '../db/connessione.php';

// --- Prendi il record unico dei ticket ---
$result = mysqli_query($conn, "SELECT numero, totale FROM dline_ticket WHERE ID=1");

if (!$result) {
    http_response_code(500);
    echo json_encode(['error' => 'Errore DB']);
    exit;
}

$row = mysqli_fetch_assoc($result);
$totale = $row['totale'];

// --- Gestione parametri GET/POST ---
$action = $_GET['action'];

// --- Esegui azione ---
if ($action === 'increment') 
{
    $totale++;
    $update = mysqli_query($conn, "UPDATE dline_ticket SET totale = $totale WHERE ID=1");

    if (!$update) 
    {
        http_response_code(500);
        echo json_encode(['error' => 'Errore UPDATE']);
        exit;
    }
}

// --- Restituisci il totale aggiornato ---
header('Content-Type: application/json');
echo json_encode(['totale' => $totale]);
?>

