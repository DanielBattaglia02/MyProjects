<div id="main" class="container" style="margin-top:100px; margin-bottom:100px;">
    <div class="row">
        <div class="col-9">

            <h1 align="center">Chat Globale</h1>
            <br>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-comment"></span>
                </div>
                <div class="panel-body">
                    <ul class="chat">

                        <?php 
             
                            $query = "SELECT PN_MESSAGGI.DESCRIZIONE, PN_MESSAGGI.DATAINOLTRO, CONCAT(PN_UTENTI.NOME ,' ', PN_UTENTI.COGNOME)AS NOME FROM PN_MESSAGGI, PN_UTENTI WHERE PN_MESSAGGI.MITTENTE=PN_UTENTI.ID AND NOT PN_UTENTI.RUOLO='admin' ORDER BY PN_MESSAGGI.DATAINOLTRO DESC" ;
                                            
                            $risp = mysqli_query($conn, $query) ;
                            if($risp)
                            {
                                while($riga = mysqli_fetch_array($risp))
                                {
                                            
                        ?>

                        <li class="left clearfix">
                            <div class="chat-body clearfix">

                                <div class="header">
                                    <strong class="primary-font"><?php echo $riga['NOME']; ?> </strong> <small class="pull-right text-muted">
                                        <span class="glyphicon glyphicon-time"></span> <?php echo $riga['DATAINOLTRO']; ?> </small>
                                </div>
                                <p>
                                    <?php echo $riga['DESCRIZIONE']; ?>
                                </p>

                                <br>

                            </div>
                        </li>

                        <?php 
             
                                    }
                                }
                            else
                            {

                                echo('Errore : '.mysqli_error($conn));
                                exit;
                            }
                                                                    
                        ?>

                    </ul>
                </div>

                <div class="panel-footer">
                    
                        <form action="../from-pages/inoltromessaggio.php" method="post" class="input-group">
                            <input type="hidden" name="chat" id="chat"></input>
                            <input type="text" name="messaggio" id="messaggio" class="form-control input-sm" placeholder="Type your message here..." /></input>
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-warning btn-sm">Invia</button>
                            </span>
                        </form>
    
                </div>
            </div>
        </div>
