public class Item {
    private Produto produto;
    private Integer quantidade = 0;

    public Integer getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void incQuantidade(){
        this.quantidade++;
    }

    public void decQuantidade(){
        this.quantidade--;
    }
}
