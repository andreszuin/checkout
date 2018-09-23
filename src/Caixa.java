import DAOS.ProdutoDAO;
import Modelos.Item;
import Modelos.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Caixa {
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private ArrayList<Item> itens = new ArrayList<>();

    public void add(Integer id){
        findAdd(produtoDAO.get(id));
    }

    public void remove(Integer id){
        findDec(produtoDAO.get(id));
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
            if(i.getQuantidade().equals(0)){
                return;
            }
            if(i.getId().equals(prod.getId())){
                i.decQuantidade();
                return;
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
