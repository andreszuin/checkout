import DAOS.ProdutoDAO;
import Modelos.Item;
import Modelos.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Caixa {
    private Produto X = new Produto();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private ArrayList<Item> itens = new ArrayList<>();

    public void add(Integer id){
        X = produtoDAO.get(id);
        findAdd(X);
    }

    public void remove(Integer id){
        X = produtoDAO.get(id);
        findDec(X);
    }

    public void findAdd(Produto prod){
        for(Item i : itens){
            if(i.getId().equals(prod.getId())){
                i.incQuantidade();
                return;
            }
        }
        Item novo = new Item();
        novo.setProduto(prod);
        novo.incQuantidade();
        itens.add(novo);
    }

    public void findDec(Produto prod){
        for(Item i : itens){
            if(i.getId().equals(prod.getId())){
                i.decQuantidade();
            }
        }
    }

    public BigDecimal getTotalPrice(){
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        for(Item i : itens){
            discount = discount.add(i.getPromo(i));
            total = total.add(i.getTotal());
        }

        return total.subtract(discount);
    }

    public BigDecimal getTotalDiscount(){
        BigDecimal discount = BigDecimal.ZERO;
        for(Item i : itens){
             discount = discount.add(i.getPromo(i));
        }
        return discount;
    }
}
