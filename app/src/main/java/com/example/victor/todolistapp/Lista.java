package com.example.victor.todolistapp;

import java.util.ArrayList;

/**
 * Created by Victor on 10/06/2017.
 */

public class Lista {
    private String nome;
    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Tarefa> getList() {
        return tarefas;
    }

    public void setList(ArrayList<Tarefa> list) {
        this.tarefas = list;
    }

    @Override
    public String toString() {
        return nome;
    }
}
