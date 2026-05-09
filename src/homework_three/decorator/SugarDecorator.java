package homework_three.decorator;

public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", сахар";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 10.0;
    }
}

