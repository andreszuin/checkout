import java.math.BigDecimal;

public interface Promocao {
    BigDecimal desconto (Item i);
    Integer getId();
}
