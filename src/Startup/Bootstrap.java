package Startup;

import DAOS.PromocaoDAO;
import Modelos.PromocaoXporY;
import Processamento.Csvreader;
import Processamento.Regex;

import javax.swing.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bootstrap {
    Conecta conex = new Conecta();
    public void criarBd(){
        conex.conexaoP();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("CREATE DATABASE checkout WITH OWNER = postgres ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252' TABLESPACE = pg_default CONNECTION LIMIT = -1;");
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao criar o banco de dados\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }
    public void criarTabelas(){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS produto(\n" +
                    "  id    INTEGER PRIMARY KEY NOT NULL ,\n" +
                    "  nome  CHARACTER VARYING(15) NOT NULL,\n" +
                    "  valor NUMERIC               NOT NULL,\n" +
                    "  UNIQUE (nome)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS item (\n" +
                    "  idproduto  INTEGER NOT NULL,\n" +
                    "  quantidade INTEGER NOT NULL,\n" +
                    "  UNIQUE (idproduto),\n" +
                    "  FOREIGN KEY (idproduto) REFERENCES produto(id)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS promocoes(\n" +
                    "  id            INTEGER PRIMARY KEY NOT NULL ,\n" +
                    "  quantidade    INTEGER NOT NULL,\n" +
                    "  valordesconto NUMERIC,\n" +
                    "  pague         INTEGER,\n" +
                    "  tipo          CHARACTER VARYING(10) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS prodPromo(\n" +
                    "  idproduto INTEGER NOT NULL ,\n" +
                    "  idpromocao INTEGER NOT NULL,\n" +
                    "  FOREIGN KEY (idproduto) REFERENCES produto(id),\n" +
                    "  FOREIGN KEY (idpromocao) REFERENCES promocoes(id)\n" +
                    ");");
            pst.execute();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao criar as tabelas\nInforme o seguinte erro ao suporte:\n"+ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        conex.desconnect();
    }

    public void preencher() throws IOException {
        /*PromocaoXporY xy =  new PromocaoXporY(0,1,1);
        PromocaoDAO promocaoDAO = new PromocaoDAO();
        promocaoDAO.insert(xy);*/
        Csvreader c = new Csvreader();
        c.read();
        Regex r = new Regex();
        String teste = r.FiletoString("C:\\Users\\miner\\Documents\\checkout\\Arquivo_dados_checkout.txt");
        String regex = "((?<=id: )\\d+(?=|))(?:.+)((?<=descricao: )\\w+(?=|))(?:.+)((?<=valor: )\\d+.\\d+(?=|))(?:.+)((?<=promocao: )\\-?\\d(?=|))";
        r.getResult(regex,teste);
    }
}
