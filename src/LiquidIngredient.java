public class LiquidIngredient implements Ingredient {
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
