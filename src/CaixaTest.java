import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
public class CaixaTest {
    Caixa caixa = new Caixa();

    @Test
    public void teste1() {
        caixa.add(16);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(91.05807653).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(16);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(182.11615306).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(16);
        assertEquals(caixa.getTotalPrice().intValue(),130,0);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(143.17422959).setScale(8)),true);
        caixa.remove(16);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(182.11615306).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
    }
    @Test
    public void teste2() {
        caixa.add(21);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(44.44605265).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(21);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(88.89210530).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(21);
        assertEquals(caixa.getTotalPrice().intValue(),130,0);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(3.33815795).setScale(8)),true);
        caixa.remove(21);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(88.89210530).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
    }

    @Test
    public void teste3() {
        caixa.add(35);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(70.65849855).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(35);
        assertEquals(caixa.getTotalPrice().intValue(),45,0);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(96.31699710).setScale(8)),true);
        caixa.remove(35);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(70.65849855).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
    }

    @Test
    public void teste4() {
        caixa.add(40);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(20.75675245).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(40);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(41.5135049).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.remove(40);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(20.75675245).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
    }

    @Test
    public void teste5() {
        caixa.add(29);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(1.948783942).setScale(9)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(29);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(3.897567884).setScale(9)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(29);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(3.897567884).setScale(9)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(1.948783942).setScale(9)),true);
        caixa.remove(29);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(3.897567884).setScale(9)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
    }


    @Test
    public void teste6() {
        caixa.add(25);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(15.31292301).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(25);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(30.62584602).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(25);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(30.62584602).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.valueOf(15.31292301).setScale(8)),true);
        caixa.remove(25);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(30.62584602).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
    }

    @Test
    public void teste7() {
        caixa.add(9);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(71.12677295).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(9);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(142.2535459).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(9);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(213.38031885).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.remove(9);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(142.2535459).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
    }

    @Test
    public void teste8() {
        caixa.add(50);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(96.53105492).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(50);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(193.06210984).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.add(50);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(289.59316476).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
        caixa.remove(50);
        assertEquals(caixa.getTotalPrice().equals(BigDecimal.valueOf(193.06210984).setScale(8)),true);
        assertEquals(caixa.getTotalDiscount().equals(BigDecimal.ZERO),true);
    }
}