import java.util.*;

interface Ingredient {
    String getName();

    double getQuantity();
}

class SolidIngredient implements Ingredient {
    private String _name;
    private double _qtyInGrams;

    public SolidIngredient(String name, double quantity) {
        this._name = name;
        this._qtyInGrams = quantity;
    }

    public String getName() {
        return _name;
    }

    public double getQuantity() {
        return _qtyInGrams;
    }
}

class LiquidIngredient implements Ingredient {
    private String _name;
    private double _qtyInMl;

    public LiquidIngredient(String name, double quantity) {
        this._name = name;
        this._qtyInMl = quantity;
    }

    public String getName() {
        return _name;
    }

    public double getQuantity() {
        return _qtyInMl;
    }
}

class Recipe<T extends Ingredient> { // Type variables using interfaces by using extends
                                     // Object passed in must implement Ingredient
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;

    public Recipe(String name, String instructions, int size) {
        this._name = name;
        this._instructions = instructions;
        this._ingredients = new ArrayList<>(size);
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

public class Main {

    public static void showOptions() {
        System.out.println("-1: Exit");
        System.out.println("0: Show Ingredients");
        System.out.println("1: Add an ingredient");
        System.out.print("Choose: ");
    }

    public static void addIngredient(Recipe<Ingredient> recipe, Scanner kb) {
        try {
            System.out.println("Enter ingredient type");
            System.out.println("1: Solid");
            System.out.println("2: Liquid");
            int input2 = kb.nextInt();
            while (input2 != 1 && input2 != 2) {
                input2 = kb.nextInt();
            }
            System.out.println("Enter ingredient name");
            String name = kb.next();
            System.out.println("Enter ingredient quantity");
            double quantity = kb.nextDouble();
            Ingredient ingredient;
            if (input2 == 1) {
                ingredient = new SolidIngredient(name, quantity);

            } else {
                ingredient = new LiquidIngredient(name, quantity);
            }
            recipe.addIngredient(ingredient);
            System.out.println("Added " + name + " to recipe.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            System.exit(-1);
        }
    }
    public static void main(String[] args) {
        Recipe<Ingredient> recipe = new Recipe<>("Pain", """
                 1. Add salt\s
                 2. Add Sugar\s
                 3. Mix""", 3);
        SolidIngredient si = new SolidIngredient("Salt", 2);
        LiquidIngredient li = new LiquidIngredient("Milk", 5);
        recipe.addIngredient(si);
        recipe.addIngredient(li);
        Scanner kb = new Scanner(System.in);
        showOptions();
        try {
            int input = kb.nextInt();
            while (input != -1) {
                if (input == 0){
                    recipe.print();
                } else if (input == 1){
                    addIngredient(recipe, kb);
                }
                showOptions();
                input = kb.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number");
            System.exit(-1);
        }
    }
}