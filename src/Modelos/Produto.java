package Modelos;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Produto {
    private Integer id;
    private String codigo;
    private BigDecimal valor;
    private ArrayList<Promocao>promo = new ArrayList<>();

    public Produto(){

    }
    public Produto(Integer id, String codigo , BigDecimal valor){
        this.id = id;
        this.valor = valor;
        this.codigo = codigo;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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
        if(promo.equals(null)){
            return BigDecimal.ZERO;
        }
        for (Promocao p : promo){
            if(p.desconto(i).compareTo(desconto)== 1){
                desconto = p.desconto(i);
            }
        }

        return desconto;
    }

    public ArrayList getPromolist(){
        return promo;
    }

    public Promocao getPromocao(){
        return promo.get(0);
    }

    public void addPromo(Promocao promocao){
        promo.add(promocao);
    }

    public void setPromo(ArrayList<Promocao> promo) {
        this.promo = promo;
    }
}
