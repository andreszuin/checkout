import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO implements DAO{
    Conecta conex = new Conecta();
    Produto produto;

    public Produto search(Integer id) {
        conex.conexao();
        Produto prod = new Produto();
        try{
            conex.executa("select * from produto where id='" +id+"'" );
            conex.rs.first();
            prod.setId(conex.rs.getInt("id"));
            prod.setCodigo(conex.rs.getString("nome"));
            prod.setValor(conex.rs.getBigDecimal("valor"));
            PromocaoDAO promocaoDAO = new PromocaoDAO();
            prod.setPromo(promocaoDAO.searchListaPromo(id));
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao buscar os dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
        return prod;
    }


    public void update(Object object) {
        conex.conexao();
        produto = ((Produto)object);
        try{
            PreparedStatement pst = conex.conn.prepareStatement("update produto set nome=?,valor=? where id=? ");
            pst.setBigDecimal(2,produto.getValor());
            pst.setString(1,produto.getCodigo());
            pst.setInt(3,produto.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }


    public void insert(Object object) {
        conex.conexao();
        produto = ((Produto)object);
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into produto(id, nome, valor)values(?,?,?)");
            pst.setInt(1,produto.getId());
            pst.setString(2,produto.getCodigo());
            pst.setBigDecimal(3,produto.getValor());
            pst.executeUpdate();
            ArrayList<Promocao> promo = produto.getPromolist();
            for(Promocao p : promo){
                ProdPromoDAO pp = new ProdPromoDAO();
                pp.insert(produto.getId(),p.getId());
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }


    public void delete(Object object) {
        conex.conexao();
        produto = ((Produto)object);
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from produto where id=?");
            pst.setInt(1,produto.getId());
            pst.execute();
            ProdPromoDAO prodPromoDAO = new ProdPromoDAO();
            prodPromoDAO.delete(produto.getId());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
}
