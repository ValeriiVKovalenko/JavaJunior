

import java.util.*;

public class Test {
    public static final String SIX = "0123456789abcdef";
    public static void main(String[] args) {
    Map<ProductEx, Integer> map = new HashMap<>();

    ProductEx p1 = new ProductEx("Coffe", 21.2);
    ProductEx p2 = new ProductEx("Tea", 33.2);

    map.put(p1, 44);
    map.put(p2, 14);

        System.out.println(check(map, p1));


    }
    public static boolean check(Map<ProductEx, Integer> map, ProductEx productEx) {
        return map.containsKey(productEx);
    }

}
class ProductEx {
    private String name;
    private double price;

    public ProductEx(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEx productEx = (ProductEx) o;
        return Double.compare(productEx.price, price) == 0 && Objects.equals(name, productEx.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
