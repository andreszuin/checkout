import java.math.BigDecimal;
import java.util.ArrayList;

public class Caixa {
    private PromocaoValor prodA = new PromocaoValor(3,130);
    private PromocaoValor prodB = new PromocaoValor(2,45);
    private PromocaoXporY prodC = new PromocaoXporY(3,2);
    private PromocaoXporY prodD = new PromocaoXporY(1,1);
    private Produto X = new Produto();
    private Produto A = new Produto(Codigo.A, BigDecimal.valueOf(50));
    private Produto B = new Produto(Codigo.B,BigDecimal.valueOf(30));
    private Produto C = new Produto(Codigo.C,BigDecimal.valueOf(20));
    private Produto D = new Produto(Codigo.D,BigDecimal.valueOf(15));

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
