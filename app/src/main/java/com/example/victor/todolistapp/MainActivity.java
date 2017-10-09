package com.example.victor.todolistapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private static ArrayList<Lista> listas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Lista novaLista = new Lista();
        novaLista.setNome("Lista1");
        listas.add(novaLista);

        Lista novaLista2 = new Lista();
        novaLista2.setNome("Lista2");
        listas.add(novaLista2);*/

        listView = (ListView) findViewById(R.id.ListViewListas);
        ArrayAdapter<Lista> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listas);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                String str = ((TextView) arg1).getText().toString();
                Toast.makeText(getBaseContext(),str, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(),TarefaActivity.class);
                intent.putExtra("list_view_value", str);
                startActivity(intent);
            }
        });
    }

    public void adicionarLista(View v) {
        EditText mEdit = (EditText) findViewById(R.id.NomeDaLista);
        if (mEdit.getText().length() == 0) {//como o tamanho é zero é nulla aresposta
            mEdit.setError("Campo vazio");
        } else {
            Lista novaLista = new Lista();

            String nomeLista = mEdit.getText().toString();
            novaLista.setNome(nomeLista);
            listas.add(novaLista);

            listView = (ListView) findViewById(R.id.ListViewListas);
            ArrayAdapter<Lista> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, listas);
            listView.setAdapter(adapter);

        }

    }

    public static ArrayList<Lista> getListas() {
        return listas;
    }

    public static void setListas(ArrayList<Lista> listas) {
        MainActivity.listas = listas;
    }
}
