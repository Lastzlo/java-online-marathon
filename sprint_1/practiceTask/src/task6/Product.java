package task6;

//task
//Create a Product class with fields name of type String and price of type double.
//
//The Product class must meet the following principles:
//
//All class fields must be private.
//Get and set methods must be used to access the class fields.
//The class must have a constructors with and without parameters.
//In the Product class write count() static method that returns count of created objects of Product type.

// Write your code here
public class Product {
    private String name;
    private double price;

    static private int countOfProducts = 0;

    static public int count() {
        return countOfProducts;
    }

    public Product() {
        countOfProducts++;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        countOfProducts++;
    }

    public Product(double price, String name) {
        this.name = name;
        this.price = price;
        countOfProducts++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
