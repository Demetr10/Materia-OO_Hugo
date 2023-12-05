
package ifpr.pgua.eic.tads.contatos.model.repositories;

public class PedidoRepository {

    private int id;
    private String observacao;
    private BebidaRepository bebida;
    private LancheRepository lanche;

    public PedidoRepository(int id, String observacao, BebidaRepository bebida, LancheRepository lanche) {
        this.id = id;
        this.observacao = observacao;
        this.bebida = bebida;
        this.lanche = lanche;
    }

    public int getId() {
        return id;
    }

    public String getObservacao() {
        return observacao;
    }

    public BebidaRepository getBebida() {
        return bebida;
    }

    public LancheRepository getLanche() {
        return lanche;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setBebida(BebidaRepository bebida) {
        this.bebida = bebida;
    }

    public void setLanche(LancheRepository lanche) {
        this.lanche = lanche;
    }

    public String toString() {
        return "PedidoRepository [ID: " + id + ", Observação: " + observacao +
                ", Bebida: " + bebida + ", Lanche: " + lanche + "]";
    }
}
