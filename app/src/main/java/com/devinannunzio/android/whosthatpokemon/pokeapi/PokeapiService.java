package com.devinannunzio.android.whosthatpokemon.pokeapi;

import com.devinannunzio.android.whosthatpokemon.models.PokemonReply;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeapiService {

    //possibly just pokemon
    @GET("pokemon?limit=151")
    Call<PokemonReply> obtainListOfPokemon();

}
