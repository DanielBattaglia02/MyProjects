<?php
include '../db/connessione.php'; // connessione DB
header('Content-Type: application/json');

// Preleva numero e totale dal DB
$result = mysqli_query($conn, "SELECT numero, totale FROM dline_ticket WHERE ID=1");

if (!$result) {
    http_response_code(500);
    echo json_encode(['error' => 'Errore DB']);
    exit;
}

$row = mysqli_fetch_assoc($result);
$numero = (int)$row['numero'];
$totale = (int)$row['totale'];

// Restituisci JSON corretto
echo json_encode([
    'numero' => $numero,
    'totale' => $totale
]);
?>
