package com.devinannunzio.android.whosthatpokemon.pokeapi;

import com.devinannunzio.android.whosthatpokemon.models.PokemonReply;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {

    
    @GET("pokemon?limit=151")
    Call<PokemonReply> obtainListOfPokemon();

}
