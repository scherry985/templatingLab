import java.util.*;
import java.io.*;

interface Ingredient {
    public String getName();

    public double getQuantity();
}

class SolidIngredient implements Ingredient {
    private String _name;
    private double _quantity;

    public SolidIngredient(String name, int quantity) {
        this._name = name;
        this._quantity = quantity;
    }

    public String getName() {
        return _name;
    }

    public double getQuantity() {
        return _quantity;
    }
}

class LiquidIngredient implements Ingredient {
    private String _name;
    private double _quantity;

    public LiquidIngredient(String name, int quantity) {
        this._name = name;
        this._quantity = quantity;
    }

    public String getName() {
        return _name;
    }

    public double getQuantity() {
        return _quantity;
    }
}

class Recipe<T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;

    public Recipe(int size) {
        _ingredients = new ArrayList<T>(size);
    }

    public void addIngredient(T ingredient) {
        _ingredients.add(ingredient);
    }

    public void print() {
        for (T ingredient : _ingredients) {
            System.out.println(ingredient.getName());
            System.out.println(ingredient.getQuantity());
        }
    }
}

public class Main {

    public static void showOptions() {
        System.out.println("0: Show Ingredients");
        System.out.println("1: Add an ingredient");
        System.out.print("Choose: ");
    }
    public static void main(String[] args) {
        Recipe<Ingredient> recipe = new Recipe<>(3);
        Scanner kb = new Scanner(System.in);
        showOptions();
        int input = kb.nextInt();
        while (input != -1) {
            if (input == 0){
                recipe.print();
            } else if (input == 1){
                String name = kb.next();
                double quantity = kb.nextDouble();
            }
            showOptions();
            input = kb.nextInt();
        }
    }
}