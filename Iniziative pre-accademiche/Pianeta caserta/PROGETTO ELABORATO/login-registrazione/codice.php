            <p class="lead">Adesso dovrai inserire un codice di conferma che ti abbiamo nviato tramite email</p>
            <br>
            <h1>CODICE</h1>

            <form action="confermalogreg.php" method="post">
                <input type="hidden" name="set" id="set" value="1"></input>
                <input type="hidden" name="MODE" id="MODE" value="reg"></input>
                <input type="text" name="key" id="key" required=""></input>
                <button class="btn btn-lg btn-primary" type="submit">Submit</button>
            </form>