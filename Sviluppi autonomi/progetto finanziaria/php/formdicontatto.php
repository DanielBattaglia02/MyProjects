<!DOCTYPE html>
<html>
    <head lang="it">
        <title>RICHIESTA PREVENTIVI</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords" content="area prestiti sud">
        <meta name="author" content="Daniel Battaglia">
        <meta name="description" content="Benvenuto su questa pagina. Il seguente form può essere utilizzato per contattarci per richieste di preventivi. La ricontatteremo quanto prima.">
        <meta name="robots" content="noindex">

        <link rel="stylesheet" href="../css/template.css" type="text/css">
        <link rel="stylesheet" href="../css/form.css" type="text/css">

            <!-- Google Search Console -->
        <script type="text/javascript">
        var _iub = _iub || [];
        _iub.csConfiguration = {"askConsentAtCookiePolicyUpdate":true,"floatingPreferencesButtonDisplay":"bottom-right","perPurposeConsent":true,"siteId":3352780,"whitelabel":false,"cookiePolicyId":50525806,"lang":"it", "banner":{ "acceptButtonDisplay":true,"closeButtonRejects":true,"customizeButtonDisplay":true,"explicitWithdrawal":true,"listPurposes":true,"position":"bottom" }};
        </script>
        <script type="text/javascript" src="https://cs.iubenda.com/autoblocking/3352780.js"></script>
        <script type="text/javascript" src="//cdn.iubenda.com/cs/iubenda_cs.js" charset="UTF-8" async></script>

            <!-- Google tag (gtag.js) -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=G-592G3CGHX7"></script>
        <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());
        gtag('config', 'G-592G3CGHX7');
        </script>
    </head>
    <body>

            <!-- header start -->
                <!-- titolo start-->
        <div class="headertitolo">
            <div class="headerconf1">
                <div>
                    <img src="../img/logo1.png" class="logo"></img>
                </div>

                <div class="azienda">
                    <div class="nomeazienda">
                        <b>AREA PRESTITI SUD</b>
                    </div>

                    <div class="indirizzo">
                        <b>Via Ferrarecce, 102</b>
                        <b>Caserta, 81100</b>
                    </div>
                </div>

                <div class="contatti">
                    <b>CONTATTI</b>
                    <br><br>
                    Tel. 0823 456023
                    <br>
                    Cell. 334 5095976
                    <br>
                    Fax. 0823 456023
                    <br>
                    E-mail: egidio.grosso@virgilio.it
                </div>
            </div>     
        </div>
                <!-- titolo end -->

                <!-- navbar start -->
        <div class="headernav">
            <div class="headerconf2">
                <ul class="navbar">
                    <li><a href="../index.html"><b>HOME</b></a></li>
                    <li><a href="../contatti.html"><b>CONTATTI</b></a></li>
                    <li><a href=""><b>RICHIESTA PREVENTIVI</b></a></li>
                </ul>
            </div>
        </div>
                <!--navbar end -->
            <!-- header end -->

            <!-- main start -->
        <div class="main">

            <?php

            if(isset($_GET['result']))  //controlla se bisogna attendere l'esito di un email inoltrata
            {
                if($_GET['result']==1)  //verifica se l'email è stata inoltrata con successo
                {

            ?>

            <div class="mydivtrue">E-mail inviata con successo. La contatteremo quanto prima.</div>   

            <?php
                }
                else
                {

            ?>

            <div class="mydivfalse">E-mail non inviata. Riprovare più tardi</div>

            <?php

                }
            }

            ?>

            <div class="spiegazione">
                Benvenuto su questa pagina. Il seguente form può essere utilizzato per contattarci per richieste di preventivi.
                La ricontatteremo quanto prima.
            </div>

                <!-- form di contatto start -->
            <form action="inoltrorichiesta.php" method="post">
                <label class="labeltext"><b>NOME:</b></label>
                <input type="text" name="nome" placeholder="Il tuo nome" required></input>

                <label class="labeltext"><b>COGNOME:</b></label>
                <input type="text" name="cognome" placeholder="Il tuo cognome" required></input>

                <label class="labeltext"><b>DATA DI NASCITA:</b></label>
                <input type="date" name="nascita"  required></input>

                <label class="labeltext"><b>E-MAIL:</b></label>
                <input type="email" name="e-mail" placeholder="La tua E-mail" required></input>

                <label class="labeltext"><b>TELEFONO:</b></label>
                <input type="text" name="telefono" placeholder="Il tuo numero di telefono" required></input>

                <label class="labeltext" for="lavoro"><b>LAVORO:</b></label>
                <select name="lavoro" id="lavoro">
                    <option value="Lavoratore Autonomo">Lavoratore Autonomo</option>
                    <option value="Dipendente Statale">Dipendente Statale</option>
                    <option value="Dipendente Pubblico">Dipendente Pubblico</option>
                    <option value="Dipendente Privato">Dipendente Privato</option>
                    <option value="Pensionato">Pensionato</option>
                    <option value="Azienda">Azienda</option>
                </select>

                <label class="labeltext"><b>DATA DI ASSUNZIONE:</b></label>
                <input type="date" name="assunzione"  required></input>

                <label class="labeltext""><b>OGGETTO:</b></label>
                <input type="text" name="oggetto" placeholder="Indicare se è una richiesta informazioni o preventivo" required></input>

                <label class="labeltext""><b>MESSAGGIO:</b></label>
                <textarea name="messaggio" rows="7" placeholder="Scrivi quì la tua richiesta"required></textarea>

                <input type="checkbox" value="si" id="trattamento_dati" name="trattamento_dati" required>
                <label class="labelcheckbox" for="trattamento dati">L'utente accetta il trattamento dati, secondo il rispetto della legge 675/96 e successive modifiche. 
                    Quì la nostra 
                    <a href="https://www.iubenda.com/privacy-policy/50525806" class="iubenda-white iubenda-noiframe iubenda-embed iubenda-noiframe " title="Privacy Policy ">Privacy Policy</a><script type="text/javascript">(function (w,d) {var loader = function () {var s = d.createElement("script"), tag = d.getElementsByTagName("script")[0]; s.src="https://cdn.iubenda.com/iubenda.js"; tag.parentNode.insertBefore(s,tag);}; if(w.addEventListener){w.addEventListener("load", loader, false);}else if(w.attachEvent){w.attachEvent("onload", loader);}else{w.onload = loader;}})(window, document);</script> - 
                </label>

                <button>INVIA</button>
            </form>
                <!-- form di contatto end -->

        </div>
             <!-- main end -->

            <!-- footer start -->
        <footer>
            &copyCopyright 2023 - 
            <a href="https://www.iubenda.com/privacy-policy/50525806" class="iubenda-white iubenda-noiframe iubenda-embed iubenda-noiframe " title="Privacy Policy ">Privacy Policy</a><script type="text/javascript">(function (w,d) {var loader = function () {var s = d.createElement("script"), tag = d.getElementsByTagName("script")[0]; s.src="https://cdn.iubenda.com/iubenda.js"; tag.parentNode.insertBefore(s,tag);}; if(w.addEventListener){w.addEventListener("load", loader, false);}else if(w.attachEvent){w.attachEvent("onload", loader);}else{w.onload = loader;}})(window, document);</script> - 
            <a href="https://www.iubenda.com/privacy-policy/50525806/cookie-policy" class="iubenda-white iubenda-noiframe iubenda-embed iubenda-noiframe " title="Cookie Policy ">Cookie Policy</a><script type="text/javascript">(function (w,d) {var loader = function () {var s = d.createElement("script"), tag = d.getElementsByTagName("script")[0]; s.src="https://cdn.iubenda.com/iubenda.js"; tag.parentNode.insertBefore(s,tag);}; if(w.addEventListener){w.addEventListener("load", loader, false);}else if(w.attachEvent){w.attachEvent("onload", loader);}else{w.onload = loader;}})(window, document);</script>
        </footer>
            <!-- footer end -->
    </body>
</html>