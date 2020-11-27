package br.usjt.ads20.univsapp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

public class SectionIndexBuilder {
    public static Object[] buildSectionHeaders(Universidade[] universidades) {
        ArrayList<String> results = new ArrayList<>();
        TreeSet<String> used = new TreeSet<>();

        if(universidades != null){
            for(Universidade universidade: universidades){
                String letter = universidade.getNome().substring(0,1);

                if(!used.contains(letter)) {
                    results.add(letter);
                }
                used.add(letter);
            }
        }
        return results.toArray(new Object[0]);
    }

    public static Hashtable<Integer, Integer> buildPositionForSectionMap(Universidade[] universidades) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if(universidades != null){
            for(int i = 0; i < universidades.length; i++){
                String letter = universidades[i].getNome().substring(0,1);
                if(!used.contains(letter)){
                    section++;
                    used.add(letter);
                    results.put(section, i);
                }
            }
        }

        return results;
    }

    public static Hashtable<Integer, Integer> buildSectionForPositionMap(Universidade[] universidades) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if(universidades != null){
            for(int i = 0; i < universidades.length; i++){
                String letter = universidades[i].getNome().substring(0,1);
                if(!used.contains(letter)){
                    section++;
                    used.add(letter);
                }
                results.put(i, section);
            }
        }

        return results;
    }
}
