package br.usjt.ads20.univsapp.view;

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.univsapp.R;
import br.usjt.ads20.univsapp.presenter.ListarUniversidadesPresenter;
import br.usjt.ads20.univsapp.presenter.UniversidadeAdapter;
import br.usjt.ads20.univsapp.model.Universidade;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Nome: Antonio Sergio Ferreira Bonato
 * RA: 931280
 */
public class ListarUniversidadesActivity extends AppCompatActivity implements ListarUniversidadesView{
    public static final String UNIVERSIDADE = "br.usjt.ads20.drinksapp.universidade";
    private Universidade[] lista;
    private Context context;
    private BaseAdapter adapter;
    private ListView listView;
    ListarUniversidadesPresenter presenter = new ListarUniversidadesPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_universidade);
        context = this;
        Intent intent = getIntent();
        lista = (Universidade[]) intent.getSerializableExtra(MainActivity.UNIVERSIDADES);

        if (lista != null) {

            adapter = new UniversidadeAdapter(context, lista);
            listView = (ListView) findViewById(R.id.listview);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Uri uri = Uri.parse(lista[position].getWebPage());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                    startActivity(intent);
                }

            });
        } else {
            {
                mostrarToast("Nada foi encontrado.");
            }
        }

    }

    public void mostrarToast(String s){
        Toast toast = Toast.makeText(this,
                s, Toast.LENGTH_LONG);
        toast.show();
    }
}
