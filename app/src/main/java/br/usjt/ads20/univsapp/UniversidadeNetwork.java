package br.usjt.ads20.univsapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UniversidadeNetwork {
    public static Universidade[] buscarUniversidades(String url) throws IOException {
        ArrayList<Universidade> universidades = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();

        Log.d("buscarUniversidades:url",url);

        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        String json = response.body().string();
        Log.d("buscarUniversidades:json",json);

        try {
            JSONArray lista = new JSONArray(json);
            for(int i = 0; i < lista.length(); i++) {
                JSONObject item = (JSONObject)lista.get(i);
                //System.out.println(item);
                Universidade universidade = new Universidade();
                universidade.setNome(item.getString("name"));
                universidade.setAlfa2(item.getString("alpha_two_code"));
                universidade.setPais(item.getString("country"));
                JSONArray webPages = item.getJSONArray("web_pages");
                universidade.setWebPage(webPages.getString(0));
                universidades.add(universidade);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        Universidade[] unis = universidades.toArray(new Universidade[0]);
        Arrays.sort(unis);
        return unis;
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}

