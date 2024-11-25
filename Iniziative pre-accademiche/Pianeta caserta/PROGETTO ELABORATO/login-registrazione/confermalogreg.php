<?php

    session_start() ;

    require_once( "../database-parts/connessione.php" ) ;
    
	if(isset($_POST['MODE']))
	{
		if($_POST['MODE'] == "log")		//CONTROLLI IN FASE DI LOGIN
		{
			$email = $_POST['email'] ;		
			$pass = $_POST['pass'] ;	
            $utente = $_POST['utente'] ;	
            $v='';  //variabile di appoggio
            
            if($utente == 'abbonato')
            {
                $query = "SELECT CONCAT(NOME,' ',COGNOME)AS result, ID, EMAIL, PASSWORD FROM PN_UTENTI WHERE EMAIL='".$email."' AND PASSWORD='".$pass."' AND RUOLO='abbonato'" ;
                $v=1;
            }

            if($utente == 'admin')
            {
                $query = "SELECT CONCAT(NOME,' ',COGNOME)AS result, ID, EMAIL, PASSWORD FROM PN_UTENTI WHERE EMAIL='".$email."' AND PASSWORD='".$pass."' AND RUOLO='admin'" ;
                $v=2;
            }

            if($utente == 'azienda')
            {
                $query = "SELECT ID, NOME FROM PN_STRUTTURE_LAVORATIVE WHERE EMAIL='".$email."' AND PIN='".$pass."'";
                $v=3;
            }

			$risp = mysqli_query($conn, $query) ;
			
			if($risp) 
			{
                if(mysqli_num_rows($risp) > 0)     //questa funzione verifica se la query di risposta dal database contiene almeno una riga
                {
                    while($riga = mysqli_fetch_array($risp))
                    {						/*assegnazione valori da associare alle variabili che creiamo nella nostra sessione*/
                        $_SESSION['id'] = $riga['ID'] ;
                        $_SESSION['email'] = $riga['EMAIL'] ;

                        if($v==1)
                        {
                            $_SESSION['nick'] = $riga['result'] ;
                            $_SESSION['ruolo'] = 'abbonato';
                        }

                        if($v==2)
                        {
                            $_SESSION['nick'] = $riga['result'] ;
                            $_SESSION['ruolo'] = 'admin' ;
                        }

                        if($v==3)
                        {
                            $_SESSION['nick'] = $riga['NOME'] ;
                            $_SESSION['ruolo'] = 'azienda' ;
                        }
                        
                        header("location:../homepage/index.php");		
                        
                        exit;
                    }
                }
                else
                {
                    header("location:homepage.php?er=3");  
                    exit;    
                }
            }
            else
            {
                echo 'ERRORE QUERY : ' . mysqli_error($conn) ;
            }
        }

		
		if ($_POST['MODE'] == "reg" )	//registrazione
		{                           
                                /*conferma codice inviato tramite email*/
			if(isset($_POST['key']))
			{
                $key = $_POST['key'] ;
                echo 'ERRORE QUERY2 :'  ;

                if($key==$_SESSION['key'])
                {
                    $query = "INSERT INTO PN_UTENTI (NOME, COGNOME, SESSO, DATADINASCITA, LUOGODINASCITA, RUOLO, EMAIL, PASSWORD) VALUES ('".$_SESSION['nome']."','".$_SESSION['cognome']."','".$_SESSION['sesso']."','".$_SESSION['dl']."','".$_SESSION['ln']."','abbonato','".$_SESSION['email']."','".$_SESSION['pass']."')" ;
                    $risp = mysqli_query($conn, $query) ;
                    if ($risp)
                    {
                        header("location:logout.php?er=0");
                        exit;
                    }
                    else
                    {
                        echo 'ERRORE QUERY2 : ' . mysqli_error($conn) ;
                    }
                }
                else
                {
                    header("location:homepageconfermaemail.php?er=1");  
                    exit;
                }
			}
			else
			{       
                    /*controllo credenziali inserite in registrazione*/
                if($_POST['pass1']!=$_POST['pass2'])
                {
                    header("location:homepage.php?er=1");
                }
                else
                {
                    if( strlen($_POST['pass1'])<6 || strlen($_POST['pass1'])>10)
                    {
                        header("location:homepage.php?er=1");   
                    }
                    else
                    {
                        $_SESSION['nome'] = $_POST['nome'] ;
                        $_SESSION['cognome'] = $_POST['cognome'] ;
                        $_SESSION['sesso'] = $_POST['sesso'] ;
                        $_SESSION['dl']= $_POST['data'] ;	//data di nascita
                        $_SESSION['ln'] = $_POST['ln'] ;	//luogo di nascita
                        $_SESSION['email'] = $_POST['email'] ;
                        $_SESSION['pass'] = $_POST['pass1'] ;

                        include 'mail.php';	    //invio email
                    }
                }
			}
		}

		if( $_POST['MODE'] == "mod")
		{

		}
	}

    mysqli_close($conn);	//fine connessione

?>