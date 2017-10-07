package com.example.victor.todolistapp;

import java.util.ArrayList;

/**
 * Created by Victor on 10/06/2017.
 */

public class Lista {
    private String nome;
    private ArrayList<Tarefa> list = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Tarefa> getList() {
        return list;
    }

    public void setList(ArrayList<Tarefa> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Lista: " +
                "nome: '" + nome + '\'' +
                ", \nTarefas: " + list;
    }
}
