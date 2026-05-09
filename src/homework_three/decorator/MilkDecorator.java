package homework_three.decorator;

public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", молоко";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 30.0;
    }
}

