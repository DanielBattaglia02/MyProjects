<?php

    session_start() ;

    require_once( "../database-parts/connessione.php" ) ;

    if(isset($_GET['stampa']))
    {
        $query = "SELECT NOME FROM PN_STRUTTURE_LAVORATIVE WHERE ID='".$_SESSION['idstruttura']."'";

        $risp = mysqli_query($conn, $query) ;
        if ($risp)
        {
            $riga = mysqli_fetch_array($risp);
        }
        else
        {
            echo 'ERRORE QUERY2 : ' . mysqli_error($conn) ;
        }

        $subject = "NOTIFICA EVENTO <PIANETA CASERTA>";

        $message = "
        <html>
            <head>
                <title>Email di attivazione</title>
            </head>

            <body>
                <table>
                    <tr>
                        <th>NUOVO EVENTO DISPONIBILE</th>
                    </tr>
                    <tr>
                        <td>
                            Il titolo dell'evento é : '".$_SESSION['titolo']."'
                        </td>  
                    </tr>
                    <tr>
                        <td>
                            Descrizione : '".$_SESSION['descrizione']."'
                        </td>  
                    </tr>
                    <tr>
                        <td>
                            Data Inizio : '".$_SESSION['datainizio']."'
                        </td>  
                    </tr>
                    <tr>
                        <td>
                            Data Fine : '".$_SESSION['datafine']."'
                        </td>  
                    </tr>
                    <tr>
                        <td>
                            Orario Inizio : '".$_SESSION['orarioinizio']."'
                        </td>  
                    </tr>
                    <tr>
                        <td>
                            Orario Fine : '".$_SESSION['orariofine']."'
                        </td>  
                    </tr>
                    <tr>
                        <td>
                            Struttura che lo mette a disposizione : '".$riga['NOME']."'
                        </td>  
                    </tr>
                </table>
            </body>
        </html>
        ";

        $query = "SELECT EMAIL FROM PN_UTENTI WHERE RUOLO='abbonato'";

        $risp = mysqli_query($conn, $query) ;
        if ($risp)
        {
            while($riga = mysqli_fetch_array($risp))
            {
                $to = $riga['EMAIL'];

                    // Always set content-type when sending HTML email
                $headers = "MIME-Version: 1.0" . "\r\n";
                $headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";

                mail($to,$subject,$message,$headers);

                unset($_SESSION['idstruttura']);
                unset($_SESSION['descrizione']);
                unset($_SESSION['titolo']);
                unset($_SESSION['datainizio']);
                unset($_SESSION['datafine']);
                unset($_SESSION['orarioinizio']);
                unset($_SESSION['orariofine']);
            }
        }
        else
        {
            echo 'ERRORE QUERY2 : ' . mysqli_error($conn) ;
        }

    }
    else
    {
        $key1 = rand(1,9);
        $key2 = rand(1,9);
        $key3 = rand(1,9);
        $key4 = rand(1,9);
        $key5 = rand(1,9);
        $key6 = rand(1,9);

        $key = $key1 . $key2 . $key3 . $key4. $key5 . $key6 ;
        $_SESSION['key'] = $key;

        $to = $_SESSION['email'];
        $subject = "NOTIFICA EVENTO <PIANETA CASERTA>";

        $message = "
        <html>
        <head>
        <title>Email di attivazione</title>
        </head>
        <body>
        <table>
        <tr>
        <th>CODICE ATTIVAZIONE</th>
        </tr>
        <tr>
        <td>".$key."</td>
        </tr>
        </table>
        </body>
        </html>
        ";

        // Always set content-type when sending HTML email
        $headers = "MIME-Version: 1.0" . "\r\n";
        $headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";

        mail($to,$subject,$message,$headers);

        header("location:homepageconfermaemail.php");
    }

    mysqli_close($conn);	//fine connessione

?>
