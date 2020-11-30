package br.usjt.ads20.univsapp.presenter;

import android.os.AsyncTask;
import java.io.IOException;

import br.usjt.ads20.univsapp.model.Universidade;
import br.usjt.ads20.univsapp.model.UniversidadeNetwork;
import br.usjt.ads20.univsapp.view.MainView;

public class MainPresenter implements Presenter{
    private final String URL = "http://universities.hipolabs.com/search?name=";
    MainView view;
    Universidade[] univs;

    public MainPresenter(MainView view){
        this.view = view;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    public void buscarUniversidades(String nome){
        if(view.estaConectado()) {
            view.iniciarProgressBar();
            new DownloadJsonUniversidades().execute(URL+nome);
        } else {
            view.mostrarToast("Erro na rede");
        }

    }

    private class DownloadJsonUniversidades extends AsyncTask<String, Void, Universidade[]> {

        @Override
        protected Universidade[] doInBackground(String... strings) {
            Universidade[] universidades = getUniversidades(strings[0]);
            return universidades;
        }

        protected void onPostExecute(Universidade[] universidades){
            view.pararProgressBar();
            view.mudarTela(universidades);
        }
    }

    public Universidade[] getUnivs(){
        return univs;
    }

    public Universidade[] getUniversidades(String url){
        Universidade[] universidades = null;
        try {
            universidades =  UniversidadeNetwork.buscarUniversidades(url);
            univs = universidades;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return universidades;
    }
}
