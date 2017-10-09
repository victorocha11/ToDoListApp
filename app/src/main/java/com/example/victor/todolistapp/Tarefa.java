package com.example.victor.todolistapp;

import java.util.Date;
import java.util.Timer;

/**
 * Created by Victor on 10/06/2017.
 */

public class Tarefa {
    private String nomeTarefa, descricaoTarefa;
    private Date dataFimTarefa;

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public Date getDataFimTarefa() {
        return dataFimTarefa;
    }

    public void setDataFimTarefa(Date dataFimTarefa) {
        this.dataFimTarefa = dataFimTarefa;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nomeTarefa='" + nomeTarefa + '\'' +
                ", descricaoTarefa='" + descricaoTarefa + '\'' +
                ", dataFimTarefa=" + dataFimTarefa +
                '}';
    }
}
