package org.example;

import java.util.Observable;
import java.util.Observer;

public class SupTecnico implements Observer {
    private String nome;
    private String ultimoChamado;

    public SupTecnico(String nome) {
        this.nome = nome;
    }

    public String getUltimoChamado() {
        return this.ultimoChamado;
    }

    public void atenderChamado(Chamado chamado) {
        chamado.addObserver(this);
    }

    @Override
    public void update(Observable chamado, Object arg) {
        this.ultimoChamado = this.nome + ", novo chamado registrado: " + chamado.toString();
    }
}
