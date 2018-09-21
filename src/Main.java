import Processamento.Csvreader;
import Processamento.Regex;
import Startup.Bootstrap;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Bootstrap b = new Bootstrap();
        b.criar();
        Csvreader c = new Csvreader();
        c.read();
        Regex r = new Regex();
        String teste = r.FiletoString("C:\\Users\\miner\\Documents\\checkout\\Arquivo_dados_checkout.txt");
        String regex = "((?<=id: )\\d+(?=|))(?:.+)((?<=descricao: )\\w+(?=|))(?:.+)((?<=valor: )\\d+.\\d+(?=|))(?:.+)((?<=promocao: )\\d(?=|))";
        r.getResult(regex,teste);
    }

}
