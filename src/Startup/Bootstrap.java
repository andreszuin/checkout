package Startup;

import DAOS.BancodeDadosDAO;
import Processamento.Csvreader;
import Processamento.TextReader;

import java.io.IOException;

public class Bootstrap {
    public void criar(){
        BancodeDadosDAO bancodeDadosDAO = new BancodeDadosDAO();
        bancodeDadosDAO.criarBd();
        bancodeDadosDAO.criarTabelas();
    }
    public void preencher() throws IOException {
        Csvreader c = new Csvreader();
        c.read();
        TextReader r = new TextReader();
        String teste = r.FiletoString("src\\Docs\\Arquivo_dados_checkout.txt");
        String regex = r.FiletoString("src\\Docs\\regex.txt");
        r.getResult(regex,teste);
    }
}
