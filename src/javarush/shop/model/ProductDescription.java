package javarush.shop.model;

public class ProductDescription {
    private String type;

    public String getType() {
        return type;
    }

    public ProductDescription(String name) {
        this.type = name;
    }
}
