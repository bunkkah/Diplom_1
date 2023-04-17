package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    private final String EXPECTED_NAME = "test sauce";
    private final float EXPECTED_PRICE = 7.77F;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, EXPECTED_NAME, EXPECTED_PRICE);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("Неверная цена ингредиента", EXPECTED_PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Название ингредиента не совпадает", EXPECTED_NAME, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Название ингредиента не совпадает", IngredientType.SAUCE, ingredient.getType());
    }
}
