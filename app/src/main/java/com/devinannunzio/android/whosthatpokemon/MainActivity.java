package com.devinannunzio.android.whosthatpokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.devinannunzio.android.whosthatpokemon.models.Pokemon;
import com.devinannunzio.android.whosthatpokemon.models.PokemonReply;
import com.devinannunzio.android.whosthatpokemon.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "POKEDEX";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getData();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PokedexAdapter();
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void getData() {
        PokeapiService service = retrofit.create(PokeapiService.class);
         Call<PokemonReply> pokemonReplyCall = service.obtainListOfPokemon();

         pokemonReplyCall.enqueue(new Callback<PokemonReply>() {
             @Override
             public void onResponse(Call<PokemonReply> call, Response<PokemonReply> response) {
                 if (response.isSuccessful()){
                     PokemonReply pokemonReply = response.body();
                     ArrayList<Pokemon> pokemonList = pokemonReply.getResults();

                     for (Pokemon pokemon : pokemonList){
                         Log.i(TAG,"Pokemon: " + pokemon.getName());
                     }

                 } else{
                     Log.e(TAG,"onResponse: " + response.errorBody());


                 }
             }

             @Override
             public void onFailure(Call<PokemonReply> call, Throwable t) {
                 Log.e(TAG, "onFailure: " + t.getMessage());

             }
         });
    }
}