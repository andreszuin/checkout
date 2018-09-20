import java.math.BigDecimal;

public class PromocaoValor implements Promocao {
    private Integer quantidade,valorDesconto;
    PromocaoValor(Integer quantidade, Integer valorDesconto){
        this.quantidade =quantidade;
        this.valorDesconto = valorDesconto;
    }
    public BigDecimal desconto (Item i){
        BigDecimal desconto;
        Integer a = i.getQuantidade()/this.quantidade;
        desconto = BigDecimal.valueOf(a).multiply((i.getProduto().getValor().multiply(BigDecimal.valueOf(quantidade))).subtract(BigDecimal.valueOf(valorDesconto)));
        return desconto;
    }
}
