package com.example.victor.todolistapp

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

import java.util.ArrayList
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var listView: ListView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Lista novaLista = new Lista();
        novaLista.setNome("Lista1");
        listas.add(novaLista);

        Lista novaLista2 = new Lista();
        novaLista2.setNome("Lista2");
        listas.add(novaLista2);*/

        listView = findViewById(R.id.ListViewListas) as ListView
        val adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listas)

        listView!!.adapter = adapter

        listView!!.onItemClickListener = AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->
            val str = (arg1 as TextView).text.toString()
            Toast.makeText(baseContext, str, Toast.LENGTH_LONG).show()
            val intent = Intent(baseContext, TarefaActivity::class.java)
            intent.putExtra("list_view_value", str)
            startActivity(intent)
        }
    }

    fun adicionarLista(v: View) {
        val mEdit = findViewById(R.id.NomeDaLista) as EditText
        if (mEdit.text.length == 0) {//como o tamanho é zero é nulla aresposta
            mEdit.error = "Campo vazio"
        } else {
            val novaLista = Lista()

            val nomeLista = mEdit.text.toString()
            novaLista.nome = nomeLista
            listas.add(novaLista)

            listView = findViewById(R.id.ListViewListas) as ListView
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, listas)
            listView!!.adapter = adapter

        }

    }

    companion object {
        var listas = ArrayList<Lista>()
    }
}
