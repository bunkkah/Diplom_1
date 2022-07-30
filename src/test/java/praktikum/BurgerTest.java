package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    String bunName = "white bun";
    String ingredientName = "кетчуп";
    float bunPrice = 18.5F;
    float ingredientPrice = 10.1F;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Mock
    Bun bun;
    Ingredient firstIngredient = mock(Ingredient.class);
    Ingredient secondIngredient = mock(Ingredient.class);

    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("white bun");
        String actual = bun.getName();
        assertEquals("Возвращается неверное имя булочки", "white bun", actual);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(firstIngredient);
        assertEquals("Неверное количество ингредиентов в бургере", 1, burger.ingredients.size());
    }

    @Test
    public void RemoveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.removeIngredient(0);
        assertTrue("Ингредиент не удалился", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты не поменялись местами", "secondIngredient", burger.ingredients.get(0).toString());
    }

    @Test
    public void getBunPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200f);
        float actual = bun.getPrice();
        assertEquals("Цена булочки некорректна", 200f, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(bun.getName()).thenReturn(bunName);

        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn(ingredientName);
        Mockito.when(firstIngredient.getPrice()).thenReturn(ingredientPrice);

        burger.addIngredient(firstIngredient);

        String expected =
                String.format("(==== %s ====)%n", bunName) +
                        String.format("= %s %s =%n", firstIngredient.getType().toString().toLowerCase(), ingredientName) +
                        String.format("(==== %s ====)%n", bunName) +
                        String.format("%nPrice: %f%n", (bunPrice * 2 + ingredientPrice));

        assertEquals(" Чек некорректен", expected, burger.getReceipt());
    }
}