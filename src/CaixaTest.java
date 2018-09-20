import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
//edunvk@gmail.com
public class CaixaTest {
    Caixa caixa = new Caixa();
    @Test    
    public void teste1() {
        caixa.add("A");
        assertEquals(caixa.getTotalPrice(),50,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("A");
        assertEquals(caixa.getTotalPrice(),100,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("A");
        assertEquals(caixa.getTotalPrice(),130,0);
        assertEquals(caixa.getTotalDiscount(),20,0);
        caixa.add("A");
        assertEquals(caixa.getTotalPrice(),180,0);
        assertEquals(caixa.getTotalDiscount(),20,0);
        caixa.add("A");
        assertEquals(caixa.getTotalPrice(),230,0);
        assertEquals(caixa.getTotalDiscount(),20,0);
        caixa.add("A");
        assertEquals(caixa.getTotalPrice(),260,0);
        assertEquals(caixa.getTotalDiscount(),40,0);
        caixa.remove("A");
        assertEquals(caixa.getTotalPrice(),230,0);
        assertEquals(caixa.getTotalDiscount(),20,0);
    }
    
    @Test
    public void teste2() {
        caixa.add("D");
        assertEquals(caixa.getTotalPrice(),15,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("A");
        assertEquals(caixa.getTotalPrice(),65,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("B");
        assertEquals(caixa.getTotalPrice(),95,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("A");
        assertEquals(caixa.getTotalPrice(),145,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("B");
        assertEquals(caixa.getTotalPrice(),160,0);
        assertEquals(caixa.getTotalDiscount(),15,0);
        caixa.add("A");
        assertEquals(caixa.getTotalPrice(),190,0);
        assertEquals(caixa.getTotalDiscount(),35,0);
        caixa.remove("A");
        assertEquals(caixa.getTotalPrice(),160,0);
        assertEquals(caixa.getTotalDiscount(),15,0);
        caixa.remove("B");
        assertEquals(caixa.getTotalPrice(),145,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
    }

    @Test
    public void teste3() {
        caixa.add("C");
        assertEquals(caixa.getTotalPrice(),20,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("C");
        assertEquals(caixa.getTotalPrice(),40,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("C");
        assertEquals(caixa.getTotalPrice(),40,0);
        assertEquals(caixa.getTotalDiscount(),20,0);
        caixa.add("C");
        assertEquals(caixa.getTotalPrice(),60,0);
        assertEquals(caixa.getTotalDiscount(),20,0);
        caixa.remove("C");
        assertEquals(caixa.getTotalPrice(),40,0);
        assertEquals(caixa.getTotalDiscount(),20,0);
        caixa.remove("C");
        assertEquals(caixa.getTotalPrice(),40,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
    }

    @Test
    public void teste4() {
        caixa.add("C");
        assertEquals(caixa.getTotalPrice(),20,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("B");
        assertEquals(caixa.getTotalPrice(),50,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
        caixa.add("B");
        assertEquals(caixa.getTotalPrice(),65,0);
        assertEquals(caixa.getTotalDiscount(),15,0);
        caixa.remove("B");
        assertEquals(caixa.getTotalPrice(),50,0);
        assertEquals(caixa.getTotalDiscount(),0,0);
    }


    @Test
    public void testeRegex() throws IOException {
        File texto = new File("promoções.csv");
        byte[] bytes = new byte[(int) texto.length()];
        FileInputStream fis = new FileInputStream(texto);
        fis.read(bytes);
        fis.close();
        String comandos = new String(bytes);
        Regex reg = new Regex();
        List<String> esperado = Arrays.asList("1","2","3");
        System.out.println(comandos);
        assertEquals(reg.getResult("\\d",comandos),esperado);
    }
}