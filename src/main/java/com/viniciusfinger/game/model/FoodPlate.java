package com.viniciusfinger.game.model;

public class FoodPlate {

    private String nome;
    private String characteristics;

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getQuestion(){
        return "O prato que você pensou é " + this.getCharacteristics() + "?";
    }
}
