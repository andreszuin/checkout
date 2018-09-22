package Startup;

import DAOS.Conecta;
import Processamento.Csvreader;
import Processamento.TextReader;

import java.io.IOException;
import java.sql.PreparedStatement;

public class Bootstrap {
    Conecta conex = new Conecta();
    public void criarBd(){
        conex.conexaoPostgres();
        TextReader tx = new TextReader();
        try(PreparedStatement pst = conex.conn.prepareStatement(tx.FiletoString("src\\Startup\\database.sql"));){
            pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }
    public void criarTabelas(){
        conex.conexaoCheckout();
        TextReader tx = new TextReader();
        try(PreparedStatement pst = conex.conn.prepareStatement(tx.FiletoString("src\\Startup\\esquema.sql"));){
            pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        conex.desconnect();
    }

    public void preencher() throws IOException {
        Csvreader c = new Csvreader();
        c.read();
        TextReader r = new TextReader();
        String teste = r.FiletoString("src\\Docs\\Arquivo_dados_checkout.txt");
        String regex = "((?<=id: )\\d+(?=|))(?:.+)((?<=descricao: )\\w+(?=|))(?:.+)((?<=valor: )\\d+.\\d+(?=|))(?:.+)((?<=promocao: )\\-?\\d(?=|))";
        r.getResult(regex,teste);
    }
}
