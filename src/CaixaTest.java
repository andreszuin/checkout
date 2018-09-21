import Processamento.Regex;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;
public class CaixaTest {
    Caixa caixa = new Caixa();
    @Test    
    public void teste1() {
        caixa.add(1);
        assertEquals(caixa.getTotalPrice().intValue(),50,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(1);
        assertEquals(caixa.getTotalPrice().intValue(),100,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(1);
        assertEquals(caixa.getTotalPrice().intValue(),130,0);
        assertEquals(caixa.getTotalDiscount().intValue(),20,0);
        caixa.add(1);
        assertEquals(caixa.getTotalPrice().intValue(),180,0);
        assertEquals(caixa.getTotalDiscount().intValue(),20,0);
        caixa.add(1);
        assertEquals(caixa.getTotalPrice().intValue(),230,0);
        assertEquals(caixa.getTotalDiscount().intValue(),20,0);
        caixa.add(1);
        assertEquals(caixa.getTotalPrice().intValue(),260,0);
        assertEquals(caixa.getTotalDiscount().intValue(),40,0);
        caixa.remove(1);
        assertEquals(caixa.getTotalPrice().intValue(),230,0);
        assertEquals(caixa.getTotalDiscount().intValue(),20,0);
    }
    
    @Test
    public void teste2() {
        caixa.add(4);
        assertEquals(caixa.getTotalPrice().intValue(),15,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(1);
        assertEquals(caixa.getTotalPrice().intValue(),65,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(2);
        assertEquals(caixa.getTotalPrice().intValue(),95,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(1);
        assertEquals(caixa.getTotalPrice().intValue(),145,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(2);
        assertEquals(caixa.getTotalPrice().intValue(),160,0);
        assertEquals(caixa.getTotalDiscount().intValue(),15,0);
        caixa.add(1);
        assertEquals(caixa.getTotalPrice().intValue(),190,0);
        assertEquals(caixa.getTotalDiscount().intValue(),35,0);
        caixa.remove(1);
        assertEquals(caixa.getTotalPrice().intValue(),160,0);
        assertEquals(caixa.getTotalDiscount().intValue(),15,0);
        caixa.remove(2);
        assertEquals(caixa.getTotalPrice().intValue(),145,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
    }

    @Test
    public void teste3() {
        caixa.add(21);
        System.out.println(caixa.getTotalPrice());
        System.out.println(caixa.getTotalDiscount());
        caixa.add(21);
        System.out.println(caixa.getTotalPrice());
        System.out.println(caixa.getTotalDiscount());
        caixa.add(21);
        System.out.println(caixa.getTotalPrice());
        System.out.println(caixa.getTotalDiscount());
        caixa.add(21);
        System.out.println(caixa.getTotalPrice());
        System.out.println(caixa.getTotalDiscount());
        caixa.remove(21);
        System.out.println(caixa.getTotalPrice());
        System.out.println(caixa.getTotalDiscount());
        caixa.remove(21);
        System.out.println(caixa.getTotalPrice());
        System.out.println(caixa.getTotalDiscount());
    }

    @Test
    public void teste4() {
        caixa.add(3);
        assertEquals(caixa.getTotalPrice().intValue(),20,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(2);
        assertEquals(caixa.getTotalPrice().intValue(),50,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(2);
        assertEquals(caixa.getTotalPrice().intValue(),65,0);
        assertEquals(caixa.getTotalDiscount().intValue(),15,0);
        caixa.remove(2);
        assertEquals(caixa.getTotalPrice().intValue(),50,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
    }



}