package Modelos;

import java.math.BigDecimal;

public interface Promocao {
    BigDecimal desconto (Item i);
    Integer getId();
    Integer getQuantidade();
    String getType();
    Integer getPague();
    BigDecimal getValorDesconto();
}
