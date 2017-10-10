package com.example.victor.todolistapp

import android.content.Context
import android.content.Intent
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

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.Timer
import kotlin.reflect.KClass

class TarefaActivity : AppCompatActivity() {
    private var listView: ListView? = null
    private var nomeDaLista: String? = null
    private var txt: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa)
        val intent = intent
        val dados = intent.extras
        nomeDaLista = dados.getString("list_view_value")

        txt = findViewById(R.id.textViewMainTarefa) as TextView
        txt!!.text = nomeDaLista


        val listas = MainActivity.listas
        var tare: ArrayList<Tarefa>? = null

        for (l in listas) {
            if (l.nome == nomeDaLista) {
                tare = l.list
            }
        }

        listView = findViewById(R.id.ListViewTarefas) as ListView
        if (tare != null) {
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, tare)
            listView!!.adapter = adapter

        }

        listView!!.onItemClickListener = AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->
            val str = (arg1 as TextView).text.toString()
            val listas = MainActivity.listas
            var tare: ArrayList<Tarefa>? = null

            for (l in listas) {
                if (l.nome == nomeDaLista) {
                    tare = l.list
                    for (t in tare!!) {
                        if (t.toString() == str) {
                            tare!!.remove(t)
                            l.list = tare as ArrayList<Tarefa>
                        }
                    }
                }
            }
            atualizaListview(tare)
        }
    }

    private fun atualizaListview(tare: ArrayList<Tarefa>?) {
        listView = findViewById(R.id.ListViewTarefas) as ListView
        if (tare != null) {
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, tare)
            listView!!.adapter = adapter
        }
    }


    @Throws(ParseException::class)
    fun novaTarefa(v: View) {
        val mEdit = findViewById(R.id.NomeDaTarefa) as EditText
        val mEditDes = findViewById(R.id.DescricaoTarefa) as EditText
        val mEditData = findViewById(R.id.DataFim) as EditText
        val mEditHora = findViewById(R.id.HoraFim) as EditText

        if (mEdit.text.length == 0) {//como o tamanho é zero é nula a resposta
            mEdit.error = "Campo vazio"
        } else {
            val nomeTarefa = mEdit.text.toString()
            val Descricao = mEditDes.text.toString()
            val format = SimpleDateFormat("dd/MM/yyyy HH:mm")

            var dataTime = mEditData.text.toString()
            dataTime += " " + mEditHora.text.toString()
            val data = format.parse(dataTime)

            val listas = MainActivity.listas
            var tare: ArrayList<Tarefa>? = null

            for (l in listas) {
                if (l.nome == nomeDaLista) {
                    val taf = Tarefa()
                    taf.nomeTarefa = nomeTarefa
                    taf.descricaoTarefa = Descricao
                    taf.dataFimTarefa = data
                    tare = l.list
                    tare.add(taf)
                    l.list = tare
                }
            }

            MainActivity.listas = listas

            listView = findViewById(R.id.ListViewTarefas) as ListView
            if (tare != null) {
                val adapter = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, tare)
                listView!!.adapter = adapter
            }
        }
    }

    fun excluirLista(v: View) {
        val listas = MainActivity.listas
        for (l in listas) {
            if (l.nome == nomeDaLista) {
                listas.remove(l)
                val str = nomeDaLista!! + " foi excluída"
                Toast.makeText(baseContext, str, Toast.LENGTH_LONG).show()
            }
        }
        val intent: Intent = Intent(this@TarefaActivity, MainActivity::class.java)
        startActivity(intent)

    }

    private fun Intent(baseContext: Context?, kClass: KClass<MainActivity>): Any {
        return kClass
    }
}
