package homework_three.decorator;

public class SimpleCoffee implements Beverage {
    @Override
    public String getDescription() {
        return "Простой кофе";
    }

    @Override
    public double getCost() {
        return 100.0;
    }
}
