package com.devinannunzio.android.whosthatpokemon.models;

import java.util.ArrayList;

public class PokemonReply {
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults(){
        return this.results;
    }

    public ArrayList<Pokemon> setResults(ArrayList<Pokemon> results){
        return this.results = results;
    }
}
