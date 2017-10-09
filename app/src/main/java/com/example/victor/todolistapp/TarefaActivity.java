package com.example.victor.todolistapp;

import android.content.Intent;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

public class TarefaActivity extends AppCompatActivity {
    private ListView listView;
    private String nomeDaLista;
    private TextView txt;


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


        ArrayList<Lista> listas = MainActivity.getListas();
        ArrayList<Tarefa> tare = null;

        for (Lista l: listas) {
            if(l.getNome().equals(nomeDaLista)){
                tare = l.getList();
            }
        }

        listView = (ListView) findViewById(R.id.ListViewTarefas);
        if(tare!=null) {
            ArrayAdapter<Tarefa> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, tare);
            listView.setAdapter(adapter);

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                String str = ((TextView) arg1).getText().toString();
                ArrayList<Lista> listas = MainActivity.getListas();
                ArrayList<Tarefa> tare = null;

                for (Lista l: listas) {
                    if(l.getNome().equals(nomeDaLista)){
                        tare = l.getList();
                        for(Tarefa t: tare){
                            if(t.toString().equals(str)) {
                                tare.remove(t);
                                l.setList(tare);
                            }
                        }
                    }
                }
                atualizaListview(tare);

            }
        });
    }

    private void atualizaListview(ArrayList<Tarefa> tare){
        listView = (ListView) findViewById(R.id.ListViewTarefas);
        if(tare!=null) {
            ArrayAdapter<Tarefa> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, tare);
            listView.setAdapter(adapter);
        }
    }




    public void novaTarefa(View v) throws ParseException {
        EditText mEdit   = (EditText)findViewById(R.id.NomeDaTarefa);
        EditText mEditDes   = (EditText)findViewById(R.id.DescricaoTarefa);
        EditText mEditData   = (EditText)findViewById(R.id.DataFim);
        EditText mEditHora   = (EditText)findViewById(R.id.HoraFim);

        if(mEdit.getText().length() == 0) {//como o tamanho é zero é nula a resposta
            mEdit.setError("Campo vazio");
        }else {
            String nomeTarefa = mEdit.getText().toString();
            String Descricao = mEditDes.getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            String dataTime = mEditData.getText().toString();
            dataTime += " "+ mEditHora.getText().toString();
            Date data = format.parse(dataTime);

            ArrayList<Lista> listas = MainActivity.getListas();
            ArrayList<Tarefa> tare = null;

            for (Lista l: listas) {
                if(l.getNome().equals(nomeDaLista)){
                    Tarefa taf = new Tarefa();
                    taf.setNomeTarefa(nomeTarefa);
                    taf.setDescricaoTarefa(Descricao);
                    taf.setDataFimTarefa(data);
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
        ArrayList<Lista> listas = MainActivity.getListas();
        for (Lista l: listas) {
            if(l.getNome().equals(nomeDaLista)){
                listas.remove(l);
                String str = nomeDaLista+" foi excluída";
                Toast.makeText(getBaseContext(),str, Toast.LENGTH_LONG).show();
            }
        }

        Intent intent = new Intent(getBaseContext(),MainActivity.class);
        startActivity(intent);
    }
}
