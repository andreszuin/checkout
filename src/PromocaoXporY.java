import java.math.BigDecimal;

public class PromocaoXporY implements Promocao {
    private Integer quantidade, pague;
    PromocaoXporY(Integer leve, Integer pague){
        this.quantidade = leve;
        this.pague = pague;
    }
    public BigDecimal desconto (Item i){
        BigDecimal desconto;
        Integer a = i.getQuantidade()/quantidade;
        desconto = BigDecimal.valueOf(a*(quantidade-pague)).multiply( i.getProduto().getValor());
        return desconto;
    }
}
