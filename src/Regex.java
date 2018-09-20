import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public List<String> getResult(String regex, String text){
        List<String> lista = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            String participantName = matcher.group();
            lista.add(participantName);
        }
        return lista;
    }

    public String FiletoString(String path) throws IOException{
        File texto = new File(path);
        byte[] bytes = new byte[(int) texto.length()];
        FileInputStream fis = new FileInputStream(texto);
        fis.read(bytes);
        fis.close();
        String resultado = new String(bytes);
        System.out.println(resultado);
        return resultado;
    }
}
