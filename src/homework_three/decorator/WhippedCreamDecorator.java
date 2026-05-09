package homework_three.decorator;

public class WhippedCreamDecorator extends BeverageDecorator {
    public WhippedCreamDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", взбитые сливки";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 40.0;
    }
}

