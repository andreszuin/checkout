import javax.swing.*;
import java.sql.SQLException;

public class ProdutoDAO{
    Conecta conex = new Conecta();

    public Produto search(String nome) {
        conex.conexao();
        Produto prod = new Produto();
        try{
            conex.executa("select * from produto where nome='" +nome+"'" );
            conex.rs.first();
            prod.setCodigo(Codigo.valueOf(conex.rs.getString("nome")));
            prod.setValor(conex.rs.getBigDecimal("valor"));
            Integer id = conex.rs.getInt("id");
            PromocaoDAO promocaoDAO = new PromocaoDAO();
            prod.setPromo(promocaoDAO.searchListaPromo(id));
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao buscar os dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
        return prod;
    }


    public void update(Produto produto) {

    }


    public void insert(Produto produto) {

    }


    public void delete(Produto produto) {

    }
}
