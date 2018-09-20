import java.math.BigDecimal;
import java.util.ArrayList;

public class Caixa {
    private PromocaoValor prodA = new PromocaoValor(1,3,130);
    private PromocaoValor prodB = new PromocaoValor(2,2,45);
    private PromocaoXporY prodC = new PromocaoXporY(3,3,2);
    private PromocaoXporY prodD = new PromocaoXporY(4,1,1);
    private Produto X = new Produto();
    private Produto A = new Produto(1,"A", BigDecimal.valueOf(50));
    private Produto B = new Produto(2,"B",BigDecimal.valueOf(30));
    private Produto C = new Produto(3,"C",BigDecimal.valueOf(20));
    private Produto D = new Produto(4,"D",BigDecimal.valueOf(15));

    Caixa(){
        A.addPromo(prodA);
        B.addPromo(prodB);
        C.addPromo(prodC);
        D.addPromo(prodD);
    }

    ArrayList<Item> itens = new ArrayList<>();
    public void entrada(String entrada){

    }

    public void add(String input){
        X = teste(input);
        findAdd(X);

    }

    public void remove(String input){
        X = teste(input);
        findDec(X);
    }

    public void findAdd(Produto prod){
        for(Item i : itens){
            if(i.getProduto().equals(prod)){
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
            if(i.getProduto().equals(prod)){
                i.decQuantidade();
            }
        }
    }

    public Produto teste(String input){
        switch (input){
            case "A":
                X = A;
                break;
            case "B":
                X = B;
                break;
            case "C":
                X = C;
                break;
            case "D":
                X = D;
                break;
                default:
        }
        return X;
    }

    public BigDecimal getTotalPrice(){
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal retorno;
        for(Item i : itens){
            discount.add(i.getProduto().getPromo(i));
            total.add(i.getProduto().getValor().multiply(BigDecimal.valueOf(i.getQuantidade())));
        }
        retorno = total.subtract(discount);
        return retorno;
    }

    public BigDecimal getTotalDiscount(){
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal retorno;
        for(Item i : itens){
             discount.add(i.getProduto().getPromo(i));
        }
        retorno = discount;
        return retorno;
    }
}
