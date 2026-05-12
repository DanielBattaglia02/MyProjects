<?php
include 'db/connessione.php'; // include connessione al DB

// --- Prendi il record unico dei ticket ---

$result = mysqli_query($conn, "SELECT numero, totale FROM dline_ticket WHERE ID=1");
$row = mysqli_fetch_assoc($result);
$current_number = $row['numero'];
$total = $row['totale'];
?>

<!doctype html>
<html lang="it">
<head>
  <title>Daniel Battaglia | Progetto DLine | Area Utente</title>
  <meta name="description" content="Dline è un mio progetto personale IoT e Web: un sistema eliminacode Cloud-native sviluppato con ESP32, API PHP e database MySQL per la gestione smart delle code.">
  <link rel="stylesheet" href="css/style.css">

  <?php include '../../../../template/php/header-meta.php'; ?> 

</head>
<body>

  <nav class="top-nav">
      <a href="https://danielbattaglia.it/progetti/progetti.php?page=personali/personali" class="btn-nav">Dashboard Progetti</a>
      <a href="admin/admin.php" class="btn-nav btn-admin">Area Admin</a>
  </nav>

  <div class="wrap">
    <div class="header-section">
        <h1 class="main-title"><span class="custom-blue">DL</span><span class="custom-black">ine</span></h1>
    </div>

    <div class="grid counters">
        <div class="card" id="box-current">
            <div class="label">Numero attuale</div>
            <div class="value" id="current-number"><?php echo $current_number; ?></div>
        </div>

        <div class="card" id="box-total">
            <div class="label">Persone in fila</div>
            <div class="value" id="total-numbers"><?php echo $total; ?></div>
        </div>

        <div class="card full-width highlight-card">
            <p>Il codice sorgente e la <strong>documentazione</strong> tecnica sono interamente a disposizione sulla mia repository <a href="https://github.com/DanielBattaglia02/MyProjects/tree/0ae21a60d2a5a5674763be76219061048b3f9cab/Sviluppi%20autonomi/DLine" target="_blank" class="github-link"><strong>GitHub</strong></a>.</p>
        </div>
    </div>
  </div>

  <div class="wrap bg-white">
    <div class="main-content-layout">
        <div class="card text-block">
            
            <h2 class="section-title">Simulazione</h2>
            <div class="video-container">
                <video controls>
                    <source src="file/simulazione-DLine.mp4" type="video/mp4">
                    Il tuo browser non supporta la riproduzione video.
                </video>
            </div>

            <h2 class="section-title">Descrizione del progetto</h2>
            <p>
                <strong>DLine</strong> è un prototipo di sistema per la gestione delle code (nei negozi) basato su tecnologia <strong>IoT</strong>. 
                L'obiettivo principale è il superamento dei limiti dei sistemi eliminacode tradizionali "stand-alone", 
                spostando la logica di calcolo e la persistenza dei dati su un’infrastruttura <strong>Cloud/Web Hosting</strong>.
            </p>
            <p>
                Il sistema permette a un dispositivo fisico (Client) di comunicare con un server remoto. 
                L’utente richiede un ticket tramite un'interfaccia fisica; l'azione viene registrata sul database web e il risultato viene mostrato sia sul display locale sia su questa dashboard dedicata al pubblico. 
            </p>
            <p>
                Questo progetto nasce dalla mia esperienza lavorativa presso <strong>Vanessa Sound</strong>, dove l'osservazione di questi dispositivi ha stimolato la mia curiosità e l’interesse di progettarne uno autonomamente per comprenderne il funzionamento.
            </p>
        </div>

        <div class="specs-container">
            <div class="card list-card">
                <h3 class="label-blue">Ambienti di Sviluppo (IDE)</h3>
                <ul class="spec-list">
                    <li><strong>Arduino IDE:</strong> Sviluppo firmware ESP32</li>
                    <li><strong>VS Code:</strong> Sviluppo Backend e Web</li>
                </ul>
            </div>

            <div class="card list-card">
                <h3 class="label-blue">Linguaggi Utilizzati</h3>
                <ul class="spec-list">
                    <li><strong>C++:</strong> Logica firmware microcontrollore</li>
                    <li><strong>PHP:</strong> Scripting lato server (API)</li>
                    <li><strong>SQL:</strong> Interrogazione Database MySQL</li>
                    <li><strong>HTML, CSS:</strong> Interfaccia Dashboard</li>
                </ul>
            </div>

            <div class="card list-card">
                <h3 class="label-blue">Protocolli & Standard</h3>
                <ul class="spec-list">
                    <li><strong>HTTP (GET/POST):</strong> Richieste Client-Server</li>
                    <li><strong>JSON:</strong> Scambio dati strutturato</li>
                    <li><strong>ESC/POS:</strong> Protocollo stampa termica</li>
                    <li><strong>Bus I2C:</strong> Gestione display OLED</li>
                </ul>
            </div>

            <div class="card list-card">
                <h3 class="label-blue">Prototipo</h3>
                <div class="img-container">
                    <img src="img/prototipo.jpeg" alt="Prototipo hardware DLine" class="img-fluid">
                </div>
            </div>
        </div>
    </div>

    <div class="logo-container">
        <img src="img/logo_dline.png" alt="DLine Logo" class="project-logo">
    </div>

    <?php include '../../../../template/php/footer.php'; ?>

  </div>

    <script>
        function aggiornaTotale() {
            fetch('api/api_server.php') 
                .then(response => response.json())
                .then(data => {
                    const elNumero = document.getElementById('current-number');
                    const elTotale = document.getElementById('total-numbers');

                    // Aggiorna solo se gli elementi esistono nella pagina
                    if (elNumero) elNumero.textContent = data.numero;
                    if (elTotale) elTotale.textContent = data.totale;
                })
                .catch(err => console.error('Errore nel fetch:', err));
        }

        // Aggiornamento automatico ogni 5 secondi
        setInterval(aggiornaTotale, 5000);

        // Caricamento immediato
        aggiornaTotale();
    </script>

</body>
</html>