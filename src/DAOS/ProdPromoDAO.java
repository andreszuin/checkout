package DAOS;
import Startup.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdPromoDAO {
    Conecta conex = new Conecta();
    public void insert(Integer idprod, Integer idpromo){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("insert into prodPromo(idproduto,idpromocao)values(?,?)");
            pst.setInt(1,idprod);
            pst.setInt(2,idpromo);
            pst.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }

    public void delete(Integer id){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from prodpromo where idproduto=?");
            pst.setInt(1,id);
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
}