package praktikum;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BunTest {
    private Bun bun;
    private final String TEST_NAME = "bulochka";
    private final float TEST_PRICE = 10.5f;

    @Before
    public void setUp() {
        bun = new Bun(TEST_NAME, TEST_PRICE);
    }

    @Test
    public void getNameReturnsCorrectValue() {
        String actual = bun.getName();
        assertEquals("Ошибка в имени булочки", TEST_NAME, actual);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        float actual = bun.getPrice();
        assertEquals("Ошибка в цене булочки", TEST_PRICE, actual, 0);
    }
}
