package com.example.debarembar.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class User {

    @PrimaryKey
    public int ID;

    @ColumnInfo
    String nome;

    @ColumnInfo
    String telefone;

    @ColumnInfo
    String endereco;

    public User(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}
