package com.example.victor.todolistapp

import java.util.ArrayList

/**
 * Created by Victor on 10/06/2017.
 */

class Lista {
    var nome: String? = null
    var list = ArrayList<Tarefa>()

    override fun toString(): String {
        return nome.toString()
    }
}
