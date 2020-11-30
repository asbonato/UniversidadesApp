package br.usjt.ads20.univsapp.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.jar.JarInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestUniversidadeNetwork {
    Universidade universidade;
    String url;

    @Before
    public void setup(){
        universidade = new Universidade("Universidade São Judas Tadeu");
        url = "http://universities.hipolabs.com/search?name=judas";
    }
    @Test
    public void testGetUniversidades() {
        String json = "[{\"country\": \"Brazil\", \"state-province\": null, \"name\": " +
                "\"Universidade São Judas Tadeu\", \"alpha_two_code\": \"BR\", " +
                "\"domains\": [\"saojudas.br\"], \"web_pages\": " +
                "[\"http://www.saojudas.br/\"]}]";

        Universidade[] universidades = null;
        try {
            universidades = UniversidadeNetwork.getUniversidades(json);
        } catch (IOException e){
            e.printStackTrace();
        }
        assertNotNull(universidades);
        assertEquals(1, universidades.length);
        assertEquals(universidades[0], universidade);
    }

    @Test
    public void testbuscarUniversidades(){
        Universidade[] universidades = null;
        try {
            universidades = UniversidadeNetwork.buscarUniversidades(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(universidades);
        assertEquals(1, universidades.length);
        assertEquals(universidades[0], universidade);
    }
}
