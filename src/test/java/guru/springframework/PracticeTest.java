package guru.springframework;

import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PracticeTest {


    @Test
    void testCalculate() {
        MoneyCurrency fiveDollar = MoneyCurrency.getDollar(5);
        assertEquals(MoneyCurrency.getDollar(10), fiveDollar.times(2));
        assertEquals(MoneyCurrency.getDollar(15), fiveDollar.times(3));

        MoneyCurrency fiveFranc = MoneyCurrency.getFranc(5);
        assertEquals( MoneyCurrency.getFranc(10), fiveFranc.times(2));
        assertEquals(MoneyCurrency.getFranc(15), fiveFranc.times(3));

    }

    @Test
    void testEquality() {
        assertEquals(MoneyCurrency.getDollar(5), MoneyCurrency.getDollar(5));
        assertNotEquals(MoneyCurrency.getDollar(5), MoneyCurrency.getDollar(8));
        assertNotEquals(MoneyCurrency.getDollar(5), MoneyCurrency.getFranc(5));
        assertEquals(MoneyCurrency.getFranc(5),  MoneyCurrency.getFranc(5));
        assertNotEquals(MoneyCurrency.getFranc(5),  MoneyCurrency.getFranc(8));
        assertNotEquals(MoneyCurrency.getFranc(5), MoneyCurrency.getDollar(5));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", MoneyCurrency.getDollar(1).getCurrency());
        assertEquals("CHF", MoneyCurrency.getFranc(1).getCurrency());
    }

    @Test
    void testSimpleAddition() {
        MoneyCurrency five = MoneyCurrency.getDollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank ();
        MoneyCurrency reduced = bank.reduced(sum, "USD");
        assertEquals(MoneyCurrency.getDollar(10), reduced);
    }

    @Test
    void testPlusReturnSum() {
        MoneyCurrency five = MoneyCurrency.getDollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augmend);
        assertEquals(five,sum.addmend);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(MoneyCurrency.getDollar(3), MoneyCurrency.getDollar(4));
        Bank bank = new Bank();
        MoneyCurrency result = bank.reduced(sum, "USD");
        assertEquals(MoneyCurrency.getDollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        MoneyCurrency result = bank.reduced(MoneyCurrency.getDollar(1), "USD");
        assertEquals(MoneyCurrency.getDollar(1), result);
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        MoneyCurrency result = bank.reduced(MoneyCurrency.getFranc(2), "USD");
        assertEquals(MoneyCurrency.getDollar(1), result);
    }

    @Test
    void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
        assertEquals(1, new Bank().rate("CHF", "CHF"));
    }



}
