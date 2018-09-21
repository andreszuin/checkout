import Processamento.Regex;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.*;
public class CaixaTest {
    Caixa caixa = new Caixa();
    @Test    
    public void teste1() {
        caixa.add(16);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(91.05807653)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(0)),true);
        caixa.add(16);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(182.11615306)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(0)),true);
        caixa.add(16);
        System.out.println(caixa.getTotalPrice());
        assertEquals(caixa.getTotalPrice().intValue(),130,0);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(143.17422959)),true);
        caixa.remove(16);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(182.11615306)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(0)),true);
    }
    @Test
    public void teste2() {
        caixa.add(21);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(44.44605265)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(0)),true);
        caixa.add(21);
        System.out.println(caixa.getTotalPrice());
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(88.89210530)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(0)),true);
        caixa.add(21);
        assertEquals(caixa.getTotalPrice().intValue(),130,0);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(3.33815795)),true);
        caixa.remove(21);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(88.89210530)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(0)),true);
    }

    @Test
    public void teste3() {
        caixa.add(35);
        assertEquals(caixa.getTotalPrice().intValue(),70.65849855,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(35);
        assertEquals(caixa.getTotalPrice().intValue(),45,0);
        assertEquals(caixa.getTotalDiscount().intValue(),96.3169971,0);
        caixa.remove(35);
        assertEquals(caixa.getTotalPrice().intValue(),70.65849855,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
    }

    @Test
    public void teste4() {
        caixa.add(40);
        assertEquals(caixa.getTotalPrice().intValue(),20.75675245,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(40);
        assertEquals(caixa.getTotalPrice().intValue(),41.5135049,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.remove(40);
        assertEquals(caixa.getTotalPrice().intValue(),20.75675245,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
    }

    @Test
    public void teste5() {
        caixa.add(29);
        assertEquals(caixa.getTotalPrice().intValue(),1.948783942,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(29);
        assertEquals(caixa.getTotalPrice().intValue(),3.897567884,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(29);
        assertEquals(caixa.getTotalPrice().intValue(),3.897567884,0);
        assertEquals(caixa.getTotalDiscount().intValue(),1.948783942,0);
        caixa.remove(29);
        assertEquals(caixa.getTotalPrice().intValue(),3.897567884,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
    }


    @Test
    public void teste6() {
        caixa.add(25);
        assertEquals(caixa.getTotalPrice().intValue(),15.31292301,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(25);
        assertEquals(caixa.getTotalPrice().intValue(),30.62584602,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(25);
        assertEquals(caixa.getTotalPrice().intValue(),30.62584602,0);
        assertEquals(caixa.getTotalDiscount().intValue(),15.31292301,0);
        caixa.remove(25);
        assertEquals(caixa.getTotalPrice().intValue(),30.62584602,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
    }

    @Test
    public void teste7() {
        caixa.add(9);
        assertEquals(caixa.getTotalPrice().intValue(),71.12677295,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(9);
        assertEquals(caixa.getTotalPrice().intValue(),142.2535459,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(9);
        assertEquals(caixa.getTotalPrice().intValue(),213.38031885,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.remove(9);
        assertEquals(caixa.getTotalPrice().intValue(),142.2535459,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
    }

    @Test
    public void teste8() {
        caixa.add(50);
        assertEquals(caixa.getTotalPrice().intValue(),96.53105492,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(50);
        assertEquals(caixa.getTotalPrice().intValue(),193.06210984,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.add(50);
        assertEquals(caixa.getTotalPrice().intValue(),289.59316476,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
        caixa.remove(50);
        assertEquals(caixa.getTotalPrice().intValue(),193.06210984,0);
        assertEquals(caixa.getTotalDiscount().intValue(),0,0);
    }
}