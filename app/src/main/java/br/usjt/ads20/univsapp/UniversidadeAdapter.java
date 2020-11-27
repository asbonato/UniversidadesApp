package br.usjt.ads20.univsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

public class UniversidadeAdapter extends BaseAdapter implements SectionIndexer {
    Universidade[] universidades;
    Context context;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public UniversidadeAdapter(Context context, Universidade[] universidades){
        this.universidades = universidades;
        this.context = context;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(universidades);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(universidades);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPositionMap(universidades);
    }

    @Override
    public int getCount() {
        return universidades.length;
    }

    @Override
    public Object getItem(int i) {
        if(i >= 0 && i < universidades.length){
            return universidades[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_universidade, viewGroup, false);
            ImageView avatar = (ImageView) view.findViewById(R.id.avatar_universidade);
            TextView nome = (TextView) view.findViewById(R.id.nome_universidade);
            TextView detalhe1 = (TextView) view.findViewById(R.id.detalhe1_universidade);
            TextView detalhe2 = (TextView) view.findViewById(R.id.detalhe2_universidade);
            ViewHolder viewHolder = new ViewHolder(avatar, nome, detalhe1,
                    detalhe2 );
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder)view.getTag();

        viewHolder.getAvatar().setImageBitmap(Util.criaAvatar(context,
                universidades[i].getAlfa2()));

        viewHolder.getNome().setText(universidades[i].getNome());

        viewHolder.getDetalhe1().setText(String.format("%s", universidades[i].getPais()));
        viewHolder.getDetalhe2().setText(String.format("%s", universidades[i].getWebPage()));

        return view;
    }
    @Override
    public Object[] getSections() {
        System.out.println(sectionHeaders);
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int i) {
        return positionForSectionMap.get(i).intValue();
    }

    @Override
    public int getSectionForPosition(int i) {
        return sectionForPositionMap.get(i).intValue();
    }
}
