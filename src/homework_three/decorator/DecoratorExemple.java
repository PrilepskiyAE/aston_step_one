package homework_three.decorator;

public class DecoratorExemple {
    public static void invoke(){
        Beverage simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + ": " + simpleCoffee.getCost() + " руб.");

        Beverage coffeeWithMilk = new MilkDecorator(new SimpleCoffee());
        System.out.println(coffeeWithMilk.getDescription() + ": " + coffeeWithMilk.getCost() + " руб.");

        Beverage coffeeWithSugarAndMilk = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(coffeeWithSugarAndMilk.getDescription() + ": " + coffeeWithSugarAndMilk.getCost() + " руб.");

        Beverage fancyCoffee = new WhippedCreamDecorator(
                new SugarDecorator(
                        new MilkDecorator(new SimpleCoffee())
                )
        );
        System.out.println(fancyCoffee.getDescription() + ": " + fancyCoffee.getCost() + " руб.");
    }
}
