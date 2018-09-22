package Modelos;

import java.math.BigDecimal;

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

    public BigDecimal getPromo(Item i){
        return produto.getPromo(i);
    }

    public BigDecimal getTotal(){
        return produto.getValor().multiply(BigDecimal.valueOf(quantidade));
    }

    public Integer getId(){
        return produto.getId();
    }
}
