package com.devinannunzio.android.whosthatpokemon;

public class Pokemon {
    private String name;
    private int number;

    Pokemon(String name, int num){
        this.name = name;
        this.number = num;
    }

    public String getName(){
        return this.name;

    }

    public int getNumber(){
        return this.number;

    }


}
