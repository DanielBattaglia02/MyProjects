package com.example.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Metodo per creare il menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla il menu dal file XML
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Metodo per gestire la selezione degli item nel menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*il messaggio "Resource IDs will be non-final by
        default in Android Gradle Plugin version 8.0" è la chiave del problema.
        A partire dalla versione 8.0 del plugin Gradle per Android,
        gli ID delle risorse non sono più definiti come costanti finali di default,
        il che significa che non possono essere utilizzati in un blocco switch-case.
        Questo comportamento è stato introdotto per supportare la compilazione incrementale
        e migliorare le prestazioni.
         */
        int id = item.getItemId();

        if (id == R.id.menu_item1) {
            Toast.makeText(this, "Hai cliccato Item 1", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_item2) {
            Toast.makeText(this, "Hai cliccato Item 2", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
