package homework_three.builder;

public class BuilderExemple {
    public static void invoke(){
        Pizza pizza1 = new Pizza.Builder(12)
                .cheese(true)
                .pepperoni(true)
                .build();
        Pizza pizza2 = new Pizza.Builder(16)
                .bacon(true)
                .build();
        Pizza pizza3 = new Pizza.Builder(8).build();
        System.out.println(pizza1);
        System.out.println(pizza2);
        System.out.println(pizza3);
    }
}
