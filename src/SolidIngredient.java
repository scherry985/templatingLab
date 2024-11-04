public class SolidIngredient implements Ingredient {
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