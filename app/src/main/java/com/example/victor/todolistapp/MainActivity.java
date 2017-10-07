package com.example.victor.todolistapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Lista> listas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lista novaLista = new Lista();
        novaLista.setNome("Lista1");
        listas.add(novaLista);

        Lista novaLista2 = new Lista();
        novaLista2.setNome("Lista2");
        listas.add(novaLista2);

        ListView listView = (ListView) findViewById(R.id.ListViewListas);

        ArrayAdapter<Lista> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listas);

        listView.setAdapter(adapter);
    }

    public void adicionarLista(View v){
       Lista novaLista = new Lista();
       novaLista.setNome("Lista1");
       listas.add(novaLista);

        ListView listView = (ListView) findViewById(R.id.ListViewListas);
        ArrayAdapter<Lista> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listas);
        listView.setAdapter(adapter);
    }


    public ArrayList<Lista> getListas() {
        return listas;
    }

    public void setListas(ArrayList<Lista> listas) {
        this.listas = listas;
    }
}
