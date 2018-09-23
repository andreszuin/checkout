package DAOS;
import java.sql.PreparedStatement;

public class ProdPromoDAO {
    private Conecta conex = new Conecta();
    public void insert(Integer idprod, Integer idpromo){
        conex.conexaoCheckout();
        try(PreparedStatement pst = conex.conn.prepareStatement("insert into prodPromo(idproduto,idpromocao)values(?,?)");){
            pst.setInt(1,idprod);
            pst.setInt(2,idpromo);
            pst.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }

    public void delete(Integer id){
        conex.conexaoCheckout();
        try (PreparedStatement pst = conex.conn.prepareStatement("delete from prodpromo where idproduto=?");){
            pst.setInt(1,id);
            pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }
}
