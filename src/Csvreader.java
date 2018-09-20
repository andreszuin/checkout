import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Csvreader {
    public void read()throws IOException{
        PromocaoDAO promocaoDAO = new PromocaoDAO();
        try (
                Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\miner\\Documents\\checkout\\promoções.csv"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());
        ){
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names
                String id = csvRecord.get("id");
                String qtd_ativacao = csvRecord.get("qtde_ativacao");
                String preco_final = csvRecord.get("preco_final");
                String qtd_paga = csvRecord.get("qtd_paga");

                if(preco_final.equals("")){
                    PromocaoXporY xy = new PromocaoXporY(Integer.valueOf(id),Integer.valueOf(qtd_ativacao),Integer.valueOf(qtd_paga));
                    promocaoDAO.insert(xy);
                }
                else{
                    PromocaoValor pv = new PromocaoValor(Integer.valueOf(id),Integer.valueOf(qtd_ativacao),Integer.valueOf(preco_final));
                    promocaoDAO.insert(pv);
                }
            }
    }
}}
