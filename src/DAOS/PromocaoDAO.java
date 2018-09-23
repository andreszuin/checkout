package DAOS;

import Modelos.*;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class PromocaoDAO implements DAO<Promocao>{
    private Conecta conex = new Conecta();
    private Promocao promocao;

    public ArrayList searchListaPromo(Integer idprod) {
        conex.conexaoCheckout();
        ArrayList<Promocao> promos = new ArrayList<>();
        try{
            conex.executa("select * from prodPromo INNER JOIN promocoes ON prodPromo.idpromocao = promocoes.id where prodpromo.idproduto='"+idprod+"'");
            while(conex.rs.next()){
                if(conex.rs.getString("tipo").equals("xy")){
                    promocao = new PromocaoXporY(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getInt("pague"));
                }
                else{
                    promocao = new PromocaoValor(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getBigDecimal("valordesconto"));
                }
                promos.add(promocao);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
        return promos;
    }

    public Promocao get(Integer id){
        conex.conexaoCheckout();
        try{
            conex.executa("select * from promocoes where id='" +id+"'" );
            conex.rs.first();
            if(conex.rs.getString("tipo").equals("xy")){
                promocao = new PromocaoXporY(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getInt("pague"));
            }
            else{
                promocao = new PromocaoValor(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getBigDecimal("valordesconto"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
        return promocao;
    }


    public void update(Promocao promocao) {
        conex.conexaoCheckout();
        try(PreparedStatement pst = conex.conn.prepareStatement("update promocoes set quantidade=?,valordesconto=?, pague=? where id=? ");){
            pst.setInt(1,(promocao.getQuantidade()));
            pst.setBigDecimal(2,(promocao.getValorDesconto()));
            pst.setInt(3,(promocao.getPague()));
            pst.setInt(4,(promocao.getId()));
            pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }


    public void insert(Promocao promocao) {
        conex.conexaoCheckout();
        try(PreparedStatement pst = conex.conn.prepareStatement("insert into promocoes(id,quantidade,valordesconto,pague,tipo)values(?,?,?,?,?)");){
            pst.setInt(1,promocao.getId());
            pst.setInt(2,promocao.getQuantidade());
            pst.setBigDecimal(3,promocao.getValorDesconto());
            pst.setInt(4,promocao.getPague());
            pst.setString(5,promocao.getType());
            pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }


    public void delete(Promocao promocao) {
        conex.conexaoCheckout();
        try(PreparedStatement pst = conex.conn.prepareStatement("delete from promocoes where id=?");) {
            pst.setInt(1,promocao.getId());
            pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }
}
