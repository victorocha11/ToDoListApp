package com.example.victor.todolistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        ListView listaDeCursos = (ListView) findViewById(R.id.ListViewListas);

        ArrayAdapter<Lista> adapter = new ArrayAdapter<Lista>(this,
                android.R.layout.simple_list_item_1, listas);

        listaDeCursos.setAdapter(adapter);
    }

    public void adicionarLista(View v){
       Lista novaLista = new Lista();
       novaLista.setNome("Lista1");
       listas.add(novaLista);


    }
}
