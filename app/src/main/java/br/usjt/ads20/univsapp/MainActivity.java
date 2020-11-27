package br.usjt.ads20.univsapp;

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.univsapp.R;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    private ProgressBar progressBar;
    public static final String UNIVERSIDADES = "br.usjt.ads20.drinksapp.universidades";
    private final String URL = "http://universities.hipolabs.com/search?name=";
    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_drink);
        progressBar = (ProgressBar)findViewById(R.id.progressBarMain);
        contexto = this;
    }

    public void buscarDrinks(View view){
        String nome = txtNome.getText().toString();
        if(UniversidadeNetwork.isConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
            new DownloadJsonUniversidades().execute(URL+nome);
        } else {
            Toast toast = Toast.makeText(this,
                    this.getResources().getString(R.string.erro_rede), Toast.LENGTH_LONG);
            toast.show();
        }

    }

    private class DownloadJsonUniversidades extends AsyncTask<String, Void, Universidade[]> {

        @Override
        protected Universidade[] doInBackground(String... strings) {
            Universidade[] universidades = null;
            try {

                universidades = UniversidadeNetwork.buscarUniversidades(strings[0]);
         } catch (IOException e) {
                e.printStackTrace();
            }
            return universidades;
        }

        protected void onPostExecute(Universidade[] universidades){
            Intent intent = new Intent(contexto, ListarUniversidadesActivity.class);
            intent.putExtra(UNIVERSIDADES, universidades);
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(intent);
        }
    }

}