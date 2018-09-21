package Startup;

import javax.swing.*;
import java.sql.*;

public class Conecta {
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/checkout";
    private String caminhoP = "jdbc:postgresql://localhost:5432/postgres";
    private String usuario = "postgres";
    private String senha = "postgres";
    public Connection conn;

    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers",driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null,"conexão realizada com sucesso");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro Fatal ao conectar!\nInforme o seguinte erro ao suporte:\n"+ex,"Erro Fatal", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void conexaoP(){
        try {
            System.setProperty("jdbc.Drivers",driver);
            conn = DriverManager.getConnection(caminhoP, usuario, senha);
            //JOptionPane.showMessageDialog(null,"conexão realizada com sucesso");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro Fatal ao conectar!\nInforme o seguinte erro ao suporte:\n"+ex,"Erro Fatal", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void executa(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao executar!\nInforme o seguinte erro ao suporte:\n"+ex,"Erro", JOptionPane.ERROR_MESSAGE);

        }
    }
    public void desconnect(){
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null,"desconectado com sucesso");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao desconectar!\nInforme o seguinte erro ao suporte:\n"+ex,"Erro", JOptionPane.ERROR_MESSAGE);

        }

    }
}
