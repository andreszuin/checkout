package DAOS;
import Modelos.*;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ProdutoDAO implements DAO<Produto>{
    private Conecta conex = new Conecta();
    private ProdPromoDAO pp = new ProdPromoDAO();

    public Produto get(Integer id) {
        conex.conexaoCheckout();
        Produto prod = new Produto();
        try{
            conex.executa("select * from produto where id='"+id+"'");
            conex.rs.first();
            prod.setId(conex.rs.getInt("id"));
            prod.setCodigo(conex.rs.getString("nome"));
            prod.setValor(conex.rs.getBigDecimal("valor"));
            PromocaoDAO promocaoDAO = new PromocaoDAO();
            prod.setPromo(promocaoDAO.searchListaPromo(id));
        }catch (Exception ex){

        }
        conex.desconnect();
        return prod;
    }


    public void update(Produto produto) {
        conex.conexaoCheckout();
        try(PreparedStatement pst = conex.conn.prepareStatement("update produto set nome=?,valor=? where id=? ");){
            pst.setBigDecimal(2,produto.getValor());
            pst.setString(1,produto.getCodigo());
            pst.setInt(3,produto.getId());
            pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }


    public void insert(Produto produto) {
        conex.conexaoCheckout();
        try(PreparedStatement pst = conex.conn.prepareStatement("insert into produto(id, nome, valor)values(?,?,?)");){
            pst.setInt(1,produto.getId());
            pst.setString(2,produto.getCodigo());
            pst.setBigDecimal(3,produto.getValor());
            pst.executeUpdate();
            ArrayList<Promocao> promo = produto.getPromolist();
            for(Promocao p : promo){
                pp.insert(produto.getId(),p.getId());
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }


    public void delete(Produto produto) {
        conex.conexaoCheckout();
        try(PreparedStatement pst = conex.conn.prepareStatement("delete from produto where id=?");) {
            pst.setInt(1,produto.getId());
            pst.execute();
            ProdPromoDAO prodPromoDAO = new ProdPromoDAO();
            prodPromoDAO.delete(produto.getId());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }
}
