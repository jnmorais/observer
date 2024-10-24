package org.example;
import java.util.Observable;
import java.util.Observer;
public class SupTecnico implements Observer{

    private String nome;
    private String ultimoChamado;

    @Override
    public void update(Observable o, Object arg) {

    }

    public  SupTecnico (String nome) {
        this.nome = nome;
    }

    public String getUltimoChamado() {
        return ultimoChamado;
    }

    public void setUltimoChamado(String ultimoChamado) {
        this.ultimoChamado = ultimoChamado;
    }
}
