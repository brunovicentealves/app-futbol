package com.bruno.futbol;

public class Time {
    private  int id ;
    private String nome ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Id :" + this.id + "Nome:"+this.nome;
    }

}