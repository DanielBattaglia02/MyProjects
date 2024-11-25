<div id="main" class="container" style="margin-top:100px; margin-bottom:100px;">
    <div class="row">

        <div class="col-9">
            <h3>INSERIMENTO NUOVO EVENTO</h3>
            <br>
            <form action="../from-pages/salvaevento.php" method="post">
                <div class="form-group">
                    <label for="formGroupExampleInput"><b>TITOLO EVENTO</b></label>
                    <input type="text" name="titolo" class="form-control" id="formGroupExampleInput" placeholder="inserisci..." required=""></input>
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2"><b>DESCRIZIONE EVENTO</b></label>
                    <input type="text" name="descrizione" class="form-control" id="formGroupExampleInput2" placeholder="inserisci..." required=""></input>
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2"><b>DATA INIZIO EVENTO</b></label>
                    <input type="date" name="datainizio" class="form-control" id="formGroupExampleInput3" placeholder="" required=""></input>
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2"><b>DATA FINE EVENTO</b></label>
                    <input type="date" name="datafine" class="form-control" id="formGroupExampleInput4" placeholder="" required=""></input>
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2"><b>ORARIO INIZIO EVENTO</b></label>
                    <input type="time" name="orarioinizio" class="form-control" id="formGroupExampleInput5" placeholder="" required=""></input>
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput6"><b>ORARIO FINE EVENTO</b></label>
                    <input type="time" name="orariofine" class="form-control" id="formGroupExampleInput6" placeholder="" required=""></input>
                </div>
                <div class="form-group">
                    <input type="submit" class="form-control" value="CONFERMA"></input>
                </div>
            </form>
        </div>