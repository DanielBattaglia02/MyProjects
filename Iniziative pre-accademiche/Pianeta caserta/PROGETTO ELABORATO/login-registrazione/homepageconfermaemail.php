<?php 
    
    include '../template-parts/header.php';

    include '../template-parts/navbar-parts/navbar-utente.php';

?>

        <div id="main" class="container" style="margin-top:100px; margin-bottom:100px;">
            <div class="row">

                <?php
                        /*stampa di eventuali errori*/
                    if(isset($_GET['er']))
                    {
                        if($_GET['er']==1)
                        {
                ?>

                <script>

                    alert ('ERRORE : Codice errato!');

                </script>

                <?php

                            unset($_SESSION['nome']) ;
                            unset($_SESSION['cognome']) ;
                            unset($_SESSION['sesso']) ;
                            unset($_SESSION['dl']) ;
                            unset($_SESSION['ln']) ;
                            unset($_SESSION['email']) ;
                            unset($_SESSION['pass']) ;
                        }
                    }

                ?>

                <div class="col-3">

                    <?php include 'codice.php'; ?>    

                </div>

                <div class="col-6">

                </div>

                <div class="col-3">

                    <?php include '../template-parts/sidebar-parts/sidebar-codice.php'; ?>

                </div>

            </div>
        </div>

<?php include '../template-parts/footer.php'; ?>