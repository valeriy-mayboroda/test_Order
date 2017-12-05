package qatestlab.model;

public class Product {
    private String name;
    private String quantity;
    private String price;

    public Product() {
    }

    public Product(String name, String quantity, String price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setQuantity(String quantity) {this.quantity = quantity;}
    public String getQuantity() {return quantity;}

    public void setPrice(String price) {this.price = price;}
    public String getPrice() {return price;}

    public static Product initProduct() {
        String name = "";
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < 5 + (int)(Math.random()*10); i ++)
            name += array[(int)(Math.random()*array.length)];
        String quantity = "" + (1 + (int)(Math.random()*100));
        String price = "" + (0.1 + Math.random()*99.9);
        price = price.substring(0, price.indexOf(".") + 3);
        price = price.replace(".", ",");
        return new Product(name, quantity, price);
    }
}