package com.example.victor.todolistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TarefaActivity extends AppCompatActivity {
    private ListView listView;
    private String nomeDaLista;
    private TextView txt;
    MainActivity ma = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);


        Intent intent = getIntent();
        Bundle dados = intent.getExtras();

        nomeDaLista =dados.getString("list_view_value");
        //email=dados.getString("email");

        txt = (TextView)findViewById(R.id.textViewMainTarefa);
        txt.setText(nomeDaLista);


    }




    public void novaTarefa(View v){
        EditText mEdit   = (EditText)findViewById(R.id.NomeDaTarefa);
        EditText mEditDes   = (EditText)findViewById(R.id.DescricaoTarefa);

        if(mEdit.getText().length() == 0) {//como o tamanho é zero é nulla aresposta
            mEdit.setError("Campo vazio");
        }else {
            String nomeTarefa = mEdit.getText().toString();
            String Descricao = mEditDes.getText().toString();
            ArrayList<Lista> listas = MainActivity.getListas();
            ArrayList<Tarefa> tare = null;

            for (Lista l: listas) {
                if(l.getNome().equals(nomeDaLista)){
                    Tarefa taf = new Tarefa();
                    taf.setNomeTarefa(nomeTarefa);
                    taf.setDescricaoTarefa(Descricao);
                    tare = l.getList();
                    tare.add(taf);
                    l.setList(tare);
                }
            }

            MainActivity.setListas(listas);

            listView = (ListView) findViewById(R.id.ListViewTarefas);
            if(tare!=null) {
                ArrayAdapter<Tarefa> adapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, tare);
                listView.setAdapter(adapter);
            }
        }
    }

    public void excluirLista(View v){

    }
}
