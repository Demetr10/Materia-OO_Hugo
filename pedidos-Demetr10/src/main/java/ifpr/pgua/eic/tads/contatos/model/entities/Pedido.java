package ifpr.pgua.eic.tads.contatos.model.entities;

// import ifpr.pgua.eic.tads.contatos.model.repositories.BebidaRepository;
// import ifpr.pgua.eic.tads.contatos.model.repositories.LancheRepository;

public class Pedido {
    private int id;
    private String observacao;
    private int id_bebida;
    private int id_lanche;
    // private LancheRepository lanche;

    public Pedido(String observacao, int id_bebida, int id_lanche) {
        this.observacao = observacao;
        this.id_bebida = id_bebida;
        this.id_lanche = id_lanche;

    }

    public Pedido(int id, String observacao, int id_bebida, int id_lanche) {
        this.id = id;
        this.observacao = observacao;
        this.id_bebida = id_bebida;
        this.id_lanche = id_lanche;
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

    public int getBebida() {
        return id_bebida;
    }

    public void setBebida(int id_bebida) {
        this.id_bebida = id_bebida;
    }

    public int getLanche() {
        return id_lanche;
    }

    public void setLanche(int id_lanche) {
        this.id_lanche = id_lanche;
    }

    @Override
    public String toString() {
        return "Número do pedido:" + id + " Bebida: " + id_bebida + "Lanche: " + id_lanche + " Observação: "
                + observacao;
    }
}
