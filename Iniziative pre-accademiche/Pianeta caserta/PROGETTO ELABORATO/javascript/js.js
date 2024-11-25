// Creo l'oggetto per le richieste asincrone Javascript in XML via HTTP note come "Ajax".
		  
var xhttp = new XMLHttpRequest() ;
		  
		  
// Imposto la funzione di gestione della risposta in riferimento all'evento "onreadystatechange".

    xhttp.onreadystatechange = function() {
    
      if ( this.readyState==4 && this.status==200 )								// La richiesta è andata a buon fine.
      {
        var arr_squadre = JSON.parse( this.responseText ) ;				// Conversione in "ArrayInd. di ArrayAss." della risposta.
        
        table.innerHTML = "" ;																		// Pulizia della tabella.

        for ( i=0 ; i<arr_squadre.length ; i++ )									// Ciclo di scansione dei record memorizzati in forma di ArrayAss. all'interno di un vettore.
        {
            tr = document.createElement( "tr" ) ;										// Da qui in poi vengono creati tutti gli elementi di una riga...
            
            table.appendChild( tr ) ;
            
            td = document.createElement( "td" ) ;
            
            // Da notare che in PHP ed in Javascript si possono usare entrambi i caratteri
            // apice o doppie virgolette per fare stringhe escludendo l'altro
            // al fine usarlo per incorporare codici di altri linguaggi:
            // IN JAVASCRIPT
            // "<a href='ancora'>Ciao "+x+" stai?</a>"		oppure		'<a href="ancora">ciao '+x+' stai?</a>'
            // IN PHP
            // "<a href='ancora'>Ciao ".$x." stai?</a>"		oppure		'<a href="ancora">ciao '.$x.' stai?</a>'
            
            td.innerHTML = '<a href="" onclick="return deleteThisTeam('+arr_squadre[i].id+')"><i class="material-icons" style="font-size:16px">delete</i></a>'
            
            tr.appendChild( td ) ;
             
             td = document.createElement( "td" ) ;
            
            td.style.textAlign = "right" ; td.innerHTML = (i+1) ;
            
            tr.appendChild( td ) ;
             
             td = document.createElement( "td" ) ;
            
            td.innerHTML = '<a href="players.php?squadra_id='+arr_squadre[i].id+'&squadra='+arr_squadre[i].nome+'"><h4><b>'+arr_squadre[i].nome+'</b></h4></a>' ;
            
            tr.appendChild( td ) ;
             
             td = document.createElement( "td" ) ;
            
            td.innerHTML = '<a href="" onclick="return editNameOfThisTeam('+arr_squadre[i].id+')"><i class="material-icons" style="font-size:16px">edit</i></a>' ;
            
            tr.appendChild( td ) ;
        }
      }
      
    };


// Imposto la funzione di richiesta.

    function richiesta()
    {
      xhttp.open("GET", "index.php?mode="+MODE, true);		// Preparazione.
      
        xhttp.send();																				// Esecuzione.
        
        MODE = "sel" ;
    }


  // Esecuzuione della richiesta temporizzata ogni 2 minuti e visualizzazione del timer di refresh della tabella.
  
      var secLabel = document.getElementById("sec") ;
      
      var secTimer = 2*60 ;
      
      secLabel.innerHTML = secTimer ;
      
      function timer()
      {
          secTimer -- ;
          
          secLabel.innerHTML = secTimer ;
          
          if ( secTimer==0 )
          {
              secTimer = 2 * 60 + 1 ;
              
              richiesta() ;
          }
      }
  
    setInterval("timer()", 1000 ) ;