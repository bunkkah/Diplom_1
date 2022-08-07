package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    Database database = new Database();
    int sizeOfIngredientsBurger;

    @Before
    public void setUp() {

        burger = new Burger();
        for(int i = 0; i <= 5; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }

        sizeOfIngredientsBurger = burger.ingredients.size();
    }

    @Mock
    Bun bun;


    @Test
    public void checkSetBuns() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("white bun");
        String actual = bun.getName();

        assertEquals("Возвращается неверное имя булочки", "white bun", actual);
    }

    @Test
    public void addIngredientTest() {
        int actualSize = burger.ingredients.size();

        assertEquals("Не хватает ингридиентов в бургере",6, actualSize);
    }

    @Test
    public void RemoveIngredientTest() {
        burger.removeIngredient(4);

        assertEquals("Ингредиент не удалился из бургера",sizeOfIngredientsBurger - 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredientBeforeMoving = burger.ingredients.get(5);
        burger.moveIngredient(5, 0);
        Ingredient ingredientAfterMoving = burger.ingredients.get(0);

        assertEquals("Ингредиент не переместился в бургере", ingredientAfterMoving, ingredientBeforeMoving);
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
        List<Ingredient> ingredientList = new ArrayList<>(burger.ingredients);
        Mockito.when(bun.getName()).thenReturn("Булочка для проверки");
        assertEquals("(==== " + bun.getName() + " ====)\n" +
                "= sauce " + ingredientList.get(0).getName() + " =\n" +
                "= sauce " + ingredientList.get(1).getName() + " =\n" +
                "= sauce " + ingredientList.get(2).getName() + " =\n" +
                "= filling " + ingredientList.get(3).getName() + " =\n" +
                "= filling " + ingredientList.get(4).getName() + " =\n" +
                "= filling " + ingredientList.get(5).getName() + " =\n" +
                "(==== " + bun.getName() + " ====)\n" +
                "\n" +
                "Price: 1200,000000\n", burger.getReceipt());
    }
    @Test
    public void createEmptyBurgerTest() {

        burger.setBuns(bun);

        assertNotNull("Бургер пустой", burger.bun);
    }
}