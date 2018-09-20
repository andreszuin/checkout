import java.math.BigDecimal;

public class PromocaoValor implements Promocao {
    private Integer quantidade,valorDesconto,id;
    PromocaoValor(Integer id, Integer quantidade, Integer valorDesconto){
        this.quantidade =quantidade;
        this.id = id;
        this.valorDesconto = valorDesconto;
    }
    public BigDecimal desconto (Item i){
        BigDecimal desconto;
        Integer a = i.getQuantidade()/this.quantidade;
        desconto = BigDecimal.valueOf(a).multiply((i.getProduto().getValor().multiply(BigDecimal.valueOf(quantidade))).subtract(BigDecimal.valueOf(valorDesconto)));
        return desconto;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
