package Modelos;

import java.math.BigDecimal;

public class PromocaoXporY implements Promocao {
    private Integer quantidade, pague, id;
    private String type;

    public PromocaoXporY(Integer id, Integer leve, Integer pague){
        this.quantidade = leve;
        this.id = id;
        this.pague = pague;
        this.type = "xy";
    }

    public BigDecimal desconto (Item i){
        BigDecimal desconto;
        Integer a = i.getQuantidade()/quantidade;
        desconto = BigDecimal.valueOf(a*(quantidade-pague)).multiply( i.getProduto().getValor());
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

    public Integer getPague() {
        return pague;
    }

    public BigDecimal getValorDesconto() {
        return BigDecimal.ZERO;
    }

    public void setPague(Integer pague) {
        this.pague = pague;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType(){
        return type;
    }
}
