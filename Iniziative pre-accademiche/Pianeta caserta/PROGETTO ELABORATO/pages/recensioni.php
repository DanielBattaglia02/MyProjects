
<div class="container">  
    <div class="msg-wrap">

        <?php 
             
            $query = "SELECT PN_RECENSIONI.DESCRIZIONE, PN_RECENSIONI.DATADICONDIVISIONE, PN_RECENSIONI.VALUTAZIONE, CONCAT(PN_UTENTI.NOME ,' ', PN_UTENTI.COGNOME)AS NOME FROM PN_RECENSIONI, PN_UTENTI WHERE PN_RECENSIONI.IDSTRUTTURA='".$i."' AND PN_RECENSIONI.IDUTENTE=PN_UTENTI.ID AND NOT PN_UTENTI.RUOLO='admin' ORDER BY PN_RECENSIONI.DATADICONDIVISIONE DESC" ;
                                            
            $risp = mysqli_query($conn, $query) ;
            if($risp)
            {
                while($riga = mysqli_fetch_array($risp))
                {
                                            
        ?>

        <div class="media msg ">
                    
            <div class="media-body">

                <h5 class="media-heading">
                    
                    <?php echo $riga['NOME']; ?> &emsp; 
                    
                    <small class="pull-right time"><i class="fa fa-clock-o"></i> 

                        <?php echo $riga['DATADICONDIVISIONE']; ?> 

                    </small>

                </h5> 

                <div class="c4l-rating">

                    <?php

                        $j=0;

                        while($j<$riga['VALUTAZIONE'])
                        {
                    
                    ?>

                    <input name="c4l-rating" id="c4l-rate1" />
                    <label for="c4l-rate1"></label>

                    <?php

                            $j++;
                        }

                    ?>

                </div>

                <small class="col-lg-7">

                    <?php echo $riga['DESCRIZIONE']; ?>

                </small>

            </div>
                    
        </div>

         <?php 
             
                }
            }
            else
            {

                echo('Errore : '.mysqli_error($conn));
                exit;
            }
                                            
        ?>
        
    </div>
</div>

<form action="../from-pages/inoltromessaggio.php" method="post">
            <input type="hidden" name="recensione" id="recensione"></input>
            <input type="hidden" name="struttura" id="struttura" value="<?php echo $i; ?>"></input>

            <div class="send-wrap ">
                <textarea class="form-control send-message" rows="3" placeholder="Scrivi una recensione..." name="messaggio" id="recensione"></textarea>
            </div>

            <div class="btn-panel">
                    <button type="submit" class=" col-lg-4 text-right btn   send-message-btn pull-right"><i class="fa fa-plus"></i> Inoltra</button>    
            </div>

            <div class="c4l-rating">
                <input name="c4l-rating" type="radio" id="c4l-rate1<?php echo $i; ?>" value="1" />  <!-- assegno i per far cambiare valore dell'ide, per aiutare la visualizzazione della valutazione -->
                <label for="c4l-rate1<?php echo $i; ?>"></label>
                
                <input name="c4l-rating" type="radio" id="c4l-rate2<?php echo $i; ?>" value="2" />
                <label for="c4l-rate2<?php echo $i; ?>"></label>
                
                <input name="c4l-rating" type="radio" id="c4l-rate3<?php echo $i; ?>" value="3" />
                <label for="c4l-rate3<?php echo $i; ?>"></label>
                
                <input name="c4l-rating" type="radio" id="c4l-rate4<?php echo $i; ?>" value="4" />
                <label for="c4l-rate4<?php echo $i; ?>"></label>
                
                <input name="c4l-rating" type="radio" id="c4l-rate5<?php echo $i; ?>" value="5" checked />
                <label for="c4l-rate5<?php echo $i; ?>"></label>
            </div>
        </form>

    