package ifpr.pgua.eic.tads.contatos.model;

import ifpr.pgua.eic.tads.contatos.model.repositories.BebidaRepository;
import ifpr.pgua.eic.tads.contatos.model.repositories.LancheRepository;

public class Pedido {
    private int id;
    private String observacao;
    private BebidaRepository bebida;
    private LancheRepository lanche;

    public Pedido(String observacao, BebidaRepository bebida, LancheRepository lanche) {
        this.observacao = observacao;
        this.bebida = bebida;
        this.lanche = lanche;
    }

    public Pedido(int id, String observacao, BebidaRepository bebida, LancheRepository lanche) {
        this.id = id;
        this.observacao = observacao;
        this.bebida = bebida;
        this.lanche = lanche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BebidaRepository getBebida() {
        return bebida;
    }

    public void setBebida(BebidaRepository bebida) {
        this.bebida = bebida;
    }

    public LancheRepository getLanche() {
        return lanche;
    }

    public void setLanche(LancheRepository lanche) {
        this.lanche = lanche;
    }

    @Override
    public String toString() {
        return "ID: " + id + "<br> Observação: " + observacao +
                "<br> Bebida: " + bebida + "<br> Lanche: " + lanche;
    }
}
