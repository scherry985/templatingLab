import java.util.ArrayList;

public class Recipe<T extends Ingredient> { // Type variables using interfaces by using extends
    // Object passed in must implement Ingredient
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;

    public Recipe(String name, String instructions, int size) {
        this._name = name;
        this._instructions = instructions;
        this._ingredients = new ArrayList<>(size);
    }

    public ArrayList<T> getIngredients() {
        return _ingredients;
    }

    public void addIngredient(T ingredient) {
        _ingredients.add(ingredient);
    }

    public void print() {
        System.out.println("Recipe: " + this._name);
        System.out.println("Instructions: ");
        System.out.println(this._instructions);
        System.out.println("Ingredients: ");
        for (T ingredient : _ingredients) {
            System.out.println(ingredient.getName());
            System.out.println(ingredient.getQuantity());
        }
    }
}
