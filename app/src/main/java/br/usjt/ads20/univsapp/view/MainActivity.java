package br.usjt.ads20.univsapp.view;

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.univsapp.R;
import br.usjt.ads20.univsapp.model.Universidade;
import br.usjt.ads20.univsapp.model.UniversidadeNetwork;
import br.usjt.ads20.univsapp.presenter.MainPresenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView{
    public static final String UNIVERSIDADES = "br.usjt.ads20.drinksapp.universidades";
    private EditText txtNome;
    private ProgressBar progressBar;
    private Universidade[] universidades;
    Context contexto;
    MainPresenter presenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_drink);
        progressBar = (ProgressBar)findViewById(R.id.progressBarMain);
        contexto = this;
    }

    public void buscarUniversidades(View view){
        String nome = txtNome.getText().toString();
        presenter.buscarUniversidades(nome);
    }

    public void pararProgressBar(){
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void iniciarProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void mostrarToast(String s){
        Toast toast = Toast.makeText(this,
                s, Toast.LENGTH_LONG);
        toast.show();
    }

    public void mudarTela(Universidade[] universidades){
        this.universidades = universidades;
        if (universidades != null && universidades.length > 0) {
            Intent intent = new Intent(contexto, ListarUniversidadesActivity.class);
            intent.putExtra(UNIVERSIDADES, universidades);
            startActivity(intent);
        } else {
            mostrarToast("Não encontrado.");
        }
    }
    /*
     * decidi acessar o model daqui da view pela necessidade de se ter um objeto
     * contexto para poder fazer o teste de conexão com a rede; caso contrário não
     * poderia testar o presenter pelo fato de que não é possível mockar um objeto
     * Context, uma vez que ele é criado pelo Android.
     */
    public boolean estaConectado(){
        return UniversidadeNetwork.isConnected(this);
    }

    public Universidade[] getUniversidades(){
        return this.universidades;
    }
}