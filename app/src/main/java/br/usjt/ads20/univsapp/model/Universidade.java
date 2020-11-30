package br.usjt.ads20.univsapp.model;

import java.io.Serializable;
import java.util.Objects;

public class Universidade implements Serializable,Comparable<Universidade>{
    private String nome;
    private String pais;
    private String alfa2;
    private String webPage;

    public Universidade(String nome){
        this.nome = nome;
    }
    public Universidade(){};

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

    @Override
    public String toString() {
        return "Universidade{" +
                "nome='" + nome + '\'' +
                ", pais='" + pais + '\'' +
                ", alfa2='" + alfa2 + '\'' +
                ", webPage='" + webPage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universidade that = (Universidade) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
