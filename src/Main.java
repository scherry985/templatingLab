import java.util.*;

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
        try {
            showOptions();
            int input = kb.nextInt();
            while (input != -1) {
                if (input == 0) {
                    recipe.print();
                } else if (input == 1) {
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