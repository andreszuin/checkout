import java.math.BigDecimal;
import java.util.ArrayList;

public class Produto {
    private Codigo codigo;
    private BigDecimal valor;
    private ArrayList<Promocao>promo = new ArrayList<>();

    Produto(){

    }
    Produto(Codigo codigo , BigDecimal valor){
        this.valor = valor;
        this.codigo = codigo;
    }


    public Codigo getCodigo() {
        return codigo;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getPromo(Item i) {
        BigDecimal desconto = BigDecimal.valueOf(0);

        for (Promocao p : promo){
            if(p.desconto(i).compareTo(desconto)== 1){
                desconto = p.desconto(i);
            }
        }

        return desconto;
    }

    public void addPromo(Promocao promocao){
        promo.add(promocao);
    }

    public void setPromo(ArrayList<Promocao> promo) {
        this.promo = promo;
    }
}
