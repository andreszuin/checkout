package Processamento;

import DAOS.ProdutoDAO;
import DAOS.PromocaoDAO;
import Modelos.Produto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextReader {

    public void getResult(String regex, String text){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            Produto produto = new Produto(Integer.valueOf(matcher.group(1)),matcher.group(2), new BigDecimal(matcher.group(3)));
            PromocaoDAO promocaoDAO = new PromocaoDAO();
            if(matcher.group(4).equals("-1")){

            }
            else{
                produto.addPromo(promocaoDAO.get(Integer.valueOf(matcher.group(4))));
            }
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.insert(produto);
        }
    }

    /*public List<String> getResult(String regex, String text){
        List<String> lista = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            String participantName = matcher.group();
            lista.add(participantName);
        }
        return lista;
    }*/

    public String FiletoString(String path) throws IOException{
        File texto = new File(path);
        byte[] bytes = new byte[(int) texto.length()];
        FileInputStream fis = new FileInputStream(texto);
        fis.read(bytes);
        fis.close();
        String resultado = new String(bytes);
        return resultado;
    }
}
