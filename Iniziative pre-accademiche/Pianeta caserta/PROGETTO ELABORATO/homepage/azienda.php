<div id="main" class="container" style="margin-top:100px; margin-bottom:100px;">
    <div class="row">

        <div class="col-9">

            <?php 

                if(isset($_GET['stampa']))
                {
                    if($_GET['stampa']==1)
                    {

            ?>

            <script>

                alert("Evento Aggiunto");

            </script>

            <?php

                    }
                }

            ?>

            <h3>BENVENUTA AZIENDA : <?php echo $_SESSION['nick']; ?></h3>
            <br>
            <p class="lead"><b>Potrai usufruire di questa sezione del sito per aggiungere nuovi eventi per la tua struttura lavorativa, e che solo gli utenti registrati potranno visualizzare. Potrai inoltre visualizzare tutte le recensioni condivise dagli utenti sulla tua struttura ed effettuare prenotazioni per nuovi incontri in sede.</b></p>
            <br>

            <div class="row">
                <a href="../homepage/index.php?page=aggiungievento" class="btn btn-primary" style="margin-bottom:20px;">AGGIUGI NUOVO EVENTO</a>
                <br>
                <a href="../homepage/index.php?page=visualizzarecensioni" class="btn btn-primary" style="margin-bottom:20px;">VISUALIZZA RECENSIONI</a>
            </div>

        </div>