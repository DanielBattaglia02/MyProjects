<?php
    /*questa pagina riceve i dati della richiesta(fatta dall'utente) da inoltrare alla finanziaria. 
    Uno volta ricevuti i dati, li inoltra via e-mail alla finanziaria*/

    $nome=$_POST['nome'];
    $cognome=$_POST['cognome'];
    $email=$_POST['email'];
    $telefono=$_POST['telefono'];
    $oggetto=$_POST['oggetto'];
    $messaggio=$_POST['messaggio'];
    $data_nascita=$_POST['nascita'];
    $lavoro=$_POST['lavoro'];
    $data_assunzione=$_POST['assunzione'];
    $trattamento_dati=$_POST['trattamento_dati'];

    if($trattamento_dati=="si") 
    { 
        $trattamento_dati="Accettato";
    }

    $txt="
            <html>
                <head>
                    <title>NUOVA RICHIESTA CLIENTE</title>
                </head>
                <body>
                    <h1>NUOVA RICHIESTA CLIENTE</h1>
                    <h3>INFORMAZIONI CLIENTE</h3>
                    <font size='5'>
                    <ul>
                        <li><b>Nome: </b>".$nome."</li>
                        <li><b>Cognome: </b>".$cognome."</li>
                        <li><b>Data di nascita: </b>".$data_nascita."</li>
                        <li><b>Email: </b>".$email."</li>
                        <li><b>Telefono: </b>".$telefono."</li>
                        <li><b>Lavoro: </b>".$lavoro."</li>
                        <li><b>Data di Assunzione: </b>".$data_assunzione."</li>
                        <li><b>Trattamento dati: </b>".$trattamento_dati."</li>
                        <li><b>Oggetto: </b>".$oggetto."</li>
                        <li><b>Messaggio: </b>".$messaggio."</li>
                    </ul>
                    </font>
                </body>
            </html>
            ";

    $to = "preventivi@areaprestitisud.it";
    $subject = "NUOVA RICHIESTA CLIENTE";

    // Always set content-type when sending HTML email
    $headers = "MIME-Version: 1.0" . "\r\n";
    $headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
                
    if(mail($to,$subject,$txt,$headers))
    {
        header('Location: formdicontatto.php?result=1');
    }
    else
    {
        header('Location: formdicontatto.php?result=0');
    }
    
?>