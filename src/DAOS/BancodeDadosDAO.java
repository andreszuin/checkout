package DAOS;

import Processamento.TextReader;

import java.sql.PreparedStatement;

public class BancodeDadosDAO {
    private Conecta conex = new Conecta();
    private TextReader tx = new TextReader();
    public void criarBd(){
        conex.conexaoPostgres();
        try(PreparedStatement pst = conex.conn.prepareStatement(tx.FiletoString("src\\Docs\\database.sql"));){
            pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }
    public void criarTabelas(){
        conex.conexaoCheckout();
        TextReader tx = new TextReader();
        try(PreparedStatement pst = conex.conn.prepareStatement(tx.FiletoString("src\\Docs\\esquema.sql"));){
            pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }
}
