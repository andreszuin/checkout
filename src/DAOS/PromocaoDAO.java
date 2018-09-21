package DAOS;

import Modelos.*;

import Startup.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PromocaoDAO implements DAO{
    private Conecta conex = new Conecta();
    private Promocao promocao;

    public ArrayList searchListaPromo(Integer idprod) {
        conex.conexao();
        ArrayList<Promocao> promos = new ArrayList<>();
        try{
            conex.executa("select * from prodPromo INNER JOIN promocoes ON prodPromo.promocao = promocoes.id where prodpromo.idproduto='"+idprod+"'");
            while(conex.rs.next()){
                if(conex.rs.getString("tipo").equals("xy")){
                    promocao = new PromocaoXporY(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getInt("pague"));
                }
                else{
                    promocao = new PromocaoValor(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getInt("valordesconto"));

                }
                promos.add(promocao);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao buscar os dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
        return promos;
    }

    public Promocao search(Integer id){
        conex.conexao();
        try{
            if(id == -1){
                return null;
            }
            conex.executa("select * from promocoes where id='" +id+"'" );
            conex.rs.first();
            if(conex.rs.getString("tipo").equals("xy")){
                promocao = new PromocaoXporY(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getInt("pague"));
            }
            else{
                promocao = new PromocaoValor(conex.rs.getInt("id"),conex.rs.getInt("quantidade"),conex.rs.getInt("valordesconto"));
            }

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao buscar os dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
        return promocao;
    }


    public void update(Object object) {
        conex.conexao();
        promocao = ((Promocao)object);
        try{
            if(promocao instanceof PromocaoXporY){
                PreparedStatement pst = conex.conn.prepareStatement("update promocoes set quantidade=?, pague=? where id=? ");
                pst.setInt(1,((PromocaoXporY)promocao).getQuantidade());
                pst.setInt(2,((PromocaoXporY)promocao).getPague());
                pst.setInt(3,((PromocaoXporY)promocao).getId());
                pst.execute();
            }
            else if(promocao instanceof PromocaoValor){
                PreparedStatement pst = conex.conn.prepareStatement("update promocoes set quantidade=?,valordesconto=? where id=? ");
                pst.setInt(1,((PromocaoValor)promocao).getQuantidade());
                pst.setInt(2,((PromocaoValor)promocao).getValorDesconto());
                pst.setInt(3,((PromocaoValor)promocao).getId());
                pst.execute();
            }

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }


    public void insert(Object object) {
        conex.conexao();
        promocao = ((Promocao)object);
        try{
            if(promocao instanceof PromocaoXporY){
                PreparedStatement pst = conex.conn.prepareStatement("insert into promocoes(id,quantidade,pague,tipo)values(?,?,?,?)");
                pst.setInt(2,((PromocaoXporY)promocao).getQuantidade());
                pst.setInt(3,((PromocaoXporY)promocao).getPague());
                pst.setInt(1,promocao.getId());
                pst.setString(4,"xy");
                pst.execute();
            }
            else if(promocao instanceof PromocaoValor){
                PreparedStatement pst = conex.conn.prepareStatement("insert into promocoes(id,quantidade,valordesconto,tipo)values(?,?,?,?)");
                pst.setInt(2,((PromocaoValor)promocao).getQuantidade());
                pst.setInt(3,((PromocaoValor)promocao).getValorDesconto());
                pst.setInt(1,promocao.getId());
                pst.setString(4,"vf");
                pst.execute();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }


    public void delete(Object object) {
        conex.conexao();
        promocao = ((Promocao)object);
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from promocoes where id=?");
            pst.setInt(1,promocao.getId());
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
}
