package com.example.victor.todolistapp

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Timer

/**
 * Created by Victor on 10/06/2017.
 */

class Tarefa {
    var nomeTarefa: String? = null
    var descricaoTarefa: String? = null
    var dataFimTarefa: Date? = null

    override fun toString(): String {

        val sdf = SimpleDateFormat("dd/MM/yyyy, HH:mm")
        val aux = sdf.format(dataFimTarefa)

        return "Tarefa: " +
                nomeTarefa +
                "\nDescrição: " + descricaoTarefa +
                " \nData e hora do fim da tarefa: " + aux
    }
}
