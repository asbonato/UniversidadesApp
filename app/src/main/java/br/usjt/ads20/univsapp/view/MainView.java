package br.usjt.ads20.univsapp.view;

import br.usjt.ads20.univsapp.model.Universidade;

public interface MainView {
    void iniciarProgressBar();
    void pararProgressBar();
    void mostrarToast(String s);
    void mudarTela(Universidade universidades[]);
    boolean estaConectado();
    Universidade[] getUniversidades();
}
