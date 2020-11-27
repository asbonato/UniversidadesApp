package br.usjt.ads20.univsapp;

import java.io.Serializable;

public class Universidade implements Serializable,Comparable<Universidade>{
    private String nome;
    private String pais;
    private String alfa2;
    private String webPage;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAlfa2() {
        return alfa2;
    }

    public void setAlfa2(String alfa2) {
        this.alfa2 = alfa2;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    @Override
    public int compareTo(Universidade universidade) {
        return nome.compareTo(universidade.getNome());
    }
}
