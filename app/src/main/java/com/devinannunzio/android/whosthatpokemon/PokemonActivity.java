package com.devinannunzio.android.whosthatpokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PokemonActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView numberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        String name = getIntent().getStringExtra("name");
        int number = getIntent().getIntExtra("number",0);

        nameTextView = findViewById(R.id.pokemonName);
        numberTextView = findViewById(R.id.pokemonNumber);

        nameTextView.setText(name);
        numberTextView.setText(String.format("#%03d",number));

    }
}