package Modelos;

import java.math.BigDecimal;

public class PromocaoValor implements Promocao {
    private Integer quantidade,id;
    private BigDecimal valorDesconto;
    public PromocaoValor(Integer id, Integer quantidade, BigDecimal valorDesconto){
        this.quantidade =quantidade;
        this.id = id;
        this.valorDesconto = valorDesconto;
    }
    public BigDecimal desconto (Item i){
        BigDecimal desconto;
        Integer a = i.getQuantidade()/this.quantidade;
        desconto = BigDecimal.valueOf(a).multiply((i.getProduto().getValor().multiply(BigDecimal.valueOf(quantidade))).subtract(valorDesconto));
        return desconto;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
