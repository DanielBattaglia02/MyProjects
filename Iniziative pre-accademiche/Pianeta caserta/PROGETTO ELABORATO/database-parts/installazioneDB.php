<?php
												/* dati utili per la connessione al DB */
	$filename = 'start-up.sql';
	$mysql_host = 'localhost';
    $mysql_username = 'root';
	$mysql_password = '';	  
												/* connessione al DB */
	$conn = mysqli_connect($mysql_host, $mysql_username, $mysql_password);
	if(!$conn) 
	{
		echo('Errore : '.mysqli_error($conn));
		exit;
	}
		
	$templine = '';
												/* Opening the installation setup file */
	$lines = file($filename);
												/* Reading the installation file */
	foreach($lines as $lines_num => $line)
	{
			//echo($lines_num.'['.$line.']<br>'); // decommentare per studio.
												/* Comments are not considered */
        if(substr($line, 0, 2) != '--' && $line != '')
        {
            $templine .= $line;
            if(substr(trim($line), -1, 1) == ';')
            {
                                                /* Sending the code as a query so that it can be executed 
                                                    and the DB can be created */
                    //echo($templine . '<br>');	// decommentare per studio.
                $risp = mysqli_query($conn, $templine);
                if(!$risp) 
                {
                    echo('Errore : '.mysqli_error($conn));
                    exit;
                }

                $templine = '';
            }
        }
    }
										 
	mysqli_close($conn);        //fine connessione

	header("location:../homepage/index.php");
	exit;
?>