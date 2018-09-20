import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class PromocaoDAO{
    private Conecta conex = new Conecta();

    public ArrayList searchListaPromo(Integer idprod) {
        conex.conexao();
        ArrayList<Promocao> promos = new ArrayList<>();
        try{
            conex.executa("select * from prodPromo INNER JOIN promocoes ON prodPromo.promocao = promocoes.id where prodpromo.idproduto='"+idprod+"'");
            while(conex.rs.next()){
                if(conex.rs.getString("tipo").equals("xy")){
                    PromocaoXporY xy = new PromocaoXporY(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getInt("pague"));
                    promos.add(xy);
                }
                else{
                    PromocaoValor pv = new PromocaoValor(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getInt("valordesconto"));
                    promos.add(pv);
                }
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao buscar os dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
        return promos;
    }

    public Promocao search(Integer id){
        return null;
    }


    public void update(Produto produto) {

    }


    public void insert(Produto produto) {

    }


    public void delete(Produto produto) {

    }
}
