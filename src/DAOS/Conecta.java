package DAOS;

import java.sql.*;

public class Conecta {
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String usuario = "postgres";
    private String senha = "postgres";
    public Connection conn;

    public void conexao(String caminho){
        try {
            System.setProperty("jdbc.Drivers",driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
        }catch (Exception ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public void conexaoCheckout(){
        this.conexao("jdbc:postgresql://localhost:5432/checkout");
    }

    public void conexaoPostgres(){
        this.conexao("jdbc:postgresql://localhost:5432/postgres");
    }

    public void executa(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void desconnect(){
        try {
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
