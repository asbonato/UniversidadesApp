package br.usjt.ads20.univsapp.presenter;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView avatar;
    private TextView nome, detalhe1,detalhe2;

    public ViewHolder(ImageView avatar, TextView nome, TextView detalhe1, TextView detalhe2) {
        this.avatar = avatar;
        this.nome = nome;
        this.detalhe1 = detalhe1;
        this.detalhe2 = detalhe2;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getDetalhe1() {
        return detalhe1;
    }

    public void setDetalhe1(TextView detalhe1) {
        this.detalhe1 = detalhe1;
    }

    public TextView getDetalhe2() {
        return detalhe2;
    }

    public void setDetalhe2(TextView detalhe2) {
        this.detalhe2 = detalhe2;
    }
}
