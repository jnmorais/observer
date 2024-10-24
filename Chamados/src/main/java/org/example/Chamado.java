package org.example;

import java.util.Observable;

public class Chamado extends Observable {
    private Integer numero;
    private String descricao;
    private String status;
    private String prioridade;

    public Chamado(Integer numero, String descricao, String prioridade) {
        this.numero = numero;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = "Aberto";
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "numero=" + numero +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", prioridade='" + prioridade + '\'' +
                '}';
    }
}