package praktikum;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import org.junit.Test;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getBunData() {
        return new Object[][] {
                {"булочка", 100},
                {"negativePrice", -1},
                {"b", 0.001f},
                {"", 0},
                {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore " +
                        "et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                        "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate " +
                        "velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non " +
                        "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 12_345_678_90},
        };
    }

    @Test
    public void getNameReturnsCorrectValue() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals("Ошибка в имени булочки", name, actual);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        assertEquals("Ошибка в цене булочки", price, actual, 0);

    }
}
