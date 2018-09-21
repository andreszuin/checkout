import DAOS.ProdutoDAO;
import Modelos.Item;
import Modelos.Produto;
import Modelos.PromocaoValor;
import Modelos.PromocaoXporY;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Caixa {
    private Produto X = new Produto();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    Caixa(){

    }

    ArrayList<Item> itens = new ArrayList<>();

    public void add(Integer id){
        X = produtoDAO.search(id);
        findAdd(X);
    }

    public void remove(Integer id){
        X = produtoDAO.search(id);
        findDec(X);
    }

    public void findAdd(Produto prod){
        for(Item i : itens){
            if(i.getProduto().getId().equals(prod.getId())){
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
            if(i.getProduto().getId().equals(prod.getId())){
                i.decQuantidade();
            }
        }
    }

    public BigDecimal getTotalPrice(){
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal retorno;
        for(Item i : itens){
            discount = discount.add(i.getProduto().getPromo(i));
            total = total.add(i.getProduto().getValor().multiply(BigDecimal.valueOf(i.getQuantidade())));
        }
        retorno = total.subtract(discount);
        return retorno;
    }

    public BigDecimal getTotalDiscount(){
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal retorno;
        for(Item i : itens){
             discount = discount.add(i.getProduto().getPromo(i));
        }
        retorno = discount;
        return retorno;
    }
}
