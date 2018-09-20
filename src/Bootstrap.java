import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bootstrap {
    Conecta conex = new Conecta();
    public void criar(){
        conex.conexao();
        try{
            PreparedStatement pst = conex.conn.prepareStatement("DROP TABLE promocoes CASCADE ;\n" +
                    "DROP TABLE item CASCADE ;\n" +
                    "DROP TABLE promocoes CASCADE ;\n" +
                    "DROP TABLE prodPromo CASCADE ;\n" +
                    "\n" +
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
                    "  valordesconto INTEGER,\n" +
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
}
