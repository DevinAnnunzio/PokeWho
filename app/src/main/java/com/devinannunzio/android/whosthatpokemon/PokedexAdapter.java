package com.devinannunzio.android.whosthatpokemon;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devinannunzio.android.whosthatpokemon.models.Pokemon;

import java.util.ArrayList;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder> {
    private ArrayList<Pokemon> dataSet;

    public PokedexAdapter(){
        dataSet = new ArrayList<>();
    }


    public void addListOfPokemon(ArrayList<Pokemon> pokemonList) {
        dataSet.addAll(pokemonList);
        notifyDataSetChanged();
    }

    public class PokedexViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout containerView;
        public TextView textView;
        PokedexViewHolder(View view){
            super(view);
            containerView = view.findViewById(R.id.pokedexRow);
            textView = view.findViewById(R.id.pokedexRowTextView);
            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Pokemon current = (Pokemon)containerView.getTag();
                    Intent intent = new Intent(v.getContext(), PokemonActivity.class);
                    intent.putExtra("name",current.getName());
                    intent.putExtra("number",current.getNumber());
                    v.getContext().startActivity(intent);
                }
            });

        }

    }


    @NonNull
    @Override
    public PokedexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokedex_row, parent, false);
        return new PokedexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokedexViewHolder holder, int position) {
        Pokemon current = dataSet.get(position);
        holder.textView.setText(current.getName());
        holder.containerView.setTag(current);

    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
