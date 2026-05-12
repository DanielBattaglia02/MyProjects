<?php
include '../db/connessione.php'; // include connessione al DB

// --- Prendi il record unico dei ticket ---
$result = mysqli_query($conn, "SELECT numero, totale FROM dline_ticket WHERE ID =1");
$row = mysqli_fetch_assoc($result);
$current_number = $row['numero'];
$total = $row['totale'];

// --- Gestione form ---
if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    if (isset($_POST['prev'])) {
        // Numero precedente
        if ($current_number > 0) {
            $current_number--;
            mysqli_query($conn, "UPDATE dline_ticket SET numero = $current_number WHERE ID =1");
        }
    }

    if (isset($_POST['next'])) {
        // Numero successivo
        if ($current_number < $total) {
            $current_number++;
            mysqli_query($conn, "UPDATE dline_ticket SET numero = $current_number WHERE ID =1");
        }
    }

    if (isset($_POST['reset'])) {
        // Reset numero e totale
        $current_number = 0;
        $total = 0;
        mysqli_query($conn, "UPDATE dline_ticket SET numero = 0, totale = 0 WHERE ID =1");
    }

    // Ricarica valori dal DB
    $result = mysqli_query($conn, "SELECT numero, totale FROM dline_ticket WHERE ID =1");
    $row = mysqli_fetch_assoc($result);
    $current_number = $row['numero'];
    $total = $row['totale'];
}
?>

<!doctype html>
<html lang="it">
<head>
  <title>Daniel Battaglia | Progetto DLine | Area Admin</title>
  <meta name="description" content="DLine è un mio progetto personale IoT e Web: un sistema eliminacode Cloud-native sviluppato con ESP32, API PHP e database MySQL per la gestione smart delle code.">
  <link rel="stylesheet" href="../css/style.css"> <!-- Riferimento al CSS Unificato -->

  <?php include '../../../../../template/php/header-meta.php'; ?> 

</head>
<body>

  <nav class="top-nav">
      <a href="https://danielbattaglia.it/progetti/progetti.php?page=personali/personali" class="btn-nav">Dashboard Progetti</a>
      <a href="../dashboard.php" class="btn-nav">Sezione Utente</a>
  </nav>

  <div class="wrap">
    <div class="header-section">
        <h1 class="main-title"><span class="custom-blue">DL</span><span class="custom-black">ine</span> <span style="font-size: 0.5em; vertical-align: middle;">(ADMIN)</span></h1>
    </div>

    <div class="grid counters">
      <div class="card" id="box-current">
        <div class="label">Numero Servito</div>
        <div class="value" id="current-number"><?php echo $current_number; ?></div>
        <div class="small"><span id="current-totale"><?php echo $total; ?></span></div>
      </div>

      <div class="card" id="box-controls" style="min-width: 320px;">
        <div class="label">Azioni Rapide</div>
        <div class="admin-controls">
            <form method="post" class="control-form">
                <button type="submit" name="prev" class="btn-action">Precedente</button>
                <button type="submit" name="next" class="btn-action btn-next">Prossimo</button>
            </form>
            <form method="post" style="margin-top: 15px;" onsubmit="return confermaReset()">
                <button type="submit" name="reset" class="btn-action btn-danger">🔄 RESET GENERALE</button>
            </form>
        </div>
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
                    <source src="../file/simulazione-DLine.mp4" type="video/mp4">
                    Il tuo browser non supporta la riproduzione video.
                </video>
            </div>

            <h2 class="section-title">Gestione della Coda</h2>
            <p>
                Questa interfaccia è dedicata esclusivamente all'<strong>addetto alle vendite</strong> (Admin), il quale ha il compito di coordinare l'avanzamento della fila all'interno del punto vendita. 
            </p>
            <p>
                Tramite i controlli asincroni, l'operatore può richiamare il numero successivo o tornare a quello precedente in caso di mancata presentazione del cliente. Ogni modifica effettuata su questa pagina viene propagata istantaneamente alla <strong>Dashboard Pubblica</strong> e al dispositivo fisico sincronizzato.
            </p>
            <p>
                La funzione di <strong>Reset</strong> permette di azzerare i contatori a fine giornata lavorativa, pulendo la persistenza dei dati sul database per la sessione successiva.
            </p>
        </div>

        <div class="specs-container">
            <div class="card list-card highlight-card">
                <h3 class="label-blue">Info Sessione</h3>
                <ul class="spec-list">
                    <li><strong>Modalità:</strong> Gestione Operatore</li>
                    <li><strong>Sincronizzazione:</strong> Real-time via API</li>
                    <li><strong>Database:</strong> Connesso (MySQL)</li>
                </ul>
            </div>

            <div class="card list-card">
                <h3 class="label-blue">Prototipo</h3>
                <div class="img-container">
                    <img src="../img/prototipo.jpeg" alt="Prototipo hardware DLine" class="img-fluid">
                </div>
            </div>
        </div>
    </div>

    <div class="logo-container">
        <img src="../img/logo_dline.png" alt="DLine Logo" class="project-logo">
    </div>

    <?php include '../../../../../template/php/footer.php'; ?>
  </div>

    <script>
      // Aggiorna solo il totale
      function aggiornaTotale() {
          fetch('../api/api_server.php') // punta al tuo file API che restituisce solo totale
              .then(response => response.json())
              .then(data => {
                  document.getElementById('current-totale').textContent = 'PERSONE IN FILA: ' + data.totale;
                  document.getElementById('current-number').textContent = data.numero;
              })
              .catch(err => console.error('Errore nel fetch:', err));
      }

      // Aggiornamento automatico ogni 5 secondi
      setInterval(aggiornaTotale, 5000);

      // Aggiornamento immediato al caricamento della pagina
      aggiornaTotale();
    </script>

    <script>
      function confermaReset() {
          return confirm("Sei sicuro di voler resettare i biglietti?"); 
          // Se l'utente clicca "OK", il form viene inviato. 
          // Se clicca "Annulla", l'invio viene bloccato.
      }
    </script>

</body>
</html>